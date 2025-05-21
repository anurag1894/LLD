package PaymentFlow;

public class payToFriend extends PaymentFlow {

    @Override
    public void validateRequest() {
        System.out.println("payToFriend validateRequest");
    }

    @Override
    public void calculateFeew() {
        System.out.println("payToFriend calculateFeew");
    }

    @Override
    public void debitAmount() {
        System.out.println("payToFriend debitAmount");
    }

    @Override
    public void creditAmount() {
        System.out.println("payToFriend creditAmount");
    }
}
