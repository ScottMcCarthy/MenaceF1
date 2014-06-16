package menaceF1.wedding;

import java.util.HashMap;
import java.util.Map;

import com.ibm.db.beans.DBSelect;

public class Admin {

	private static final int totalDayGuests = 100;
	private int hotelBookingsNeedingPayment = 0;
	private int dayGuestsNotConfirmed = 0;
	private int onlineRSVPNeedingChecking = 0;
	private int eveningGuestsNotConfirmed = 0;
	private String hotelBookingsHTML = "";
	private String rsvpEntriesHTML = "";
	private String dayGuestTableHTML = "";
	private String eveningGuestTableHTML = "";
	private Map<String,String> paymentTypeMap;
	private Map<String,String> menuChoiceMap;
	private Map<String,String> paymentReceived;
	private int guestsLeftToInvite = 0;

	public boolean placeLeft() {
		return guestsLeftToInvite<totalDayGuests;
	}
	
	public String getHotelBookingsHTML() {
		return hotelBookingsHTML;
	}

	public String eveningGuestTableHTML() {
		return eveningGuestTableHTML;
	}	
	
	public String dayGuestTableHTML() {
		return dayGuestTableHTML;
	}	
	
	public Admin() throws Exception{
		paymentTypeMap = new HashMap<String,String>();
		menuChoiceMap = new HashMap<String,String>();
		paymentTypeMap.put("banking", "Bank-Transfer");
		paymentTypeMap.put("paypal", "PayPal");
		paymentTypeMap.put("cheque", "Cheque");
		menuChoiceMap.put("M", "Meat");
		menuChoiceMap.put("V", "Vegetarian");
		menuChoiceMap.put("X", "No meal");
		paymentReceived = new HashMap<String,String>();
		paymentReceived.put("N", "<b>Payment not yet received</b>");
		paymentReceived.put("Y", "Payment Received");
		calculateHotelBookings();
		loadHotelBookingsHTML();
		loadRSVPHTML();
		calculatePlacesRemaining();
		calculateRSVPStatus();
		calculateRSVPRequests();
		dayGuestTableHTML = loadGuestHTML("DAY");
		eveningGuestTableHTML = loadGuestHTML("EVENING");
	}
	
	public int getDayGuestsNotConfirmed() {
		return dayGuestsNotConfirmed;
	}
	
	public int getOnlineRSVPNeedingChecking() {
		return onlineRSVPNeedingChecking;
	}	

	public int getEveningGuestsNotConfirmed() {
		return eveningGuestsNotConfirmed;
	}

	public int getGuestsLeftToInvite() {
		return guestsLeftToInvite;
	}	
	
	public int getHotelBookingsNeedingPayment() {
		return hotelBookingsNeedingPayment;
	}

