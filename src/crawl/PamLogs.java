package crawl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PamLogs {

	private static final String PATH = "/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/PAM Prod Working/";
	private static Map<Date, Integer> dateCounts;
	
	public static void main(String[] args) {
		dateCounts = new HashMap<Date,Integer>();
		System.out.println("starting PAM log scanner!");
		scanDirectory(PATH);
	}
	
	private static void scanDirectory(String directory) {
        File folder = new File(directory);
        String[] files = folder.list();
        for (String file : files)
        {
            System.out.println(file);
            readLogFile(PATH+file);
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Date d : dateCounts.keySet()) {
        	System.out.println(dateFormat.format(d)+","+dateCounts.get(d));
        }
        System.out.println(dateCounts);
    }
	
	private static void parseLine(String line) {
		try {
			String date = line.substring(line.indexOf('[')+1, line.indexOf(']')-15);
			Date dateObject=new SimpleDateFormat("dd/MMM/yyyy").parse(date);  
			if (dateCounts.containsKey(dateObject)) {
				dateCounts.put(dateObject, dateCounts.get(dateObject).intValue()+1);
			} else {
				dateCounts.put(dateObject, new Integer(1));
			}
		} catch (Exception e) {}
	}
	
	private static void readLogFile(String file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				parseLine(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
