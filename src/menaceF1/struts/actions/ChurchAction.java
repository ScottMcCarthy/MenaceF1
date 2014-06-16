package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ChurchAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value

	try {

	    if (request.getSession().getAttribute("WEDDINGGUEST")== null){
	    	return mapping.findForward("sessionExpired");
	    }

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
		errors.add("unknownError", new ActionError("unknown"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}
	// Write logic determining how the user should be forwarded.
	forward = mapping.findForward("church");

	// Finish with
	return (forward);

    }
}
