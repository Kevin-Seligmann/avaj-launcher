package avaj_launcher.aircraft;

import avaj_launcher.simulation.Coordinates;
import avaj_launcher.util.BadInputFileException;

public class AircraftFactory {
	private static AircraftFactory instance;
	private int id;

	private AircraftFactory(){
		id = 1;
	}

	public static AircraftFactory getAircraftFactoryInstance(){
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	};

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		Aircraft aircraft;
		
		if ("baloon".equalsIgnoreCase(p_type))
			aircraft = new Baloon(id, p_name, p_coordinates);
		else if ("helicopter".equalsIgnoreCase(p_type))
			aircraft = new Helicopter(id, p_name, p_coordinates);
		else if ("jetplane".equalsIgnoreCase(p_type))
			aircraft = new JetPlane(id, p_name, p_coordinates);
		else
			throw new BadInputFileException("Unknown Aircraft Type");
		id ++;
		return aircraft;
	}
}
