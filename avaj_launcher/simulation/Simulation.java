package avaj_launcher.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import avaj_launcher.aircraft.AircraftFactory;
import avaj_launcher.aircraft.Flyable;
import avaj_launcher.aircraft.Aircraft;
import avaj_launcher.util.BadInputFileException;

public class Simulation {
	private static int SIM_COUNT_STARTING_POINT = 1;
	private static int MIN_AIRCRAFT_QTY = 1;
	private static Simulation instance;
	private List<Flyable> aircrafts;
	private int sim_count;
	private File file;
	private Scanner sc;

	private Simulation(){
		sim_count = SIM_COUNT_STARTING_POINT;
	}

	public static Simulation getSimulation(){
		if (instance == null)
			instance = new Simulation();
		return instance;
	};

	public void runSimulation(){
		WeatherTower tower = new WeatherTower();
		for (Flyable aircraft: aircrafts){
			aircraft.registerTower(tower);
		}
		for (int i = 0; i < sim_count; i ++){
			tower.changeWeather();
		}
		sc.close();
	}

	public void loadFile(String file) {
		this.file = new File(file);
		try {
			sc = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			throw new BadInputFileException("File not found.");
		}
		if (!sc.hasNextInt()){
			throw new BadInputFileException("Number of simulations not provided.");
		}
		sim_count = sc.nextInt();
		if (sim_count < MIN_AIRCRAFT_QTY){
			throw new BadInputFileException("Number of simulation should be greater than 0.");
		}
		sc.nextLine();
		if (!sc.hasNextLine()){
			throw new BadInputFileException("Must provide at least one aircraft.");
		}
		loadAircrafts();
	}

	private void loadAircrafts() {
		AircraftFactory aircraftFactory = AircraftFactory.getAircraftFactoryInstance();

		aircrafts = new ArrayList<Flyable>();
		while (sc.hasNextLine()){
			String line = sc.nextLine();
			String[] arguments = line.split("\\s+");
	
			if (arguments.length != 5)
				throw new BadInputFileException("Aircraft format: TYPE NAME LONGITUDE LATITUDE HEIGHT.");
			String type = arguments[0];
			String name = arguments[1];
			Coordinates coordinates = new Coordinates(
				getCoordinate(arguments[2], Aircraft.MIN_LONGITUDE, Integer.MAX_VALUE, "Longitude"), 
				getCoordinate(arguments[3], Aircraft.MIN_LATITUDE, Integer.MAX_VALUE, "Latitude"), 
				getCoordinate(arguments[4], Aircraft.MIN_HEIGT, Aircraft.MAX_HEIGHT, "Height")
			);
			aircrafts.add(aircraftFactory.newAircraft(type, name, coordinates));
		}
	}

	private int getCoordinate(String str, int min, int max, String type) {
		int rta;

		try {
			rta = Integer.valueOf(str);
		} catch (NumberFormatException e){
			throw new BadInputFileException(str + " is not a valid number. (Out of bound values for Integer types are invalid)");
		}
		if (rta < min)
			throw new BadInputFileException(type + ": Must be greater than " + min +  ".");
		if (rta > max)
			throw new BadInputFileException(type + ": Must be less than " + max + ".");
		return rta;
	}
}
