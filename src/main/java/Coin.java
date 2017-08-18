public enum Coin {
    DIME(10), QUARTER(25), NICKEL(5);
    private int value;

    Coin(int value){

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
