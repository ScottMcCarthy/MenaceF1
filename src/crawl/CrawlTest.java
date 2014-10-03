package crawl;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * On Windows:
 *  To compile:
 *  C:\Morningstar\services\Svcs-TdmCrawl\src\main\scripts\CrawlTester\crawl>javac -cp ../commons-io-2.4.jar CrawlTest.java
 *  To run:
 *  C:\Morningstar\services\Svcs-TdmCrawl\src\main\scripts\CrawlTester>java -cp commons-io-2.4.jar;. crawl.CrawlTest http://internal-tdm-devl2-1759524920.us-east-1.elb.amazonaws.com/tdm/sm/37CF5C5524E0EC0FDB60924B2DAE941B/sitemap.index C:\temp15
 */
public class CrawlTest {
	
	//private static final String defaultCrawlURL = "http://10.241.16.212:4200/tdm/sm/37CF5C5524E0EC0FDB60924B2DAE941B/sitemap.index";
	//private static final String defaultDestinationDirectory = "/Users/ScottMcCarthy/crawl";
	private static final String locationTag = "loc";
	
	private static String crawlURL = "";
	private static String destinationDirectory = "";
	private static int totalDownloads = 0;
	private static int failedDownloads = 0;
	
	private static final ExecutorService executor = Executors.newFixedThreadPool(100);
	private static final long SHUTDOWN_TIME_MINUTES = 10;

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
	
	public static int successfulDownloads(){
		return totalDownloads - failedDownloads;
	}
	
	public static void addToDownloads(int files) {
		totalDownloads = totalDownloads+files;
	}
	
	public static void incrementFailedDownloadCount() {
		failedDownloads++;
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
		System.out.println("File size is "+output.length()+ " bytes");
		List<String> siteMaps = getListOfURLs(output, locationTag);
		return siteMaps;
	}

	private static void copyURLToFile(URL source, File destination) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) source.openConnection();
		connection.setInstanceFollowRedirects(true);
		InputStream input = connection.getInputStream();
		// Redirect does not work when switching protocols from http to https, see
		// http://stackoverflow.com/a/1884427/152233
		StringWriter writer = new StringWriter();
		IOUtils.copy(input, writer, StandardCharsets.UTF_8);
		HttpURLConnection httpsConnection = (HttpURLConnection) new URL(writer.toString()).openConnection();
		httpsConnection.setInstanceFollowRedirects(true);
		InputStream httpsInput = httpsConnection.getInputStream();
		FileUtils.copyInputStreamToFile(httpsInput, destination);
	}
	
	/**
	 * This method uses the recommended shutdown strategy as documented in {@link ExecutorService}.
	 */
	private static void shutdownExecutor() {
		executor.shutdown(); // Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			if (!executor.awaitTermination(SHUTDOWN_TIME_MINUTES, TimeUnit.MINUTES)) {
				executor.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!executor.awaitTermination(SHUTDOWN_TIME_MINUTES, TimeUnit.MINUTES)) {
					System.err.println("The executor did not terminate after " + SHUTDOWN_TIME_MINUTES + TimeUnit.MINUTES);
				}
			}
		} catch (InterruptedException e) {
			// (Re-)Cancel if current thread also interrupted
			executor.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String[] args) {
				
		if (args.length!=2) {
			System.out.println("Usage : java -cp commons-io-2.4.jar:. crawl.CrawlTest <url-to-crawl> <directory-to-save-files-to>");
			return;
		}
		
		if (args.length == 2){
			crawlURL = args[0];
			destinationDirectory = args[1];
		}
		
		System.out.println("URL "+crawlURL);
		System.out.println("Directory : "+destinationDirectory);		
		
		//Step 1 : read the customer's Index.
		int fileNumber = 0;
		System.out.println("About to crawl: "+crawlURL);
		List<String> siteMaps = getURLsFromHyperLink(crawlURL);
		
		//Only run this stage to spoof URLs for testing on development system.
		siteMaps = covertURLsForDevSystem(siteMaps);
		System.out.println("Found "+siteMaps.size()+" site maps");
		
		//Step 2 : Read all the sitemaps.
		int sitemapCount = 0;
		for (String siteMap : siteMaps){
			sitemapCount++;
			System.out.println("Reading sitemap: "+sitemapCount+ " "+siteMap);
			List<String> dataFileList = covertURLsForDevSystem(getURLsFromHyperLink(siteMap));
			System.out.println("Sitemap "+sitemapCount+ " contains "+dataFileList.size()+ " files");
			CrawlTest.addToDownloads(dataFileList.size());
			
			
			//Step 3 : download the files
			for (String fileURL : dataFileList) {
				fileNumber++;
				final String threadURL = fileURL;
				final int threadFileNumber = fileNumber;
					
				executor.execute(new Runnable() {
				    @Override
					public void run() {
				    	try {
				    		copyURLToFile(new URL(threadURL), new File(destinationDirectory+"/"+threadFileNumber+".xml"));
						} catch (MalformedURLException e) {
							System.out.println("URL not valid: "+threadURL);
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println("Error occured downloading: "+threadURL);
							CrawlTest.incrementFailedDownloadCount();
							e.printStackTrace();
						}
				    }
				});

			}
		}
		shutdownExecutor();
		
		//Output Summary
		System.out.println();
		System.out.println("CRAWL COMPLETE");
		System.out.println("--------------");
		System.out.println(failedDownloads + " failed downloads");
		System.out.println(CrawlTest.successfulDownloads() + " files downloaded");
	}

}
