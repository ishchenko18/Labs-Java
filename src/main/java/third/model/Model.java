package third.model;

import third.entities.Flower;
import third.parser.Parser;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private Flower[] flowers;
    private Parser parser;

    public Model() {
        parser = new Parser();
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public List<Flower> getBloomedFlowers() {
        if (flowers == null) {
            return Collections.emptyList();
        } else {
            return Arrays.stream(flowers).filter(Flower::isBloom).collect(Collectors.toList());
        }
    }

    public Double getPriceOfBloomedFlowers() {
        if (getBloomedFlowers() == null) {
            return 0d;
        } else {
            return getBloomedFlowers().stream().mapToDouble(Flower::getPrice).sum();
        }
    }

    public List<Flower> getFlowersByName(String name) {
        if (name == null || flowers == null) {
            return Collections.emptyList();
        } else {
            return Arrays.stream(flowers).filter(f -> f.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
    }

    public Integer getCountOfFlowersByName(String name) {
        if (getFlowersByName(name) == null) {
            return 0;
        } else {
            return getFlowersByName(name).size();
        }
    }

    public String parseFile(String fileName) {
        try {
            List<Flower> fls = parser.parseCsvFile(fileName);
            flowers = new Flower[fls.size()];
            flowers = fls.toArray(flowers);
        } catch (IOException e) {
            return e.getMessage();
        }

        return String.format("File %s was successfully parsed.", fileName);
    }
}
