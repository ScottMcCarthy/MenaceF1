package menaceF1.struts.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 10 fields on this form:
 * <ul>
 * <li>Name - [your comment here]
 * <li>Address1 - [your comment here]
 * <li>Address2 - [your comment here]
 * <li>County - [your comment here]
 * <li>Postcode - [your comment here]
 * <li>Telephone - [your comment here]
 * <li>Country - [your comment here]
 * <li>eMail - [your comment here]
 * <li>paymentMethod - [your comment here]
 * <li>days - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class HotelBookingFormBean extends ActionForm

{
	public static final long serialVersionUID = 1;
    private String name = null;
    private String address1 = null;
    private String address2 = null;
    private String county = null;
    private String postcode = null;
    private String telephone = null;
    private String country = null;
    private String email = null;
    private String paymentMethod = null;
    private String roomID = null;
    private String nights = null;
    private String roomcost = null;
    private String bookingID = null;

    public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getRoomcost() {
		if (roomcost.indexOf('.')<0) return roomcost;
		if (roomcost.indexOf('.')+3 > roomcost.length()) return roomcost;
		return roomcost.substring(0,roomcost.indexOf('.')+3);
	}

	public void setRoomcost(String roomcost) {
		this.roomcost = roomcost;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	/**
     * Get Name
     * @return String
     */
    public String getName() {
	return name;
    }

    /**
     * Set Name
     * @param <code>String</code>
     */
    public void setName(String n) {
	this.name = n;
    }

    /**
     * Get Address1
     * @return String
     */
    public String getAddress1() {
	return address1;
    }

    /**
     * Set Address1
     * @param <code>String</code>
     */
    public void setAddress1(String a) {
	this.address1 = a;
    }

    /**
     * Get Address2
     * @return String
     */
    public String getAddress2() {
	return address2;
    }

    /**
     * Set Address2
     * @param <code>String</code>
     */
    public void setAddress2(String a) {
	this.address2 = a;
    }

    /**
     * Get County
     * @return String
     */
    public String getCounty() {
	return county;
    }

    /**
     * Set County
     * @param <code>String</code>
     */
    public void setCounty(String c) {
	this.county = c;
    }

    /**
     * Get Postcode
     * @return String
     */
    public String getPostcode() {
	return postcode;
    }

    /**
     * Set Postcode
     * @param <code>String</code>
     */
    public void setPostcode(String p) {
	this.postcode = p;
    }

    /**
     * Get Telephone
     * @return String
     */
    public String getTelephone() {
	return telephone;
    }

    /**
     * Set Telephone
     * @param <code>String</code>
     */
    public void setTelephone(String t) {
	this.telephone = t;
    }

    /**
     * Get Country
     * @return String
     */
    public String getCountry() {
	return country;
    }

    /**
     * Set Country
     * @param <code>String</code>
     */
    public void setCountry(String c) {
	this.country = c;
    }

    /**
     * Get eMail
     * @return String
     */
    public String getEmail() {
	return email;
    }

    /**
     * Set eMail
     * @param <code>String</code>
     */
    public void setEmail(String e) {
	this.email = e;
    }

    /**
     * Get paymentMethod
     * @return String
     */
    public String getPaymentMethod() {
	return paymentMethod;
    }

    /**
     * Set paymentMethod
     * @param <code>String</code>
     */
    public void setPaymentMethod(String p) {
	this.paymentMethod = p;
    }


    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset values are provided as samples only. Change as appropriate.

	name = null;
	address1 = null;
	address2 = null;
	county = null;
	postcode = null;
	telephone = null;
	country = null;
	email = null;
	paymentMethod = null;
	roomcost = null;
	nights = null;

    }

    public ActionErrors validate(ActionMapping mapping,
	    HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	// Validate the fields in your form, adding
	// adding each error to this.errors as found, e.g.

	 if ((name == null) || (name.length() == 0)) {
		   errors.add("blankName", new org.apache.struts.action.ActionError("errors.blankName"));
		 }
	 if ((address1 == null) || (address1.length() == 0)) {
		   errors.add("blankAddress", new org.apache.struts.action.ActionError("errors.blankAddress"));
		 }
	 if ((county == null) || (county.length() == 0)) {
		   errors.add("blankCounty", new org.apache.struts.action.ActionError("errors.blankCounty"));
		 }
	 if ((postcode == null) || (postcode.length() == 0)) {
		   errors.add("blankPostcode", new org.apache.struts.action.ActionError("errors.blankPostcode"));
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
	 if (paymentMethod == null) {
		   errors.add("blankPaymentMethod", new org.apache.struts.action.ActionError("errors.blankPaymentMethod"));
		 }
	 return errors;

    }

	public String getNights() {
		return nights;
	}

	public void setNights(String nights) {
		this.nights = nights;
	}
}
