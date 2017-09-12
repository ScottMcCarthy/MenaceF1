package menaceF1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SolrParse {

	public static void main(String[] args) {
		readFile("/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/LION/Solr/nohup.out"
				,
				"/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/LION/Solr/solr.csv"
				);
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
				if ( 
					line.contains("params=") &&
					line.contains("hits=") &&
					!line.contains("freedom")
						) {
					try {
						line = line.replaceAll(",", ".");
						String core = line.substring(line.indexOf('[')+1, line.indexOf(']'));
						String query = line.substring(line.indexOf('{')+1, line.indexOf('}'));
						String hits = line.substring(line.indexOf("hits=")+5, line.indexOf("status="));
						String qtime = line.substring(line.indexOf("QTime=")+6);
						String csvLine = core.trim() + "," + query.trim() + "," + hits.trim() + "," + qtime.trim();
						csvBuffer.append(csvLine);
						csvBuffer.append("\n");
					} catch (ArrayIndexOutOfBoundsException e) {e.printStackTrace();}
				}
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
