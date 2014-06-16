/*
 * Created on 31-May-04
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package menaceF1;
import com.ibm.db.beans.*;
import java.sql.SQLException;

/**
 * @author Scott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Prediction {

	private String player;
	private String matchday; 

	private String[] fixture   = new String[31];
	private String[] homeScore = new String[31];
	private String[] awayScore = new String[31];



	public String submit() {
		try{
			DBModify dbm = new DBModify();
			DBSelect dbs = new DBSelect();
			dbm.setDataSourceName("jdbc/preds");
			dbs.setDataSourceName("jdbc/preds");
			
			//First Check that the submission deadline hasn't passed.
			
			String deadlineSQL = "select count(*) from matchdays where day = "+matchday+" and start_date > current date";
			dbs.setCommand(deadlineSQL);
			dbs.execute();
			if (dbs.getColumnAsString(1).equals("0")) {
					dbs.close();
					return "late";
					}
			dbs.close(); 
			
			String deleteSQL = "delete from preds where player_id = "+player+" and fixture_id in (select fixture_id from fixtures where matchday = "+matchday+")";
				dbm.setCommand(deleteSQL);
				System.out.println(deleteSQL);
				dbm.execute();
				dbm.commit();
						
			for (int i=1;i<31;i++){
				String sql = "insert into preds values ( "+
					player+","+
				    fixture[i]+","+
					homeScore[i]+","+
					awayScore[i]+")";
					dbm.setCommand(sql);
					
				if(!(homeScore[i]== null)) {dbm.execute();}
			} 
			dbm.close();
			for (int i=1;i<31;i++){ homeScore[i]= null; awayScore[i]= null;}
		}
			catch (SQLException sql) {return sql.getSQLState();
		}
		return "0";
	}


	public String submitResults() {
		try{
			DBModify dbm = new DBModify();
			dbm.setDataSourceName("jdbc/preds");
				
			for (int i=1;i<31;i++){
				String sql = "update fixtures set  "+
					" homescore = "+homeScore[i]+
					" ,awayscore = "+awayScore[i]+
					" where fixture_id = "+fixture[i];
					dbm.setCommand(sql);
				System.out.println(sql);	
				if(!(homeScore[i]== null)) {dbm.execute();}
			} 
			dbm.close();
			for (int i=1;i<31;i++){ homeScore[i]= null; awayScore[i]= null;}
		}
			catch (SQLException sql) {return sql.getSQLState();
		}
		return "0";
	}

	
	
	/**private String homeScore1;
	 * @return
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * @param string
	 */
	public void setPlayer(String string) {
		player = string;
	}


	/**
	 * @return
	 */
	public String getMatchday() {
		return matchday;
	}

	/**
	 * @param string
	 */
	public void setMatchday(String string) {
		matchday = string;
	}


	/**
	 * @param string
	 */
	public void setAwayScore1(String string) {
		awayScore[1] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore10(String string) {
		awayScore[10] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore11(String string) {
		awayScore[11] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore12(String string) {
		awayScore[12] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore13(String string) {
		awayScore[13] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore14(String string) {
		awayScore[14] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore15(String string) {
		awayScore[15] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore16(String string) {
		awayScore[16] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore17(String string) {
		awayScore[17] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore18(String string) {
		awayScore[18] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore19(String string) {
		awayScore[19] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore2(String string) {
		awayScore[2] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore20(String string) {
		awayScore[20] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore21(String string) {
		awayScore[21] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore22(String string) {
		awayScore[22] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore23(String string) {
		awayScore[23] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore24(String string) {
		awayScore[24] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore25(String string) {
		awayScore[25] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore26(String string) {
		awayScore[26] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore27(String string) {
		awayScore[27] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore28(String string) {
		awayScore[28] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore29(String string) {
		awayScore[29] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore3(String string) {
		awayScore[3] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore30(String string) {
		awayScore[30] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore4(String string) {
		awayScore[4] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore5(String string) {
		awayScore[5] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore6(String string) {
		awayScore[6] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore7(String string) {
		awayScore[7] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore8(String string) {
		awayScore[8] = string;
	}

	/**
	 * @param string
	 */
	public void setAwayScore9(String string) {
		awayScore[9] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore1(String string) {
		homeScore[1] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore10(String string) {
		homeScore[10] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore11(String string) {
		homeScore[11] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore12(String string) {
		homeScore[12] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore13(String string) {
		homeScore[13] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore14(String string) {
		homeScore[14] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore15(String string) {
		homeScore[15] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore16(String string) {
		homeScore[16] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore17(String string) {
		homeScore[17] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore18(String string) {
		homeScore[18] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore19(String string) {
		homeScore[19] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore2(String string) {
		homeScore[2] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore20(String string) {
		homeScore[20] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore21(String string) {
		homeScore[21] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore22(String string) {
		homeScore[22] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore23(String string) {
		homeScore[23] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore24(String string) {
		homeScore[24] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore25(String string) {
		homeScore[25] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore26(String string) {
		homeScore[26] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore27(String string) {
		homeScore[27] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore28(String string) {
		homeScore[28] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore29(String string) {
		homeScore[29] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore3(String string) {
		homeScore[3] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore30(String string) {
		homeScore[30] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore4(String string) {
		homeScore[4] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore5(String string) {
		homeScore[5] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore6(String string) {
		homeScore[6] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore7(String string) {
		homeScore[7] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore8(String string) {
		homeScore[8] = string;
	}

	/**
	 * @param string
	 */
	public void setHomeScore9(String string) {
		homeScore[9] = string;
	}

	public void setfixture1(String string) {
		fixture[1] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture10(String string) {
		fixture[10] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture11(String string) {
		fixture[11] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture12(String string) {
		fixture[12] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture13(String string) {
		fixture[13] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture14(String string) {
		fixture[14] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture15(String string) {
		fixture[15] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture16(String string) {
		fixture[16] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture17(String string) {
		fixture[17] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture18(String string) {
		fixture[18] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture19(String string) {
		fixture[19] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture2(String string) {
		fixture[2] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture20(String string) {
		fixture[20] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture21(String string) {
		fixture[21] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture22(String string) {
		fixture[22] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture23(String string) {
		fixture[23] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture24(String string) {
		fixture[24] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture25(String string) {
		fixture[25] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture26(String string) {
		fixture[26] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture27(String string) {
		fixture[27] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture28(String string) {
		fixture[28] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture29(String string) {
		fixture[29] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture3(String string) {
		fixture[3] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture30(String string) {
		fixture[30] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture4(String string) {
		fixture[4] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture5(String string) {
		fixture[5] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture6(String string) {
		fixture[6] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture7(String string) {
		fixture[7] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture8(String string) {
		fixture[8] = string;
	}

	/**
	 * @param string
	 */
	public void setfixture9(String string) {
		fixture[9] = string;
	}


}
