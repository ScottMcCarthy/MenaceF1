package menaceF1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TomcatParse {

	public static void main(String[] args) {
		
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("Timestamp,Path");
		outputBuffer.append("\n");
		
		File folder = new File("/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/LION/Tomcat/");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        if (listOfFiles[i].getName().contains(".txt")) {
		        	System.out.println(listOfFiles[i].getPath());
		    		StringBuffer csv = readFile(listOfFiles[i].getPath());
		    		outputBuffer.append(csv.toString());
		        }
		      } 
		    }
		
		FileWriter fw;
		try {
			fw = new FileWriter("/Users/smccarth/Library/Mobile Documents/com~apple~CloudDocs/logs/LION/access.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(outputBuffer.toString());	
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static StringBuffer readFile(String filename) {
		StringBuffer csvBuffer = new StringBuffer();
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String returnCode = line.substring(line.indexOf("TTP/1.1")+9, line.lastIndexOf(' '));
				
				if ( 
					returnCode.equalsIgnoreCase("200") 
					&& !line.contains("marketing/index.jsp")
					&& !line.contains("index.php")
					&& !line.contains("ExtCAISUat")
					&& !line.contains("*")
						) {
					try {
						
						String date = line.substring(line.indexOf('[')+1, line.indexOf(']'));
						
						line = line.substring(line.indexOf(' ')+1);
						line = line.substring(line.indexOf(' ')+1);
						line = line.substring(line.indexOf(' ')+1);
						line = line.substring(line.indexOf(' ')+1);
						line = line.substring(line.indexOf(' ')+1);
						String url = line.substring(line.indexOf('/')+1,line.lastIndexOf("HTTP/1.1"));

						String csvLine = date.trim() + "," + url.trim();
						csvBuffer.append(csvLine);
						csvBuffer.append("\n");
					} catch (ArrayIndexOutOfBoundsException e) {e.printStackTrace();}
				}
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return csvBuffer;
	}

}
