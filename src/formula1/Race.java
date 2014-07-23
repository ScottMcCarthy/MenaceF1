package formula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Race {

	static F1Car alonso;
	static F1Car hamilton;
	static F1Car vettel;
	
	private static void setupGrid() {
		alonso = new F1Car("Ferrari","Fernando Alonso", 14);
		hamilton = new F1Car("Mercedes","Lewis Hamilton", 44);
		vettel = new F1Car("Red Bull","Sebastian Vettel", 1);
		
	}
	
	private static String getImageDimensions(String imageDetails) {
		int startChar = imageDetails.indexOf(" JPEG ");
		String startDimensions = imageDetails.substring(startChar+6);
		int endChar = startDimensions.indexOf(" ");
		String dimensions = startDimensions.substring(0, endChar);
		return dimensions;
	}
	
	private static int getImageWidth(String imageDetails) {
		String dimensions = getImageDimensions(imageDetails);
		return Integer.parseInt(dimensions.substring(0, dimensions.indexOf('x')));
	}
	
	private static int getImageHeight(String imageDetails) {
		String dimensions = getImageDimensions(imageDetails);
		return Integer.parseInt(dimensions.substring(1+dimensions.indexOf('x')));
	}
	
	public static void main(String[] args) {
		String image = "/var/www/wedding/Uploaded by Scott on Tuesday 22nd July 2014RESTRICTED/DSCN9052.jpg JPEG 3240x4320 3240x4320+0+0 8-bit DirectClass 4.26MB 0.010u 0:00.020";
		System.out.println("Got back:"+getImageHeight(image)+"::");
		System.out.println("Got back:"+getImageWidth(image)+"::");
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Got back:"+getImageWidth(image)+"::");
		
		setupGrid();
		
		
		String s = null;
		
		try {
			Process p = Runtime.getRuntime().exec("ls -l");
			
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
			
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
             
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("DRS Enabled: "+alonso.drsEnabled);
		System.out.println("Alonso's team name: "+alonso.getTeamName());

		System.out.println ("Watch for the lights!");
		System.out.println("GO GO GO!!!");
		
		System.out.println("Lap 1");
		System.out.println("Lap 2");
		System.out.println("Lap 3");
		F1Car.setDrsEnabled(true);
		System.out.println("Lap 4");
		System.out.println("Lap 5");
		System.out.println("DRS Enabled: "+alonso.drsEnabled);
		System.out.println("Lap 6");
		System.out.println("Lap 7");
		vettel.setPenaltyAtNextStop(10);
		System.out.println("Lap 8");
		System.out.println("Penalty for Alonso: "+alonso.getPenaltyAtNextStop());
		System.out.println("Penalty for Vettel: "+vettel.getPenaltyAtNextStop());
		System.out.println("Lap 9");
		System.out.println("Lap 10");

		
		
		
		
		
		
		
		
	}

}
