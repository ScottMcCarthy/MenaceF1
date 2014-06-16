package menaceF1.wedding;

import menaceF1.struts.forms.RsvpFormBean;
import menaceF1.struts.forms.WeddingGuestFormBean;

import com.ibm.db.beans.DBModify;
import com.ibm.db.beans.DBParameterMetaData;
import com.ibm.db.beans.DBSelect;

public class GuestUtils {
	
	public boolean submitRSVP(RsvpFormBean rsvp) throws Exception{

		DBModify dbm = new DBModify();
		int guestsAccepted = 0;
		if (rsvp.isAttending()) guestsAccepted = 2;
		if (rsvp.isAttending() && (rsvp.getPartnername()==null || rsvp.getPartnername().length()==0)) guestsAccepted = 1;
		
		try {
				dbm.setDataSourceName("jdbc/preds");
				String sql = "insert into RSVP (NAME,PARTNERNAME,ADDRESS1,ADDRESS2,COUNTY,POSTCODE,COUNTRY,EMAIL,RSVP_TS,TELEPHONE,GUESTSACCEPTED,MENUCHOICE,PARTNERMENUCHOICE,SPECIALREQUIREMENTS,PARTNERSPECIALREQUIREMENTS,COMMENTS,CAR) values (?,?,?,?,?,?,?,?,current timestamp,?,?,?,?,?,?,?,?)";
				dbm.setCommand(sql);
				DBParameterMetaData parmMetaData = dbm.getParameterMetaData();
				parmMetaData.setParameter(1,"NAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(2,"PARTNERNAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(3,"ADDRESS1",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(4,"ADDRESS2",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(5,"COUNTY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(6,"POSTCODE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(7,"COUNTRY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(8,"EMAIL",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(9,"TELEPHONE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(10,"GUESTSACCEPTED",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR ,String.class);
				parmMetaData.setParameter(11,"MENUCHOICE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(12,"PARTNERMENUCHOICE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(13,"SPECIALREQUIREMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(14,"PARTNERSPECIALREQUIREMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(15,"COMMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(16,"CAR",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);


				dbm.setParameterFromString("NAME", rsvp.getName());
				dbm.setParameterFromString("PARTNERNAME", rsvp.getPartnername());
				dbm.setParameterFromString("ADDRESS1", rsvp.getAddress1());
				dbm.setParameterFromString("ADDRESS2", rsvp.getAddress2());
				dbm.setParameterFromString("COUNTY", rsvp.getCounty());
				dbm.setParameterFromString("POSTCODE", rsvp.getPostcode());
				dbm.setParameterFromString("COUNTRY", rsvp.getCountry());
				dbm.setParameterFromString("EMAIL", rsvp.getEmail());
				dbm.setParameterFromString("TELEPHONE", rsvp.getTelephone());
				dbm.setParameterFromString("GUESTSACCEPTED", "" + guestsAccepted);
				dbm.setParameterFromString("MENUCHOICE", rsvp.getYourmenu());
				dbm.setParameterFromString("PARTNERMENUCHOICE", rsvp.getPartnermenu());
				dbm.setParameterFromString("SPECIALREQUIREMENTS", rsvp.getYourspecial());
				dbm.setParameterFromString("PARTNERSPECIALREQUIREMENTS", rsvp.getPartnerspecial());
				dbm.setParameterFromString("COMMENTS", rsvp.getComments());
				dbm.setParameterFromString("CAR", rsvp.getCar());
				
				dbm.execute();
				dbm.close();

				} catch (Exception ex) {
					ex.printStackTrace();
					dbm.close();
					throw ex;
					
				}

	return true;
	}
	
	public RsvpFormBean fetchRsvp(int rsvpID)throws Exception{
		RsvpFormBean myRSVP = new RsvpFormBean();
		try {
			DBSelect dbs = new DBSelect();
			dbs.setDataSourceName("jdbc/preds");
			String sql = "select name,partnername,address1,address2,county,postcode,country,telephone,email,menuchoice,partnermenuchoice,specialrequirements,partnerspecialrequirements,comments,guestsAccepted,RSVP_TS,car  from rsvp where ID = "+rsvpID;
			dbs.setCommand(sql);
			dbs.execute();
			if (dbs.onRow()) {
				do{  
					myRSVP.setName(dbs.getColumnAsString(1));
					myRSVP.setPartnername(dbs.getColumnAsString(2));
					myRSVP.setAddress1(dbs.getColumnAsString(3));
					myRSVP.setAddress2(dbs.getColumnAsString(4));
					myRSVP.setCounty(dbs.getColumnAsString(5));
					myRSVP.setPostcode(dbs.getColumnAsString(6));
					myRSVP.setCountry(dbs.getColumnAsString(7));
					myRSVP.setTelephone(dbs.getColumnAsString(8));
					myRSVP.setEmail(dbs.getColumnAsString(9));
					myRSVP.setYourmenu(dbs.getColumnAsString(10));
					myRSVP.setPartnermenu(dbs.getColumnAsString(11));
					myRSVP.setYourspecial(dbs.getColumnAsString(12));
					myRSVP.setPartnerspecial(dbs.getColumnAsString(13));
					myRSVP.setComments(dbs.getColumnAsString(14));
					myRSVP.setGuestsAccepted(Integer.parseInt(dbs.getColumnAsString(15)));
					myRSVP.setTimestamp(dbs.getColumnAsString(16));
					myRSVP.setCar(dbs.getColumnAsString(17));
				} while (dbs.next());
				dbs.close();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}		
		return myRSVP;
	}
	
	public boolean updateGuestListFromRSVP(int rsvpID, int guestID) throws Exception{

		DBModify dbm = new DBModify();
		DBModify dbm2 = new DBModify();
		RsvpFormBean rsvp = fetchRsvp(rsvpID);
		String partnerMenuChoice = rsvp.getPartnermenu();
		String accepted = "Y";
		if (rsvp.getGuestsAccepted()==0) accepted = "N";
		if (rsvp.getGuestsAccepted()==1) partnerMenuChoice = "X";
		
		try {
				dbm.setDataSourceName("jdbc/preds");
				dbm2.setDataSourceName("jdbc/preds");
				String sql = "update GUESTLIST set NAME = ?,PARTNERNAME = ?,ADDRESS1 = ?,ADDRESS2 = ?,COUNTY = ?,POSTCODE = ?,COUNTRY = ?,EMAIL = ? ,RSVP_TS = ?,TELEPHONE = ?,MENUCHOICE = ?,PARTNERMENUCHOICE = ?,SPECIALREQUIREMENTS = ?,PARTNERSPECIALREQUIREMENTS = ?,COMMENTS = ?,ACCEPTED = ?, CAR = ? where ID = "+guestID;
				String sql2 = "update RSVP set CHECKED = 'Y' where ID = "+rsvpID;
				dbm.setCommand(sql);
				dbm2.setCommand(sql2);
				DBParameterMetaData parmMetaData = dbm.getParameterMetaData();
				parmMetaData.setParameter(1,"NAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(2,"PARTNERNAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(3,"ADDRESS1",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(4,"ADDRESS2",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(5,"COUNTY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(6,"POSTCODE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(7,"COUNTRY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(8,"EMAIL",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(9,"RSVP_TS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.TIMESTAMP,String.class);
				parmMetaData.setParameter(10,"TELEPHONE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(11,"MENUCHOICE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(12,"PARTNERMENUCHOICE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(13,"SPECIALREQUIREMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(14,"PARTNERSPECIALREQUIREMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(15,"COMMENTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.VARCHAR,String.class);
				parmMetaData.setParameter(16,"ACCEPTED",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(17,"CAR",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				
				dbm.setParameterFromString("NAME", rsvp.getName());
				dbm.setParameterFromString("PARTNERNAME", rsvp.getPartnername());
				dbm.setParameterFromString("ADDRESS1", rsvp.getAddress1());
				dbm.setParameterFromString("ADDRESS2", rsvp.getAddress2());
				dbm.setParameterFromString("COUNTY", rsvp.getCounty());
				dbm.setParameterFromString("POSTCODE", rsvp.getPostcode());
				dbm.setParameterFromString("COUNTRY", rsvp.getCountry());
				dbm.setParameterFromString("EMAIL", rsvp.getEmail());
				dbm.setParameterFromString("RSVP_TS", rsvp.getTimestamp());
				dbm.setParameterFromString("TELEPHONE", rsvp.getTelephone());
				dbm.setParameterFromString("MENUCHOICE", rsvp.getYourmenu());
				dbm.setParameterFromString("PARTNERMENUCHOICE", partnerMenuChoice);
				dbm.setParameterFromString("SPECIALREQUIREMENTS", rsvp.getYourspecial());
				dbm.setParameterFromString("PARTNERSPECIALREQUIREMENTS", rsvp.getPartnerspecial());
				dbm.setParameterFromString("COMMENTS", rsvp.getComments());
				dbm.setParameterFromString("ACCEPTED", accepted);
				dbm.setParameterFromString("CAR", rsvp.getCar());
				
				dbm.execute();
				dbm.close();
				dbm2.execute();
				dbm2.close();

				} catch (Exception ex) {
					ex.printStackTrace();
					dbm.close();
					throw ex;
					
				}

	return true;
	}
	
	public boolean createNewGuest(WeddingGuestFormBean guest) throws Exception{

		DBModify dbm = new DBModify();
		String numberOfGuests = "1";
		if (guest.hasPartner()) {
			numberOfGuests = "2";
		} else {
			guest.setPartner(null);
		}
		try {
				dbm.setDataSourceName("jdbc/preds");
				String sql = "insert into guestlist (NAME,GUESTS,PARTNERNAME,ADDRESS1,ADDRESS2,COUNTY,POSTCODE,COUNTRY,GUESTTYPE) values (?,?,?,?,?,?,?,?,?)";
				dbm.setCommand(sql);
				DBParameterMetaData parmMetaData = dbm.getParameterMetaData();
				parmMetaData.setParameter(1,"NAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(2,"GUESTS",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(3,"PARTNERNAME",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(4,"ADDRESS1",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(5,"ADDRESS2",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(6,"COUNTY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(7,"POSTCODE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(8,"COUNTRY",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);
				parmMetaData.setParameter(9,"GUESTTYPE",java.sql.DatabaseMetaData.procedureColumnIn,java.sql.Types.CHAR,String.class);

			
				dbm.setParameterFromString("NAME", guest.getName());
				dbm.setParameterFromString("GUESTS", numberOfGuests);
				dbm.setParameterFromString("PARTNERNAME", guest.getPartner());
				dbm.setParameterFromString("ADDRESS1", guest.getAddress1());
				dbm.setParameterFromString("ADDRESS2", guest.getAddress2());
				dbm.setParameterFromString("COUNTY", guest.getCounty());
				dbm.setParameterFromString("POSTCODE", guest.getPostcode());
				dbm.setParameterFromString("COUNTRY", guest.getCountry());
				dbm.setParameterFromString("GUESTTYPE", guest.getGuestType());
				
				dbm.execute();
				dbm.close();

				} catch (Exception ex) {
					ex.printStackTrace();
					dbm.close();
					throw ex;
					
				}

	return true;
	}

}
