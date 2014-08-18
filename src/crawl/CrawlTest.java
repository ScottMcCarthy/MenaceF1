package crawl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CrawlTest {
	
	private static final String crawlURL = "http://10.241.16.212:4200/tdm/sm/37CF5C5524E0EC0FDB60924B2DAE941B/sitemap.index";

	private static String readExternalFile(URL url){
		//Check if we need to do a redirect to a different URL.
		System.out.println("Return code is: "+httpReturnCode(url));
		
		String urlOutput = "";
		
		if (307 == httpReturnCode(url)){
			try {
				return readExternalFile(new URL(get307RedirectURL(url)));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				Scanner s = new Scanner(url.openStream());
				while (s.hasNext()) {
					urlOutput = urlOutput+s.next();
				}
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return urlOutput;
	}
	
	private static String get307RedirectURL(URL url){
		String returnURL = "";
		try {
			Scanner s = new Scanner(url.openStream());
            returnURL =  s.next();
            s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnURL;
		
	}
	
	private static int httpReturnCode(URL url) {
		HttpURLConnection connection;
		int code = 0;
		try {
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			code = connection.getResponseCode();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}
	
	
	public static void main(String[] args) {
		System.out.println("About to crawl: "+crawlURL);
		String customerIndex = "";
		try {
			customerIndex = readExternalFile(new URL(crawlURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Customer index: "+customerIndex);

	}

}
