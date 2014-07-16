package menaceF1;
import java.io.*;
import java.util.*;


/**
 * @author Scott McCarthy
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Menweb {
	
	private static boolean testServer = true;
	public String gallery;
	public String galleryName;
	public boolean showLogo = true;
	
	public boolean isShowLogo() {
		return showLogo;
	}

	public void setShowLogo(boolean showLogo) {
		this.showLogo = showLogo;
	}

	public void setGallery(String s) {
		gallery = s.replace('¬','/');
		galleryName = s.substring(s.lastIndexOf('/')+1);
	}
	
	public String getGallery() {
		return gallery;
	}

	public String getGalleryName() {
		return galleryName;
	}
	
	public String printDate() {
		java.util.Date todayDate = new java.util.Date() ;
		Calendar today = Calendar.getInstance();
		today.setTime(todayDate);
		String Day = "";
		if (today.get(Calendar.DAY_OF_WEEK) == 1) {Day = "Sunday";};
		if (today.get(Calendar.DAY_OF_WEEK) == 2) {Day = "Monday";}
		if (today.get(Calendar.DAY_OF_WEEK) == 3) {Day = "Tuesday";}
		if (today.get(Calendar.DAY_OF_WEEK) == 4) {Day = "Wednesday";}
		if (today.get(Calendar.DAY_OF_WEEK) == 5) {Day = "Thursday";}
		if (today.get(Calendar.DAY_OF_WEEK) == 6) {Day = "Friday";}
		if (today.get(Calendar.DAY_OF_WEEK) == 7) {Day = "Saturday";}	
		
		String Month = "";	
		if (today.get(Calendar.MONTH) == 0) {Month = "January";};
		if (today.get(Calendar.MONTH) == 1) {Month = "February";};
		if (today.get(Calendar.MONTH) == 2) {Month = "March";};
		if (today.get(Calendar.MONTH) == 3) {Month = "April";};
		if (today.get(Calendar.MONTH) == 4) {Month = "May";};
		if (today.get(Calendar.MONTH) == 5) {Month = "June";};
		if (today.get(Calendar.MONTH) == 6) {Month = "July";};
		if (today.get(Calendar.MONTH) == 7) {Month = "August";};
		if (today.get(Calendar.MONTH) == 8) {Month = "September";};
		if (today.get(Calendar.MONTH) == 9) {Month = "October";};
		if (today.get(Calendar.MONTH) == 10) {Month = "November";};
		if (today.get(Calendar.MONTH) == 11) {Month = "December";};
		
		String suffix = "th";
		if (today.get(Calendar.DAY_OF_MONTH) == 1) {suffix = "st";};
		if (today.get(Calendar.DAY_OF_MONTH) == 2) {suffix = "nd";};
		if (today.get(Calendar.DAY_OF_MONTH) == 3) {suffix = "rd";};
		if (today.get(Calendar.DAY_OF_MONTH) == 21) {suffix = "st";};
		if (today.get(Calendar.DAY_OF_MONTH) == 22) {suffix = "nd";};
		if (today.get(Calendar.DAY_OF_MONTH) == 23) {suffix = "rd";};
		if (today.get(Calendar.DAY_OF_MONTH) == 31) {suffix = "st";};		
										
		return "" + Day + " " + today.get(Calendar.DAY_OF_MONTH) + suffix + " " + Month + " " + today.get(Calendar.YEAR) ;
	}
	
	private String getImageDimensions(String imageDetails) {
		int startChar = imageDetails.indexOf(" JPEG ");
		String startDimensions = imageDetails.substring(startChar+6);
		int endChar = startDimensions.indexOf(" ");
		String dimensions = startDimensions.substring(0, endChar);
		return dimensions;
	}
	
	private int getImageWidth(String imageDetails) {
		String dimensions = getImageDimensions(imageDetails);
		return Integer.parseInt(dimensions.substring(0, dimensions.indexOf('x')));
	}
	
	private int getImageHeight(String imageDetails) {
		String dimensions = getImageDimensions(imageDetails);
		return Integer.parseInt(dimensions.substring(1+dimensions.indexOf('x')));
	}

	public void makeThumb(String path) {
	
		int sourceHeight = 0;
		int sourceWidth = 0;
		
		String[] identifyCommandArguments = {"identify",path};
		
		try {
			Process proc = Runtime.getRuntime().exec(identifyCommandArguments);
            BufferedReader in = new BufferedReader(  
            new InputStreamReader(proc.getInputStream()));  
            String line = in.readLine();
            sourceHeight = getImageHeight(line);
            sourceWidth = getImageWidth(line);
			} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	
		
		int height = sourceHeight;
		int factor = height/130;
		int width = sourceWidth/factor;

		//save the scaled image
		String savePath = path.substring(0,path.lastIndexOf("/")) + "/thumbs" + path.substring(path.lastIndexOf("/"),path.length());
		String[] scaleCommandArguments = {"convert",path,"-resize",width+ "x130!",savePath};
		
		try {
			Runtime.getRuntime().exec(scaleCommandArguments);	
			} 
		catch (IOException e) {
			e.printStackTrace();
		}    
	}

	public void makeMidsize(String path) {
	
		int sourceHeight = 0;
		int sourceWidth = 0;
		
		String[] identifyCommandArguments = {"identify",path};
		
		try {
			Process proc = Runtime.getRuntime().exec(identifyCommandArguments);
            BufferedReader in = new BufferedReader(  
            new InputStreamReader(proc.getInputStream()));  
            String line = in.readLine();
            sourceHeight = getImageHeight(line);
            sourceWidth = getImageWidth(line);
			} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		int height = sourceHeight;
		double factor = height/800.0;
		double newWidth = sourceWidth/factor;
		Double newWidthObj = new Double(newWidth);
		int newWidthInt = newWidthObj.intValue();
		
		//save the scaled image
		String savePath = path.substring(0,path.lastIndexOf("/")) + "/midsize" + path.substring(path.lastIndexOf("/"),path.length());
		String[] scaleCommandArguments = {"convert",path,"-resize",newWidthInt+ "x800!",savePath};
		
		try {
			Runtime.getRuntime().exec(scaleCommandArguments);
			} 
		catch (IOException e) {
			e.printStackTrace();
		}    

	}


	public void jpegTrawler (String path) {
		File dir = new File(path);
		String[] imageList = dir.list();
		if (imageList == null) return;
		for (int i=0;i<imageList.length;i++) {
				if (imageList[i].toUpperCase().indexOf(".JPG") > 0) {
					makeThumb(path + imageList[i]);
					makeMidsize(path + imageList[i]);
					
					//Pause to allow Operating System to catch-up
					
					try {
						Thread.sleep(275000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
				}
		}
	}

	public void directoryTrawler (String path) {
		File dir = new File(path);
		File[] dirList = dir.listFiles();
		if (dirList==null) return;
		for (int i=0;i<dirList.length;i++) {
				if (dirList[i].isDirectory() && !dirList[i].toString().endsWith("extras")) {
					File thumbsDir  = new File(dirList[i] + "/thumbs");
					File midsizeDir = new File(dirList[i] + "/midsize");
					if (!thumbsDir.exists() && !midsizeDir.exists()) {
						thumbsDir.mkdir();
						midsizeDir.mkdir();
						jpegTrawler(dirList[i].toString() + "/");
					}
				}
		}
		
	}

	public void restrictedGalleryFront (String path, javax.servlet.jsp.JspWriter out, String jspPage) {
		
		try {
			out.println("<TABLE border='1' width='100%' bgcolor='#ffffff'>");
			out.println("<TR><TD>");
			out.println("<TABLE border='0' width='100%' bgcolor='#ffffff'>");
			out.println("<TR><TD colspan='2'>");
			if (showLogo) out.println("<H2><B><U>Photo Galleries</H2></B></U>");
			out.println("</TD></TR>");
			out.println("<FORM name = 'director' method = 'get' action = '"+jspPage+"'>");
			out.println("<input type = 'hidden' name = 'gallery' value = ''>");
			out.println("</FORM>");
			out.println("<script language=JavaScript>");
			out.println("function openGallery(f,gal){");
			out.println("f.gallery.value = gal;");
			out.println("f.submit();");
			out.println("}");
			out.println("</script>");

			out.println("<TR>");
			if (showLogo) out.println("<TD width = '20%'><IMG border='0' src='images/camera.jpg'></TD><TD>");
			

		File dir = new File(path);
		File[] dirList = dir.listFiles();
		String[] fileList = dir.list();
		String altFile = "";
		
		for (int i=0;i<dirList.length;i++) {
				if (dirList[i].isDirectory() && dirList[i].toString().endsWith("RESTRICTED")) {
					altFile = dirList[i].toString();
					out.println("<a href=\"javascript:openGallery(document.forms.director,'" + altFile + "')\">" + fileList[i].substring(0,fileList[i].length()-10) + "</A><BR>");
				}
		}
		out.println("</TD></TR></TABLE></TD></TD></TABLE>");			
		}
		catch (Exception e) {e.printStackTrace();};
		
	}

	
	
	public void galleryFront (String path, javax.servlet.jsp.JspWriter out, String jspPage) {
	
		try {
			out.println("<table border='1' width='100%' bgcolor='#ffffff'>");
			out.println("<tr><td>");
			out.println("<table border='0' width='100%' bgcolor='#ffffff'>");
			out.println("<tr><td colspan='2'>");
			if (showLogo) out.println("<h2><b><u>Photo Galleries</h2></b></u>");
			out.println("</td></tr>");
			out.println("<form name = 'director' method = 'get' action = '"+jspPage+"'>");
			out.println("<input type = 'hidden' name = 'gallery' value = ''>");
			out.println("</form>");
			out.println("<script language=JavaScript>");
			out.println("function openGallery(f,gal){");
			out.println("f.gallery.value = gal;");
			out.println("f.submit();");
			out.println("}");
			out.println("</script>");

			out.println("<tr>");
			

		File dir = new File(path);
		File[] dirList = dir.listFiles();
		String[] fileListArray = dir.list();
		ArrayList<String> fileList = new ArrayList<String>();
		Map<String,File> dirFileMap = new HashMap<String,File>();
		for (int x=0;x<fileListArray.length;x++) {
			if (dirList[x].isDirectory() && !dirList[x].toString().endsWith("extras") && !dirList[x].toString().endsWith("RESTRICTED")) {
				fileList.add(fileListArray[x]);
				dirFileMap.put(fileListArray[x], dirList[x]);
				}
			}

		Collections.sort(fileList);
		Collections.reverse(fileList);
		String altFile = "";

		out.println("<table>");
		out.println("<tr>");
		int imagesPerRow = 5;
		int imageCount = 0;
		for (int i=0;i<dirList.length;i++) {
			altFile = dirFileMap.get(fileList.get(i)).toString();
			out.println("<td align=\"center\" >");
			out.println("<a href=\"javascript:openGallery(document.forms.director,'" + altFile + "')\">" + galPinkyLink(path,fileList.get(i)) + "<br />"+fileList.get(i).substring(fileList.get(i).indexOf("-")+1).replace("-", "<br />")+"</a>");
			out.println("</td>");
			imageCount++;
			if (imageCount==imagesPerRow) {
				out.println("</tr>");
				out.println("<tr>");
				imageCount = 0;
			}
		}		
		out.println("</tr>");
		out.println("</table>");
		out.println("</td></tr></table></td></td></table>");			
		}
		catch (Exception e) {e.printStackTrace();};
		
	}

	private String galPinkyLink(String path,String filename){
		path = path+"/";
		StringBuffer html = new StringBuffer();
		File dir = new File(path+filename+"/thumbs");
		File[] dirList = dir.listFiles();
		String[] fileListArray = dir.list();
		
		ArrayList<String> fileList = new ArrayList<String>();
		for (int x=0;x<fileListArray.length;x++) {
			if (!dirList[x].isDirectory()) {
				fileList.add(fileListArray[x]);
				}
			}
		path.replace('/','¬');
		String localPath = path.replace('/','¬').substring(path.replace('/','¬').lastIndexOf('¬')+1);
		if (path.lastIndexOf("extras") != -1) {
			localPath = path.substring(path.lastIndexOf("extras")).replace('/','/');
		}		
		
		String imagePath = getDomainPrefix()+"/"+localPath+"/"+filename+"/thumbs/cover.JPG";
		if (!fileList.contains("cover.jpg") && !fileList.contains("cover.JPG")) {
			for (int i=0;i<dirList.length;i++) {
				imagePath =getDomainPrefix()+"/"+localPath+"/"+filename+"/thumbs/"+fileList.get(i);
			}			
		}
		html.append("<img src="+imagePath.replace(" ", "%20")+">");
		return html.toString();
	}

	public boolean isPasswordProtected (String path) {
		File passwordFile = new File(path+"/password.txt");
		return passwordFile.exists();
	}

	public boolean securityCheck (String path, String userPassword) {
	
		boolean accessGranted = false;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path+"/password.txt"));
		 	String galleryPassword = in.readLine();
		 	if (userPassword.equalsIgnoreCase(galleryPassword)) accessGranted = true;
		}
		catch (Exception e) {
			return false;
			};
		try {
			in.close();
		} catch (IOException e) {
			return false;
		}
		return accessGranted;
	}

	public void thumbsHTML (String path, String name, javax.servlet.jsp.JspWriter out, String gal, String jspPage) {
		gal = convertDriveLetter(gal);
		path = convertDriveLetter(path);
		try{
		out.println("<TABLE border='1' width='100%' bgcolor='#ffffff'>");
		out.println("<TR><TD>");
		out.println("<TABLE border='0' width='100%' bgcolor='#ffffff'>");
		out.println("<TR><TD colspan='4'>");
		out.println("<H2><B><U>" + name + "</H2></B></U>");
		out.println("</TD></TR>");
		out.println("<TR>");

		File dir = new File(path);
		String localPath = name;
		if (path.lastIndexOf("extras") != -1) {
			localPath = path.substring(path.lastIndexOf("extras")).replace('/','/');
		}
		String[] imageList = dir.list();
		int count = 0;

		out.println("<FORM name = 'director' method = 'get' action = '"+jspPage+"'>");
		out.println("<input type = 'hidden' name = 'gallery' value = '"+gal+"'>");
		out.println("<input type = 'hidden' name = 'filename' value = ''>");
		out.println("<script language=JavaScript>");
		out.println("function openGallery(f,filename){");
		out.println("f.filename.value = filename;");
		out.println("f.submit();");
		out.println("}");
		out.println("</script>");

		
		for (int i=0;i<imageList.length;i++) { 
				if (imageList[i].toUpperCase().indexOf(".JPG") > 0) {
					out.println("<TD><a href=\""+jspPage+"?gallery="+gal+"&filename="+imageList[i]+"\"><IMG border='0' src='/" + localPath + "/thumbs/" + imageList[i] + "'> </A></TD>");
					count++;
					if (count == 4) {
							count = 0;
							out.println("</TR><TR>");
					}
				}
		}

		out.println("</TD></TR></TABLE></TD></TD></TABLE>");			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	private static String getDomainPrefix(){
		if (testServer) return "http://menacef1.dnsalias.com";
		return "";
	}
	
	private static String convertDriveLetter(String path) {
		if (path.length()>2 && (path.startsWith("D:") || path.startsWith("d:"))) {
			return "C"+path.substring(1);
		}
		return path;
	}
	
	public void slideshowHTML (String path, String name, javax.servlet.jsp.JspWriter out, String gal, String jspPage) {
		gal = convertDriveLetter(gal);
		path = convertDriveLetter(path);
		try{
			out.println("<div class='group galleryGroup'>");
			out.println("<ul align=\"center\">");


			File dir = new File(path);
			String localPath = name;
			if (path.lastIndexOf("extras") != -1) {
				localPath = path.substring(path.lastIndexOf("extras")).replace('/','/');
			}
			String[] imageList = dir.list();
			String style = "";
			
			for (int i=0;i<imageList.length;i++) { 
					if (imageList[i].toUpperCase().indexOf(".JPG") > 0) {
						out.println("<li "+style+"><a href=\"/" + localPath + "/midsize/" + imageList[i] + "\" class=\"lightview\" rel=\"gallery[myset]\" id=\""+imageList[i]+"\"><IMG border='0' src=\"images/viewSlideshow.gif\"> </a></li>");
						style="style=\"display:none\"";
					}
			}

			out.println("</ul>");			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	
	
	
	public void imageHTML (String path, String name, String imageName,  javax.servlet.jsp.JspWriter out) {
	
		try {

		String localPath = name;
		if (path.lastIndexOf("extras") != -1) {
			localPath = path.substring(path.lastIndexOf("extras")).replace('/','/');
		}
		out.println("<TD><a href='/" + localPath + "/" + imageName + "'><IMG border='0' src='/" + localPath + "/midsize/" + imageName + "'> </A>");
		}
		catch (Exception e) {e.printStackTrace();};
		
	}


}
