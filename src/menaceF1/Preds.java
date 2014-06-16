/*
 * Created on 02-May-04
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package menaceF1;
import javax.servlet.jsp.JspWriter;
import com.ibm.db.beans.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Scott McCarthy
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Preds {

	private String news = new String();
	private String name = new String();
	private String email = new String();
	private String subject = new String();




	public boolean getTeamSelect(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "Select * from teams order by name";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<option value='"+dbs.getColumnAsString(1)+"'>"+dbs.getColumnAsString(2)+" </option>");				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public String fullDate(String d){
	String year  = d.substring(0,4);
	String month = d.substring(5,7);
	String date  = d.substring(8,10);

	return date+"/"+month+"/"+year;	
	}



	public boolean matchInProgress(){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select count(*) from matchdays where current date between start_date and end_date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(1).trim().equals("0")) {return false;};
				} while (dbs.next());
				dbs.close();
				return true;
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}




	public String currentMatch(){
	String matchday;
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from matchdays where current date between start_date and end_date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					matchday = (dbs.getColumnAsString(1).trim()+" in progress <br> "+dbs.getColumnAsString(2).trim()+" to "+dbs.getColumnAsString(3).trim());
				} while (dbs.next());
				dbs.close();
				return matchday;
			}
		}
		catch (Exception e) {e.printStackTrace();return "";
		}
		return "";
	}

	public String currentMatchPreds(){
	String matchday;
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from matchdays where current date between start_date and end_date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					matchday = (dbs.getColumnAsString(1).trim()+"<br> "+dbs.getColumnAsString(2).trim()+" to "+dbs.getColumnAsString(3).trim());
				} while (dbs.next());
				dbs.close();
				return matchday;
			}
		}
		catch (Exception e) {e.printStackTrace();return "";
		}
		return "";
	}

	
	private String getMatchdaysPlayedForPlayerId(String playerID){
		String matchesPlayed;
			try {
				DBSelect dbs = new DBSelect();
				dbs.setDataSourceName("jdbc/preds");
				String sql = "select count(distinct matchday) from preds A, fixtures B, matchdays C where A.fixture_id = B.fixture_id and B.matchday = C.day and start_date <= current_date and player_id = "+playerID+" group by player_id";
				//String sql = "select count(distinct matchday) from preds A, fixtures B where A.fixture_id = B.fixture_id and player_id = "+playerID+" group by player_id";
				dbs.setCommand(sql);
				dbs.execute();
				if (dbs.onRow()) {
					do{
						matchesPlayed = dbs.getColumnAsString(1).trim();
					} while (dbs.next());
					dbs.close();
					return matchesPlayed;
				}
				dbs.close();
			}
			catch (Exception e) {e.printStackTrace();return "0";
			}
			return "0";
		}

	
	public String getNextMatchday(){
	String matchday;
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from matchdays where start_date > current date fetch first 1 row only";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					matchday = ("Matchday "+dbs.getColumnAsString(1).trim()+" <br> from "+fullDate(dbs.getColumnAsString(2).trim())+" to "+fullDate(dbs.getColumnAsString(3).trim()));
				} while (dbs.next());
				dbs.close();
				return matchday;
			}
		}
		catch (Exception e) {e.printStackTrace();return "";
		}
		return "";
	}

public void predReminder() {
	
	try {
		DBSelect dbs = new DBSelect();
		dbs.setDataSourceName("jdbc/preds");
		String sql = "select * from matchdays where start_date = current date + 1 day and day != 99 fetch first 1 row only";
		dbs.setCommand(sql);
		dbs.execute();
		if (dbs.onRow()) {
			do{
					DBSelect players = new DBSelect();
					players.setDataSourceName("jdbc/preds");
					String playersSQL = "select FIRSTNAME, EMAIL from players where player_id not in (select player_id from preds P, fixtures F where P.fixture_id = F.fixture_id and matchday ="+dbs.getColumnAsString(1).trim()+" )";
					players.setCommand(playersSQL);
						players.execute();
					if (players.onRow()) {
						do{
							Email reminder = new Email("PREDS");
							reminder.setMimeType(Email.HTML);
							reminder.setSendTo(players.getColumnAsString(2).trim());
							reminder.setSubject("Enter your preds for matchday " + dbs.getColumnAsString(1).trim());
							reminder.println("Hi "+players.getColumnAsString(1).trim()+",");
							reminder.println("<BR>");
							reminder.println("<BR>");
							reminder.println("You have not yet submitted your predictions for Matchday "+dbs.getColumnAsString(1).trim()+".");
							reminder.println("<BR>");
							reminder.println("<BR>");
							reminder.println("You have until midnight tonight to submit your predictions at <a href='http://www.menacef1.co.uk'>www.menacef1.co.uk</a>.");
							reminder.println("<BR>");
							reminder.println("<BR>");
							reminder.println("Thanks and good luck!");
							reminder.println("<BR>");
							reminder.println("<BR>");
							reminder.println("Scott");

							reminder.send(players.getColumnAsString(2));

						} while (players.next());
						players.close();
					}	

//				matchday = dbs.getColumnAsString(1).trim()+" <br> from "+fullDate(dbs.getColumnAsString(2).trim())+" to "+fullDate(dbs.getColumnAsString(3).trim()));
			} while (dbs.next());
			dbs.close();
		}
		EmailSender menaceMail = new EmailSender();
		menaceMail.go();
	}
	catch (Exception e) {e.printStackTrace();
	}
	
	
}

	public boolean moveFixtureSelect(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select fixture_id, matchday, HT.name, AT.name from fixtures F, Teams HT, teams AT where F.hometeam = HT.team_Id and F.awayteam = AT.team_id order by matchday";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<option value='"+dbs.getColumnAsString(1)+"'>"+dbs.getColumnAsString(2)+". "+dbs.getColumnAsString(3)+" Vs "+dbs.getColumnAsString(4)+" </option>");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}


		
	public boolean getMatchdaySelect(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "Select * from matchdays order by start_date";
			dbs.setCommand(sql);
			out.println("<option value='0'></option>");
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<option value='"+dbs.getColumnAsString(1)+"'>"+dbs.getColumnAsString(1)+". "+fullDate(dbs.getColumnAsString(2))+" - "+fullDate(dbs.getColumnAsString(3))+" </option>");
				} while (dbs.next());
				dbs.close();
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	
	public boolean getLeagueTable(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select  firstname, surname, name, image, points, player_id from players P, teams T where P.team_ID = T.team_id order by points desc";
			dbs.setCommand(sql);
			dbs.execute();
			out.println("<table>");
			out.println("<th><td><small>Player</small></td><td><small>Points (Matchdays&nbsp;Played)</small></td></th>");
			if (dbs.onRow()) {
				do{
					out.println("<tr><td><IMG border='0' src='../images/teams/"+dbs.getColumnAsString(4)+"'></td>");
					out.println("<td><small>"+dbs.getColumnAsString(1)+" "+dbs.getColumnAsString(2)+"</small></td>");
					out.println("<td align='right'><small>"+dbs.getColumnAsString(5)+" ("+getMatchdaysPlayedForPlayerId(dbs.getColumnAsString(6))+")</small></td></tr>");
				} while (dbs.next());
				dbs.close();
				out.println("</table>");
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public boolean getCompletedMatchdays(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from matchdays where end_date < current date order by start_date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<A href='results.jsp?matchday="+dbs.getColumnAsString(1).trim()+"'>Matchday "+dbs.getColumnAsString(1).trim()+". "+fullDate(dbs.getColumnAsString(2).trim())+" to "+fullDate(dbs.getColumnAsString(3).trim())+"</a><br>");
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public boolean showNews(JspWriter out, HttpServletRequest req, int articles){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from news order by posted desc fetch first "+articles+" rows only";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<i>"+dbs.getColumnAsString(1)+"</i><br>"+dbs.getColumnAsString(2)+"<br><br>");
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public boolean showFeedback(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select * from feedback order by TS desc";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<i>"+dbs.getColumnAsString(1)+"</i><br>"+dbs.getColumnAsString(2)+"- "+dbs.getColumnAsString(3)+"<b> "+dbs.getColumnAsString(4)+"</b><br><FONT color='green'>"+dbs.getColumnAsString(5)+"</font><br><br>");
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}



	public boolean getCompletedMatchdaysAdmin(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select matchday, max(start_Date), max(end_date) from matchdays M, fixtures F where M.day = F.matchday and start_date < current date  and F.homescore is null group by matchday order by matchday ";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<A href='enterResults2.jsp?matchday="+dbs.getColumnAsString(1).trim()+"'>Matchday "+dbs.getColumnAsString(1).trim()+". "+fullDate(dbs.getColumnAsString(2).trim())+" to "+fullDate(dbs.getColumnAsString(3).trim())+"</a><br>");
				} while (dbs.next());
			} else {out.println("There are no matchdays that are awaiting results to be submitted.");
			}
			dbs.close();
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}



	public boolean allActivePreds(JspWriter out, HttpServletRequest req){
	
		try {
			DBSelect dbs1 = new DBSelect();
			DBSelect dbs2 = new DBSelect();
			DBSelect dbs3 = new DBSelect();
			dbs1.setDataSourceName("jdbc/preds");
			dbs2.setDataSourceName("jdbc/preds");
			dbs3.setDataSourceName("jdbc/preds");

			String sql1= "select F.fixture_ID,  HT.name, HT.image, AT.name, AT.image "+
 						 "from  fixtures F, matchdays M, teams HT, teams AT "+
						 "where  F.matchday = M.day "+
						 "and F.hometeam = HT.team_id "+
						 "and F.awayteam = AT.team_id "+
						 "and current date between start_date and end_date "+
						 "order by fixture_id ";

			String sql2= "select firstname, surname, F.fixture_ID, home_score, away_score, HT.name, HT.image, AT.name, AT.image, P.player_id"+
						" from players P, preds PR, fixtures F, matchdays M, teams HT, teams AT"+
						" where P.player_ID = PR.player_ID"+
						" and PR.fixture_id = F.fixture_id"+
						" and F.matchday = M.day"+
						" and F.hometeam = HT.team_id"+
						" and F.awayteam = AT.team_id"+
						" and current date between start_date and end_date"+
						" order by surname, firstname, fixture_id";

			String sql3= "select P.player_Id, max(firstname), max(surname)"+
						" from players P, preds PR, fixtures F, matchdays M, teams HT, teams AT"+
						" where P.player_ID = PR.player_ID"+
						" and PR.fixture_id = F.fixture_id"+
						" and F.matchday = M.day"+
						" and F.hometeam = HT.team_id"+
						" and F.awayteam = AT.team_id"+
						" and current date between start_date and end_date"+
						" group by P.player_id"+
						" order by max(surname), max(firstname)";


			dbs1.setCommand(sql1);
			dbs1.execute();
			out.println("<Table border='1'><tr><td></td>");
			int fixtures = dbs1.getRowCount();
			String[] fixtureArray = new String[10000];
			int count=1;
			String[][] allPreds = new String[10000][10000];
			if (dbs1.onRow()) {
				do{
					out.println("<td><IMG border='0' src='../images/teams/"+dbs1.getColumnAsString(3)+"'><br><IMG border='0' src='../images/teams/"+dbs1.getColumnAsString(5)+"'></td>");
					fixtureArray[count]=dbs1.getColumnAsString(1);
					count++;
		
						} while (dbs1.next());
				dbs1.close();
			out.println("</tr>");
			dbs2.setCommand(sql2);
			dbs2.execute();
			if (dbs2.onRow()) {
				do{
					allPreds[Integer.parseInt(dbs2.getColumnAsString(10))][Integer.parseInt(dbs2.getColumnAsString(3))] = ""+dbs2.getColumnAsString(4)+"-"+dbs2.getColumnAsString(5);	
				} while (dbs2.next());
				dbs2.close();
			}

			dbs3.setCommand(sql3);
			dbs3.execute();

			if (dbs3.onRow()) {
				do{
				out.println("<tr><td>"+dbs3.getColumnAsString(2)+" "+dbs3.getColumnAsString(3)+"</td>");
				for (int x=1;x<=fixtures;x++){
					if (allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray[x])]==null) {allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray[x])] = "-";}
					out.println("<td align='center'>"+allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray[x])]+"</td>");
				}
				out.println("</tr>");
					 	
				} while (dbs3.next());
				dbs3.close();
			}

			out.println("</table>");
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}


	public boolean showResults(JspWriter out, HttpServletRequest req, String matchday){
	
		try {
			DBSelect dbs1 = new DBSelect();
			DBSelect dbsR = new DBSelect();
			DBSelect dbsP = new DBSelect();
			DBSelect dbs2 = new DBSelect();
			DBSelect dbs3 = new DBSelect();
			dbs1.setDataSourceName("jdbc/preds");
			dbs2.setDataSourceName("jdbc/preds");
			dbs3.setDataSourceName("jdbc/preds");
			dbsR.setDataSourceName("jdbc/preds");
			dbsP.setDataSourceName("jdbc/preds");

			String sql1= "select F.fixture_ID,  HT.name, HT.image, AT.name, AT.image "+
						 "from  fixtures F, matchdays M, teams HT, teams AT "+
						 "where  F.matchday = M.day "+
						 "and F.hometeam = HT.team_id "+
						 "and F.awayteam = AT.team_id "+
						 "and matchday = "+matchday+
						 " and homescore is not null "+
						 " order by fixture_id ";

			String sqlR= "select F.fixture_ID, homescore, awayscore "+
						 "from  fixtures F, matchdays M "+
						 "where  F.matchday = M.day "+
						 "and matchday = "+matchday+
						 " order by fixture_id ";

			String sqlP   = "select player_ID, sum(points) from ("+
							" select P.player_id, home_score, away_score, homescore, awayscore,"+
							" CASE WHEN home_score = homescore AND away_score = awayscore THEN 3"+ 
							" WHEN home_score > away_score AND homescore > awayscore THEN 1"+ 
							" WHEN home_score < away_score AND homescore < awayscore THEN 1"+
							" WHEN home_score = away_score AND homescore = awayscore THEN 1"+
							" ELSE 0"+
							" END AS points"+
							" from players P, preds PR, fixtures F"+
							" where P.player_id = PR.player_Id"+
							" and PR.fixture_id = F.fixture_id"+
							" and matchday ="+matchday+
							" and homescore is not null"+
							" and home_score is not null"+
							" ) A"+
							" group by player_id";



			String sql2= "select firstname, surname, F.fixture_ID, home_score, away_score, HT.name, HT.image, AT.name, AT.image, P.player_id"+
						" from players P, preds PR, fixtures F, matchdays M, teams HT, teams AT"+
						" where P.player_ID = PR.player_ID"+
						" and PR.fixture_id = F.fixture_id"+
						" and F.matchday = M.day"+
						" and F.hometeam = HT.team_id"+
						" and F.awayteam = AT.team_id"+
						" and matchday = "+matchday+ 
						" order by surname, firstname, fixture_id";

			String sql3= "select P.player_Id, max(firstname), max(surname)"+
						" from players P, preds PR, fixtures F, matchdays M, teams HT, teams AT"+
						" where P.player_ID = PR.player_ID"+
						" and PR.fixture_id = F.fixture_id"+
						" and F.matchday = M.day"+
						" and F.hometeam = HT.team_id"+
						" and F.awayteam = AT.team_id"+
						" and matchday = "+matchday+
						" group by P.player_id"+
						" order by max(surname), max(firstname)";


			dbs1.setCommand(sql1);
			dbs1.execute();
			out.println("<Table border='1'><tr><td></td>");
			int fixtures = dbs1.getRowCount();
			List<String> fixtureArray = new ArrayList<String>();
			int count=1;
			String[][] allPreds = new String[10000][10000];
			if (dbs1.onRow()) {
				do{
					out.println("<td><IMG border='0' src='../images/teams/"+dbs1.getColumnAsString(3)+"'><br><IMG border='0' src='../images/teams/"+dbs1.getColumnAsString(5)+"'></td>");
					fixtureArray.add(dbs1.getColumnAsString(1));
					count++;
		
						} while (dbs1.next());
			} else {
				out.println("</table><B>Results for this matchday have not been uploaded yet.<br>  Please come back later.</B>");
				return true;
			}
				dbs1.close();
			out.println("<td></td></tr>");

			dbsR.setCommand(sqlR);
			dbsR.execute();
			out.println("<tr><td bgcolor='yellow'><b>Actual Result</b></td>");
			if (dbsR.onRow()) {
				do{
					out.println("<td align='center'  bgcolor='yellow'><b>"+dbsR.getColumnAsString(2)+"-"+dbsR.getColumnAsString(3)+"</b></td>");
		
						} while (dbsR.next());
				dbsR.close();
			out.println("<td  bgcolor='yellow'><b>Points</b></td></tr>");
			}

			dbs2.setCommand(sql2);
			dbs2.execute();
			if (dbs2.onRow()) {
				do{
					allPreds[Integer.parseInt(dbs2.getColumnAsString(10))][Integer.parseInt(dbs2.getColumnAsString(3))] = ""+dbs2.getColumnAsString(4)+"-"+dbs2.getColumnAsString(5);	
				} while (dbs2.next());
			}
			dbs2.close();
			dbs3.setCommand(sql3);
			dbs3.execute();

			dbsP.setCommand(sqlP);
			dbsP.execute();
			String[] points = new String[1000];
			if (dbsP.onRow()) {
				do{
					points[Integer.parseInt(dbsP.getColumnAsString(1))] = dbsP.getColumnAsString(2);	
				} while (dbsP.next());
			}
			dbsP.close();


			dbs3.setCommand(sql3);
			dbs3.execute();
			if (dbs3.onRow()) {
				do{
				out.println("<tr><td>"+dbs3.getColumnAsString(2)+" "+dbs3.getColumnAsString(3)+"</td>");
				for (int x=1;x<=fixtures;x++){
					if (allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray.get(x-1))]==null) {allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray.get(x-1))] = "-";}
					out.println("<td align='center'>"+allPreds[Integer.parseInt(dbs3.getColumnAsString(1))][Integer.parseInt(fixtureArray.get(x-1))]+"</td>");
				}
				out.println("<td align='center'><b>"+points[Integer.parseInt(dbs3.getColumnAsString(1))]+"</b></td>");
				out.println("</tr>");
					 	
				} while (dbs3.next());
			}
			dbs3.close();
			out.println("</table>");
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}



	public boolean getFutureMatchdays(JspWriter out, HttpServletRequest req, String player){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select day, start_Date, end_date, count(home_score) - count(f.fixture_id)  from matchdays M, Fixtures F left outer join preds P on (F.fixture_id = P.fixture_id and P.Player_id = "+player+") where M.day = F.matchday and start_date > current date group by day, start_date, end_date order by start_Date";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					out.println("<A href='submitPreds.jsp?matchday="+dbs.getColumnAsString(1).trim()+"'>Matchday "+dbs.getColumnAsString(1).trim()+". "+fullDate(dbs.getColumnAsString(2).trim())+" to "+fullDate(dbs.getColumnAsString(3).trim())+"</a>");
					if (dbs.getColumnAsString(4).equals("0")) {out.println("<font color='green'><IMG border='0' src='../images/tick.gif'></font>");}
					out.println("<br>") ;
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public boolean calculateScores(){
	
		try {
			DBSelect dbs = new DBSelect();
			DBModify dbm = new DBModify();
			dbs.setDataSourceName("jdbc/preds");
			dbm.setDataSourceName("jdbc/preds");
			String sql = "select player_ID, sum(points) from ("+
							" select P.player_id, home_score, away_score, homescore, awayscore,"+
							" CASE WHEN home_score = homescore AND away_score = awayscore THEN 3"+ 
							" WHEN home_score > away_score AND homescore > awayscore THEN 1"+ 
							" WHEN home_score < away_score AND homescore < awayscore THEN 1"+
							" WHEN home_score = away_score AND homescore = awayscore THEN 1"+
							" ELSE 0"+
							" END AS points"+
							" from players P, preds PR, fixtures F"+
							" where P.player_id = PR.player_Id"+
							" and PR.fixture_id = F.fixture_id"+
							" and homescore is not null"+
							" and home_score is not null"+
							" ) A"+
							" group by player_id";
			dbs.setCommand(sql);
			dbs.execute();
			String[] points = new String[1000];
			String[] players = new String[1000];
			int row=1;
			if (dbs.onRow()) {
				do{
					points[Integer.parseInt(dbs.getColumnAsString(1))] = dbs.getColumnAsString(2); 
					players[row]=dbs.getColumnAsString(1);
					row++;
				} while (dbs.next());
			}
			dbs.close();
			
			for (int x=1;x<row;x++){
				String scoreSQL = "update players set points = "+points[Integer.parseInt(players[x])]+" where player_id = "+Integer.parseInt(players[x]);
				dbm.setCommand(scoreSQL);
				dbm.execute();
				
			}

		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}


	public boolean getPreds(JspWriter out, HttpServletRequest req, String player, String matchday){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select hometeam, T1.name, T1.image, awayteam, T2.name, T2.image, home_score, away_score, F.fixture_id  from matchdays M, Teams T1, teams T2, fixtures F left outer join preds P on (P.fixture_id = F.fixture_id and player_id = "+player+") where  F.matchday = M.day and F.hometeam = T1.team_id and F.awayteam = T2.team_id and matchday = "+matchday+" order by T1.name";
			dbs.setCommand(sql);
			dbs.execute();
			int x=1;
			int y=1;
			String[] homeScore = new String[10];
			String[] awayScore = new String[10];
					
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(7)!=null){
						for (y=0;y<10;y++) {
							if (dbs.getColumnAsString(7).equals(""+y)) {
								homeScore[y]="SELECTED";
							} else homeScore[y] =" ";
						}
					} else for (y=0;y<10;y++) { homeScore[y] =" ";}
					if (dbs.getColumnAsString(8)!=null){
							for (y=0;y<10;y++) {
								if (dbs.getColumnAsString(8).equals(""+y)) {
									awayScore[y]="SELECTED";
								} else awayScore[y] =" ";
							}
						} else for (y=0;y<10;y++) { awayScore[y] =" ";}
					
					out.println("<tr>");
					out.println("<td>"+dbs.getColumnAsString(2).trim()+"</td>");
					out.println("<td><IMG border='0' src='../images/teams/"+dbs.getColumnAsString(3)+"'></td>");
					out.println("<td><select name='homeScore"+x+"'>");
					out.println("<option value='null'></option>");
					out.println("<option value='0' "+homeScore[0]+">0</option>");
					out.println("<option value='1' "+homeScore[1]+">1</option>");
					out.println("<option value='2' "+homeScore[2]+">2</option>");
					out.println("<option value='3' "+homeScore[3]+">3</option>");
					out.println("<option value='4' "+homeScore[4]+">4</option>");
					out.println("<option value='5' "+homeScore[5]+">5</option>");
					out.println("<option value='6' "+homeScore[6]+">6</option>");
					out.println("<option value='7' "+homeScore[7]+">7</option>");
					out.println("<option value='8' "+homeScore[8]+">8</option>");
					out.println("<option value='9' "+homeScore[9]+">9</option>");
					out.println("</select></td>");
					out.println("<td><select name='awayScore"+x+"'>");
					out.println("<option value='null'></option>");
					out.println("<option value='0' "+awayScore[0]+">0</option>");
					out.println("<option value='1' "+awayScore[1]+">1</option>");
					out.println("<option value='2' "+awayScore[2]+">2</option>");
					out.println("<option value='3' "+awayScore[3]+">3</option>");
					out.println("<option value='4' "+awayScore[4]+">4</option>");
					out.println("<option value='5' "+awayScore[5]+">5</option>");
					out.println("<option value='6' "+awayScore[6]+">6</option>");
					out.println("<option value='7' "+awayScore[7]+">7</option>");
					out.println("<option value='8' "+awayScore[8]+">8</option>");
					out.println("<option value='9' "+awayScore[9]+">9</option>");
					out.println("</select></td>");
					out.println("<td><IMG border='0' src='../images/teams/"+dbs.getColumnAsString(6)+"'></td>");
					out.println("<td>"+dbs.getColumnAsString(5).trim()+"</td>");
					out.println("<input type = 'hidden' name='fixture"+x+"' value='"+dbs.getColumnAsString(9).trim()+"'");
					out.println("</tr>");
					x++;
				} while (dbs.next());
				dbs.close();
				x--;
				out.println("<tr><td><input type = 'hidden' name='totalFixtures' value='"+x+"'</td></tr>");
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}

	public boolean getResultForm(JspWriter out, HttpServletRequest req, String matchday){
	
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select hometeam, T1.name, T1.image, awayteam, T2.name, T2.image, homescore, awayscore, F.fixture_id  from matchdays M, Teams T1, teams T2, fixtures F where  F.matchday = M.day and F.hometeam = T1.team_id and F.awayteam = T2.team_id and matchday ="+matchday+" order by T1.name";
			dbs.setCommand(sql);
			dbs.execute();
			int x=1;
			int y=1;
			String[] homeScore = new String[10];
			String[] awayScore = new String[10];
					
			if (dbs.onRow()) {
				do{
					if (dbs.getColumnAsString(7)!=null){
						for (y=0;y<10;y++) {
							if (dbs.getColumnAsString(7).equals(""+y)) {
								homeScore[y]="SELECTED";
							} else homeScore[y] =" ";
						}
					} else for (y=0;y<10;y++) { homeScore[y] =" ";}
					if (dbs.getColumnAsString(8)!=null){
							for (y=0;y<10;y++) {
								if (dbs.getColumnAsString(8).equals(""+y)) {
									awayScore[y]="SELECTED";
								} else awayScore[y] =" ";
							}
						} else for (y=0;y<10;y++) { awayScore[y] =" ";}
					
					out.println("<tr>");
					out.println("<td>"+dbs.getColumnAsString(2).trim()+"</td>");
					out.println("<td><IMG border='0' src='../images/teams/"+dbs.getColumnAsString(3)+"'></td>");
					out.println("<td><select name='homeScore"+x+"'>");
					out.println("<option value='null'></option>");
					out.println("<option value='0' "+homeScore[0]+">0</option>");
					out.println("<option value='1' "+homeScore[1]+">1</option>");
					out.println("<option value='2' "+homeScore[2]+">2</option>");
					out.println("<option value='3' "+homeScore[3]+">3</option>");
					out.println("<option value='4' "+homeScore[4]+">4</option>");
					out.println("<option value='5' "+homeScore[5]+">5</option>");
					out.println("<option value='6' "+homeScore[6]+">6</option>");
					out.println("<option value='7' "+homeScore[7]+">7</option>");
					out.println("<option value='8' "+homeScore[8]+">8</option>");
					out.println("<option value='9' "+homeScore[9]+">9</option>");
					out.println("</select></td>");
					out.println("<td><select name='awayScore"+x+"'>");
					out.println("<option value='null'></option>");
					out.println("<option value='0' "+awayScore[0]+">0</option>");
					out.println("<option value='1' "+awayScore[1]+">1</option>");
					out.println("<option value='2' "+awayScore[2]+">2</option>");
					out.println("<option value='3' "+awayScore[3]+">3</option>");
					out.println("<option value='4' "+awayScore[4]+">4</option>");
					out.println("<option value='5' "+awayScore[5]+">5</option>");
					out.println("<option value='6' "+awayScore[6]+">6</option>");
					out.println("<option value='7' "+awayScore[7]+">7</option>");
					out.println("<option value='8' "+awayScore[8]+">8</option>");
					out.println("<option value='9' "+awayScore[9]+">9</option>");
					out.println("</select></td>");
					out.println("<td><IMG border='0' src='../images/teams/"+dbs.getColumnAsString(6)+"'></td>");
					out.println("<td>"+dbs.getColumnAsString(5).trim()+"</td>");
					out.println("<input type = 'hidden' name='fixture"+x+"' value='"+dbs.getColumnAsString(9).trim()+"'");
					out.println("</tr>");
					x++;
				} while (dbs.next());
				dbs.close();
				x--;
				out.println("<tr><td><input type = 'hidden' name='totalFixtures' value='"+x+"'</td></tr>");
			}
		}
		catch (Exception e) {e.printStackTrace();return false;
		}
		return true;
	}



	/**
	 * @return
	 */
	public String getNews() {
		return news;
	}

	/**
	 * @param string
	 */
	public void setNews(String string) {
		news = string.replace('\'',' ');
	}

	public String postNews() {
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
			String sql = "insert into news values(current timestamp, '"+news+"')";
			dbm.setCommand(sql);
			dbm.execute();

			dbm.close();
		}
			catch (SQLException sql) {return sql.getSQLState();
		}
		return "0";
	}

	public String postFeedback() {
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
			String sql = "insert into feedback values(current timestamp,'"+name+"','"+email+"','"+subject+"','"+news+"')";
			dbm.setCommand(sql);
			dbm.execute();

			dbm.close();
		}
			catch (SQLException sql) {return sql.getSQLState();
		}
		return "0";
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string.replace('\'',' ');
	}

	/**
	 * @param string
	 */
	public void setSubject(String string) {
		subject = string.replace('\'',' ');
	}

}
