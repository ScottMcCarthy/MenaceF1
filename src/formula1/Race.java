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
	
	public static void main(String[] args) {
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
