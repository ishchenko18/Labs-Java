package third.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import third.entities.Flower;
import third.exceptions.WrongFileFormatException;
import third.validators.Validator;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private CSVParser csvParser;

    public List<Flower> parseCsvFile(String fileName) throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(fileName));
        List<Flower> flowers = new ArrayList<>();
        int i = 0;

        csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Id", "Bloom", "Name", "Type", "Kind", "Subtype", "Price")
                .withDelimiter(',')
                .withIgnoreHeaderCase()
                .withTrim());

        for (CSVRecord record : csvParser) {
            if (record.size() == 7) {
                ++i;

                Integer id = Integer.parseInt(record.get("Id"));
                String bloom = record.get("Bloom");
                String name = record.get("Name");
                String type = record.get("Type");
                String kind = record.get("Kind");
                String subtype = record.get("Subtype");
                Double price = Double.parseDouble(record.get("Price"));

                Validator.validateIdOfFlower(id, i);
                Validator.validateBloomFlagOfFlower(bloom, i);
                Validator.validatePriceOfFlower(price, i);

                Flower flower = new Flower(id, Boolean.parseBoolean(bloom), name, type, kind, subtype, price);

                flowers.add(flower);
            } else {
                throw new WrongFileFormatException("Line №" + ++i + " has wrong format. Please, check the file.");
            }
        }

        return flowers;
    }
}
