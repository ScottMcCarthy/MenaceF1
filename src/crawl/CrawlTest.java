package crawl;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class CrawlTest {
	
	private static final String crawlURL = "http://10.241.16.212:4200/tdm/sm/37CF5C5524E0EC0FDB60924B2DAE941B/sitemap.index";
	private static final String locationTag = "loc";

	private static String readExternalFile(URL url){
		//Check if we need to do a redirect to a different URL.
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
	
	private static List<String> getListOfURLs(String source, String tag){
		List<String> URLs = new ArrayList<String>();
		String sourceTemp = source;
		String startTag = "<" + tag + ">";
		String endTag = "</" + tag + ">";
		while (sourceTemp.contains(startTag)){
			int start = sourceTemp.indexOf(startTag);
			int end = sourceTemp.indexOf(endTag);
			String url = sourceTemp.substring(start+startTag.length(), end);
			sourceTemp = sourceTemp.substring(end+endTag.length());
			URLs.add(url.replace("&amp;", "&"));
		}
		return URLs;
	}
	
	private static List<String> covertURLsForDevSystem(List<String> urls) {
		String beforeURL = "nightlyservices.aa1.pqe";
		String afterURL = "10.241.16.212:4200";
		ArrayList<String> updatedURLs = new ArrayList<String>();
		
		for (String s : urls){
			updatedURLs.add(s.replaceAll(beforeURL, afterURL));
		}
		return updatedURLs;
	}
	
	private static List<String> getURLsFromHyperLink(String url){
		String output = "";
		try {
			output = readExternalFile(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		List<String> siteMaps = getListOfURLs(output, locationTag);
		return siteMaps;
	}
	
	public static void main(String[] args) {
		//Step 1 : read the customer's Index.
		int fileNumber = 0;
		System.out.println("About to crawl: "+crawlURL);
		List<String> siteMaps = getURLsFromHyperLink(crawlURL);
		
		//Only run this stage to spoof URLs for testing on development system.
		siteMaps = covertURLsForDevSystem(siteMaps);
		System.out.println("Sitemaps: "+siteMaps);
		
		//Step 2 : Read all the sitemaps.
		for (String siteMap : siteMaps){
			List<String> dataFileList = covertURLsForDevSystem(getURLsFromHyperLink(siteMap));
			System.out.println("dataFileList: "+dataFileList);
			
			//Step 3 : download the files
			for (String fileURL : dataFileList) {
				fileNumber++;
				final String threadURL = fileURL;
				final int threadFileNumber = fileNumber;
					
					new Thread(new Runnable() {
					    public void run() {
					    	try {
					    		if (307 == httpReturnCode(new URL(threadURL))){
					    			try {
					    				FileUtils.copyURLToFile(new URL(get307RedirectURL(new URL(threadURL))), new File("/Users/ScottMcCarthy/crawl/"+threadFileNumber+".xml"));
					    				return;

					    			} catch (MalformedURLException e) {
					    				e.printStackTrace();
					    			}
					    			
					    		} else {
					    			FileUtils.copyURLToFile(new URL(threadURL), new File("/Users/ScottMcCarthy/crawl/"+threadFileNumber+".xml"));
					    		}
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					    }
					}).start();
			}
		}
	}

}
