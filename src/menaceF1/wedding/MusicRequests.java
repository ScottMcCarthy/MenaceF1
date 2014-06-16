package menaceF1.wedding;

import menaceF1.struts.forms.MusicRequestFormBean;

import com.ibm.db.beans.DBModify;
import com.ibm.db.beans.DBParameterMetaData;
import com.ibm.db.beans.DBSelect;

public class MusicRequests {

	public boolean submitMusicRequest(MusicRequestFormBean musicRequest) throws Exception{

		DBModify dbm = new DBModify();
		try {
				dbm.setDataSourceName("jdbc/preds");
				String sql = "insert into musicrequests (GUESTNAME,ARTIST,SONGTITLE,TS) values (?,?,?,current timestamp)";
				dbm.setCommand(sql);
				DBParameterMetaData parmMetaData = dbm.getParameterMetaData();
				parmMetaData.setParameter(1,"GUESTNAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(2,"ARTIST",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(3,"SONGTITLE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);

			
				dbm.setParameterFromString("GUESTNAME", musicRequest.getGuest());
				dbm.setParameterFromString("ARTIST", musicRequest.getArtist());
				dbm.setParameterFromString("SONGTITLE", musicRequest.getSong());
				
				dbm.execute();
				dbm.close();

				} catch (Exception ex) {
					ex.printStackTrace();
					dbm.close();
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
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select Artist,Songtitle,Guestname from musicrequests order by TS desc";
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{
					sbuf.append("	<tr>");
					sbuf.append("		<td>"+dbs.getColumnAsString(1)+"</td>");
					sbuf.append("		<td>"+dbs.getColumnAsString(2)+"</td>");
					sbuf.append("		<td>"+dbs.getColumnAsString(3)+"</td>");
					sbuf.append("  </tr>");
					sbuf.append("</form>");
				} while (dbs.next());
				dbs.close();

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
