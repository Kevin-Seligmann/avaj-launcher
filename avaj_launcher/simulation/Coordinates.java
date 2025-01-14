package avaj_launcher.simulation;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	protected Coordinates(int p_longitude, int p_latitude, int p_height){
		this.latitude = p_latitude;
		this.longitude = p_longitude;
		this.height = p_height;
	}

	public int getLongitude(){return longitude;}
	public int getLatitude(){return latitude;}
	public int getHeight(){return height;}

	public void setLongitude(int longitude){this.longitude = longitude;}
	public void setHeight(int height){this.height = height;}
	public void setLatitude(int latitude){this.latitude = latitude;}

	public String toString(){
		return "LONG: " + longitude + ", LAT: " + latitude + ", HGT: " + height;
	}
}
