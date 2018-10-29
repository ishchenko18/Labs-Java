package third.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import third.entities.Flower;
import third.parser.Parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final Logger LOGGER = LogManager.getLogger(Model.class);
    private Flower[] flowers;
    private Parser parser;

    public Model() {
        parser = new Parser();
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public List<Flower> getRoomBloomedFlowers() {
        if (flowers == null) {
            return Collections.emptyList();
        } else {
            return Arrays.stream(flowers).filter(Flower::isBloom)
                    .filter(flower -> flower.getType().equalsIgnoreCase("room"))
                    .collect(Collectors.toList());
        }
    }

    public Double getPriceOfRoomBloomedFlowers() {
        return getRoomBloomedFlowers().stream().mapToDouble(Flower::getPrice).sum();
    }

    public List<Flower> getFlowersByName(String name) {
        if (StringUtils.isBlank(name) || flowers == null) {
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

    public void parseFile(String fileName) throws Exception {
        List<Flower> fls = parser.parseCsvFile(fileName);
        flowers = new Flower[fls.size()];
        flowers = fls.toArray(flowers);

        LOGGER.info("File {} was successfully parsed.", fileName);
    }
}
