package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menaceF1.struts.forms.PasswordFormBean;
import menaceF1.wedding.WeddingGuest;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class PasswordAction extends Action

{
	private static final String fullGuestPassword     = "celebrate";
	private static final String eveningGuestPassword  = "justmarried";
	private static final String brideAndGroomPassword = "arfarf";
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); 

	try {
		PasswordFormBean pwForm = (PasswordFormBean)form;
		//Create a new WeddingGuest object
		
		WeddingGuest thisGuest = new WeddingGuest();
		
		if (pwForm.getPassword().equalsIgnoreCase(fullGuestPassword)) {
			thisGuest.setFullGuest(true);
			request.getSession().setAttribute("WEDDINGGUEST", thisGuest);
			return mapping.findForward("success");
		}

		if (pwForm.getPassword().equalsIgnoreCase(eveningGuestPassword)) {
			thisGuest.setEveningGuest(true);
			request.getSession().setAttribute("WEDDINGGUEST", thisGuest);
			return mapping.findForward("success");
		}		

		if (pwForm.getPassword().equalsIgnoreCase(brideAndGroomPassword)) {
			thisGuest.setAdmin(true);
			request.getSession().setAttribute("WEDDINGGUEST", thisGuest);
			return mapping.findForward("success");
		}
		
		
		errors.add("invalidPassword", new ActionError("errors.invalidPassword"));

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("unknownError", new ActionError("unknown"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}

	forward = mapping.findForward("failed");

	// Finish with
	return (forward);

    }
}
