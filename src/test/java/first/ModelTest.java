package first;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest {

    @Spy
    @InjectMocks
    private Model model;

    private int[][] matrix;

    @Before
    public void setUp() {
        matrix = new int[][]{
                {1, 3},
                {4, -3}
        };
    }

    @Test
    public void getMatrixShouldReturnMatrixTest() {
        model.setMatrix(matrix);

        assertEquals(matrix, model.getMatrix());
    }

    @Test
    public void findRowWithMaxElementShouldReturnNumberOfRowWithMaxElementTest() {
        model.setMatrix(matrix);

        int line = model.findRowWithMaxElement();

        assertEquals(1, line);
    }

    @Test
    public void deleteRowWithMaxElementShouldReturnMatrixWithDeletedRowWhenWasMaxElement() {
        int[][] expected = new int[][] {
                {1, 3},
                {0, 0}
        };

        model.setMatrix(matrix);
        matrix = model.deleteRowWithMaxElement(1);

        assertEquals(expected, matrix);
    }
}
