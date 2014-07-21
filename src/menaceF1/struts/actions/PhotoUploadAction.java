package menaceF1.struts.actions;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * @version 	1.0
 * @author
 */
public class PhotoUploadAction extends Action

{

	   private int maxFileSize = 50 * 1024 * 1024;
	   private int maxMemSize = 4 * 1024 * 1024;
	   private String filePath = "/Users/ScottMcCarthy/upload/";
	   private File file ;
	
	//public static String uploadedBy = "";
	public static Map<String,String> uploadedByMap = new HashMap<String,String>();
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value


    DiskFileItemFactory factory = new DiskFileItemFactory();
    // maximum size that will be stored in memory
    factory.setSizeThreshold(maxMemSize);
    // Location to save data that is larger than maxMemSize.
    factory.setRepository(new File("/Users/ScottMcCarthy/upload/"));

    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);
    // maximum file size to be uploaded.
    upload.setSizeMax( maxFileSize );

    try{ 
    // Parse the request to get file items.
    Map<String, List<FileItem>> fileItems = upload.parseParameterMap(request);
    
    // Process the uploaded file items

    List<FileItem> files1 = fileItems.get("files");

    Iterator<FileItem> i = files1.iterator();
    
    while ( i.hasNext () ) 
    {
       FileItem fi = i.next();
       if ( !fi.isFormField () )	
       {
          // Get the uploaded file parameters
          String fieldName = fi.getFieldName();
          String fileName = fi.getName();
          String contentType = fi.getContentType();
          boolean isInMemory = fi.isInMemory();
          long sizeInBytes = fi.getSize();
          // Write the file
          
          if( fileName.lastIndexOf("\\") >= 0 ){
        	  System.out.println("Writing file to: "+filePath + fileName.substring( fileName.lastIndexOf("\\")));
        	  file = new File( filePath + 
             fileName.substring( fileName.lastIndexOf("\\"))) ;
          }else{
        	  System.out.println("Writing file2 to: "+filePath + 
             fileName.substring(fileName.lastIndexOf("\\")+1));
             file = new File( filePath + 
             fileName.substring(fileName.lastIndexOf("\\")+1)) ;
          }
          fi.write( file ) ;
          System.out.println("Uploaded Filename: " + fileName);
       }
    }
 }catch(Exception ex) {
     ex.printStackTrace();
 }
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
