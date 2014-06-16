package menaceF1.struts.actions;

import java.util.HashMap;
import java.util.Map;

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
public class PhotoUploadAction extends Action

{

	//public static String uploadedBy = "";
	public static Map<String,String> uploadedByMap = new HashMap<String,String>();
	
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
	
	System.out.println("IP address when setting name: "+request.getRemoteAddr());
	uploadedByMap.put(request.getRemoteAddr(), request.getParameter("name"));
	request.getSession().setAttribute("photoName", request.getParameter("name"));

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}
	// Write logic determining how the user should be forwarded.
	forward = mapping.findForward("photoUploadApplet");

	// Finish with
	return (forward);

    }
}
