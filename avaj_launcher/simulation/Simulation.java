package avaj_launcher.simulation;

import java.io.File;
import java.util.Scanner;
import avaj_launcher.model.*;

public class Simulation {
	private static int COUNT_STARTING_POINT = 1;
	private static int MIN_AIRCRAFT_QTY = 1;
	private static Simulation instance;
	private WeatherTower tower;
	private int sim_count;
	private File file;
	private Scanner sc;

	private Simulation(){
		sim_count = COUNT_STARTING_POINT;
	}

	public static Simulation geSimulation(){
		if (instance == null)
			instance = new Simulation();
		return instance;
	};

	public void loadFile(String file) throws Exception {
		this.file = new File(file);
		sc = new Scanner(this.file);

		if (!sc.hasNextInt()){
			throw new Exception("The file's format is incorrect. First argument must be a number representing how many times the weather will change (Length of simulation)");
		}
		sim_count = sc.nextInt();
		if (sim_count <= MIN_AIRCRAFT_QTY){
			throw new Exception("Must provide a greater than 0 simulation length");
		}
		sc.nextLine();
		if (!sc.hasNextLine()){
			throw new Exception("The file must provide at least one aircraft");
		}
	}

	public void runSimulation() throws Exception{
		tower = new WeatherTower();
		registerAircrafts();
	}

	private void registerAircrafts() throws Exception{
		Flyable aircraft;
		AircraftFactory aircraftFactory = AircraftFactory.getAircraftFactoryInstance();

		while (sc.hasNextLine()){
			String line = sc.nextLine();
			String[] arguments = line.split("\\s+");
	
			if (arguments.length != 5)
				throw new Exception("Invalid input: TYPE NAME C1 C2 C3");
			String type = arguments[0];
			String name = arguments[1];
			Coordinates coordinates = new Coordinates(Integer.valueOf(arguments[2]), Integer.valueOf(arguments[3]), Integer.valueOf(arguments[4]));
			aircraft = aircraftFactory.newAircraft(type, name, coordinates);
			aircraft.registerTower(tower);
		}
	}
}
