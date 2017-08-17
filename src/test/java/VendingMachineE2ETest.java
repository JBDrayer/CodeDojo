import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineE2ETest {

    @Mock
    private Display display;

    private VendingMachine vendingMachine;

    @Before
    public void configureVendingMachine(){
        vendingMachine = new VendingMachine(display);
    }

    @Test
    public void acceptsValidCoins() throws Exception {
        verify(display).hasNoCoins();
        vendingMachine.acceptCoin(Coins.NICKEL);
        verify(display).showTotal("5 cents");
        vendingMachine.acceptCoin(Coins.DIME);
        verify(display).showTotal("15 cents");
        vendingMachine.acceptCoin(Coins.QUARTER);
        verify(display).showTotal("40 cents");
    }

    @Test
    public void rejectsInvalidCoins() throws Exception {
        vendingMachine.acceptCoin(Coins.PENNY);

        verify(display,times(2)).hasNoCoins();
    }
}

