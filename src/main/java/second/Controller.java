package second;

import java.io.IOException;

public class Controller {
    private Model model;

    public Controller() {
        model = new Model();
    }

    public String putStringAndChangeIt(String text) {
        model.setText(text);
        return model.changeString();
    }

    public String readStringFromFileAndChangeIt(String fileName) {
        try {
            model.readStringFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return model.changeString();
    }
}
