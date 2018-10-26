package third.view;

import third.entities.Flower;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void printList(List<Flower> flowers) {
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }

    public void printString(String string) {
        System.out.print(string);
    }

    public int inputNumber() {
        return scanner.nextInt();
    }

    public String inputString() {
        return scanner.next();
    }
}
