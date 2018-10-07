package second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller();
        View view = new View();
        view.printInfoAboutDeveloper();

        view.printString("\nPlease, choose method of initializing(file - f, console - c): ");
        String method = scanner.next();

        switch (method) {
            case "f":
                view.printString("Input fileName: ");
                String fileName = scanner.next();
                controller.readStringFromFile(fileName);
                view.printTextBeforeChanging(controller.getText());
                controller.changeString();
                view.printTextAfterChanging(controller.getText());
                break;
            case "c":
                view.printString("Input text(for finish reading enter 'end'): \n");
                controller.readStringFromConsole();
                view.printTextBeforeChanging(controller.getText());
                controller.changeString();
                view.printTextAfterChanging(controller.getText());
                break;
            default:
                view.printString("Such variant method of reading does not exist.");
                break;
        }

    }
}
