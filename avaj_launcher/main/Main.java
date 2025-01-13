package avaj_launcher.main;

import java.io.FileNotFoundException;

import avaj_launcher.simulation.Simulation;

class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("usage: 'sh run.sh file'");
            return ;
        }

        Simulation simulation = Simulation.geSimulation();
        try {
            simulation.loadFromFile(args[0]);
            simulation.runSimulation();
        } catch (FileNotFoundException e){
            System.out.println("File '" + args[0] + "' not found");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
