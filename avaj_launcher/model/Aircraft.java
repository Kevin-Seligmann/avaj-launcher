package avaj_launcher.model;

public class Aircraft extends Flyable {
	private static int MAX_HEIGHT = 100;
	private static int MIN_HEIGT = 0;

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
		if (height == MIN_HEIGT)
			weatherTower.unregister(this);
	}

	protected void changeLatitude(int n){
		coordinates.setLatitude(coordinates.getLatitude() + 2);
	}

	protected void changeLongitude(int n){
		coordinates.setLongitude(coordinates.getLongitude() + 2);
	}

	public void updateConditions(){};

	public String toString(){
		return "#" + name + "(" + id + ")";
	}
}
