package menaceF1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class OAScan {

	public static void main(String[] args) {
		readFile("/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/natureDOIs.txt"
				,
				"/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/results.csv"
				);
	}
	
	private static boolean checkOAFromService(String articleID) {
		try {
			JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.oadoi.org/v2/"+articleID+"?email=Scott.McCarthy@ProQuest.com"), Charset.forName("UTF-8")));
			return json.getBoolean("is_oa");
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
			csvBuffer.append("DOI,Title,Journal,IS Open Access");
			csvBuffer.append("\n");
			String line;
			while ((line = bufferedReader.readLine()) != null) {
					try {
						String doi = line.split("\t")[0];
						String title = line.split("\t")[1];
						String journal = line.split("\t")[2];
						checkOAFromService(doi);
						String csvLine = doi+","+title.replaceAll(",", " ")+","+journal.replaceAll(",", " ")+","+checkOAFromService(doi);
						System.out.println("OUTPUT: "+csvLine);
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
