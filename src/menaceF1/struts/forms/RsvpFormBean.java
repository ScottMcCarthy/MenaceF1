package menaceF1.struts.forms;

import javax.servlet.http.HttpServletRequest;

import menaceF1.wedding.WeddingGuest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 1 field on this form:
 * <ul>
 * <li>Accepted - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class RsvpFormBean extends ActionForm

{
	public static final long serialVersionUID = 1;
	
    private String canAttend = null;
    private String address1 = null;
    private String address2 = null;
    private String county = null;
    private String postcode = null;
    private String country = null;
    private String name = null;
    private String partnername = null;
    private String telephone = null;
    private String email = null;
    private String yourmenu = null;
    private String partnermenu = null;
    private String yourspecial = null;
    private String partnerspecial = null;
    private String comments = null;
    private String car = null;
    private int guestsAccepted = 0;
    private String timestamp = null;

    public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}
    
    public boolean isAttending() {
    	if (canAttend == null) return false;
    	return (canAttend.equalsIgnoreCase("Yes"));
    }

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
     * Get Accepted
     * @return String
     */
    public String getCanAttend() {
	return canAttend;
    }

    /**
     * Set Accepted
     * @param <code>String</code>
     */
    public void setCanAttend(String a) {
	this.canAttend = a;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset values are provided as samples only. Change as appropriate.

    canAttend = null;

    }

    public ActionErrors validate(ActionMapping mapping,
    	    HttpServletRequest request) {
    	StringBuffer sb = new StringBuffer();
    	ActionErrors errors = new ActionErrors();
    	if (isAttending()){
    		sb.append("document.getElementById('canAttendDiv').style.display= 'block';");
			sb.append("document.getElementById('cannotAttendDiv').style.display= 'none';");
			sb.append("document.getElementById('RSVPFormYES').style.display= 'block';");
			sb.append("document.getElementById('RSVPForm').style.display= 'block';");
			sb.append("document.getElementById('canAttendbutton').style.display= 'block';");
			sb.append("document.getElementById('cannotAttendbutton').style.display= 'none';");
			
			WeddingGuest guest = (WeddingGuest) request.getSession().getAttribute("WEDDINGGUEST");
			
    		if ((name == null) || (name.length() == 0)) {
     		   errors.add("blankName", new org.apache.struts.action.ActionError("errors.blankName"));
     		 }
    		
    		if (guest.isFullGuest()) {
    		
    		 if ((address1 == null) || (address1.length() == 0)) {
    			   errors.add("blankAddress", new org.apache.struts.action.ActionError("errors.blankAddress"));
    			 }
    		 if ((county == null) || (county.length() == 0)) {
    			   errors.add("blankCounty", new org.apache.struts.action.ActionError("errors.blankCounty"));
    			 }
    		 if ((postcode == null) || (postcode.length() == 0)) {
    			   errors.add("blankPostcode", new org.apache.struts.action.ActionError("errors.blankPostcode"));
    			 }
    		}
    		 if ((telephone == null) || (telephone.length() == 0)) {
    			   errors.add("blankTelephone", new org.apache.struts.action.ActionError("errors.blankTelephone"));
    			 }
    		 if ((email == null) || (email.length() == 0)) {
    			   errors.add("blankPassword", new org.apache.struts.action.ActionError("errors.blankEmail"));
    			 }
    		 if ((email != null) && (email.length() > 0) && (!email.contains("@"))) {
    			   errors.add("invalidEmail", new org.apache.struts.action.ActionError("errors.invalidEmail"));
    			 }
    		
    		
    	} else { //If they can't attend we're only interesting in their name.
    		
			sb.append("document.getElementById('canAttendDiv').style.display= 'none';");
			sb.append("document.getElementById('cannotAttendDiv').style.display= 'block';");	
			sb.append("document.getElementById('RSVPFormYES').style.display= 'none';");
			sb.append("document.getElementById('RSVPForm').style.display= 'block';");
			sb.append("document.getElementById('canAttendbutton').style.display= 'none';");
			sb.append("document.getElementById('cannotAttendbutton').style.display= 'block';");	    		
    		
    		
    		if ((name == null) || (name.length() == 0)) {
    		   errors.add("blankName", new org.apache.struts.action.ActionError("errors.blankName"));
    		 }
    	}
    	request.setAttribute("styleJavascript", sb.toString());
    	return errors;

        }

	public String getPartnername() {
		return partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPartnermenu() {
		if (partnermenu == null) return "X";
		return partnermenu;
	}

	public void setPartnermenu(String partnermenu) {
		this.partnermenu = partnermenu;
	}

	public String getPartnerspecial() {
		return partnerspecial;
	}

	public void setPartnerspecial(String partnerspecial) {
		this.partnerspecial = partnerspecial;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getYourmenu() {
		if (yourmenu == null) return "X";
		return yourmenu;
	}

	public void setYourmenu(String yourmenu) {
		this.yourmenu = yourmenu;
	}

	public String getYourspecial() {
		return yourspecial;
	}

	public void setYourspecial(String yourspecial) {
		this.yourspecial = yourspecial;
	}

	public int getGuestsAccepted() {
		return guestsAccepted;
	}

	public void setGuestsAccepted(int guestsAccepted) {
		this.guestsAccepted = guestsAccepted;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
}
