public class VendingMachine {
    private Display display;
    private Inventory inventory;
    private int total;

    public VendingMachine(Display display, Inventory inventory) {
        this.display = display;
        this.inventory = inventory;
        this.display.displayInsertCoin();
    }

    public void insertCoin(Coin coin) {
        total += coin.value();
        display.displayValue(total);
    }

    public Item pushZeButton(String item) {
        inventory.vendItem(new Chips());
        return null;
    }
}
