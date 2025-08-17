package DW.model;

public class Wallet {
    private int walletId;
    private String walletName;
    private int balance;

    public Wallet(int walletId, String walletName) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.balance = 0;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int amount){
        this.balance += amount;
    }
    public void subBalance(int amount){
        this.balance -= amount;
    }
}
