package PaymentFlow;

public class Main {
    public static void main(String[] args) {

        PaymentFlow obj = new payToFriend();
        obj.sendMoney();

        System.out.println("\n");

        PaymentFlow merchantPay = new PayToMerchant();
        merchantPay.sendMoney();
    }
}
