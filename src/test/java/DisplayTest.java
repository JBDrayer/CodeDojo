import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayTest {

    @Mock
    private PrintStream stream;

    @Test
    public void shouldDisplayInsertCoinsWhenNoCoins() throws Exception {
        Display display = new Display(stream);

        display.hasNoCoins();

        verify(stream).println("insert coin");
    }
}