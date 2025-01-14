package avaj_launcher.model;

import java.util.Random;

public class WeatherProvider {
	private String weather[];
	private static WeatherProvider instance;

	private WeatherProvider(){
		weather = new String[4];
		weather[0] = "FOG";
		weather[1] = "SNOW";
		weather[2] = "RAIN";
		weather[3] = "SUN";
	}

	public static WeatherProvider getWeatherProviderInstance(){
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	};

	public String getCurrentWeather(Coordinates p_coordinates){
		int noise = getNoise(p_coordinates);
		return weather[noise % weather.length];
	}

    private int getNoise(Coordinates p_coordinates) {
        int sum = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
        Random random = new Random(sum);
        return random.nextInt(10000);
    }
}
