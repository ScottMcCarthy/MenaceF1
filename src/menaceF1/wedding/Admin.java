package menaceF1.wedding;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import menaceF1.Database.DatabaseUtils;


public class Admin {

	private static final int totalDayGuests = 100;
	private int dayGuestsNotConfirmed = 0;
	private int onlineRSVPNeedingChecking = 0;
	private int eveningGuestsNotConfirmed = 0;
	private String rsvpEntriesHTML = "";
	private String rsvpEntriesCompleteHTML = "";
	private String dayGuestTableHTML = "";
	private String eveningGuestTableHTML = "";
	private Map<String,String> paymentTypeMap;
	private Map<String,String> menuChoiceMap;
	private Map<String,String> paymentReceived;
	private int guestsLeftToInvite = 0;

	public boolean placeLeft() {
		return guestsLeftToInvite<totalDayGuests;
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
		rsvpEntriesHTML = loadRSVPHTML();
		rsvpEntriesCompleteHTML = loadRSVPCompleteHTML();
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

	private String loadRSVPHTML() throws Exception{
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
			String sql = "select ID,name,partnername,address1,address2,county,postcode,country,telephone,email,menuchoice,partnermenuchoice,specialrequirements,partnerspecialrequirements,comments  from rsvp where checked = 'N' order by ID";
			
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
					String guestSpecialRequirements = rs.getString(13);
					String partnerSpecialRequirements = rs.getString(14);
					if (guestSpecialRequirements == null) guestSpecialRequirements = "";
					if (partnerSpecialRequirements == null) partnerSpecialRequirements = "";
					
					sbuf.append("<form onsubmit=\"return confirmRSVP(this)\" method=\"post\" name=\"booking"+rs.getString(1)+"\" action=\"/MenaceF1/rsvpMapping.do\" >");
					sbuf.append("<input type=\"hidden\" name=\"RSVPID\" value=\""+rs.getString(1)+"\" >");
					sbuf.append("	<tr>");
					sbuf.append("		<td align=\"center\">"+rs.getString(2)+"</td>");
					sbuf.append("		<td align=\"center\">"+rs.getString(3)+"</td>");
					sbuf.append("		<td><small><a href=\"mailto:"+rs.getString(10)+"\">"+rs.getString(2)+"</a><br />"+rs.getString(4)+"<br />"+rs.getString(5)+"<br />"+rs.getString(6)+"<br />"+rs.getString(7)+"<br />"+rs.getString(8)+"<br />"+rs.getString(9)+"<br /></small></td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(rs.getString(11).trim())+"<br />"+guestSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(rs.getString(12).trim())+"<br />"+partnerSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+rs.getString(15)+"</td>");
					sbuf.append("		<td align=\"center\">"+Admin.getUnconfirmedGuestsListbox()+"</td>");
					sbuf.append("		<td align=\"center\"><input type=\"submit\" name=\"mapRSVP\" value=\"Confirm RSVP\"></td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		sbuf.append("	</tbody>");
		sbuf.append("</table>");		
		return sbuf.toString();
	}

	private String loadRSVPCompleteHTML() throws Exception{
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b><small>Name</small></b></td>");
		sbuf.append("		<td><b><small>Partner Name</small></b></td>");
		sbuf.append("		<td><b><small>Address</small></b></td>");
		sbuf.append("		<td><b><small>Menu Choice</small></b></td>");
		sbuf.append("		<td><b><small>Partner's menu choice</small></b></td>");
		sbuf.append("		<td><b><small>Comment</small></b></td>");
		sbuf.append("  </tr>");

		
		try {
			String sql = "select ID,name,partnername,address1,address2,county,postcode,country,telephone,email,menuchoice,partnermenuchoice,specialrequirements,partnerspecialrequirements,comments  from rsvp where checked = 'Y' order by ID";
			
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
					String guestSpecialRequirements = rs.getString(13);
					String partnerSpecialRequirements = rs.getString(14);
					if (guestSpecialRequirements == null) guestSpecialRequirements = "";
					if (partnerSpecialRequirements == null) partnerSpecialRequirements = "";
					
					sbuf.append("<form onsubmit=\"return confirmRSVP(this)\" method=\"post\" name=\"booking"+rs.getString(1)+"\" action=\"/MenaceF1/rsvpMapping.do\" >");
					sbuf.append("<input type=\"hidden\" name=\"RSVPID\" value=\""+rs.getString(1)+"\" >");
					sbuf.append("	<tr>");
					sbuf.append("		<td align=\"center\">"+rs.getString(2)+"</td>");
					sbuf.append("		<td align=\"center\">"+rs.getString(3)+"</td>");
					sbuf.append("		<td><small><a href=\"mailto:"+rs.getString(10)+"\">"+rs.getString(2)+"</a><br />"+rs.getString(4)+"<br />"+rs.getString(5)+"<br />"+rs.getString(6)+"<br />"+rs.getString(7)+"<br />"+rs.getString(8)+"<br />"+rs.getString(9)+"<br /></small></td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(rs.getString(11).trim())+"<br />"+guestSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+menuChoiceMap.get(rs.getString(12).trim())+"<br />"+partnerSpecialRequirements+"</td>");
					sbuf.append("		<td align=\"center\">"+rs.getString(15)+"</td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		sbuf.append("	</tbody>");
		sbuf.append("</table>");		
		return sbuf.toString();
	}
	
	
public static String getUnconfirmedGuestsListbox() throws Exception{
	StringBuffer sbuf = new StringBuffer();
	sbuf.append("<select name=\"realGuestID\">");
	
	try {
		String sql = "select ID,name,partnername from guestlist where accepted is null order by name";
		Connection conn = DatabaseUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()){
				sbuf.append("<option value=\""+rs.getString(1)+"\">"+rs.getString(2));
				if (rs.getString(3) != null) sbuf.append(" &amp; "+rs.getString(3));
				sbuf.append("</option>");
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
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted is null order by name";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					if (rs.getString(2).trim().equalsIgnoreCase("1")) sbuf.append(rs.getString(1)+"<br />");
					if (rs.getString(2).trim().equalsIgnoreCase("2")) sbuf.append(rs.getString(1)+" &amp; "+rs.getString(3)+"<br />");
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
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted = 'N' order by name";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					if (rs.getString(2).trim().equalsIgnoreCase("1")) sbuf.append(rs.getString(1)+"<br />");
					if (rs.getString(2).trim().equalsIgnoreCase("2")) sbuf.append(rs.getString(1)+" &amp; "+rs.getString(3)+"<br />");
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
			String sql = "select name,guests,partnername from guestlist where guesttype = '"+guestType+"' and accepted = 'Y' order by name";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					if (rs.getString(2).trim().equalsIgnoreCase("1")) sbuf.append(rs.getString(1)+"<br />");
					if (rs.getString(2).trim().equalsIgnoreCase("2")) sbuf.append(rs.getString(1)+" &amp; "+rs.getString(3)+"<br />");
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
			String sql = "select "+totalDayGuests+" - sum(guests) from guestlist where guesttype = 'DAY' and (accepted is null or accepted = 'Y')";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					guestsLeftToInvite = Integer.parseInt(rs.getString(1));
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}

	private void calculateRSVPRequests() throws Exception{
		try {
			String sql = " select count(*) from rsvp where checked = 'N'";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					onlineRSVPNeedingChecking = Integer.parseInt(rs.getString(1));
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}	
	
	private void calculateRSVPStatus() throws Exception{
	try {
		String sql = " select guesttype, sum(GUESTS) as notyetaccepted from guestlist where accepted is null group by guesttype order by guesttype";
		Connection conn = DatabaseUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()){
				if (rs.getString(1).trim().equalsIgnoreCase("DAY")) dayGuestsNotConfirmed = Integer.parseInt(rs.getString(2));
				if (rs.getString(1).trim().equalsIgnoreCase("EVENING")) eveningGuestsNotConfirmed = Integer.parseInt(rs.getString(2));
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

	public String getRsvpEntriesCompleteHTML() {
		return rsvpEntriesCompleteHTML;
	}	
	
}
