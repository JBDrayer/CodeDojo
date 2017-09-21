import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineE2ETest {

    @Mock
    private Display display;

    @Mock
    private CoinReturn coinReturn;

    @Test
    public void vendingMachineAcceptsCoins() throws Exception {
        VendingMachine vendingMachine = new VendingMachine(display, coinReturn);

        vendingMachine.insertCoin(Coin.NICKEL);
        verify(display).displayTotal(5);

        vendingMachine.insertCoin(Coin.DIME);
        verify(display).displayTotal(15);

        vendingMachine.insertCoin(Coin.QUARTER);
        verify(display).displayTotal(40);
    }

    @Test
    public void vendingMachineRejectsPennies() {
        VendingMachine vendingMachine = new VendingMachine(display, coinReturn);

        vendingMachine.insertCoin(Coin.PENNY);

        verifyZeroInteractions(display);
        verify(coinReturn).addRejectedCoin(Coin.PENNY);
    }
}
