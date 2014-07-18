package menaceF1.wedding;

import menaceF1.Database.DatabaseUtils;
import menaceF1.struts.forms.MusicRequestFormBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class MusicRequests {

	public boolean submitMusicRequest(MusicRequestFormBean musicRequest) throws Exception{

		try {
				String sql = "insert into musicrequests (GUESTNAME,ARTIST,SONGTITLE,TS) values (?,?,?,current_timestamp)";
				
				Connection conn = DatabaseUtils.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, musicRequest.getGuest());
	            statement.setString(2, musicRequest.getArtist());
	            statement.setString(3, musicRequest.getSong());
	            statement.execute();

				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
					
				}

	return true;
	}

	
	public static String getMusicRequestsHTML() {

		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
		sbuf.append("<tbody>");
		sbuf.append("	<tr>");
		sbuf.append("		<td><b>Artist</b></td>");
		sbuf.append("		<td><b>Song</b></td>");
		sbuf.append("		<td><b>Requested By</b></td>");
		sbuf.append("  </tr>");

		
		try {
			String sql = "select Artist,Songtitle,Guestname from musicrequests order by TS desc";
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					sbuf.append("	<tr>");
					sbuf.append("		<td>"+rs.getString(1)+"</td>");
					sbuf.append("		<td>"+rs.getString(2)+"</td>");
					sbuf.append("		<td>"+rs.getString(3)+"</td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		sbuf.append("	</tbody>");
		sbuf.append("</table>");		
		return sbuf.toString();
	}	
}
