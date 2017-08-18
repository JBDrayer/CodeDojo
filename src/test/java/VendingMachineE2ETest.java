import org.junit.Test;

import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.OutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineE2ETest {

    @Mock
    private PrintStream stream;

    @Test
    public void acceptsValidCoins() throws Exception {
        Display display = new Display(stream);
        VendingMachine vendingMachine = new VendingMachine(display);
        verify(stream).println("insert coin");
        vendingMachine.acceptCoin(Coin.NICKEL);
        verify(display).sendTotal(5);
        vendingMachine.acceptCoin(Coin.DIME);
        verify(display).sendTotal(15);
        vendingMachine.acceptCoin(Coin.QUARTER);
        verify(display).sendTotal(40);
    }




}