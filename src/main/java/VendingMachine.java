public class VendingMachine {
    private Display display;
    private int totalToShow;

    public VendingMachine(Display display) {
        this.display = display;
        display.hasNoCoins();
    }

    public void acceptCoin(Coins coin) {

         totalToShow += coin.getValue();

        display.showTotal(totalToShow + " cents");
    }


}
