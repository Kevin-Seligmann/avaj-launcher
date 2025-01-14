package avaj_launcher.util;

public class FileHandlingException extends RuntimeException {
	public FileHandlingException(String message){
		super("File handling error: " + message);
	}
}
