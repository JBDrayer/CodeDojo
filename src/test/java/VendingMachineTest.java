import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)

public class VendingMachineTest {

    @Mock
    private Display display;
    @Mock
    private Inventory inventory;

    private VendingMachine vendingMachine;

    @Before
    public void setup() {
        vendingMachine = new VendingMachine(display, inventory);
    }

    @Test
    public void vendingMachineDisplaysInsertCoinWhenItComesIntoBeing() throws Exception {
        verify(display).displayInsertCoin();
    }

    @Test
    public void vendingMachineDisplaysCoinValueWhenACoinIsInserted() throws Exception {
        vendingMachine.insertCoin(Coin.QUARTER);

        verify(display).displayValue(25);
    }

    @Test
    public void vendingMachineDisplaysTotalValueWhenMultipleCoinsAreInserted() throws Exception {
        vendingMachine.insertCoin(Coin.QUARTER);
        verify(display).displayValue(25);
        vendingMachine.insertCoin(Coin.QUARTER);
        verify(display).displayValue(50);
    }

    @Test
    public void vendsChipsWhenProperChangeIsInserted() throws Exception {
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.pushZeButton("chips");

        verify(inventory).vendItem(any(Chips.class));
    }

    @Test
    public void subtractsCostOfItemFromBalanceAfterVending() throws Exception {
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.pushZeButton("chips");

        InOrder inOrder = inOrder(display, inventory);
        inOrder.verify(display).displayInsertCoin();
        inOrder.verify(inventory).vendItem(any(Chips.class));
        inOrder.verify(display).displayInsertCoin();

    }
}