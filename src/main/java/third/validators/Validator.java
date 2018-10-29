package third.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import third.exceptions.IncorrectBooleanValueException;
import third.exceptions.NegativeValueException;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    public static void validateIdOfFlower(int id, int i) throws NegativeValueException {
        if (id < 1) {
            LOGGER.error("Id of flower is negative.");
            throw new NegativeValueException("On line №" + i + " field 'id' is negative value.");
        }
    }

    public static void validateBloomFlagOfFlower(String bloom, int i) throws IncorrectBooleanValueException {
        if (!bloom.equalsIgnoreCase("true") && !bloom.equalsIgnoreCase("false")) {
            LOGGER.error("'Bloom' flag has invalid value.");
            throw new IncorrectBooleanValueException("On line №" + i + " field 'bloom' is incorrect.");
        }
    }

    public static void validatePriceOfFlower(double price, int i) throws NegativeValueException {
        if (price <= 0.0) {
            LOGGER.error("Price of flower is negative.");
            throw new NegativeValueException("On line №" + i + " field 'price' has negative value.");
        }
    }
}
