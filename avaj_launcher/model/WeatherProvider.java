package avaj_launcher.model;

public class WeatherProvider {
	private String weather;
	private static WeatherProvider instance;

	private WeatherProvider(){}

	public static WeatherProvider getWeatherProviderInstance(){
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	};

	public String getCurrentWeather(Coordinates p_coordinates){return weather;}
}
