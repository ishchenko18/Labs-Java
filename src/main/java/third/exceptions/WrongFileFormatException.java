package third.exceptions;

public class WrongFileFormatException extends Exception {
    public WrongFileFormatException() {
        super("Some line has wrong format.");
    }

    public WrongFileFormatException(String message) {
        super(message);
    }
}
