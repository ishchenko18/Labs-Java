package second;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {
    private String text;
    private BufferedReader reader;

    public Model() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readStringFromFile(String fileName) throws IOException {
        text = FileUtils.readFileToString(new File(String.format("src/main/resources/second/%s", fileName)));
    }

    public void readStringFromConsole() throws IOException {
        StringBuilder builder = new StringBuilder();
        String string;

        while (!(string = reader.readLine()).equalsIgnoreCase("end")) {
            builder.append(string).append("\n");
        }

        this.text = builder.toString();
    }

    public void changeString() {
        text = text.replaceAll("[^A-Za-z\\s]", "");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
