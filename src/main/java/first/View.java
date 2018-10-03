package first;

import java.util.Arrays;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private Controller controller;

    public View() {
        scanner = new Scanner(System.in);
        controller = new Controller();
    }

    public void printMatrix() {
        String delimiter = "---------------------------------------------------------------";
        System.out.println("\n" + delimiter);

        for (int[] arr : controller.getMatrix()) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + "\t\t"));
            System.out.println();
        }

        System.out.println(delimiter + "\n");
    }

    public void printInfoAboutDeveloper() {
        System.out.println("Developer: Ishchenko Vladyslav");
    }

    public void createAndPrintMatrix() {
        System.out.print("\nPlease, enter positive size of matrix: ");

        int n = scanner.nextInt();

        if(n < 1) {
            throw new NegativeArraySizeException("Size of array should be positive value.");
        }

        controller.createMatrix(n);
        printMatrix();
    }

    public void doTask() {
        controller.doTask();
        printMatrix();
    }
}
