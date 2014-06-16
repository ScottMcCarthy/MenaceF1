package menaceF1;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import com.ibm.db.beans.DBModify;
import com.ibm.db.beans.DBSelect;


public class SeasonTicket {
	
	public static final int MATCH_TICKET_PRICE = 48;

	private static final String CHANGE_FIXTURE_PARAM = "ticketChangeID";
	private static final String JAMES_TICKET_PARAM = "james";
	private static final String MATT_TICKET_PARAM = "matt";
	private static final String SCOTT_TICKET_PARAM = "scott";
	private static final String MARK_AS_PAID_PARAM = "paidID";
	
	//To add extra people to the payment list, add to the following three methods:
	
	//First method
	private Map<String,String> labelsMap() {
		HashMap<String,String> labels = new HashMap<String,String>();
		labels.put("matt", "Matt");
		labels.put("james", "James");
		labels.put("scott", "Scott");
		labels.put("vicky", "Vicky");
		labels.put("ticketExchange", "Ticket Exchange");
		labels.put("unused", "Unused");
		return labels;
		
	}
	
	//second method
	private Map<String,String> namesMap() {
		HashMap<String,String> names = new HashMap<String,String>();
		names.put("m", "Matt");
		names.put("j", "James");
		names.put("s", "Scott");
		names.put("v", "Vicky");
		return names;
		
	}
	
	//Third method
	public boolean getFixtures(JspWriter out, HttpServletRequest req){
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select  name, image, competition, ticket_matt, ticket_james, date, id, ticket_scott from stmatches st, teams T where st.team_ID = T.team_id order by date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<tr align=\"center\"><td align='right'><small>"+dbs.getColumnAsString(6)+"</small></td>");
					out.println("<td align=\"center\"><img border='0' src='images/teams/arsenal.gif' /> v <img border='0' src='images/teams/"+dbs.getColumnAsString(2)+"' /></td>");
					out.println("<td align=\"center\"><small>"+dbs.getColumnAsString(3)+"</small></td>");
					out.println("<td align=\"center\"><small>"+dbs.getColumnAsString(4)+"</small></td>");
					out.println("<td align=\"center\"><small>"+dbs.getColumnAsString(5)+"</small></td>");
					out.println("<td align=\"center\"><small>"+dbs.getColumnAsString(8)+"</small></td>");
					out.println("<td align=\"center\"><small><a href='#change"+dbs.getRow()+"' class='lightview' title=\"Select who is using each ticket for this match\">change</a> </small>");
					
