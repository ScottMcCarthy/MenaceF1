package menaceF1;

	import javax.mail.*;
	import javax.mail.internet.*;
	import java.util.Properties;
	import java.io.*;
	import java.util.Vector;
	import java.util.StringTokenizer;
	import javax.activation.*;
	import java.net.InetAddress;
	import java.net.UnknownHostException;
	import com.sun.mail.smtp.SMTPMessage;

/**
 *Program to scan a directory for .txt & .err files and send the contents of these
 *files via SMTP.
 *
 *
 * 13/11/2002 V0.0 AS
 * 22/11/2002 V1.0 AS Initial release
 * 27/11/2002 V1.1 AS Move emailPath property to svimtop.cfg
 * 27/11/2002 V1.3 AS Updates to default Session properties - now taken direct from config file
 * 27/11/2002 V1.4 AS Default 'From' now working, added return receipts, more status messages,
 * changed setSender() to setFrom() to use correct header, check that To and subject are set.
 * Default TO list for error reports is support team, unless specified in err file
 * 02/12/2002 V1.41 AS Changed delimiter in alert.emailto from ; to ,
 * @author: Alex Sweeney
 */
public class EmailSender  {

//Directory to store invalid files in, so that they don't get processed again
private File invalidFileDir;


//Directory to scan for txt and err files to send as emails
private java.io.File mailDir;
/**
 * Insert the method's description here.
 * Creation date: (13/11/2002 17:47:31)
 */
public EmailSender() {

}
/**
*Checks for any files that don't end with .txt or .err in the mail directory.
*Any files that are found are moved to the Invalid_Files directory so that they
*aren't processed again. The file names are then reported.
*/
private void checkForInvalidFiles() {

	String EOL = System.getProperty("line.separator", "\r\n");


	System.out.println("Checking directoy for unknown file types");
	//Once all emails have been sent, and any attachments, then check for any
	//other files in the directory that don't end in ".txt" or ".err" and report
	//as an error.
	File[] wrongFiles = mailDir.listFiles( new FileFilter() {
		public boolean accept(File f) {
			return !(		f.getName().toUpperCase().endsWith(".TXT")
								||f.getName().toUpperCase().endsWith(".ERR")
								||f.isDirectory() );
		}
	});

	if (wrongFiles.length > 0) {

		StringBuffer buf = new StringBuffer();
		buf.append("The following files has invalid filenames (should be .txt or .err) and have been "+
				   "moved to the Invalid_Files directory"+EOL);

		for (int i=0; i<wrongFiles.length; i++) {
			buf.append(wrongFiles[i].getName()+EOL);
		}

		System.out.println(buf.toString());
	}


}
/*
*Scans the file to see which files were attached, deletes those files
*then deletes <code>file</code>.
*Returns true if everything was deleted, otherwise returns false
*/
private boolean deleteEmail(File file) {

	BufferedReader br=null;
	String line;
	int len;

	//Try for each file - if one file fails then we still want to try
	//to process all of the other files.
	try {

		br = new BufferedReader(new FileReader(file));

		while ( (line=br.readLine()) != null ) {

			line = line.trim();
			len = line.length();

			if ( len>=11 && line.substring(0,11).toUpperCase().equals("ATTACHMENT:") ) {

				File attach = new File( line.substring(11,len) );
				if (! attach.exists() )
					throw new EmailException("Can't delete non-existant file "+attach.getAbsolutePath()+"!");

				//Return false if we fail to delete any attachment
			  if (! attach.delete() )
				return false;
			}

		} //end of while

	}//End of try block
	catch(FileNotFoundException fnfe) {
		System.out.println(fnfe);
		return false;
	}
	catch(IOException ioe) {
		System.out.println(ioe);
		return false;
	}
	finally {

		try {
			if (br!=null) br.close();
		}
		catch (IOException ignore) {
		}

	}

	return file.delete();

}
	/**
	*Returns an array of InterNetAddresses from a comma-separated string of addresses.
	*/
	private InternetAddress[] getAddresses(String s, String delimiter) throws AddressException {

		StringTokenizer st = new StringTokenizer(s, delimiter);

		InternetAddress[] addr = new InternetAddress[st.countTokens()];
		int index=0;

		while ( st.hasMoreTokens() ) {
			addr[index++] = new InternetAddress( st.nextToken() );
		}


		return addr;
	}
/**
 * Insert the method's description here.
 * Creation date: (13/11/2002 16:29:40)
 * @exception javax.mail.MessagingException The exception description.
 */
public void go() {

	System.out.println("Process Started");




	mailDir = new File( "c:\\predNotes\\" );
	if (! mailDir.exists() ) {
		System.out.println("'mailDir' directory "+mailDir.getAbsolutePath()+" not found");
		return;
	}

	//Check that invalidFileDir exists, and try to create it if it doesn't.
	invalidFileDir = new File( mailDir, "Invalid_Files" );
	if (! invalidFileDir.exists() ) {
		if (! invalidFileDir.mkdir() ) {
			System.out.println("Unable to create "+mailDir.getAbsolutePath()+"\\Invalid_Files\\. Exiting...");
			return;
		}
	}


	try {
		sendEmails();
	}
	catch (MessagingException mme) {
		System.out.println(mme);
	}

	checkForInvalidFiles();

	System.out.println("Process Finished");

}
/**
 * Insert the method's description here.
 * Creation date: (13/11/2002 16:30:09)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {

	EmailSender sender = new EmailSender();

	sender.go();
}
private MimeMessage[] parseEmails(Session session, File[] files) {

	//Same length array as number of files. This lets us map a MimeMessage
	//to a File by the index, so that the calling method can delete the
	//file once the message is sent
	MimeMessage[] msg = new MimeMessage[files.length];
	String line;
	BufferedReader br=null;

	int len;
	InternetAddress[] addresses;
	InternetAddress addr;

	SMTPMessage message; //the current message being constructed
	Multipart multipart; //container to hold multiple parts of a message
	BodyPart messageBodyPart; //single part of a message, to be held in the multipart
	DataSource source; //source for attachments
	Vector<BodyPart> attachments = new Vector<BodyPart>(); //store all attachments in Vector, so we can append to end of message


	String mimeType = "text/plain"; //default to sending plain text
	StringBuffer body = new StringBuffer();

	for (int i=0; i<files.length; i++) {

		body.delete(0 , body.length() ); //clear StringBuffer ready for next message
		attachments.clear() ; //clear all attachments
		message = new SMTPMessage(session); //create new blank message using current Session
		multipart = new MimeMultipart(); //create new empty multipart to hold the message parts

		//Try for each file - if one file fails then we still want to try
		//to process all of the other files.
		try {

			message.setFrom(); //set to default from address
			message.setNotifyOptions( SMTPMessage.NOTIFY_FAILURE ); //Get failure notifications

			br = new BufferedReader(new FileReader(files[i]));

			line = br.readLine();
			if (line == null)
				throw new EmailException("File "+files[i]+" appears to be empty");

			//Read down to a blank line, checking each line against known headers.
			//Check that each line is long enough before comparing a substring to headers
			//else we could get an StringIndexOutOfBoundsException
			while( line!= null && !line.equals("") ) {  //read headers down to blank line

				line = line.trim();
				len = line.length();

				if ( line.indexOf(':') == -1 )
					throw new EmailException("Ensure a blank line separates the headers and body");

				if ( len>=8 && line.substring(0, 8).toUpperCase().equals("SUBJECT:") )
					message.setSubject( line.substring( 8, len ) );

				else if ( len>=5 && line.substring(0,5).toUpperCase().equals("FROM:") ) {
					addr = new InternetAddress( line.substring(5, len) );
					message.setFrom(addr);
				}
				else if ( len>=8 && line.substring(0,8).toUpperCase().equals("REPLYTO:") ) {

					addresses = getAddresses( line.substring(8, len), "," );
					message.setReplyTo(addresses);
				}
				else if ( len>=3 && line.substring(0,3).toUpperCase().equals("TO:") ) {
					addresses = getAddresses( line.substring(3, len), "," );
					message.addRecipients( Message.RecipientType.TO, addresses );
				}
				else if ( len>=3 && line.substring(0,3).toUpperCase().equals("CC:") ) {
					addresses = getAddresses( line.substring(3, len), "," );
					message.addRecipients( Message.RecipientType.CC, addresses );
				}
				else if ( len>=4 && line.substring(0,4).toUpperCase().equals("BCC:") ) {
					addresses = getAddresses( line.substring(4, len), "," );
					message.addRecipients( Message.RecipientType.BCC, addresses );
				}
				else if ( len>=9 && line.substring(0,9).toUpperCase().equals("MIMETYPE:") ) {
					mimeType = line.substring(9, len);
				}
				else if ( len>=15 && line.substring(0,15).toUpperCase().equals("DELIVERYREPORT:") ) {
					if ( line.substring(15, line.length()).trim().toUpperCase().equals("YES") ) {
						//Get return receipt for success or failure
						message.setNotifyOptions( SMTPMessage.NOTIFY_FAILURE | SMTPMessage.NOTIFY_SUCCESS );
					}
					else {
						throw new EmailException("Invalid value found: "+line);
					}
				}				
				else if ( len>=11 && line.substring(0,11).toUpperCase().equals("ATTACHMENT:") ) {
					File attach = new File( line.substring(11,len) );
					if (! attach.exists() )
						throw new EmailException("Attachment "+attach.getAbsolutePath()+" not found");

					source = new FileDataSource(attach);
					messageBodyPart = new MimeBodyPart();
					messageBodyPart.setDataHandler( new DataHandler(source) );
					messageBodyPart.setFileName( attach.getName() );
					attachments.add( messageBodyPart ); //store in vector, add to end of message later
				}
				else {
					throw new EmailException( "Invalid header found in "+files[i].getName()+": "+line );
				}

				line = br.readLine();

			} //End of while loop

			//Make sure we have the basic req'd headers
			if ( message.getRecipients(Message.RecipientType.TO) == null )
				throw new EmailException("No TO address specified in file "+files[i].getName());

			if ( message.getSubject() == null )
				throw new EmailException("No subject specified in file "+files[i].getName());
			

			//Make sure that there's more in the file once we find a blank line
			if (! br.ready() )
				throw new EmailException("No message body found. Ensure a blank line separates the headers & body");

			//Read rest of message and put into StringBuffer.
			//readLine() reads up to line separator, so add this into the body to preserve line breaks
			//Use \r\n for SMTP protocol, rather than the platform EOL
			while ( br.ready() ) {
				body.append( br.readLine() ).append("\r\n");
			}

			//message.setContent( body.toString(), mimeType );

			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent( body.toString(), mimeType );
			multipart.addBodyPart( messageBodyPart );

			//Now add any attachments, so that they appear at the bottom of the message
			for (int attachIndex=0; attachIndex<attachments.size(); attachIndex++)
				multipart.addBodyPart( (BodyPart)attachments.get(attachIndex));

			message.setContent(multipart);
			message.saveChanges(); //update all headers to reflect messages contents
			msg[i] = message;


		}//End of try block
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			msg[i] = null; //No message to send
		}
		catch(AddressException ae) {
			System.out.println(ae);
			msg[i] = null;
		}
		catch(MessagingException me) {
			System.out.println(me);
			msg[i] = null;
		}
		catch(IOException ioe) {
			System.out.println(ioe);
			msg[i] = null;
		}
		catch(EmailException ee) {
			System.out.println("Invalid file format: "+ee);
			msg[i] = null;
		}
		finally {

			try {
				if (br!=null) br.close(); //close file, else we can't delete it later
			}
			catch (IOException ignore) {
			}

		}




	} //End of for loop;

	return msg;

}
private MimeMessage[] parseErrors(Session session, File[] files) {
	//Same length array as number of files. This lets us map a MimeMessage
	//to a File by the index, so that the calling method can delete the
	//file once the message is sent
	MimeMessage[] msg = new MimeMessage[files.length];
	String line;
	BufferedReader br=null;

	int len;
	InternetAddress[] addresses;

	MimeMessage message; //the current message being constructed

	InternetAddress[] supportTeam;
	try {
	 //supportTeam = getAddresses( getProperty("alert.sendto"), ";" );
	 supportTeam = getAddresses( "scott.mccarthy@Menacef1.co.uk", "," );
	}
	catch (AddressException ae) {
		System.out.println("No error reports sent - invalid address found in alert.sendto list: "+ae.getMessage());
		return new MimeMessage[0];
	}

	String mimeType = "text/plain"; //default to sending plain text
	StringBuffer body = new StringBuffer();

	String hostname;

	try {
		hostname = InetAddress.getLocalHost().getHostName();
	}
	catch (UnknownHostException uhe) {
		hostname = "???";
	}

	for (int i=0; i<files.length; i++) {

		body.delete(0 , body.length() ); //clear StringBuffer ready for next message
		message = new MimeMessage(session); //create new blank message using current Session


		//Try for each file - if one file fails then we still want to try
		//to process all of the other files.
		try {

			message.setFrom(); //set to default from address
			message.setSubject(hostname+" - Error report from server");

			br = new BufferedReader(new FileReader(files[i]));

			line = br.readLine();
			if (line == null)
				throw new EmailException("File "+files[i]+" appears to be empty");

			//Read down to a blank line, checking each line against known headers.
			//Check that each line is long enough before comparing a substring to headers
			//else we could get an StringIndexOutOfBoundsException
			while( line != null && !line.equals("") ) {

				line = line.trim();
				len = line.length();

				if ( line.indexOf(':') == -1 )
					throw new EmailException("Ensure a blank line separates the headers and body");

				//Only header is TO. Don't need to CC/BCC for an error report.
				//Subject is set automatically
				//No attachements req'd
				//All error reports to come from 3flight, and no REPLY-TO req'd.
				if ( len>=3 && line.substring(0,3).toUpperCase().equals("TO:") ) {
					addresses = getAddresses( line.substring(3, len), "," );
					message.addRecipients( Message.RecipientType.TO, addresses );
				}
				else {
					throw new EmailException( "Invalid header found in "+files[i].getName()+": "+line );
				}

				line = br.readLine();

			} //End of while loop

			//Make sure that there's more in the file once we find a blank line
			if (! br.ready() )
				throw new EmailException("No message body found. Ensure a blank line separates the headers & body");

			//Read rest of message and put into StringBuffer.
			//readLine() reads up to line separator, so add this into the body to preserve line breaks
			while ( br.ready() ) {
				body.append( br.readLine() ).append("\r\n");
			}


			//If there's no to address specified then send to whole of support team
			if ( message.getRecipients(Message.RecipientType.TO) == null)
				message.setRecipients( Message.RecipientType.TO, supportTeam);
				

			message.setContent( body.toString(), mimeType );
			message.saveChanges(); //update all headers to reflect messages contents
			msg[i] = message;


		}//End of try block
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			msg[i] = null; //No message to send
		}
		catch(AddressException ae) {
			System.out.println(ae);
			msg[i] = null;
		}
		catch(MessagingException me) {
			System.out.println(me);
			msg[i] = null;
		}
		catch(IOException ioe) {
			System.out.println(ioe);
			msg[i] = null;
		}
		catch(EmailException ee) {
			System.out.println("Invalid file format: "+ee);
			msg[i] = null;
		}
		finally {

			try {
				if (br!=null) br.close(); //close file, else we can't delete it later
			}
			catch (IOException ignore) {
			}

		}
	}// End of for loop

	return msg;

}
public void sendEmails() throws MessagingException {



	//Default properties for the SMTP Session to use
	Properties defaults = new Properties();
	defaults.setProperty("mail.smtp.host","localhost");
	defaults.setProperty("mail.smtp.from","predserver@Menacef1.co.uk");
	defaults.setProperty("mail.smtp.port","444");
	defaults.setProperty("mail.from","predserver@Menacef1.co.uk");

	//Get list of files in the mailDir and process each one
	File[] txtFiles = mailDir.listFiles( new FileFilter() {
		public boolean accept(File f) {
			return f.getName().toUpperCase().endsWith(".TXT");
		}
	});
	System.out.println(txtFiles.length+" emails to process");

	File[] errFiles = mailDir.listFiles( new FileFilter() {
		public boolean accept(File f) {
			return f.getName().toUpperCase().endsWith(".ERR");
		}
	});
	System.out.println(errFiles.length+" error reports to process");

	if (txtFiles.length == 0 && errFiles.length == 0) {
		System.out.println("No files to process");
		return;
	}




  //Create session
	Session session = Session.getDefaultInstance(defaults);

	System.out.println("Parsing emails");
	//Parse all text files and return valid ones as MimeMessages
	MimeMessage[] msg = parseEmails(session, txtFiles);

	//Parse all error files and return valid ones as MimeMessages
	System.out.println("Parsing error reports");
	MimeMessage[] errors = parseErrors(session, errFiles);


	//Assume we have no valid MimeMessages to send, then check to see if we
	//do have any valid. This way we will connect to the SMTP server only
	//if we have something to send.
	boolean noValidFiles = true;

	//See if any of the email-files were valid. Move any that weren't valid
	for (int i=0; i<msg.length; i++) {

		if (msg[i] == null) {
			System.out.println(txtFiles[i]+" being moved to Invalid_Files directory");
		}
		else {
			noValidFiles = false; //Found a valid file. Set flag to continue program
		}

	}

	//See if any of the error-files were valid. Move any that weren't valid
	for (int i=0; i<errors.length; i++) {

		if (errors[i] == null) {
			System.out.println(errFiles[i]+" being moved to Invalid_Files directory");
		}
		else {
			noValidFiles = false; //Found a valid file. Set flag to continue program
		}

	}


	//If we didn't find any valid MimeMessage objects above, then we don't need
	//to connect to the SMTP server as there's nothing to send.
	if (noValidFiles) {
		System.out.println("No valid files to process");
		return;
	}



	System.out.println("Connecting to SMTP server");
	Transport transport = session.getTransport("smtp");
	transport.connect( defaults.getProperty("mail.smtp.host"), "", "" ); //no userid/pw


	System.out.println("Sending emails...");
	for (int i=0; i<msg.length; i++) {

		//Just send the non-null elements. We dealt with null elements earlier
		if (msg[i] != null) {
			try {
				Thread.sleep(20 * 1000);
				Transport.send(msg[i], msg[i].getAllRecipients());
				System.out.println("Email sent from "+msg[i].getFrom()[0]+" to "+msg[i].getAllRecipients().length+" recipients");

				//Try to delete the file and all attachments referenced within the file
				if (! deleteEmail(txtFiles[i]) )
					System.out.println("Failed to delete "+txtFiles[i].getName()+" or one of the referenced attachments");
			}
			catch (MessagingException me) {
				System.out.println("Failed to send "+txtFiles[i].getName()+": "+me);
			}
			catch (InterruptedException e) {}
				
		}
	}


	System.out.println("Sending error reports...");
	for (int i=0; i<errors.length; i++) {

		//Just send the non-null elements. We dealt with null elements earlier
		if (errors[i] != null) {
			try {
				Transport.send(errors[i], errors[i].getAllRecipients());
				if (! errFiles[i].delete() )
					System.out.println("Failed to delete "+errFiles[i].getName() );
			}
			catch (MessagingException me) {
				System.out.println("Failed to send error report "+errFiles[i].getName()+": "+me);
			}
		}
	}

	System.out.println("Closing connection to SMTP server");
	transport.close();




}
}
