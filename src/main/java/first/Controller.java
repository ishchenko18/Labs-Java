package first;

public class Controller {
    private Model model;

    public Controller() {
        model = new Model();
    }

    public int[][] doTask() {
        int row = model.findRowWithMaxElement();

        return model.deleteRowWithMaxElement(row);
    }

    public void createMatrix(int n) {
        model.generateMatrix(n);
    }

    public int[][] getMatrix() {
        return model.getMatrix();
    }
}
