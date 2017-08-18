import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineTest {

    @Mock
    private Display display;
    private VendingMachine machine;

    @Before
    public void configureMachine() {
        machine = new VendingMachine(display);
    }

    @Test
    public void vendingMachineSends5ToDisplayWhenNickelIsInserted() throws Exception {
        machine.acceptCoin(Coin.NICKEL);

        verify(display).sendTotal(5);
    }

    @Test
    public void sendsUpdatedTotalToDisplayWhenMultipleCoinsInserted() throws Exception {
        machine.acceptCoin(Coin.NICKEL);
        machine.acceptCoin(Coin.DIME);

        verify(display).sendTotal(5);
        verify(display).sendTotal(15);
    }

}