	private void loadHotelBookingsHTML() throws Exception{
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b><small>Booking ID</small></b></td>");
		sbuf.append("		<td><b><small>Booking Date</small></b></td>");
		sbuf.append("		<td><b><small>Booking For</small></b></td>");
		sbuf.append("		<td><b><small>Payment Type</small></b></td>");
		sbuf.append("		<td><b><small>Nights</small></b></td>");
		sbuf.append("		<td><b><small>Cost</small></b></td>");
		sbuf.append("  </tr>");

		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select ID,date(Booking_TS),name,address1,address2,county,postcode,country,telephone,email,paymenttype,days,paid,cost from hotelbookings order by paid, ID";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					sbuf.append("<form onsubmit=\"return confirmPayment(this)\" method=\"post\" name=\"booking"+dbs.getColumnAsString(1)+"\" action=\"/MenaceF1/hotelBookingPaymentReceived.do\" >");
					sbuf.append("<input type=\"hidden\" name=\"BOOKINGID\" value=\""+dbs.getColumnAsString(1)+"\" >");
					sbuf.append("	<tr>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(1)+"</td>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(2)+"</td>");
					sbuf.append("		<td><small><a href=\"mailto:"+dbs.getColumnAsString(10)+"\">"+dbs.getColumnAsString(3)+"</a><br />"+dbs.getColumnAsString(4)+"<br />"+dbs.getColumnAsString(5)+"<br />"+dbs.getColumnAsString(6)+"<br />"+dbs.getColumnAsString(7)+"<br />"+dbs.getColumnAsString(8)+"<br />"+dbs.getColumnAsString(9)+"<br /></small></td>");
					sbuf.append("		<td align=\"center\">"+paymentTypeMap.get(dbs.getColumnAsString(11).trim())+"<br /></td>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(12)+"</td>");
					sbuf.append("		<td align=\"center\">¬"+Accomodation.webNumber(Float.parseFloat(dbs.getColumnAsString(14).trim()))+"<br /><br />");
					sbuf.append(		paymentReceived.get(dbs.getColumnAsString(13).trim())+"<br /><br />");
					if (dbs.getColumnAsString(13).trim().equalsIgnoreCase("n"))sbuf.append("		<input type=\"submit\" name=\"markPaid\" value=\"Mark as paid\"></td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		sbuf.append("	</tbody>");
		sbuf.append("</table>");		
		hotelBookingsHTML = sbuf.toString();
	}

	private void loadRSVPHTML() throws Exception{
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b><small>Name</small></b></td>");
		sbuf.append("		<td><b><small>Partner Name</small></b></td>");
		sbuf.append("		<td><b><small>Address</small></b></td>");
		sbuf.append("		<td><b><small>Menu Choice</small></b></td>");
		sbuf.append("		<td><b><small>Partner's menu choice</small></b></td>");
		sbuf.append("		<td><b><small>Comments</small></b></td>");
		sbuf.append("		<td><b><small>Link to...</small></b></td>");
		sbuf.append("  </tr>");

		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select ID,name,partnername,address1,address2,county,postcode,country,telephone,email,menuchoice,partnermenuchoice,specialrequirements,partnerspecialrequirements,comments  from rsvp where checked = 'N' order by ID";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					String guestSpecialRequirements = dbs.getColumnAsString(13);
					String partnerSpecialRequirements = dbs.getColumnAsString(14);
					if (guestSpecialRequirements == null) guestSpecialRequirements = "";
					if (partnerSpecialRequirements == null) partnerSpecialRequirements = "";
					
					sbuf.append("<form onsubmit=\"return confirmRSVP(this)\" method=\"post\" name=\"booking"+dbs.getColumnAsString(1)+"\" action=\"/MenaceF1/rsvpMapping.do\" >");
					sbuf.append("<input type=\"hidden\" name=\"RSVPID\" value=\""+dbs.getColumnAsString(1)+"\" >");
					sbuf.append("	<tr>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(2)+"</td>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(3)+"</td>");
					sbuf.append("		<td><small><a href=\"mailto:"+dbs.getColumnAsString(10)+"\">"+dbs.getColumnAsString(2)+"</a><br />"+dbs.getColumnAsString(4)+"<br />"+dbs.getColumnAsString(5)+"<br />"+dbs.getColumnAsString(6)+"<br />"+dbs.getColumnAsString(7)+"<br />"+dbs.getColumnAsString(8)+"<br />"+dbs.getColumnAsString(9)+"<br /></small></td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(dbs.getColumnAsString(11).trim())+"<br />"+guestSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(dbs.getColumnAsString(12).trim())+"<br />"+partnerSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+dbs.getColumnAsString(15)+"</td>");
					sbuf.append("		<td align=\"center\">"+Admin.getUnconfirmedGuestsListbox()+"</td>");
					sbuf.append("		<td align=\"center\"><input type=\"submit\" name=\"mapRSVP\" value=\"Confirm RSVP\"></td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		sbuf.append("	</tbody>");
		sbuf.append("</table>");		
		rsvpEntriesHTML = sbuf.toString();
	}
	
public static String getUnconfirmedGuestsListbox() throws Exception{
	StringBuffer sbuf = new StringBuffer();
	sbuf.append("<select name=\"realGuestID\">");
	
	try {
		DBSelect dbs = new DBSelect();
		dbs.setDataSourceName("jdbc/preds");
		String sql = "select ID,name,partnername from guestlist where accepted is null order by name";
		dbs.setCommand(sql);
		dbs.execute();
		if (dbs.onRow()) {
			do{
				sbuf.append("<option value=\""+dbs.getColumnAsString(1)+"\">"+dbs.getColumnAsString(2));
				if (dbs.getColumnAsString(3) != null) sbuf.append(" &amp; "+dbs.getColumnAsString(3));
				sbuf.append("</option>");
			} while (dbs.next());
			dbs.close();

		}
	}
	catch (Exception e) {
		e.printStackTrace();
		throw (e);
	}
	sbuf.append("</select>");
	return sbuf.toString();

}
	
	private String getAwaitingReply(String guestType) throws Exception{
		StringBuffer sbuf = new StringBuffer();
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted is null order by name";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("1")) sbuf.append(dbs.getColumnAsString(1)+"<br />");
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("2")) sbuf.append(dbs.getColumnAsString(1)+" &amp; "+dbs.getColumnAsString(3)+"<br />");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return sbuf.toString();
	}

	private String getNotComing(String guestType) throws Exception{
		StringBuffer sbuf = new StringBuffer();
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted = 'N' order by name";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("1")) sbuf.append(dbs.getColumnAsString(1)+"<br />");
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("2")) sbuf.append(dbs.getColumnAsString(1)+" &amp; "+dbs.getColumnAsString(3)+"<br />");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return sbuf.toString();
	}
	
	private String getComing(String guestType) throws Exception{
		StringBuffer sbuf = new StringBuffer();
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted = 'Y' order by name";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("1")) sbuf.append(dbs.getColumnAsString(1)+"<br />");
					if (dbs.getColumnAsString(2).trim().equalsIgnoreCase("2")) sbuf.append(dbs.getColumnAsString(1)+" &amp; "+dbs.getColumnAsString(3)+"<br />");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return sbuf.toString();
	}	
	
	
	private String loadGuestHTML(String guestType) throws Exception{
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b><small>Guests not yet RSVPed.</small></b></td>");
		sbuf.append("		<td><b><small>Guests attending</small></b></td>");
		sbuf.append("		<td><b><small>Guests not attending</small></b></td>");
		sbuf.append("  </tr>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><small>"+getAwaitingReply(guestType)+"</small></td>");
		sbuf.append("		<td><small>"+getComing(guestType)+"</small></td>");
		sbuf.append("		<td><small>"+getNotComing(guestType)+"</small></td>");
		sbuf.append("  </tr>");
		sbuf.append("</tbody>");
		sbuf.append("</table>");
		return sbuf.toString();
	}
	
	private void calculatePlacesRemaining() throws Exception{
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select "+totalDayGuests+" - sum(guests) from guestlist where guesttype = 'DAY' and (accepted is null or accepted = 'Y')";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					guestsLeftToInvite = Integer.parseInt(dbs.getColumnAsString(1));
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	
	private void calculateHotelBookings() throws Exception{
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select count(*) from hotelbookings where paid = 'N'";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					hotelBookingsNeedingPayment = Integer.parseInt(dbs.getColumnAsString(1));
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}

	private void calculateRSVPRequests() throws Exception{
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = " select count(*) from RSVP where checked = 'N'";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					onlineRSVPNeedingChecking = Integer.parseInt(dbs.getColumnAsString(1));
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}	
	
	private void calculateRSVPStatus() throws Exception{
	try {
		DBSelect dbs = new DBSelect();
		dbs.setDataSourceName("jdbc/preds");
		String sql = " select guesttype, sum(GUESTS) as notyetaccepted from guestlist where accepted is null group by guesttype order by guesttype";
		dbs.setCommand(sql);
		dbs.execute();
		if (dbs.onRow()) {
			do{
				if (dbs.getColumnAsString(1).trim().equalsIgnoreCase("DAY")) dayGuestsNotConfirmed = Integer.parseInt(dbs.getColumnAsString(2));
				if (dbs.getColumnAsString(1).trim().equalsIgnoreCase("EVENING")) eveningGuestsNotConfirmed = Integer.parseInt(dbs.getColumnAsString(2));
			} while (dbs.next());
			dbs.close();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	public static int getTotalDayGuests() {
		return totalDayGuests;
	}

	public void setGuestsLeftToInvite(int guestsLeftToInvite) {
		this.guestsLeftToInvite = guestsLeftToInvite;
	}

	public String getRsvpEntriesHTML() {
		return rsvpEntriesHTML;
	}
	
}
