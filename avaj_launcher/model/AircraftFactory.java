package avaj_launcher.model;

public class AircraftFactory {
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){return new Aircraft(1, p_name, p_coordinates) {};}
}
