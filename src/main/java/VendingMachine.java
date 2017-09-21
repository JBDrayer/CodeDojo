public class VendingMachine {
    private Display display;
    private CoinReturn coinReturn;
    private int total;

    public VendingMachine(Display display, CoinReturn coinReturn) {
        this.display = display;
        this.coinReturn = coinReturn;
        this.total = 0;
    }

    public void insertCoin(Coin coin) {
        if (coin == Coin.PENNY) {
            coinReturn.addRejectedCoin(Coin.PENNY);
        }
        total += coin.getValue();
        display.displayTotal(total);
    }

}
