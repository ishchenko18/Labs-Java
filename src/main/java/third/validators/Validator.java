package third.validators;

import third.exceptions.IncorrectBooleanValueException;
import third.exceptions.NegativeValueException;

public class Validator {
    public static void validateIdOfFlower(int id, int i) throws NegativeValueException {
        if (id < 1) {
            throw new NegativeValueException("On line №" + i + " field 'id' is negative value.");
        }
    }

    public static void validateBloomFlagOfFlower(String bloom, int i) throws IncorrectBooleanValueException {
        if (!bloom.equalsIgnoreCase("true") && !bloom.equalsIgnoreCase("false")) {
            throw new IncorrectBooleanValueException("On line №" + i + " field 'bloom' is incorrect.");
        }
    }

    public static void validatePriceOfFlower(double price, int i) throws NegativeValueException {
        if (price <= 0.0) {
            throw new NegativeValueException("On line №" + i + " field 'price' has negative value.");
        }
    }
}
