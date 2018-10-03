package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {
    private Controller controller;
    private Scanner scanner;

    public View() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public void printString(String text) {
        System.out.println(text);
    }

    public void printInfoAboutDeveloper() {
        System.out.println("Developer: Ishchenko Vladyslav");
    }

    private void printTextWhichWasReadFromConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter text: ");
        String text = null;

        text = bufferedReader.readLine();

        text = controller.putStringAndChangeIt(text);

        System.out.println("\n-------After--------");
        printString(text);
        System.out.println("--------------------\n");
    }

    private void printTextWhichWasReadFromFile(String fileName) {
        String text = controller.readStringFromFileAndChangeIt(fileName);

        System.out.println("\n-------After--------");
        printString(text);
        System.out.println("--------------------\n");
    }

    public void printText() {
        System.out.print("\nPlease, choose method of initializing(file - f, console - c): ");
        String method = scanner.next();

        switch (method) {
            case "f":
                System.out.print("Input fileName: ");
                String fileName = scanner.next();
                printTextWhichWasReadFromFile(fileName);
                break;
            case "c":
                try {
                    printTextWhichWasReadFromConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                printString("Such variant method of reading does not exist.");
                break;
        }
    }
}
