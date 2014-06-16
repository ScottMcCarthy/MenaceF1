package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import menaceF1.struts.forms.WeddingGuestFormBean;
import menaceF1.wedding.GuestUtils;

/**
 * @version 	1.0
 * @author		Scott McCarthy
 */
public class AddGuestAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value
    if (request.getSession().getAttribute("WEDDINGGUEST")== null){
    	return mapping.findForward("sessionExpired");	
    }
	WeddingGuestFormBean weddingGuestFormBean = (WeddingGuestFormBean) form;

	try {
		GuestUtils guestUtils = new GuestUtils();
		guestUtils.createNewGuest(weddingGuestFormBean);
		weddingGuestFormBean.reset(mapping, request);
	    

	} catch (Exception e) {

		forward = mapping.findForward("failed");

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}
	// Write logic determining how the user should be forwarded.
	forward = mapping.findForward("success");

	// Finish with
	return (forward);

    }
}
