/*
 * Created on 23-May-04
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
public class Fixtures {


private String[] match = new String[31];
private String[] hometeam = new String[31];
private String[] awayteam = new String[31];
private String fixture = new String();

public String submit() {
	try{
		DBModify dbm = new DBModify();
		dbm.setDataSourceName("jdbc/preds");
		for (int i=1;i<31;i++){
			String sql = "insert into fixtures (matchday,hometeam,awayteam) values ( "+
				match[i]+","+
				hometeam[i]+","+
				awayteam[i]+")";
				dbm.setCommand(sql);
				System.out.println(sql);
				if(!match[i].equals("0")) {dbm.execute();}
		} 
		dbm.close();
	}
		catch (SQLException sql) {return sql.getSQLState();
	}
	return "0";
}


public String move() {
	try{
		DBModify dbm = new DBModify();
		dbm.setDataSourceName("jdbc/preds");
		String sql = "update fixtures set matchday = "+ match[1]+ " where fixture_id = "+fixture;		dbm.setCommand(sql);
		System.out.println(sql);
		dbm.execute();

		dbm.close();
	}
		catch (SQLException sql) {return sql.getSQLState();
	}
	return "0";
}



/**
 * @param i
 */
public void setAwayteam1(String s) {
	awayteam[1] = s;
}

/**
 * @param i
 */
public void setAwayteam10(String s) {
	awayteam[10] = s;
}

/**
 * @param i
 */
public void setAwayteam11(String s) {
	awayteam[11] = s;
}

/**
 * @param i
 */
public void setAwayteam12(String s) {
	awayteam[12] = s;
}

/**
 * @param i
 */
public void setAwayteam13(String s) {
	awayteam[13] = s;
}

/**
 * @param i
 */
public void setAwayteam14(String s) {
	awayteam[14] = s;
}

/**
 * @param i
 */
public void setAwayteam15(String s) {
	awayteam[15] = s;
}

/**
 * @param i
 */
public void setAwayteam16(String s) {
	awayteam[16] = s;
}

/**
 * @param i
 */
public void setAwayteam17(String s) {
	awayteam[17] = s;
}

/**
 * @param i
 */
public void setAwayteam18(String s) {
	awayteam[18] = s;
}

/**
 * @param i
 */
public void setAwayteam19(String s) {
	awayteam[19] = s;
}

/**
 * @param i
 */
public void setAwayteam2(String s) {
	awayteam[2] = s;
}

/**
 * @param i
 */
public void setAwayteam20(String s) {
	awayteam[20] = s;
}

/**
 * @param i
 */
public void setAwayteam21(String s) {
	awayteam[21] = s;
}

/**
 * @param i
 */
public void setAwayteam22(String s) {
	awayteam[22] = s;
}

/**
 * @param i
 */
public void setAwayteam23(String s) {
	awayteam[23] = s;
}

/**
 * @param i
 */
public void setAwayteam24(String s) {
	awayteam[24] = s;
}

/**
 * @param i
 */
public void setAwayteam25(String s) {
	awayteam[25] = s;
}

/**
 * @param i
 */
public void setAwayteam26(String s) {
	awayteam[26] = s;
}

/**
 * @param i
 */
public void setAwayteam27(String s) {
	awayteam[27] = s;
}

/**
 * @param i
 */
public void setAwayteam28(String s) {
	awayteam[28] = s;
}

/**
 * @param i
 */
public void setAwayteam29(String s) {
	awayteam[29] = s;
}

/**
 * @param i
 */
public void setAwayteam3(String s) {
	awayteam[3] = s;
}

/**
 * @param i
 */
public void setAwayteam30(String s) {
	awayteam[30] = s;
}

/**
 * @param i
 */
public void setAwayteam4(String s) {
	awayteam[4] = s;
}

/**
 * @param i
 */
public void setAwayteam5(String s) {
	awayteam[5] = s;
}

/**
 * @param i
 */
public void setAwayteam6(String s) {
	awayteam[6] = s;
}

/**
 * @param i
 */
public void setAwayteam7(String s) {
	awayteam[7] = s;
}

/**
 * @param i
 */
public void setAwayteam8(String s) {
	awayteam[8] = s;
}

/**
 * @param i
 */
public void setAwayteam9(String s) {
	awayteam[9] = s;
}

/**
 * @param i
 */
public void setMatch1(String s) {
	match[1] = s;
}

/**
 * @param i
 */
public void setMatch10(String s) {
	match[10] = s;
}

/**
 * @param i
 */
public void setMatch11(String s) {
	match[11] = s;
}

/**
 * @param i
 */
public void setMatch12(String s) {
	match[12] = s;
}

/**
 * @param i
 */
public void setMatch13(String s) {
	match[13] = s;
}

/**
 * @param i
 */
public void setMatch14(String s) {
	match[14] = s;
}

/**
 * @param i
 */
public void setMatch15(String s) {
	match[15] = s;
}

/**
 * @param i
 */
public void setMatch16(String s) {
	match[16] = s;
}

/**
 * @param i
 */
public void setMatch17(String s) {
	match[17] = s;
}

