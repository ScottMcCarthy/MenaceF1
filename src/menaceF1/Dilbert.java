package menaceF1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPMessage;

public class Dilbert {

	private static String cartoonURL() {
		String css = "img-responsive img-comic";
		String img = "src=";

		int startIndex = siteHTML().substring(siteHTML().indexOf(css)).indexOf(img)+img.length()+1;
		String snipToUrlStart = siteHTML().substring(siteHTML().indexOf(css)).substring(startIndex);
		int endIndex = snipToUrlStart.indexOf("\" />");
		return siteHTML().substring(siteHTML().indexOf(css)).substring(startIndex,startIndex+endIndex);
	}
	
	private static String siteHTML() {
		try {
			URL url = new URL("http://dilbert.com");
			InputStream is = url.openStream();
			int ptr = 0;
			StringBuffer buffer = new StringBuffer();
			while ((ptr = is.read()) != -1) {
				buffer.append((char)ptr);
			}
			return buffer.toString();
		} catch (Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	private static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}	
	
	private static File imageFile(String path){
		try {
			saveImage(path,"/mysql/dilbert.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new File("/mysql/dilbert.jpg");
		
	}
	
	public static void main(String[] args) {
		System.out.println("Dilbert Grabber v1.01");
		System.out.println("Dilbert URL: "+cartoonURL());

		Message message;
		try {
			message = buildSimpleMessage(buildSimpleSession(), imageFile(cartoonURL()));
			message.setRecipient(RecipientType.TO, new InternetAddress("Scott.McCarthy@MenaceF1.co.uk"));
			

			
			Transport.send(message);	
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static Session buildSimpleSession() {

	    Properties mailProps = new Properties();
	    mailProps.put("mail.transport.protocol", "smtp");
	    mailProps.put("mail.host", "localhost");
	    mailProps.put("mail.smtp.port", "444");
	    mailProps.put("mail.from", "Scott.McCarthy@MenaceF1.co.uk");
	    return Session.getDefaultInstance(mailProps);

	  }	
	
	private static Message buildSimpleMessage(Session session, File dilbert)

			  throws MessagingException {
			  SMTPMessage m = new SMTPMessage(session);
			  MimeMultipart content = new MimeMultipart();
			  MimeBodyPart mainPart = new MimeBodyPart();
			  mainPart.setText("Here is your daily Dilbert cartoon...");
			  content.addBodyPart(mainPart);
			  m.setContent(content);
			  m.setSubject("Daily Dilbert");
			  
			  MimeBodyPart messageBodyPart = new MimeBodyPart();
			  messageBodyPart = new MimeBodyPart();
			  DataSource source = new FileDataSource(dilbert);
			  messageBodyPart.setDataHandler(new DataHandler(source));
			  messageBodyPart.setFileName("Dilbert.jpg");
			  messageBodyPart.setDisposition(MimeBodyPart.INLINE); 
			
			  content.addBodyPart(messageBodyPart);				  
			  
			  return m;
			}	
	

}
