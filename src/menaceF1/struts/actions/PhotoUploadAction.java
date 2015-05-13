package menaceF1.struts.actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menaceF1.Menweb;

import org.apache.struts.action.Action;
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

	   private int maxFileSize = 5 * 1024  * 1024 * 1024;
	   private int maxMemSize = 1 * 1024 * 1024;
	   public static String filePath = "/var/www/wedding/";
	   private File file ;

	   static String convertStreamToString(java.io.InputStream is) {
		    java.util.Scanner scanner1 = new java.util.Scanner(is);
		    java.util.Scanner scanner2 = scanner1.useDelimiter("\\A");
		    String streamString =  scanner2.hasNext() ? scanner2.next() : "";
		    scanner1.close();
		    scanner2.close();
		    return streamString;
		}
	   
	   
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); // return value


    DiskFileItemFactory factory = new DiskFileItemFactory();
    // maximum size that will be stored in memory
    factory.setSizeThreshold(maxMemSize);
    // Location to save data that is larger than maxMemSize.
    factory.setRepository(new File(filePath));

    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);
    // maximum file size to be uploaded.
    upload.setSizeMax( maxFileSize );
    
    Menweb tools = new Menweb();
     try{ 
    // Parse the request to get file items.
    Map<String, List<FileItem>> fileItems = upload.parseParameterMap(request);
    
    List<FileItem> fileItemList = fileItems.get("guestname");
    FileItem fiw = fileItemList.get(0);
    String name = convertStreamToString(fiw.getInputStream());
    String uploadedBy = "Uploaded by "+name+" on "+tools.printDate()+"RESTRICTED";
 
	//create the folder
	File dir = new File(filePath+uploadedBy);
	if (!dir.exists()) dir.mkdir();
    
    
    // Process the uploaded file items

    List<FileItem> files1 = fileItems.get("files");

    Iterator<FileItem> i = files1.iterator();
    
    int x=0;
    
    while ( i.hasNext () ) 
    {
       x++;
    	FileItem fi = i.next();
       if ( !fi.isFormField () )	
       {
          // Get the uploaded file parameters
          String fileName = x+fi.getName();
          // Write the file
             file = new File( filePath + "/" + uploadedBy + "/" + fileName) ;

          fi.write( file ) ;
       }
    }
 }catch(Exception ex) {
     ex.printStackTrace();
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
