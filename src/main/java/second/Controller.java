package second;

import java.io.IOException;

public class Controller {
    private Model model;

    public Controller() {
        model = new Model();
    }

    public void readStringFromFile(String fileName) {
        try {
            model.readStringFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStringFromConsole() {
        try {
            model.readStringFromConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String changeString() {
        model.changeString();

        return getText();
    }

    public String getText() {
        return model.getText();
    }
}