					out.println("<div style=\"display:none\" id='change"+dbs.getRow()+"'>");
					out.println("<br />");
					out.println("<p align=\"center\"><img border='0' src='images/teams/arsenal.gif' /><b> Arsenal Vs "+dbs.getColumnAsString(1));
					out.println("<img border='0' src='images/teams/"+dbs.getColumnAsString(2)+"' /></b><br />");
					out.println(dbs.getColumnAsString(3)+"</p>");
					out.println("<form action=\"seasonTickets.jsp\" method=\"get\">");
					out.println("	<table>");
					out.println("		<tr>");
					out.println("			<td>Matt's Ticket</td>");
					out.println("			<td>");
					out.println("				<select name=\""+MATT_TICKET_PARAM+"\">");
					out.println("					<option value=\""+checkIgnore("matt",dbs.getColumnAsString(4),"matt")+"\""+insertSelected("matt",dbs.getColumnAsString(4))+">Matt</option>");
					out.println("					<option value=\""+checkIgnore("james",dbs.getColumnAsString(4),"james")+"\""+insertSelected("james",dbs.getColumnAsString(4))+">James</option>");
					out.println("					<option value=\""+checkIgnore("scott",dbs.getColumnAsString(4),"scott")+"\""+insertSelected("scott",dbs.getColumnAsString(4))+">Scott</option>");
					out.println("					<option value=\""+checkIgnore("vicky",dbs.getColumnAsString(4),"vicky")+"\""+insertSelected("vicky",dbs.getColumnAsString(4))+">Vicky</option>");
					out.println("					<option value=\""+checkIgnore("ticket Exchange",dbs.getColumnAsString(4),"ticketExchange")+"\""+insertSelected("ticket Exchange",dbs.getColumnAsString(4))+">Ticket Exchange</option>");
					out.println("					<option value=\""+checkIgnore("unused",dbs.getColumnAsString(4),"unused")+"\""+insertSelected("unused",dbs.getColumnAsString(4))+">Unused</option>");
					out.println("				</select>");
					out.println("			</td>");
					out.println("		</tr>");
					out.println("		<tr>");
					out.println("			<td>James's Ticket</td>");
					out.println("			<td>");
					out.println("				<select name=\""+JAMES_TICKET_PARAM+"\">");
					out.println("					<option value=\""+checkIgnore("matt",dbs.getColumnAsString(5),"matt")+"\""+insertSelected("matt",dbs.getColumnAsString(5))+">Matt</option>");
					out.println("					<option value=\""+checkIgnore("james",dbs.getColumnAsString(5),"james")+"\""+insertSelected("james",dbs.getColumnAsString(5))+">James</option>");
					out.println("					<option value=\""+checkIgnore("scott",dbs.getColumnAsString(5),"scott")+"\""+insertSelected("scott",dbs.getColumnAsString(5))+">Scott</option>");
					out.println("					<option value=\""+checkIgnore("vicky",dbs.getColumnAsString(4),"vicky")+"\""+insertSelected("vicky",dbs.getColumnAsString(4))+">Vicky</option>");
					out.println("					<option value=\""+checkIgnore("ticket Exchange",dbs.getColumnAsString(5),"ticketExchange")+"\""+insertSelected("ticket Exchange",dbs.getColumnAsString(5))+">Ticket Exchange</option>");
					out.println("					<option value=\""+checkIgnore("unused",dbs.getColumnAsString(5),"unused")+"\""+insertSelected("unused",dbs.getColumnAsString(5))+">Unused</option>");
					out.println("				</select>");
					out.println("			</td>");
					out.println("		</tr>");
					out.println("		<tr>");
					out.println("			<td>Scott's Ticket</td>");
					out.println("			<td>");
					out.println("				<select name=\""+SCOTT_TICKET_PARAM+"\">");
					out.println("					<option value=\""+checkIgnore("matt",dbs.getColumnAsString(8),"matt")+"\""+insertSelected("matt",dbs.getColumnAsString(8))+">Matt</option>");
					out.println("					<option value=\""+checkIgnore("james",dbs.getColumnAsString(8),"james")+"\""+insertSelected("james",dbs.getColumnAsString(8))+">James</option>");
					out.println("					<option value=\""+checkIgnore("scott",dbs.getColumnAsString(8),"scott")+"\""+insertSelected("scott",dbs.getColumnAsString(8))+">Scott</option>");
					out.println("					<option value=\""+checkIgnore("vicky",dbs.getColumnAsString(4),"vicky")+"\""+insertSelected("vicky",dbs.getColumnAsString(4))+">Vicky</option>");
					out.println("					<option value=\""+checkIgnore("ticket Exchange",dbs.getColumnAsString(8),"ticketExchange")+"\""+insertSelected("ticket Exchange",dbs.getColumnAsString(8))+">Ticket Exchange</option>");
					out.println("					<option value=\""+checkIgnore("unused",dbs.getColumnAsString(8),"unused")+"\""+insertSelected("unused",dbs.getColumnAsString(8))+">Unused</option>");
					out.println("				</select>");
					out.println("			</td>");
					out.println("		</tr>");
					out.println("	</table>");
					out.println("<br />");
					out.println("<input type=\"hidden\" name=\""+CHANGE_FIXTURE_PARAM+"\" value=\""+dbs.getColumnAsString(7)+"\" />");
					out.println("	<input type=\"submit\" value=\"Submit\" />					");
					out.println("</form>");
					out.println("</div>");
					
