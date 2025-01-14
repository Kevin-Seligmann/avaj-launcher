package avaj_launcher.main;

import java.io.FileNotFoundException;

import avaj_launcher.exception.BadInputFileException;
import avaj_launcher.exception.FileHandlingException;
import avaj_launcher.simulation.Simulation;

class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            usage();
            return ;
        }

        if (args[0].equals("--help")){
            help();
            return ;
        }
    
        Simulation simulation = Simulation.getSimulation();
        try {
            simulation.loadFile(args[0]);
            simulation.runSimulation();
        } catch (FileHandlingException e){
            e.printStackTrace();
        } catch (BadInputFileException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            advise();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error desconocido");
        }
    }

    private static void help(){
        System.out.println(
            "java avaj_launcher.main.Main [FILE]\n" +
            "java avaj_launcher.main.Main --help\n\n" +
            "This program runs a simulation of aircrafts, weather, and towers.\n" +
            "Aircrafts have a type (Baloon, JetPlane, Helicopter), name and coordinates (Longitude, Latitude, Height).\n" +
            "Each iteration, aircrafts move based on the weather. Weather is coordinate based. The weather is SUN, FOG, RAIN or SNOW.\n" +
            "Aircrafts log a message based on the weather after each interation.\n" +
            "Aircrafts that reach height 0 are considered as grounded, they don't update anymore.\n" +
            "\nInput format.\n" +
            "The input is a single text file.\n" +
            "The first line of the text file must be a number representing how many iterations the program will simulate.\n" +
            "Each following line represents an aircraft, and must be formatted this way: TYPE NAME LONGITUDE LATITUDE HEIGHT."
        );
    }

    private static void usage(){
        System.out.println("usage: 'java avaj_launcher.main.Main [FILE]'.");
        advise();

    }

    private static void advise(){
        System.out.println("Try avaj_launcher.main.Main --help for detailed information.");
    }
}
