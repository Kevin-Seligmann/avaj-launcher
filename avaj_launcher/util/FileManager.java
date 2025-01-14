package avaj_launcher.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import avaj_launcher.exception.FileHandlingException;

public class FileManager {
	private static final String OUTPUT_FILE_NAME = "simulation.txt";
	private static FileManager instance;
	private BufferedWriter  writer;
	
	private FileManager() {
		try {
			writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
		} catch (IOException e){
			throw new FileHandlingException("Opening output file.");
		}
	}
	
	public static FileManager getFileInstance(){
		if (instance == null)
			instance = new FileManager();
		return instance;
	};

	public void close(){
		try {
			if (writer != null) {
				writer.close();
				writer = null;
				instance = null;
			}
		} catch (IOException e){
			throw new FileHandlingException("Closing output file.");
		}
    }

	public void printToOutputFile(String str) {
		try {
			writer.write(str + "\n");
			writer.flush();
		} catch (IOException e){
			throw new FileHandlingException("Writing to output file.");
		}
	}
}
