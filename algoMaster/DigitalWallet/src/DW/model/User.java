package DW.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private Wallet wallet;
    private Account account;
    List<Transaction> transactions;
    public User(int id, String username) {
        this.id = id;
        this.username = username;
        transactions = new ArrayList<Transaction>();

    }
    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }
    public Account getAccount() {
        return account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public String getUsername() {
        return username;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
