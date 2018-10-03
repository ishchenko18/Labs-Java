package first;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Spy
    @InjectMocks
    private Controller controller;

    @Mock
    private Model model;

    @Test
    public void createMatrixShouldCallGenerateMatrixMethodTest() {
        controller.createMatrix(2);

        verify(model, times(1)).generateMatrix(2);
    }

    @Test
    public void getMatrixShouldReturnMatrixTest() {
        int[][] expected = new int[][]{};

        when(model.getMatrix()).thenReturn(expected);

        int[][] matrix = controller.getMatrix();

        verify(model, times(1)).getMatrix();
        assertEquals(expected, matrix);
    }

    @Test
    public void doTaskShouldReturnChangedMatrix() {
        int[][] expected = new int[][]{};
        when(model.findRowWithMaxElement()).thenReturn(1);
        when(model.deleteRowWithMaxElement(anyInt())).thenReturn(expected);

        int[][] matrix = controller.doTask();

        verify(model, times(1)).findRowWithMaxElement();
        verify(model, times(1)).deleteRowWithMaxElement(1);

        assertEquals(expected, matrix);
    }
}
