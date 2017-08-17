import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineTest {

    @Mock
    private Display display;

    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine(display);
    }

    @Test
    public void tellsDisplayThereAreZeroCoinsAtStart() throws Exception {
        verify(display).hasNoCoins();
    }

    @Test
    public void updatesDisplayWhenNickelIsInserted() throws Exception {
        machine.acceptCoin(Coins.NICKEL);

        verify(display).showTotal("5 cents");
    }

    @Test
    public void updatesDisplayWhenNickelAndDimeIsInserted() throws Exception {
        machine.acceptCoin(Coins.NICKEL);
        machine.acceptCoin(Coins.DIME);

        verify(display).showTotal("15 cents");
    }
}