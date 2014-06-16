package menaceF1.wedding;

import menaceF1.struts.forms.HotelBookingFormBean;
import com.ibm.db.beans.DBModify;
import com.ibm.db.beans.DBParameterMetaData;
import com.ibm.db.beans.DBSelect;


public class Accomodation {

	public String availableRoomsHTML;	
	public boolean soldOut = false;
	public boolean roomFull = false;
	
	public Accomodation() throws Exception{
		loadAvailableRoomsHTML();
	}

	public boolean isRoomStillAvailable (String roomID) throws Exception{
		DBSelect dbs = new DBSelect();
		try {
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from hotels where rooms_available > rooms_booked and ID = "+roomID;
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.getRowCount()==0) {
				dbs.close();
				return false;
			} else dbs.close();
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	public String getMaxBookingNumber () throws Exception{
		DBSelect dbs = new DBSelect();
		String refNumber = "";
		try {
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select max(id) from hotelbookings";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.getRowCount() > 0) {
				if (dbs.onRow()) {
					refNumber   = dbs.getColumnAsString(1);
				}
			dbs.close();
			} 
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		return refNumber;
	}	
	
	public boolean submitBooking(HotelBookingFormBean booking) throws Exception{

		try {
			roomFull = !isRoomStillAvailable (booking.getRoomID());
			if (roomFull) return false;

					DBModify dbm = new DBModify();
					DBModify dbm2 = new DBModify();
					dbm.setDataSourceName("jdbc/preds");
					dbm2.setDataSourceName("jdbc/preds");
					String sql = "insert into hotelbookings (ROOM_ID,NAME,ADDRESS1,ADDRESS2,COUNTY,COUNTRY,POSTCODE,TELEPHONE,PAYMENTTYPE,DAYS,COST,PAID,BOOKING_TS,EMAIL) values (?,?,?,?,?,?,?,?,?,?,?,'N',current timestamp,?)";
					String sql2 = "update hotels set ROOMS_BOOKED = ROOMS_BOOKED+1 where ID = "+booking.getRoomID();
					dbm.setCommand(sql);
					dbm2.setCommand(sql2);
					DBParameterMetaData parmMetaData = dbm.getParameterMetaData();
					parmMetaData.setParameter(1,"ROOMID",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(2,"NAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(3,"ADDRESS1",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(4,"ADDRESS2",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(5,"COUNTY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(6,"COUNTRY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(7,"POSTCODE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(8,"TELEPHONE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(9,"PAYMENTTYPE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(10,"DAYS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(11,"COST",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
					parmMetaData.setParameter(12,"EMAIL",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				
					dbm.setParameterFromString("ROOMID", booking.getRoomID());
					dbm.setParameterFromString("NAME", booking.getName());
					dbm.setParameterFromString("ADDRESS1", booking.getAddress1());
					dbm.setParameterFromString("ADDRESS2", booking.getAddress2());
					dbm.setParameterFromString("COUNTY", booking.getCounty());
					dbm.setParameterFromString("COUNTRY", booking.getCountry());
					dbm.setParameterFromString("POSTCODE", booking.getPostcode());
					dbm.setParameterFromString("TELEPHONE", booking.getTelephone());
					dbm.setParameterFromString("PAYMENTTYPE", booking.getPaymentMethod());
					dbm.setParameterFromString("DAYS", booking.getNights());
					dbm.setParameterFromString("COST", booking.getRoomcost());
					dbm.setParameterFromString("EMAIL", booking.getEmail());
					
					dbm.execute();
					dbm.close();
					dbm2.execute();
					dbm2.close();
					} catch (Exception ex) {
						ex.printStackTrace();
						throw ex;
					}
	
		return true;
	}

	public static void markBookingPaid(String bookingID) throws Exception{
		
		DBModify dbm = new DBModify();
		try {
				dbm.setDataSourceName("jdbc/preds");
				String sql = "update hotelbookings set PAID = 'Y' where ID = "+bookingID;
				dbm.setCommand(sql);
				
				dbm.execute();
				dbm.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					dbm.close();
					throw ex;
				}
	}

	public String getAvailableRoomsHTML() {
		return availableRoomsHTML;
	}
	
	
	
	private void loadAvailableRoomsHTML() throws Exception{
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b><small>Hotel Name / Link to photos</small></b></td>");
		sbuf.append("		<td><b><small>Room Type</small></b></td>");
		sbuf.append("		<td><b><small>Description</small></b></td>");
		sbuf.append("		<td><b><small>Price per room per night</small></b></td>");
		sbuf.append("		<td><b><small>Nights required</small></b></td>");
		sbuf.append("		<td>&nbsp;</td>");
		sbuf.append("  </tr>");

		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from hotels where rooms_available > rooms_booked order by 2,3";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.getRowCount()==0) soldOut = true;
			if (dbs.onRow()) {
				do{
					sbuf.append("<form method=\"post\" name=\"booking"+dbs.getColumnAsString(1)+"\" action=\"/MenaceF1/hotelBookingForm.do\" >");
					sbuf.append("<input type=\"hidden\" name=\"ROOMID\" value=\""+dbs.getColumnAsString(1)+"\" >");
					sbuf.append("<input type=\"hidden\" name=\"HOTELNAME\" value=\""+dbs.getColumnAsString(2)+"\" >");
					sbuf.append("<input type=\"hidden\" name=\"ROOMTYPE\" value=\""+dbs.getColumnAsString(3)+"\" >");
					sbuf.append("<input type=\"hidden\" name=\"ROOMCOST\" value=\""+dbs.getColumnAsString(8)+"\" >");
					sbuf.append("	<tr>");
					sbuf.append("		<td><small><a href=\""+dbs.getColumnAsString(6)+"\" >"+dbs.getColumnAsString(2)+"</a></small></td>");
					sbuf.append("		<td><small>"+dbs.getColumnAsString(3)+"</small></td>");
					sbuf.append("		<td><small>"+dbs.getColumnAsString(7)+"</small></td>");
					sbuf.append("		<td><small>"+dbs.getColumnAsString(8)+"</small></td>");
					sbuf.append("		<td><small><select name=\"NIGHTS\"><option value=\"1\" selected>Saturday night only</option><option value=\"2\">Friday and Saturday night</option></select></small></td>");
					sbuf.append("		<td><small><input type=\"submit\" name=\"book\" value=\"Book this Room\"></small></td>");
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
		availableRoomsHTML = sbuf.toString();
	}

	public static String webNumber (float x){	
		String number = ""+x;
		if (number.indexOf('.')+2 == number.length()) number = number + "0";
		if (number.indexOf('.')+2 < number.length()) number = number.substring(0, number.indexOf('.')+3);
		return number;
}
}