					out.println("</td></tr>");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}	
	
	
	
	public void actionUpdates(HttpServletRequest req){
		//Work out what actions to do
		String fixtureUpdateID = req.getParameter(CHANGE_FIXTURE_PARAM);
		String jamesTicket = req.getParameter(JAMES_TICKET_PARAM);
		String mattsTicket = req.getParameter(MATT_TICKET_PARAM);
		String scottTicket = req.getParameter(SCOTT_TICKET_PARAM);
		String markAsPaidID = req.getParameter(MARK_AS_PAID_PARAM);
		
		if (fixtureUpdateID != null) updateTicketAllocation(Integer.parseInt(fixtureUpdateID), mattsTicket, jamesTicket, scottTicket);
		if (markAsPaidID != null) markAsPaid(Integer.parseInt(markAsPaidID));
		
		
	}

	private void markAsPaid(int id) {
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
				
				String sql = "update MATCH_PAYMENTS set PAID='Y', date_paid = current date where paid = 'N'   "+
					" and id = "+id;
					dbm.setCommand(sql);
				dbm.execute();
			dbm.close();
		}
			catch (SQLException sql) {
				sql.printStackTrace();
		}		
	}

	private void updateTicketAllocation(int id, String mattsTicket, String jamesTicket, String scottTicket) {
		try{
			DBModify dbm1 = new DBModify();
			DBModify dbm2 = new DBModify();
			DBModify dbm3 = new DBModify();
			dbm1.setDataSourceName("jdbc/preds");
			dbm2.setDataSourceName("jdbc/preds");
			dbm3.setDataSourceName("jdbc/preds");
				
				String sql1 = "update STMATCHES set  "+
					" TICKET_MATT = '"+labelsMap().get(mattsTicket)+
					"' where id = "+id;
					dbm1.setCommand(sql1);
				if (!mattsTicket.equalsIgnoreCase("ignore")) dbm1.execute();
			dbm1.close();

			String sql2 = "update STMATCHES set  "+
			" TICKET_JAMES = '"+labelsMap().get(jamesTicket)+
			"' where id = "+id;
			dbm2.setCommand(sql2);
			if (!jamesTicket.equalsIgnoreCase("ignore")) dbm2.execute();
	dbm2.close();
			
			String sql3 = "update STMATCHES set  "+
				" TICKET_SCOTT = '"+labelsMap().get(scottTicket)+
					"' where id = "+id;
				dbm3.setCommand(sql3);
					if (!scottTicket.equalsIgnoreCase("ignore")) dbm3.execute();
				dbm3.close();
		}
			catch (SQLException sql) {
				sql.printStackTrace();
		}
		clearMatchPayment(id);	
		addMatchPayment(id, "matt", mattsTicket);
		addMatchPayment(id, "james", jamesTicket);
		addMatchPayment(id, "scott", scottTicket);
	}
	
	private void clearMatchPayment(int matchID){
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
				
				String sql = "delete from MATCH_PAYMENTS where paid = 'N' and MATCH_ID = "+matchID;
					dbm.setCommand(sql);
				dbm.execute();
			dbm.close();
		}
			catch (SQLException sql) {
				sql.printStackTrace();
		}			
	}
	
	private void addMatchPayment(int matchID, String seasonTicket, String used_by) {
		char seasonTicketInitial = seasonTicket.charAt(0);
		char usedByInitial = used_by.charAt(0);
		
			if (seasonTicket.equalsIgnoreCase(used_by)) return;
			if (used_by.equalsIgnoreCase("ticketExchange")) return;
			if (used_by.equalsIgnoreCase("Unused")) return;
			if (used_by.equalsIgnoreCase("ignore")) return;	
			
			
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
				
				String sql = "insert into MATCH_PAYMENTS (ID, MATCH_ID, SEASON_TICKET, USED_BY, PAID, AMOUNT) VALUES (  "+
					nextIDNumberForMatchPayments()+", "+
					matchID+", "+
					"'"+seasonTicketInitial+"', "+
					"'"+usedByInitial+"', "+
					"'N', "+
					MATCH_TICKET_PRICE+" )";
					dbm.setCommand(sql);
				System.out.println(sql);	
				dbm.execute();
			dbm.close();
		}
			catch (SQLException sql) {
				sql.printStackTrace();
		}			
		
	}
	
	private String nextIDNumberForMatchPayments() {
		int nextID = 0;
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select max(id) from match_payments";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					String maxID = dbs.getColumnAsString(1);
					if (maxID!=null) nextID = Integer.parseInt(maxID);
					nextID++;
				} while (dbs.next());
			}
			dbs.close();
		}
		catch (Exception e) {e.printStackTrace();return "0";
		}
		return ""+nextID;
	}
	
	private String insertSelected(String value1, String value2){
		System.out.println("Comparing "+value1+" with "+value2);
		if (value1.trim().equalsIgnoreCase(value2.trim())) {
			return "selected=\"selected\"";
		}
		return "";
	}

	private String checkIgnore(String value1, String value2, String idValue){
		if (value1.trim().equalsIgnoreCase(value2.trim())) {
			return "ignore";
		}
		return idValue;
	}
	
	public boolean getPaymentsPending(JspWriter out, HttpServletRequest req){
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select a.id, a.season_ticket, a.used_by, amount, competition, name, b.date, image  from match_payments a, stmatches b, teams t where b.team_id = t.team_id and a.match_id = b.id and paid = 'N'";
			System.out.println(sql);
			dbs.setCommand(sql);
			dbs.execute();
			boolean noPending = true;
			if (dbs.onRow()) {
				do{
					noPending = false;
					out.println("<td>"+namesMap().get(dbs.getColumnAsString(3).trim())+" owes "+namesMap().get(dbs.getColumnAsString(2))+" ¬"+dbs.getColumnAsString(4)+" for the "+dbs.getColumnAsString(5)+" match against "+dbs.getColumnAsString(6)+" on "+dbs.getColumnAsString(7)+". </td>");
					out.println("<td><small><a href='#pay"+dbs.getRow()+"' class='lightview' title=\"Mark this match as paid\">Mark as paid</a> </small>");

					out.println("<div style=\"display:none\" id='pay"+dbs.getRow()+"'>");
					out.println("<br />");
					
					out.println("<p align=\"center\"><img border='0' src='images/teams/arsenal.gif' /><b> Arsenal Vs "+dbs.getColumnAsString(6));
					out.println("<img border='0' src='images/teams/"+dbs.getColumnAsString(8)+"' /></b><br />");
					out.println(dbs.getColumnAsString(5)+"</p>");
					
					
					out.println("<br />");
					out.println("Click the button below once payment has been transferred to "+namesMap().get(dbs.getColumnAsString(2)));
					out.println("<form action=\"seasonTickets.jsp\" method=\"get\">");
					out.println("<br />");
					out.println("<input type=\"hidden\" name=\""+MARK_AS_PAID_PARAM+"\" value=\""+dbs.getColumnAsString(1)+"\" />");
					out.println("<p align=\"center\"><input type=\"submit\" value=\"Mark as paid\" /></p>					");
					out.println("</form>");
					out.println("</div>");
					
					out.println("</td></tr>");
				} while (dbs.next());
				dbs.close();
			}
			if (noPending) out.println("<td>There are no payments pending at the moment</td>");
			
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}	
	
	public boolean getPaymentHistory(JspWriter out, HttpServletRequest req){
		
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select image, a.season_ticket, a.used_by, amount, competition, name, b.date  from match_payments a, stmatches b, teams t where b.team_id = t.team_id and a.match_id = b.id and paid = 'Y'";
			System.out.println(sql);
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<tr><td align='left'><small>"+dbs.getColumnAsString(7)+"</small></td>");
					out.println("<td><img border='0' src='images/teams/arsenal.gif' /> v <img border='0' src='images/teams/"+dbs.getColumnAsString(1)+"' /></td>");
					out.println("<td><small>"+dbs.getColumnAsString(5)+"</small></td>");					
					out.println("<td>"+namesMap().get(dbs.getColumnAsString(3).trim())+" paid "+namesMap().get(dbs.getColumnAsString(2))+" ¬"+dbs.getColumnAsString(4)+" </td>");
					out.println("</td></tr>");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}		
}
