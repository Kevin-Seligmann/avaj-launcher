package avaj_launcher.aircraft;

import avaj_launcher.simulation.Coordinates;
import avaj_launcher.util.FileManager;

public class Helicopter extends Aircraft {
	private static int RAIN_LONGITUDE_CHANGE = 5;
	private static int SUN_LONGITUDE_CHANGE = 10;
	private static int SUN_HEIGHT_CHANGE = 2;
	private static int FOG_LONGITUDE_CHANGE = 1;
	private static int SNOW_HEIGHT_CHANGE = -12;
	private String currentWeather;

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates){super(p_id, p_name, p_coordinates);}

	public void updateConditions() {
		if (currentWeather != null){
			FileManager.getFileInstance().printToOutputFile(this + " " + currentWeather + ".");
			switch (currentWeather) {
				case "RAIN": rainWeather(); break;
				case "FOG": fogWeather(); break;
				case "SUN": sunWeather(); break;
				case "SNOW": snowWeather(); break;
			}
		}

		currentWeather = weatherTower.getWeather(coordinates);
	}

	private void rainWeather(){
		changeLongitude(RAIN_LONGITUDE_CHANGE);
	}

	private void sunWeather() {
		changeHeight(SUN_HEIGHT_CHANGE);
		changeLongitude(SUN_LONGITUDE_CHANGE);
	}

	private void fogWeather(){
		changeLongitude(FOG_LONGITUDE_CHANGE);
	}

	private void snowWeather() {
		changeHeight(SNOW_HEIGHT_CHANGE);
	}


	public String toString(){
		return "Helicopter" + super.toString();
	}
}
