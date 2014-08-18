package menaceF1.wedding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import menaceF1.Database.DatabaseUtils;
import menaceF1.struts.forms.RsvpFormBean;
import menaceF1.struts.forms.WeddingGuestFormBean;


public class GuestUtils {
	
	public boolean submitRSVP(RsvpFormBean rsvp) throws Exception{

		int guestsAccepted = 0;
		if (rsvp.isAttending()) guestsAccepted = 2;
		if (rsvp.isAttending() && (rsvp.getPartnername()==null || rsvp.getPartnername().length()==0)) guestsAccepted = 1;
		
		try {
				String sql = "insert into rsvp (NAME,PARTNERNAME,ADDRESS1,ADDRESS2,COUNTY,POSTCODE,COUNTRY,EMAIL,RSVP_TS,TELEPHONE,GUESTSACCEPTED,MENUCHOICE,PARTNERMENUCHOICE,SPECIALREQUIREMENTS,PARTNERSPECIALREQUIREMENTS,COMMENTS,CAR) values (?,?,?,?,?,?,?,?,current_timestamp,?,?,?,?,?,?,?,?)";

				Connection conn = DatabaseUtils.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);


				statement.setString(1, rsvp.getName());
				statement.setString(2, rsvp.getPartnername());
				statement.setString(3, rsvp.getAddress1());
				statement.setString(4, rsvp.getAddress2());
				statement.setString(5, rsvp.getCounty());
				statement.setString(6, rsvp.getPostcode());
				statement.setString(7, rsvp.getCountry());
				statement.setString(8, rsvp.getEmail());
				statement.setString(9, rsvp.getTelephone());
				statement.setString(10, "" + guestsAccepted);
				statement.setString(11, rsvp.getYourmenu());
				statement.setString(12, rsvp.getPartnermenu());
				statement.setString(13, rsvp.getYourspecial());
				statement.setString(14, rsvp.getPartnerspecial());
				statement.setString(15, rsvp.getComments());
				statement.setString(16, "N");
				
	            statement.execute();

				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
					
				}

	return true;
	}
	
	public RsvpFormBean fetchRsvp(int rsvpID)throws Exception{
		RsvpFormBean myRSVP = new RsvpFormBean();
		try {
			String sql = "select name,partnername,address1,address2,county,postcode,country,telephone,email,menuchoice,partnermenuchoice,specialrequirements,partnerspecialrequirements,comments,guestsAccepted,RSVP_TS,car  from rsvp where ID = "+rsvpID;
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()){
					myRSVP.setName(rs.getString(1));
					myRSVP.setPartnername(rs.getString(2));
					myRSVP.setAddress1(rs.getString(3));
					myRSVP.setAddress2(rs.getString(4));
					myRSVP.setCounty(rs.getString(5));
					myRSVP.setPostcode(rs.getString(6));
					myRSVP.setCountry(rs.getString(7));
					myRSVP.setTelephone(rs.getString(8));
					myRSVP.setEmail(rs.getString(9));
					myRSVP.setYourmenu(rs.getString(10));
					myRSVP.setPartnermenu(rs.getString(11));
					myRSVP.setYourspecial(rs.getString(12));
					myRSVP.setPartnerspecial(rs.getString(13));
					myRSVP.setComments(rs.getString(14));
					myRSVP.setGuestsAccepted(Integer.parseInt(rs.getString(15)));
					myRSVP.setTimestamp(rs.getString(16));
					myRSVP.setCar(rs.getString(17));
				} 		}
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}		
		return myRSVP;
	}
	
	public boolean updateGuestListFromRSVP(int rsvpID, int guestID) throws Exception{

		RsvpFormBean rsvp = fetchRsvp(rsvpID);
		String partnerMenuChoice = rsvp.getPartnermenu();
		String accepted = "Y";
		if (rsvp.getGuestsAccepted()==0) accepted = "N";
		if (rsvp.getGuestsAccepted()==1) partnerMenuChoice = "X";
		
		try {
				String sql = "update guestlist set NAME = ?,PARTNERNAME = ?,ADDRESS1 = ?,ADDRESS2 = ?,COUNTY = ?,POSTCODE = ?,COUNTRY = ?,EMAIL = ? ,RSVP_TS = ?,TELEPHONE = ?,MENUCHOICE = ?,PARTNERMENUCHOICE = ?,SPECIALREQUIREMENTS = ?,PARTNERSPECIALREQUIREMENTS = ?,COMMENTS = ?,ACCEPTED = ?, CAR = ? where ID = "+guestID;
				String sql2 = "update rsvp set CHECKED = 'Y' where ID = "+rsvpID;

				Connection conn = DatabaseUtils.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);
				Connection conn2 = DatabaseUtils.getConnection();
	            PreparedStatement statement2 = conn2.prepareStatement(sql2);
				
	            statement.setString(1, rsvp.getName());
	            statement.setString(2, rsvp.getPartnername());
	            statement.setString(3, rsvp.getAddress1());
	            statement.setString(4, rsvp.getAddress2());
	            statement.setString(5, rsvp.getCounty());
	            statement.setString(6, rsvp.getPostcode());
	            statement.setString(7, rsvp.getCountry());
	            statement.setString(8, rsvp.getEmail());
	            statement.setString(9, rsvp.getTimestamp());
	            statement.setString(10, rsvp.getTelephone());
	            statement.setString(11, rsvp.getYourmenu());
	            statement.setString(12, partnerMenuChoice);
	            statement.setString(13, rsvp.getYourspecial());
	            statement.setString(14, rsvp.getPartnerspecial());
	            statement.setString(15, rsvp.getComments());
	            statement.setString(16, accepted);
	            statement.setString(17, rsvp.getCar());
				
	            statement.execute();
	            statement2.execute();

				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
					
				}

	return true;
	}
	
	public boolean createNewGuest(WeddingGuestFormBean guest) throws Exception{

		String numberOfGuests = "1";
		if (guest.hasPartner()) {
			numberOfGuests = "2";
		} else {
			guest.setPartner(null);
		}
		try {

				String sql = "insert into guestlist (NAME,GUESTS,PARTNERNAME,ADDRESS1,ADDRESS2,COUNTY,POSTCODE,COUNTRY,GUESTTYPE) values (?,?,?,?,?,?,?,?,?)";
				Connection conn = DatabaseUtils.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, guest.getName());
				statement.setString(2, numberOfGuests);
				statement.setString(3, guest.getPartner());
				statement.setString(4, guest.getAddress1());
				statement.setString(5, guest.getAddress2());
				statement.setString(6, guest.getCounty());
				statement.setString(7, guest.getPostcode());
				statement.setString(8, guest.getCountry());
				statement.setString(9, guest.getGuestType());
				
				statement.execute();

				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
				}

	return true;
	}

}
