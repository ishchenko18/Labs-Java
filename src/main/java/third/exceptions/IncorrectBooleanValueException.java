package third.exceptions;

public class IncorrectBooleanValueException extends Exception {
    public IncorrectBooleanValueException() {
        super("Boolean value is incorrect.");
    }

    public IncorrectBooleanValueException(String message) {
        super(message);
    }
}
