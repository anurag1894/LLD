package vm.model;

public enum Coin {
    TWO(2),
    FIVE(5),
    TEN(10);

    int value;
    Coin(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static Coin getCoinType(int value) {
        for (Coin coin : Coin.values()) {
            if (coin.getValue() == value) {
                return coin;
            }
        }
        return null;
    }
}
