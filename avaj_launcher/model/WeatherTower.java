package avaj_launcher.model;


public class WeatherTower extends Tower {
	public WeatherTower(){super();}

	public String getWeather(Coordinates p_coordinates){
		return WeatherProvider.getWeatherProviderInstance().getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
		conditionChanged();
	}
}
