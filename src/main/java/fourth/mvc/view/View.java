package fourth.mvc.view;

import java.util.List;

public class View {
    public void printString(String string) {
        System.out.print(string);
    }

    public void printChooseList(List list) {

        int count = 0;

        for (Object ob : list) {
            System.out.println(++count + "-" + ob.toString());
        }
    }
}
