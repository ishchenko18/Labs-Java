package third.view;

import third.entities.Flower;

import java.util.List;

public class View {
    public static void printList(List<Flower> flowers) {
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }

    public static void printString(String string) {
        System.out.print(string);
    }
}
