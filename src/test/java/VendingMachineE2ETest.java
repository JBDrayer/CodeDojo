import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineE2ETest {

    @Mock
    private Display display;
    private Inventory inventory = new Inventory();

    @Test
    public void vendsItemWhenExactChangeIsInsertedIntoMachine() throws Exception {
        VendingMachine vendingMachine = new VendingMachine(display, inventory);
        verify(display).displayInsertCoin();

        vendingMachine.insertCoin(Coin.QUARTER);
        verify(display).displayValue(25);

        vendingMachine.insertCoin(Coin.QUARTER);
        verify(display).displayValue(50);

        Item results = vendingMachine.pushZeButton("chips");
        verify(display).displayThankYou();
        assertThat(results).isInstanceOf(Chips.class);

        verify(display).displayInsertCoin();
    }
}
