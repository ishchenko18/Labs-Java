package first;

import java.util.Arrays;

import static java.lang.Math.random;

public class Model {
    private int[][] matrix;

    public void generateMatrix(int n) {
        matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (random() * 100) - 50;
            }
        }
    }

    public int findRowWithMaxElement() {
        int max = matrix[0][0];
        int line = 0;

        if (matrix.length > 1) {
            for (int i = 0; i < matrix.length; i++) {
                int localMax = Arrays.stream(matrix[i]).max().getAsInt();

                if (localMax > max) {
                    line = i;
                    max = localMax;
                }
            }
        }

        System.out.println();
        System.out.println(String.format("Max element %d ont the %d line", max, line + 1));
        System.out.println();

        return line;
    }

    public int[][] deleteRowWithMaxElement(int line) {
        System.arraycopy(matrix, line + 1, matrix, line, matrix.length - 1 - line);
        matrix[matrix.length - 1] = new int[matrix.length];

        return matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