/**
 * @param i
 */
public void setMatch18(String s) {
	match[18] = s;
}

/**
 * @param i
 */
public void setMatch19(String s) {
	match[19] = s;
}

/**
 * @param i
 */
public void setMatch2(String s) {
	match[2] = s;
}

/**
 * @param i
 */
public void setMatch20(String s) {
	match[20] = s;
}

/**
 * @param i
 */
public void setMatch21(String s) {
	match[21] = s;
}

/**
 * @param i
 */
public void setMatch22(String s) {
	match[22] = s;
}

/**
 * @param i
 */
public void setMatch23(String s) {
	match[23] = s;
}

/**
 * @param i
 */
public void setMatch24(String s) {
	match[24] = s;
}

/**
 * @param i
 */
public void setMatch25(String s) {
	match[25] = s;
}

/**
 * @param i
 */
public void setMatch26(String s) {
	match[26] = s;
}

/**
 * @param i
 */
public void setMatch27(String s) {
	match[27] = s;
}

/**
 * @param i
 */
public void setMatch28(String s) {
	match[28] = s;
}

/**
 * @param i
 */
public void setMatch29(String s) {
	match[29] = s;
}

/**
 * @param i
 */
public void setMatch3(String s) {
	match[3] = s;
}

/**
 * @param i
 */
public void setMatch30(String s) {
	match[30] = s;
}

/**
 * @param i
 */
public void setMatch4(String s) {
	match[4] = s;
}

/**
 * @param i
 */
public void setMatch5(String s) {
	match[5] = s;
}

/**
 * @param i
 */
public void setMatch6(String s) {
	match[6] = s;
}

/**
 * @param i
 */
public void setMatch7(String s) {
	match[7] = s;
}

/**
 * @param i
 */
public void setMatch8(String s) {
	match[8] = s;
}

/**
 * @param i
 */
public void setMatch9(String s) {
	match[9] = s;
}

/**
 * @param i
 */
public void setHometeam1(String s) {
	hometeam[1] = s;
}

/**
 * @param i
 */
public void setHometeam10(String s) {
	hometeam[10] = s;
}

/**
 * @param i
 */
public void setHometeam11(String s) {
	hometeam[11] = s;
}

/**
 * @param i
 */
public void setHometeam12(String s) {
	hometeam[12] = s;
}

/**
 * @param i
 */
public void setHometeam13(String s) {
	hometeam[13] = s;
}

/**
 * @param i
 */
public void setHometeam14(String s) {
	hometeam[14] = s;
}

/**
 * @param i
 */
public void setHometeam15(String s) {
	hometeam[15] = s;
}

/**
 * @param i
 */
public void setHometeam16(String s) {
	hometeam[16] = s;
}

/**
 * @param i
 */
public void setHometeam17(String s) {
	hometeam[17] = s;
}

/**
 * @param i
 */
public void setHometeam18(String s) {
	hometeam[18] = s;
}

/**
 * @param i
 */
public void setHometeam19(String s) {
	hometeam[19] = s;
}

/**
 * @param i
 */
public void setHometeam2(String s) {
	hometeam[2] = s;
}

/**
 * @param i
 */
public void setHometeam20(String s) {
	hometeam[20] = s;
}

/**
 * @param i
 */
public void setHometeam21(String s) {
	hometeam[21] = s;
}

/**
 * @param i
 */
public void setHometeam22(String s) {
	hometeam[22] = s;
}

/**
 * @param i
 */
public void setHometeam23(String s) {
	hometeam[23] = s;
}

/**
 * @param i
 */
public void setHometeam24(String s) {
	hometeam[24] = s;
}

/**
 * @param i
 */
public void setHometeam25(String s) {
	hometeam[25] = s;
}

/**
 * @param i
 */
public void setHometeam26(String s) {
	hometeam[26] = s;
}

/**
 * @param i
 */
public void setHometeam27(String s) {
	hometeam[27] = s;
}

/**
 * @param i
 */
public void setHometeam28(String s) {
	hometeam[28] = s;
}

/**
 * @param i
 */
public void setHometeam29(String s) {
	hometeam[29] = s;
}

/**
 * @param i
 */
public void setHometeam3(String s) {
	hometeam[3] = s;
}

/**
 * @param i
 */
public void setHometeam30(String s) {
	hometeam[30] = s;
}

/**
 * @param i
 */
public void setHometeam4(String s) {
	hometeam[4] = s;
}

/**
 * @param i
 */
public void setHometeam5(String s) {
	hometeam[5] = s;
}

/**
 * @param i
 */
public void setHometeam6(String s) {
	hometeam[6] = s;
}

/**
 * @param i
 */
public void setHometeam7(String s) {
	hometeam[7] = s;
}

/**
 * @param i
 */
public void setHometeam8(String s) {
	hometeam[8] = s;
}

/**
 * @param i
 */
public void setHometeam9(String s) {
	hometeam[9] = s;
}

/**
 * @return
 */
public String getFixture() {
	return fixture;
}

/**
 * @param string
 */
public void setFixture(String string) {
	fixture = string;
}

}
