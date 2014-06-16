package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menaceF1.wedding.GuestUtils;

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
public class SubmitRSVPAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value
	menaceF1.struts.forms.RsvpFormBean rsvpFormBean = (menaceF1.struts.forms.RsvpFormBean) form;

	try {

	    GuestUtils gu = new GuestUtils();
	    gu.submitRSVP(rsvpFormBean);

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("name", new ActionError("id"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}
	// Write logic determining how the user should be forwarded.
	if (rsvpFormBean.isAttending()) forward = mapping.findForward("rsvpYES");
	else forward = mapping.findForward("rsvpNO");

	// Finish with
	return (forward);

    }
}
