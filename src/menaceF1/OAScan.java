package menaceF1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class OAScan {

	public static void main(String[] args) {
		readFile("/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/AJRCCM-DOI-TEST.txt"
				,
				"/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/results.txt"
				);
	}
	
	private static boolean checkOAFromService() {
		try {
			JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.oadoi.org/v2/10.1371/journal.pntd.0002030?email=Scott.McCarthy@ProQuest.com"), Charset.forName("UTF-8")));
			System.out.println("JSON WAS: "+json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
	private static void readFile(String filename, String outputFilename) {
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer csvBuffer = new StringBuffer();
			csvBuffer.append("Core,Query,Hits,Time");
			csvBuffer.append("\n");
			String line;
			while ((line = bufferedReader.readLine()) != null) {
					try {
						System.out.println("Reading a line");
						checkOAFromService();
						String csvLine = "LINE";
						csvBuffer.append(csvLine);
						csvBuffer.append("\n");
					} catch (ArrayIndexOutOfBoundsException e) {e.printStackTrace();}
			}
			fileReader.close();
			
			FileWriter fw = new FileWriter(outputFilename);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(csvBuffer.toString());	
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
