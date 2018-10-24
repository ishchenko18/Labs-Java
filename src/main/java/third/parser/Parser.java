package third.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import third.entities.Flower;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private CSVParser csvParser;

    public List<Flower> parseCsvFile(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(fileName));
        List<Flower> flowers = new ArrayList<>();

        csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Id", "Bloom", "Name", "Type", "Kind", "Subtype", "Price")
                .withDelimiter(',')
                .withIgnoreHeaderCase()
                .withTrim());

        for (CSVRecord record : csvParser) {
            Flower flower = new Flower(Integer.parseInt(record.get("Id")), Boolean.parseBoolean(record.get("Bloom")),
                    record.get("Name"), record.get("Type"), record.get("Kind"),
                    record.get("Subtype"), Double.parseDouble(record.get("Price")));

            flowers.add(flower);
        }

        return flowers;
    }
}
