public enum Coins {
    DIME(10), QUARTER(25), NICKEL(5), PENNY(0);

    private int coin;

    Coins(int coin) {

        this.coin = coin;
    }

    public int getValue() {
        return coin;
    }
}