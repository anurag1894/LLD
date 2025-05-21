package PaymentFlow;

public class PayToMerchant extends PaymentFlow {

    @Override
    public void validateRequest() {
        System.out.println("Pay to Merchant validate Request");
    }

    @Override
    public void calculateFeew() {
        System.out.println("Pay to Merchant calculateFeew");
    }

    @Override
    public void debitAmount() {
        System.out.println("Pay to Merchant debit amount");
    }

    @Override
    public void creditAmount() {
        System.out.println("Pay to Merchant credit amount");
    }
}
