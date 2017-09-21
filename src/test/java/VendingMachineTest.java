import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnit44Runner;
import static org.mockito.Mockito.verify;
import org.mockito.Mock;
@RunWith(MockitoJUnit44Runner.class)
public class VendingMachineTest {

    @Mock
    private Display display;

    @Mock
    private CoinReturn coinReturn;

    private VendingMachine vendingMachine;

    @Before
    public void configureVendingMachine() {
        vendingMachine = new VendingMachine(display, coinReturn);
    }

    @Test
    public void vendingMachineUpdatesDisplayWhenGivenValidCoins() throws Exception {
        vendingMachine.insertCoin(Coin.NICKEL);

        verify(display).displayTotal(5);
    }

    @Test
    public void vendingMachineDisplaysTotalOfValidInsertedCoins() throws Exception {
        vendingMachine.insertCoin(Coin.NICKEL);
        verify(display).displayTotal(5);

        vendingMachine.insertCoin(Coin.DIME);
        verify(display).displayTotal(15);
    }

    @Test
    public void rejectsPennies() throws Exception {
        vendingMachine.insertCoin(Coin.PENNY);

        verify(coinReturn).addRejectedCoin(Coin.PENNY);
    }

    @Test
    public void doesNotUpdateDisplayWhenPennyInserted() throws Exception {
        vendingMachine.insertCoin(Coin.PENNY);

    }
}