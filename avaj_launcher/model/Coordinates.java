package avaj_launcher.model;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	private Coordinates(long p_id, String p_name, Coordinates p_coordinates){}
	
	public int getLongitude(){return longitude;}
	public int getLatitude(){return latitude;}
	public int getHeight(){return height;}
}
