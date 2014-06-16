package menaceF1;

import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Creates an Email that will be sent from one of the Flightdeck task IDs.
 *
 * Basic Usage from a subclass of SVIM.Program:<br>
 * <code><br>
 * Email note = new Email(this);<br>
 * note.sendFrom( Email.UK_FLIGHTDECK );<br>
 * note.sendTo( someone@uk.ibm.com );<br>
 * note.setSubject( "This is a test email! ");<br>
 * note.println( "This is line 1" );<br>
 * note.print( "This is part of line 2");<br>
 * note.println( "end of line 2");<br>
 * note.println( "line 3" ");<br>
 * note.send();<br>
 * </code>
 * <br>
 * <br>
 * Version History:<br>
 * <ul>
 *  <li>1.0  AS Initial Version</li>
 *  <li>1.1  AS Added clearBody() method</li>
 *  <li>1.2  AS On error, now sends email addressee and body text to support team</li>
 *  <li>1.3  AS 21/08/2002 Added isBlank() method</li>
 *  <li>1.4  AS 27/11/2002 Updated for use with EmailSender - new format & added
 *                        cc, bcc, confidential, mime-types, replyTo etc.</li>
 *  <li>1.41 AS Removed unneeded method
 *  <li>1.5  AS Added delivery notifications
 *  <li>1.51 AS Added new constructor to allow calling from Websphere
 *  <li>1.52 AS Changed ':' to '-' in new constructor as ':' not allowed in filename
 * </ul>
 * @author: Alex Sweeney
 */
public class Email {

	/* Addresses for From: and ReplyTo: */
	/** Identifier for Task ID 'UK Flightdeck/UK/IBM */
	public final static int UK_FLIGHTDECK = 0;
	/** Identifier for Task ID 'Gloabl Services Information Manamagenemt/UK/IBM */
	public final static int UK_GSIM = 1;
	/** Identifier for Task ID 'UK BMS Support Desk/UK/IBM */	
	public final static int UK_BMS = 2;
	/** Identifier for Task ID 'UK ADSM Support Team/UK/IBM */	
	public final static int UK_ADSM = 3;
	/** Identifier for Task ID 'Travel Team/Poughkeepsie/IBM' */	
	public final static int TRAVEL_TEAM = 4;
	
	
	private int sendFrom = 0; //default to sending from UK_FLIGHTDECK
	
	public final static int PLAIN_TEXT = 0;
	public final static int HTML = 1;
	private int mimeType=PLAIN_TEXT; //default to plain text
		

	//Used to generate filename, have timestamp down to milliseconds as part of the file
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
	private static final String EOL = System.getProperty("line.separator");



	private StringBuffer text  = new StringBuffer(); //to hold the actual body of the email
	private String subject; //optional. Depends on file extension
	private String toList; //comma separated list of addresses to sendto

	private boolean confidential = false; //assume it's not 'IBM Confidential'
	private boolean deliveryNotification = false; //assume user doesn't want successful delivery notification

	
	private final java.lang.String[] mimeTypes = new String[]{"text/plain", "text/html"};
	private final java.lang.String[] addresses = new String[]{"predserver@Menacef1.co.uk",
																														"3ukbms@uk.ibm.com",
																														"adsmsup@uk.ibm.com",
																														"travteam@us.ibm.com"};

	//-1 for no replyTo address
	private int replyTo = -1;
	private String ccList=null; 
	private String bccList=null;
	private Vector<String> attachments = new Vector<String>();
	/**
	*Creates an Email that can be used by any class.
	*If you are calling from a subclass of<code>SVIM.Program</code>. then use the other constructor!<br />
	*Provide a meaningful name as this will be the name given in any error reports (it will be
	*prefixed with 'WS:'.<br />
	*This will be sent from UK Flightdeck in plain text format by default
	*@param program the SVIM.Program that is creating this email
	*/
	public Email(String name) {

		if (name== null)
		  throw new IllegalArgumentException("You must supply a name for the calling program (to track errors)");

	}


/**
 * Adds <code>file</code> as an attachment.
 * There is no error checking to make sure the file exists, this is done
 * by EmailSender when the email is actually sent.
 * file will be deleted when the email has been sent
 * Creation date: (25/11/2002 17:57:51)
 * @param file The file to attach
 */
public void addAttachment(File file) {

	//String path = file.getAbsolutePath();

	//StringBuffer buf = new StringBuffer();

	//for (int i=0; i<path.length(); i++) {
	//	buf.append( path.charAt(i) );

	//	//If character is a backslash then double it up
	//	if (path.charAt(i) == '\\' )
	//		buf.append( '\\' );

	//}
	
	//attachments.add(buf.toString());
	attachments.add( file.getAbsolutePath() );
}
/**
 * Adds the file denoted by filePath as an attachment.
 * Make sure that any backslashes are doubled up in the path,
 * eg c:\\temp\\readme.txt<br>
 * There is no error checking to make sure the file specified by
 * filePath exists, this is done by EmailSender when the email is
 * actually sent.<br>
 * The file specified by filePath will be deleted when the email has been sent
 * Creation date: (25/11/2002 17:57:51)
 * @param filePath full absolute path to the file
 */
public void addAttachment(String filePath) {
	attachments.add(filePath);
}
/**
*Clears the current text of the email body
*/
public void clearBody() {
	text.delete(0, text.length());
}
/**
 * Returns the current mimeType of the email
 * Creation date: (25/11/2002 17:07:57)
 * @return int mimetype
 */
public int getMimeType() {
	return mimeType;
}
/**
*Returns true iff there is no text in the body of the email
*
*/
public boolean isBlank() {
	  return (text.length() == 0);
  }  
/**
*Adds the specified text to the email, with no end of line
*@param s the new text to append to the email
*/
public void print(String s) {
	text.append(s);
}
/**
*Adds an empty line to the body of the email
*/
public void println() {
	print(EOL);
}
/**
*Adds the specified text to the email, followed by an end of line
*@param s the new text to append to the email
*/
public void println(String s) {
	print(s+EOL);
}
/**
*Writes the email out to a text file, ready for scheduled sending by EmailSender.
*This function will create a file in a directory under \notify\ on the server.
*The file will have a unique name, based on the name of the calling process and a timestamp
*@throws IllegalStateException if no recipient has been specified or there is no subject
*/
public void send() throws IllegalStateException {

	String dir = "c:\\predNotes\\";

	if (dir == null)
		throw new IllegalStateException("Unable to retrieve email directory path from svimtop.cfg");

	if (toList==null)
		throw new IllegalStateException("No sendTo address defined.");

	if (subject==null)
		throw new IllegalStateException("No subject specified");

	String filename = dir + "preds"+"_"+sdf.format(new Date()) +".txt";
	PrintWriter pw = null;


	try {
		pw = new PrintWriter( new FileWriter( filename ) );

		pw.println("To:"+toList);	
		if (ccList != null) 
			pw.println("Cc:"+ccList);
		if (bccList != null)
			pw.println("Bcc:"+bccList);
		pw.println("From:"+addresses[sendFrom]);
		if (replyTo != -1)
			pw.println("ReplyTo:"+addresses[replyTo]);
		pw.println("MimeType:"+mimeTypes[mimeType]);
		pw.println("Subject:"+ (confidential?"*IBM Confidential:":"")+subject);

		if (deliveryNotification) //only write line if req'd, default is notification for failure only
			pw.println("DeliveryReport:YES");
			
		for (int i=0; i<attachments.size(); i++)
			pw.println("Attachment:"+attachments.get(i));

		pw.println(); //Blank line between headers and body

		//write out body of message
		pw.println( text.toString() );


	}
	catch (IOException ioe) {


	}
	finally {

		if (pw!=null) {
			pw.flush();
			pw.close();
		}

	}

}

/**
*Writes the email out to a text file, ready for scheduled sending by EmailSender.
*This function will create a file in a directory under \notify\ on the server.
*The file will have a unique name, based on the name of the calling process and a timestamp
*@throws IllegalStateException if no recipient has been specified or there is no subject
*/
public void send(String identifier) throws IllegalStateException {

	String dir = "c:\\predNotes\\";

	if (dir == null)
		throw new IllegalStateException("Unable to retrieve email directory path from svimtop.cfg");

	if (toList==null)
		throw new IllegalStateException("No sendTo address defined.");

	if (subject==null)
		throw new IllegalStateException("No subject specified");

	String filename = dir + identifier.trim() +"_"+sdf.format(new Date()) +".txt";
	PrintWriter pw = null;


	try {
		pw = new PrintWriter( new FileWriter( filename ) );

		pw.println("To:"+toList);	
		if (ccList != null) 
			pw.println("Cc:"+ccList);
		if (bccList != null)
			pw.println("Bcc:"+bccList);
		pw.println("From:"+addresses[sendFrom]);
		if (replyTo != -1)
			pw.println("ReplyTo:"+addresses[replyTo]);
		pw.println("MimeType:"+mimeTypes[mimeType]);
		pw.println("Subject:"+ (confidential?"*IBM Confidential:":"")+subject);

		if (deliveryNotification) //only write line if req'd, default is notification for failure only
			pw.println("DeliveryReport:YES");
			
		for (int i=0; i<attachments.size(); i++)
			pw.println("Attachment:"+attachments.get(i));

		pw.println(); //Blank line between headers and body

		//write out body of message
		pw.println( text.toString() );


	}
	catch (IOException ioe) {


	}
	finally {

		if (pw!=null) {
			pw.flush();
			pw.close();
		}

	}

}


	/**
	*Specifies to whom the email is to be BCCed.
	*@param names array of email address
	*@throws IllegalArgumentException if any of the elements of the array are null
	*/
	public void setBCC(String[] names) throws IllegalArgumentException {
		setNameList(names, "BCC");
	}

/**
*Specifies to whom the email is to be BCCed.
* Set to null to remove all BCC names.
* @param names comma separated list of email addresses
*/
public void setBCC(String names) {
	bccList = names;
}
	/**
	*Specifies to whom the email is to be CCed.
	*@param names array of email address
	*@throws IllegalArgumentException if any of the elements of the array are null
	*/
	public void setCC(String[] names) throws IllegalArgumentException {
		setNameList(names, "CC");
	}

/**
*Specifies to whom the email is to be CCed.
* Set to null to remove all CC names.
* @param names comma separated list of email addresses
*/
public void setCC(String names) {
	ccList = names;
}
/**
 * If set to true, then '*IBM Confidential:' will be prepended to the subject when sent.
 * Creation date: (26/11/2002 16:55:54)
 * @param confidential true if the email content is 'IBM Confidential'
 */
public void setConfidential(boolean confidential) {
	this.confidential = confidential;
}
/**
 * Insert the method's description here.
 * Creation date: (27/11/2002 17:30:32)
 * @param required boolean
 */
public void setDeliveryNotification(boolean required) {
	deliveryNotification = required;
}
/**
 * Sets the mimetype of the email.
 * Creation date: (25/11/2002 17:08:18)
 * @param mimeType the mimeType to set
 */
public void setMimeType(int mimeType) {
		if (mimeType < 0 || mimeType >= mimeTypes.length)
			throw new IllegalArgumentException("Argument must be between 0 and "+(mimeTypes.length-1));

		this.mimeType = mimeType;
	}
/**
 * Insert the method's description here.
 * Creation date: (25/11/2002 17:36:29)
 * @param names java.lang.String
 * @param field java.lang.String
 */
	private void setNameList(String[] names, String field) {

		StringBuffer buf = new StringBuffer();

		for (int i=0; i<names.length; i++) {
			if (names[i]==null)
				throw new IllegalArgumentException(field +"address number "+(i-1)+" is null");

		  buf.append( names[i] ).append(",");
		}

		buf.setLength( buf.length()-1 ); //drop last comma

		if ( field.equals("TO") )
			toList = buf.toString();
		else if ( field.equals("CC") )
			ccList = buf.toString();
		else if ( field.equals("BCC") )
			bccList = buf.toString();
		else
			throw new IllegalArgumentException("Field name "+field+" not recognised");
			
			

	}
	/**
	*Specifies an address to which replies should be sent.
	*Set to null to remove the replyTo address
	*@param name Single email address.
	*@throws IllegalArgumentException if more than one address is specified
	*/
	public void setReplyTo(int address) {

		if (address < 0 || address >= addresses.length)
			throw new IllegalArgumentException("ReplyTo address must be between 0 and "+(addresses.length-1));

		replyTo = address;

	}
	/**
	*Specifies from which ID the email should sent.
	*The email can be sent from any of the addresses defined in this class
	*@param address Email.UK_FLIGHTDECK, Email.GSIM etc
	*@throws IllegalArgumentException if a value other than the above is specified
	*/
	public void setSendFrom(int address) throws IllegalArgumentException {

 		if (address < 0 || address >= addresses.length)
 			throw new IllegalArgumentException("Invalid userID to send note from. Must be 0 <= x <= "+(addresses.length-1));

 		sendFrom = address;
	}
	/**
	*Specifies to whom the email is to be sent.
	*@param names array of email address (full notes address or short name)
	*@throws IllegalArgumentException if any of the elements of the array are null
	*/
	public void setSendTo(String[] names) throws IllegalArgumentException {
		setNameList(names, "TO");
	}

	/**
	*Specifies to whom the email is to be sent.
	*@param names string of email address, separated by commas
	*@throws IllegalArgumentException if the argument is null
	*/
	public void setSendTo(String names) {
		if (names == null)
			throw new IllegalArgumentException("Cannot set null address to send to");

		toList = names;

	}
/**
*Sets the subject line of the email
*@param subject the subject of the email
*/
public void setSubject(String subject) {
		this.subject = subject;		
	}
}
