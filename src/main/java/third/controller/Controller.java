package third.controller;

import third.entities.Flower;
import third.model.Model;
import third.view.View;
import third.writers.WriterUtils;

import java.io.IOException;
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
                    getRoomBloomedFlowersAndPrice();
                    writeFlowers(model.getRoomBloomedFlowers(), "roomBloomedFlowers");
                    break;
                case 2:
                    view.printString("Enter name of flower: ");
                    String flower = view.inputString();
                    getFlowerByNameAndCount(flower);
                    writeFlowers(model.getFlowersByName(flower), "roomBloomedFlowers");
                    break;
                case 3:
                    view.printString("-----All flowers-----\n");
                    view.printList(Arrays.stream(model.getFlowers()).collect(Collectors.toList()));
                    break;
                case 4:
                    break;
                default:
                    view.printString("Such task doesn't exist.");
            }
        } while (task != 4);
    }

    public void getRoomBloomedFlowersAndPrice() {
        generalPrintingInformation("\n\n======Bloomed flowers=====\n",
                model.getRoomBloomedFlowers(), String.format("\nPrice of bloomed flowers: %.2f", model.getPriceOfRoomBloomedFlowers()));
    }

    public void getFlowerByNameAndCount(String name) {
        generalPrintingInformation(String.format("\n\n======Flowers '%s'======\n", name.toUpperCase()),
                model.getFlowersByName(name), String.format("\nCount of '%s': %d", name.toUpperCase(), model.getCountOfFlowersByName(name)));
    }

    private void writeFlowers(List<Flower> flowers, String fileName) {
        view.printString("\n----------Type Of Writing----------\n");
        view.printString("1 - Write data to *.txt file\n");
        view.printString("2 - Write data to *.txt file(serialization)\n");
        view.printString("3 - Write data to *.json file\n");
        view.printString("4 - Exit\n");
        view.printString("Choose type of writing: ");
        int choose = view.inputNumber();

        try {
            switch (choose) {
                case 1:
                    WriterUtils.simpleWriteFlowers(flowers, fileName);
                    break;
                case 2:
                    WriterUtils.writeFlowersUsingSerialization(flowers, fileName);
                    break;
                case 3:
                    WriterUtils.writeFlowersToJSON(flowers, fileName);
                    break;
                case 4:
                    break;
                default:
                    view.printString("Such type of writing doesn't exist.");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void generalPrintingInformation(String headline, List<Flower> flowers, String lastStr) {
        view.printString(headline);
        view.printList(flowers);

        view.printString(lastStr);
    }

    private void parseFile(String fileName) {
        try {
            model.parseFile(String.format("src/main/resources/third/%s", fileName));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
