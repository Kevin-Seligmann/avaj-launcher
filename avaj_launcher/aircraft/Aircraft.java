package avaj_launcher.aircraft;

import avaj_launcher.util.FileManager;
import avaj_launcher.simulation.Coordinates;

public class Aircraft extends Flyable {
	public static final int MAX_HEIGHT = 100;
	public static final int MIN_HEIGT = 0;
	public static final int MIN_LATITUDE = 0;
	public static final int MIN_LONGITUDE = 0;
	public static final int MAX_LONGITUDE = Integer.MAX_VALUE;
	public static final int MAX_LATITUDE = Integer.MAX_VALUE;

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	protected void changeHeight(int n){
		int height = coordinates.getHeight();

		if (height + n > MAX_HEIGHT)
			height = MAX_HEIGHT;
		else if (height + n < MIN_HEIGT)
			height = MIN_HEIGT;
		else
			height = height + n;
		coordinates.setHeight(height);
		if (height == MIN_HEIGT){
			FileManager.getFileInstance().printToOutputFile(this + " landing.");
			weatherTower.unregister(this);
		}
	}

	protected void changeLatitude(int n){
		int latitude = coordinates.getLatitude();

		if (MAX_LONGITUDE - latitude < n){
			limit_warning();
			latitude = MAX_LATITUDE;
		}
		else
			latitude += n;
		coordinates.setLatitude(latitude);
	}

	protected void changeLongitude(int n){
		int longitude = coordinates.getLongitude();

		if (MAX_LONGITUDE - longitude < n){
			limit_warning();
			longitude = MAX_LONGITUDE;
		}
		else
			longitude += n;
		coordinates.setLongitude(longitude);
	}

	public void updateConditions(){};

	private void limit_warning(){
		System.out.println("Warning: Aircraft " + name + " has reached unrealistic coordinates: (" + coordinates + ").");
		System.out.println("Try running a more realistic simulation.");
	}

	public String toString(){
		return "#" + name + "(" + id + ")";
	}
}
