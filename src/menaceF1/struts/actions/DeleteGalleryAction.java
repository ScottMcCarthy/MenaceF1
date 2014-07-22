package menaceF1.struts.actions;

import java.io.File;

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
public class DeleteGalleryAction extends Action

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
	    
	    String directoryName = request.getParameter("directory");
	    File dir = new File(PhotoUploadAction.filePath+directoryName);
	    File renamedDir = new File(PhotoUploadAction.filePath+directoryName+"extras");
	    System.out.println("Found file, and is it a directory - "+dir.isDirectory());
	    if (dir.isDirectory() & !renamedDir.exists()){
	    	dir.renameTo(renamedDir);
	    }
	    
	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
		errors.add("unknownError", new ActionError("unknown"));
		request.setAttribute("EXCEPTION", e.getMessage());

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
