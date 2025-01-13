package avaj_launcher.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	File file;

	public void openFile(String filename){
		file = new File(filename);
	}

	// just testing
	public void printFile(){
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
