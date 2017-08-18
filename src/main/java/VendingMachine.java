public class VendingMachine {
    private Display display;
    private int total;

    public VendingMachine(Display display) {

        this.display = display;
        display.hasNoCoins();
    }

    public void acceptCoin(Coin coin) {
        total += coin.getValue();
        display.sendTotal(total);
    }
}
