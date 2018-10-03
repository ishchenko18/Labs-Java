package second;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Model {
    private String text;

    public String readStringFromFile(String fileName) throws IOException {
        text = FileUtils.readFileToString(new File(String.format("src/main/resources/second/%s", fileName)));

        return text;
    }

    public String changeString() {
        System.out.println("\n-------Before-------");
        System.out.println(text);
        System.out.println("--------------------\n");

        text = text.replaceAll("[^A-Za-z\\s]", "");

        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
