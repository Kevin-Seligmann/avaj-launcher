package avaj_launcher.model;

public class JetPlane extends Aircraft {
	private static int RAIN_LATITUDE_CHANGE = 5;
	private static int SUN_LATITUDE_CHANGE = 10;
	private static int SUN_HEIGHT_CHANGE = 2;
	private static int FOG_LATITUDE_CHANGE = 1;
	private static int SNOW_HEIGHT_CHANGE = -7;

	public JetPlane(long p_id, String p_name, Coordinates p_coordinates){super(p_id, p_name, p_coordinates);}

	public void updateConditions(){
		String weather = WeatherProvider.getWeatherProviderInstance().getCurrentWeather(coordinates);
		switch (weather) {
			case "RAIN": rainWeather(); break;
			case "FOG": fogWeather(); break;
			case "SUN": sunWeather(); break;
			case "SNOW": snowWeather(); break;
		}
	}

	private void rainWeather(){
		changeLatitude(RAIN_LATITUDE_CHANGE);
	}

	private void sunWeather(){
		changeLatitude(SUN_LATITUDE_CHANGE);
		changeHeight(SUN_HEIGHT_CHANGE);
	}

	private void fogWeather(){
		changeLatitude(FOG_LATITUDE_CHANGE);
	}

	private void snowWeather(){
		changeHeight(SNOW_HEIGHT_CHANGE);
	}


	public String toString(){
		return "JetPlane" + super.toString();
	}
}
