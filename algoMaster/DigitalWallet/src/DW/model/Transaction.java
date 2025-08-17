package DW.model;


import DW.enums.TransactionStatus;
import DW.enums.TransactionType;


public class Transaction {
    User user;
    TransactionType transactiontype;
    int amount;
    TransactionStatus transactionStatus;
    public Transaction(User user, TransactionType transactionType, int amount, TransactionStatus transactionStatus) {
        this.user = user;
        this.transactiontype = transactionType;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
    }

    public TransactionType getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(TransactionType transactiontype) {
        this.transactiontype = transactiontype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }


}
