package second;

public class View {
    public void printString(String text) {
        System.out.print(text);
    }

    public void printInfoAboutDeveloper() {
        System.out.println("Developer: Ishchenko Vladyslav");
    }

    public void printTextAfterChanging(String text) {
        System.out.println("\n-------After--------");
        printString(text);
        System.out.println("\n--------------------\n");
    }

    public void printTextBeforeChanging(String text) {
        System.out.println("\n-------Before-------");
        System.out.println(text);
        System.out.println("--------------------\n");
    }
}
