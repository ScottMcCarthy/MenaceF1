package menaceF1.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	
	private static final String usernameFile = "/mysql/username.txt";
	//private static final String databaseName = "raspberrypi";
	private static final String databaseName = "localhost";
	//private static final String databaseName = "raspberrypi";
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BufferedReader reader;
		String username = null;
		String password = null;
		try {
			reader = new BufferedReader(new FileReader(usernameFile));
			username = reader.readLine();
			password = reader.readLine();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Connection conn = null;
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://"+databaseName+"/Wedding?" +
		                                   "user="+username+"&password="+password);

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return conn;
		
	}	

}
