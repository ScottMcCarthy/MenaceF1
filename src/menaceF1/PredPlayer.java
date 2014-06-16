/*
 * Created on 08-May-04
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
public class PredPlayer {

private int id;
private String firstname;
private String surname;
private String username;
private String password;
private int teamID;
private int points;
private String userPassword;
private String email;
private String teamIDString;
private boolean admin;

public int getUserDetails(String un){
	try {
		DBSelect dbs = new DBSelect();
		dbs.setDataSourceName("jdbc/preds");
		String sql = "Select * from players where username = '"+un+"'";
		dbs.setCommand(sql);
		dbs.execute();
		
		if (dbs.getRowCount() > 0) {
			if (dbs.onRow()) {
					
					surname   = dbs.getColumnAsString(3);
					firstname = dbs.getColumnAsString(2);
				    password  = dbs.getColumnAsString(5);
				    teamID    = Integer.parseInt(dbs.getColumnAsString(6));
				    points    = Integer.parseInt(dbs.getColumnAsString(7));
				    id        = Integer.parseInt(dbs.getColumnAsString(1));
					admin = false;
					if (dbs.getColumnAsString(9) != null){
						if (dbs.getColumnAsString(9).trim().equals("Y")) {admin = true;}
					}
				    dbs.close();
				    return 0;
				}
			}else 
				surname   = null;
				firstname = null;
				password  = null;
				teamID    = 0;
				points    = 0;
				admin     = false;
				dbs.close();
				return -1;

	}
		catch (Exception e) {e.printStackTrace();
}
return 99;
}
       
public String getFullName(){
	if (firstname==null || surname==null) { return null;}
	return (firstname.trim()+" "+surname.trim());
}

public boolean passwordValid(){
	if (password==null || userPassword==null) { return false;}
	if (userPassword.trim().equals(password.trim())) { return true;}
	return false;
}

public String register() {
	try{
		DBModify dbm = new DBModify();
		dbm.setDataSourceName("jdbc/preds");
		String sql = "insert into players (firstname,surname,username,password,team_id,points,email) values ( "+
				"'"+firstname.trim()+"',"+
				"'"+surname.trim()+"',"+
				"'"+username.trim()+"',"+
				"'"+password.trim()+"',"+
				+teamID+","+
				"0,"+
				"'"+email.trim()+"')";
		dbm.setCommand(sql);
		System.out.println(sql);
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
public String getFirstname() {
	return firstname;
}


public boolean isAdministrator() {
	return admin;
}

/**
 * @return
 */
public int getId() {
	return id;
}

/**
 * @return
 */
public String getPassword() {
	return password;
}

/**
 * @return
 */
public int getPoints() {
	return points;
}

/**
 * @return
 */
public String getSurname() {
	return surname;
}

/**
 * @return
 */
public int getTeamID() {
	return teamID;
}

/**
 * @return
 */
public String getUsername() {
	return username;
}

/**
 * @param string
 */
public void setFirstname(String string) {
	firstname = string.replace('\'',' ');
}

/**
 * @param i
 */
public void setId(int i) {
	id = i;
}

/**
 * @param string
 */
public void setPassword(String string) {
	password = string;
}

/**
 * @param i
 */
public void setPoints(int i) {
	points = i;
}

/**
 * @param string
 */
public void setSurname(String string) {
	surname = string.replace('\'',' ');
}

/**
 * @param i
 */
public void setTeamID(String s) {
	teamID = Integer.parseInt(s);
}

/**
 * @param string
 */
public void setUsername(String string) {
	username = string;
}

/**
 * @return
 */
public String getUserPassword() {
	return userPassword;
}

/**
 * @param string
 */
public void setUserPassword(String string) {
	userPassword = string;
}

/**
 * @return
 */
public String getEmail() {
	return email;
}

/**
 * @param string
 */
public void setEmail(String string) {
	email = string;
}

/**
 * @return
 */
public String getTeamIDString() {
	return teamIDString;
}

/**
 * @param i
 */
public void setTeamID(int i) {
	teamID = i;
}

/**
 * @param string
 */
public void setTeamIDString(String string) {
	teamIDString = string;
	teamID = Integer.parseInt(string);
}

}
