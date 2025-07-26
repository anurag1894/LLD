package enums;

public enum Cash {
    TENS(10),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    Cash(int value) {
        this.amount = value;
    }
    public final  int amount;
}
