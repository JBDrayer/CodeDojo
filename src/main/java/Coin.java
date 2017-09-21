public enum Coin {
    QUARTER(25);

    private int value;

    Coin(int value){
        this.value = value;
    }

    public int value() {
        return value;
    }
}
