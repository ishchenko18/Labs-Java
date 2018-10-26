package third.exceptions;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("Some number has negative value.");
    }

    public NegativeValueException(String message) {
        super(message);
    }
}
