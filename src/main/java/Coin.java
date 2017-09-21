public enum Coin {
    DIME(10), QUARTER(25), NICKEL(5), PENNY(1);
    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
