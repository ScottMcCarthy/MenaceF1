package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import menaceF1.*;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;


/**
 * @version 	1.0
 * @author
 */
public class ReceiveFileAction extends Action

	{

	public static final String PHOTO_PATH = "/var/www/extras/wedding/";
	
    @SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value

	try {
		Menweb tools = new Menweb();
		System.out.println("IP address when uploading photo: "+request.getRemoteAddr());
		String uploadedBy = "Uploaded by "+PhotoUploadAction.uploadedByMap.get(request.getRemoteAddr())+" on "+tools.printDate()+"RESTRICTED";
	    System.out.println("Processing uploaded files");

		File dir = new File(PHOTO_PATH+uploadedBy);
		if (!dir.exists()) dir.mkdir();
	    
	    System.out.println("Name entered was: "+request.getParameter("name"));
	    System.out.println(request.getParameterMap());
	    System.out.println(request.getQueryString());
	    DiskFileUpload upload = new DiskFileUpload();

//	     Parse the request
	    List items = upload.parseRequest(request);

	    Iterator iter = items.iterator();
	    while (iter.hasNext()) {
	    	FileItem item = (FileItem)iter.next();
	    	if (item.isFormField()) {
	    		System.out.println("its a field");
	    		System.out.println(item.getFieldName());
	    	} else {
	    		System.out.println("its a file");
	    		System.out.println(item.getName());
	    		File cfile=new File(item.getName());
	    		//File tosave=new File(cfile.getName());
	    		File tosave=new File(PHOTO_PATH+uploadedBy,cfile.getName());
	    		
	    		System.out.println(tosave.getAbsolutePath());
	    		item.write(tosave);
	    	}
	    }

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("name", new ActionError("id"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);

	    // Forward control to the appropriate 'failure' URI (change name as desired)
	    //	forward = mapping.findForward("failure");

	} else {

	    // Forward control to the appropriate 'success' URI (change name as desired)
	    // forward = mapping.findForward("success");

	}

	// Finish with
	forward = mapping.findForward("UploadSuccessful");
	return (forward);

    }
}
