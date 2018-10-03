package second;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest {

    @Spy
    private Model model;

    private String string;

    @Before
    public void setUp() {
        string = "sf23 *2ds";
    }

    @Test
    public void changeStringShouldReturnStringWithReplacedCharactersTest() {
        model.setText(string);

        assertEquals("sf ds", model.changeString());
    }
}
