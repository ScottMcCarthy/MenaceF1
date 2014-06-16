package menaceF1.struts.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 1 field on this form:
 * <ul>
 * <li>password - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class PasswordFormBean extends ActionForm


{
	public static final long serialVersionUID = 1;
    
	private String password = null;

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
	return password;
    }

    /**
     * Set password
     * @param <code>String</code>
     */
    public void setPassword(String p) {
	this.password = p;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset values are provided as samples only. Change as appropriate.

	password = null;

    }

    public ActionErrors validate(ActionMapping mapping,
	    HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	// Validate the fields in your form, adding
	// adding each error to this.errors as found, e.g.

	 if ((password == null) || (password.length() == 0)) {
	   errors.add("blankPassword", new org.apache.struts.action.ActionError("errors.blankPassword"));
	 }
	return errors;

    }
}
