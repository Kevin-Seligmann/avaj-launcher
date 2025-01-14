package avaj_launcher.model;

import avaj_launcher.util.FileManager;

public class Baloon extends Aircraft {
	private static int RAIN_HEIGHT_CHANGE = -5;
	private static int SUN_LONGITUDE_CHANGE = 2;
	private static int SUN_HEIGHT_CHANGE = 4;
	private static int FOG_HEGIHT_CHANGE = -3;
	private static int SNOW_HEIGHT_CHANGE = -15;
	private String currentWeather;

	public Baloon(long p_id, String p_name, Coordinates p_coordinates){super(p_id, p_name, p_coordinates);}

	public void updateConditions(){
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

	private void rainWeather() {
		changeHeight(RAIN_HEIGHT_CHANGE);
	}

	private void sunWeather() {
		changeHeight(SUN_HEIGHT_CHANGE);
		changeLongitude(SUN_LONGITUDE_CHANGE);
	}

	private void fogWeather() {
		changeHeight(FOG_HEGIHT_CHANGE);
	}

	private void snowWeather() {
		changeHeight(SNOW_HEIGHT_CHANGE);
	}

	public String toString(){
		return "Baloon" + super.toString();
	}
}
