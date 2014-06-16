package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import menaceF1.struts.forms.MusicRequestFormBean;
import menaceF1.wedding.MusicRequests;

/**
 * @version 	1.0
 * @author
 */
public class SubmitMusicRequestAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionForward forward = new ActionForward(); // return value

    if (request.getSession().getAttribute("WEDDINGGUEST")== null){
    	return mapping.findForward("sessionExpired");
    }
	
	MusicRequestFormBean musicRequestFormBean = (MusicRequestFormBean) form;

	try {
			MusicRequests mr = new MusicRequests();
			mr.submitMusicRequest(musicRequestFormBean);
			musicRequestFormBean.reset(mapping, request);
	    

	} catch (Exception e) {

		forward = mapping.findForward("failed");

	}

	// Write logic determining how the user should be forwarded.
	forward = mapping.findForward("success");

	// Finish with
	return (forward);

    }
}
