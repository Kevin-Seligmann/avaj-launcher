package avaj_launcher.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
	private static Simulation instance;
	private File file;
	private Scanner sc;

	private Simulation(){}

	public static Simulation geSimulation(){
		if (instance == null)
			instance = new Simulation();
		return instance;
	};

	public void loadFromFile(String file) throws FileNotFoundException {
		this.file = new File(file);
		sc = new Scanner(this.file);
	}

	public void runSimulation(){

	}
}
