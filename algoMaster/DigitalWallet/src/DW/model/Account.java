package DW.model;

public class Account {
    private int accountId;
    private String accountName;
    private int balance;
    public Account(int accountId, String accountName,int balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
