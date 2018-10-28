package third.controller;

import third.entities.Flower;
import third.model.Model;
import third.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void doTask() {
        int task;

        view.printString("Developer: Vladyslav Ishchenko\n");

        parseFile("flowers.csv");

        do {
            view.printString("\n\n----------TASKS----------\n");
            view.printString("1 - Get Room Bloomed Flowers And Price\n2 - Get Flowers By Name And Count\n3 - Output all data\n4 - Exit\n");

            view.printString("Please, enter number of task: ");
            task = view.inputNumber();

            switch (task) {
                case 1:
                    getRoomBloomedFLowersAndPrice("flowers.csv");
                    break;
                case 2:
                    view.printString("Enter name of flower: ");
                    String flower = view.inputString();
                    getFlowerByNameAndCount(flower, "flowers.csv");
                    break;
                case 3:
                    view.printString("--------------------All flowers--------------------\n");
                    view.printListOfFlowers(Arrays.stream(model.getFlowers()).collect(Collectors.toList()));
                    break;
                case 4:
                    break;
                default:
                    view.printString("Such task doesn't exist.");
            }
        } while (task != 4);
    }

    public void getRoomBloomedFLowersAndPrice(String fileName) {
        generalPrintingInformation("\n\n========================Bloomed flowers=======================\n",
                model.getRoomBloomedFlowers(), String.format("\nPrice of bloomed flowers: %.2f", model.getPriceOfRoomBloomedFlowers()));
    }

    public void getFlowerByNameAndCount(String name, String fileName) {
        generalPrintingInformation(String.format("\n\n========================Flowers '%s'========================\n", name.toUpperCase()),
                model.getFlowersByName(name), String.format("\nCount of '%s': %d", name.toUpperCase(), model.getCountOfFlowersByName(name)));
    }

    private void generalPrintingInformation(String headline, List<Flower> flowers, String lastStr) {
        view.printString(headline);
        view.printListOfFlowers(flowers);

        view.printString(lastStr);
    }

    private void parseFile(String fileName) {
        model.parseFile(String.format("src/main/resources/third/%s", fileName));
    }
}
