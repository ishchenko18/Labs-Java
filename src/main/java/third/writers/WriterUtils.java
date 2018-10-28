package third.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import third.entities.Flower;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriterUtils {
    public static void simpleWriteFlowers(List<Flower> flowers, String fileName) throws IOException {
        FileUtils.writeLines(new File(buildFileName(fileName, "txt")), flowers);
    }

    public static void writeFlowersUsingSerialization(List<Flower> flowers, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(buildFileName(fileName, "txt")));
        objectOutputStream.writeObject(flowers);
    }

    public static void writeFlowersToJSON(List<Flower> flowers, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFlowers = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(flowers);
        FileUtils.write(new File(buildFileName(filename, "json")), jsonFlowers);
    }

    private static String buildFileName(String fileName, String extension) {
        return String.format("src/main/resources/third/%s.%s", fileName, extension);
    }
}
