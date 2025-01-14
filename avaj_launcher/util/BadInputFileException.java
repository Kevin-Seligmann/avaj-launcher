package avaj_launcher.util;

public class BadInputFileException extends RuntimeException {
	public BadInputFileException(String message){
		super("Input file format error: " + message);
	}
}
