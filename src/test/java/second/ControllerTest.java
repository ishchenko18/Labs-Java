package second;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Spy
    @InjectMocks
    private Controller controller;

    @Mock
    private Model model;

    @Test
    public void putStringAndChangeItTest() {
        String string = "abc f";
        when(model.changeString()).thenReturn(string);

        assertEquals(string, controller.putStringAndChangeIt(anyString()));

        verify(model, times(1)).setText(anyString());
        verify(model, times(1)).changeString();
    }

    @Test
    public void readStringFromFileAndChangeItTest() throws IOException {
        String fileName = "fileName";
        String string = "abc df";

        when(model.readStringFromFile(fileName)).thenReturn(string);
        when(model.changeString()).thenReturn(string);

        controller.readStringFromFileAndChangeIt(fileName);

        verify(model, times(1)).readStringFromFile(fileName);
        verify(model, times(1)).changeString();
    }
}
