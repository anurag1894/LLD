package PaymentFlow;

public abstract class PaymentFlow {

    public abstract void validateRequest();
    public abstract void calculateFeew();
    public abstract void debitAmount();
    public abstract void creditAmount();

    public final void sendMoney(){  // Note : The final word make it to not override by others.
        validateRequest(); // step 1
        calculateFeew(); // step 2
        debitAmount(); // step 3
        creditAmount(); // step 4
    }
}
