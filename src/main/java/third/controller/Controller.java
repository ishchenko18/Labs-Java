package third.controller;

import third.entities.Flower;
import third.model.Model;
import third.view.View;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private Model model;
    private Scanner scanner;

    public Controller() {
        model = new Model();
        scanner = new Scanner(System.in);
    }

    public void doTask() {
        View.printString("Developer: Vladyslav Ishchenko\n\n");

        View.printString("----------TASKS----------\n");
        View.printString("1 - Get Bloomed Flowers And Price\n2 - Get Flowers By Name And Count\n");

        View.printString("Please, enter number of task: ");
        Integer task = scanner.nextInt();

        switch (task) {
            case 1:
                getBloomedFLowersAndPrice("flowers.csv");
                break;
            case 2:
                View.printString("Enter name of flower: ");
                String flower = scanner.next();
                getFlowerByNameAndCount(flower, "flowers.csv");
                break;
            default:
                View.printString("Such task doesn't exist.");
        }
    }

    public void getBloomedFLowersAndPrice(String fileName) {
        parseFile(fileName);
        generalPrintingInformation("\n\n======Bloomed flowers=====\n",
                model.getBloomedFlowers(), String.format("\nPrice of bloomed flowers: %.2f", model.getPriceOfBloomedFlowers()));
    }

    public void getFlowerByNameAndCount(String name, String fileName) {
        parseFile(fileName);
        generalPrintingInformation(String.format("\n\n======Flowers '%s'======\n", name.toUpperCase()),
                model.getFlowersByName(name), String.format("\nCount of '%s': %d", name.toUpperCase(), model.getCountOfFlowersByName(name)));
    }

    private void generalPrintingInformation(String headline, List<Flower> flowers, String lastStr) {
        View.printString(headline);
        View.printList(flowers);

        View.printString(lastStr);
    }

    private void parseFile(String fileName) {
        model.parseFile(String.format("src/main/resources/third/%s", fileName));
    }
}
