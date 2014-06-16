package formula1;

public class F1Car {

	public static final int numberOfWheels = 4;
	public static final int maxWeight = 2000;
	
	public static boolean drsEnabled = false;
	
	private String teamName;
	private String driver;
	private int carNumber;
	private int penaltyAtNextStop = 0;

	public F1Car (String nameOfTeam, String nameOfDriver, int number) {
		teamName = nameOfTeam;
		driver = nameOfDriver;
		carNumber = number;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public static boolean isDrsEnabled() {
		return drsEnabled;
	}

	public static void setDrsEnabled(boolean drsEnabled) {
		F1Car.drsEnabled = drsEnabled;
	}

	public int getPenaltyAtNextStop() {
		return penaltyAtNextStop;
	}

	public void setPenaltyAtNextStop(int penaltyAtNextStop) {
		this.penaltyAtNextStop = penaltyAtNextStop;
	}	
	
	
	
	
}
