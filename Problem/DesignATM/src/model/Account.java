package model;

public class Account {
    int accountNo;
    int cardNo;
    int balance;
    int pin;
    String name;

    public Account(int accountNo, int cardNo, int balance, int pin, String name) {
        this.accountNo = accountNo;
        this.cardNo = cardNo;
        this.balance = balance;
        this.pin = pin;
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
