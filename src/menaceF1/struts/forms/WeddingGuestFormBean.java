package menaceF1.struts.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 14 fields on this form:
 * <ul>
 * <li>name - Name of Guest
 * <li>plusOne - Include a partner?
 * <li>partner - Partner's Name
 * <li>address1 - Address Line 1
 * <li>address2 - Address Line 2
 * <li>county - county
 * <li>postcode - Postcode
 * <li>country - Country
 * <li>email - e-mail Address
 * <li>telephone - Telephone number
 * <li>menuChoice - Normal / Vegie / Special
 * <li>specialRequirements - Special Diatry requirements
 * <li>accepted - Y/N
 * <li>GuestType - Day or evening Guest.
 * </ul>
 * @version 	1.0
 * @author		Scott McCarthy
 */
public class WeddingGuestFormBean extends ActionForm

{
	public final static long serialVersionUID = 1;
    private String name = null;
    private String plusOne = null;
    private String partner = null;
    private String address1 = null;
    private String address2 = null;
    private String county = null;
    private String postcode = null;
    private String country = null;
    private String email = null;
    private String telephone = null;
    private String menuChoice = null;
    private String specialRequirements = null;
    private String partnerMenuChoice = null;
    private String partnerSpecialRequirements = null;
    private String accepted = null;
    private String guestType = null;
    private String actionType = null;
    private boolean hasPartner = false;
   
    
    public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	/**
     * Get name
     * @return String
     */
    public String getName() {
	return name;
    }

    /**
     * Set name
     * @param <code>String</code>
     */
    public void setName(String n) {
	this.name = n;
    }

    /**
     * Get plusOne
     * @return String
     */
    public String getPlusOne() {
	return plusOne;
    }

    /**
     * Set plusOne
     * @param <code>String</code>
     */
    public void setPlusOne(String p) {
	this.plusOne = p;
	if (p.equalsIgnoreCase("on")) {
		this.hasPartner = true;
	} else {
		this.hasPartner = false;
	}
    }

    /**
     * Get partner
     * @return String
     */
    public String getPartner() {
	return partner;
    }

    /**
     * Set partner
     * @param <code>String</code>
     */
    public void setPartner(String p) {
	this.partner = p;
    }

    /**
     * Get address1
     * @return String
     */
    public String getAddress1() {
	return address1;
    }

    /**
     * Set address1
     * @param <code>String</code>
     */
    public void setAddress1(String a) {
	this.address1 = a;
    }

    /**
     * Get address2
     * @return String
     */
    public String getAddress2() {
	return address2;
    }

    /**
     * Set address2
     * @param <code>String</code>
     */
    public void setAddress2(String a) {
	this.address2 = a;
    }

    /**
     * Get county
     * @return String
     */
    public String getCounty() {
	return county;
    }

    /**
     * Set county
     * @param <code>String</code>
     */
    public void setCounty(String c) {
	this.county = c;
    }

    /**
     * Get postcode
     * @return String
     */
    public String getPostcode() {
	return postcode;
    }

    /**
     * Set postcode
     * @param <code>String</code>
     */
    public void setPostcode(String p) {
	this.postcode = p;
    }

    /**
     * Get country
     * @return String
     */
    public String getCountry() {
	return country;
    }

    /**
     * Set country
     * @param <code>String</code>
     */
    public void setCountry(String c) {
	this.country = c;
    }

    /**
     * Get email
     * @return String
     */
    public String getEmail() {
	return email;
    }

    /**
     * Set email
     * @param <code>String</code>
     */
    public void setEmail(String e) {
	this.email = e;
    }

    /**
     * Get telephone
     * @return String
     */
    public String getTelephone() {
	return telephone;
    }

    /**
     * Set telephone
     * @param <code>String</code>
     */
    public void setTelephone(String t) {
	this.telephone = t;
    }

    /**
     * Get menuChoice
     * @return String
     */
    public String getMenuChoice() {
	return menuChoice;
    }

    /**
     * Set menuChoice
     * @param <code>String</code>
     */
    public void setMenuChoice(String m) {
	this.menuChoice = m;
    }

    /**
     * Get specialRequirements
     * @return String
     */
    public String getSpecialRequirements() {
	return specialRequirements;
    }

    /**
     * Set specialRequirements
     * @param <code>String</code>
     */
    public void setSpecialRequirements(String s) {
	this.specialRequirements = s;
    }

    /**
     * Get accepted
     * @return String
     */
    public String getAccepted() {
	return accepted;
    }

    /**
     * Set Accepted
     * @param <code>String</code>
     */
    public void setAccepted(String a) {
	this.accepted = a;
    }

    /**
     * Get GuestType
     * @return String
     */
    public String getGuestType() {
	return guestType;
    }

    /**
     * Set GuestType
     * @param <code>String</code>
     */
    public void setGuestType(String g) {
	this.guestType = g;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset values are provided as samples only. Change as appropriate.

        name = null;
        plusOne = null;
        partner = null;
        address1 = null;
        address2 = null;
        county = null;
        postcode = null;
        country = null;
        email = null;
        telephone = null;
        menuChoice = null;
        specialRequirements = null;
        partnerMenuChoice = null;
        partnerSpecialRequirements = null;
        accepted = null;
        guestType = null;
        actionType = null;
        hasPartner = false;

    }

    public ActionErrors validate(ActionMapping mapping,
	    HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	if (actionType.equalsIgnoreCase("NEWGUEST")) {
	 if ((name == null) || (name.length() == 0)) {
		   errors.add("blankGuestName", new org.apache.struts.action.ActionError("errors.blankGuestName"));
		 }
	 if (plusOne!=null && plusOne.equalsIgnoreCase("on") && ((name == null) || (name.length() == 0))) {
		   errors.add("blankPartnerName", new org.apache.struts.action.ActionError("errors.blankPartnerName"));
		 }
	 if ((address1 == null) || (address1.length() == 0)) {
		   errors.add("blankGuestAddress", new org.apache.struts.action.ActionError("errors.blankGuestAddress"));
		 }
	 if ((county == null) || (county.length() == 0)) {
		   errors.add("blankGuestCounty", new org.apache.struts.action.ActionError("errors.blankGuestCounty"));
		 }
	 if ((postcode == null) || (postcode.length() == 0)) {
		   errors.add("blankGuestPostcode", new org.apache.struts.action.ActionError("errors.blankGuestPostcode"));
		 }
	}
	//TODO put validation code here for RSVP acceptance
	return errors;

    }

	public String getPartnerSpecialRequirements() {
		return partnerSpecialRequirements;
	}

	public void setPartnerSpecialRequirements(String partnerSpecialRequirements) {
		this.partnerSpecialRequirements = partnerSpecialRequirements;
	}

	public String getPartnerMenuChoice() {
		return partnerMenuChoice;
	}

	public void setPartnerMenuChoice(String partnerMenuChoice) {
		this.partnerMenuChoice = partnerMenuChoice;
	}

	public boolean hasPartner() {
		return hasPartner;
	}

	public void setHasPartner(boolean hasPartner) {
		this.hasPartner = hasPartner;
	}
}
