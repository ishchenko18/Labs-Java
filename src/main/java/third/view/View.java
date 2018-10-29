package third.view;

import third.entities.Flower;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void printListOfFlowers(List<Flower> flowers) {
        System.out.format("%s %10s %10s %15s %15s %30s %30s\n", "Id", "IsBloom", "Name", "Type", "Kind", "Subtype", "Price");
        System.out.println("----------------------------------------------------------------------------------------------" +
                "-------------------------");
        for (Flower flower : flowers) {
            System.out.format("%-5d %-13s %-15s %-15s %-27s %-32s %.2f\n", flower.getId(), flower.isBloom(), flower.getName(),
                    flower.getType(), flower.getKind(), flower.getSubtype(), flower.getPrice());
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
