package second;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller() {
        model = new Model();
        view = new View();
        scanner = new Scanner(System.in);
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

    public void doTask() {
        view.printInfoAboutDeveloper();

        view.printString("\nPlease, choose method of initializing(file - f, console - c): ");
        String method = scanner.next();

        switch (method) {
            case "f":
                view.printString("Input fileName: ");
                String fileName = scanner.next();
                readStringFromFile(fileName);
                view.printTextBeforeChanging(getText());
                changeString();
                view.printTextAfterChanging(getText());
                break;
            case "c":
                view.printString("Input text(for finish reading enter 'end'): \n");
                readStringFromConsole();
                view.printTextBeforeChanging(getText());
                changeString();
                view.printTextAfterChanging(getText());
                break;
            default:
                view.printString("Such variant method of reading does not exist.");
                break;
        }

    }

    public String getText() {
        return model.getText();
    }
}
