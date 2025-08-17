package DW;

import DW.command.TransactionInvoker;
import DW.enums.TransactionStatus;
import DW.enums.TransactionType;
import DW.model.Account;
import DW.model.Transaction;
import DW.model.User;
import DW.model.Wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletManager {
    private List<User> users;
    private Map<Integer, User> userMap;
    TransactionInvoker transactionInvoker;

    private static WalletManager instance = new WalletManager();
    public static WalletManager getInstance() {
        return instance;
    }
    private WalletManager() {
        users = new ArrayList<>();
        userMap = new HashMap<>();
        transactionInvoker = new TransactionInvoker();

    }

    public void registerUser(int id,String Username) { // userId should ne unique generated
        User user = new User(id,Username);
        users.add(user);
        userMap.put(id, user);
    }

    public void createWallet(int userId, int walletId) { // walletId should be UUID generated
        User user = userMap.get(userId);
        Wallet wallet = new Wallet(walletId,user.getUsername() + "'s Wallet");
        user.setWallet(wallet);
    }

    public void linkAccount(int userId, Account account) {
        User user = userMap.get(userId);
        user.setAccount(account);
    }

    public void unlinkAccount(int userId) {
        User user = userMap.get(userId);
        user.setAccount(null);
    }

    public boolean deposit(int userId, int amount) {
        User user = userMap.get(userId);
        if (user == null) {
            System.out.println("User not found");
            return false;
        }
        if(user.getAccount() == null) {
            System.out.println("Account is not linked");
            return false;
        }

        if(user.getWallet() == null){
            System.out.println("Wallet is not created");
            return false;
        }
        if(user.getAccount().getBalance() < amount){
            System.out.println("Not enough balance in account");
            return false;
        }

        Transaction transaction = new Transaction(user, TransactionType.ADD_MONEY,amount, TransactionStatus.INPROGRESS);
        transactionInvoker.processTransactions(transaction,user.getWallet());
        user.addTransaction(transaction);
        user.getAccount().setBalance(user.getAccount().getBalance() - amount);
        return true;
    }

    public boolean withdraw(int userId, int amount) {
        User user = userMap.get(userId);
        if (user == null) {
            System.out.println("User not found");
            return false;
        }
        if(user.getAccount() == null) {
            System.out.println("Account is not linked");
            return false;
        }

        if(user.getWallet() == null){
            System.out.println("Wallet is not created");
            return false;
        }
        if(user.getWallet().getBalance() < amount){
            System.out.println("Not enough balance in wallet");
            return false;
        }

        Transaction transaction = new Transaction(user, TransactionType.WITHDRAW_MONEY,amount, TransactionStatus.INPROGRESS);
        transactionInvoker.processTransactions(transaction,user.getWallet());
        user.addTransaction(transaction);
        user.getAccount().setBalance(user.getAccount().getBalance() + amount);
        return true;
    }

    public boolean transfer(int fromId, int toId, int amount) {
        User sender = userMap.get(fromId);
        User receiver = userMap.get(toId);
        if(sender == null || receiver == null) {
            System.out.println("Sender or Receiver is not registered");
            return false;
        }
        if(sender.getWallet() == null || receiver.getWallet() == null) {
            System.out.println("Sender or Receiver wallet is not linked");
            return false;
        }
        if(sender.getWallet().getBalance() < amount){
            System.out.println("Not enough balance in account");
            return false;
        }
        Transaction transaction = new Transaction(sender, TransactionType.TRANSFER_MONEY, amount, TransactionStatus.INPROGRESS);
        transactionInvoker.processTransactions(transaction,sender.getWallet(),receiver.getWallet());
        sender.addTransaction(transaction);
        receiver.addTransaction(transaction);
        return true;
    }

    public void showTransactions(int userId) {
        userMap.get(userId).getTransactions().forEach(transaction -> {System.out.println(transaction.getTransactiontype() + " amount: " + transaction.getAmount());});
    }

    public void showWalletBalance(int userId) {
        User user = userMap.get(userId);
        System.out.println("Wallet Balance is " + user.getWallet().getBalance());
    }

    public void showAccountBalance(int userId) {
        User user = userMap.get(userId);
        System.out.println("Account Balance is " + user.getAccount().getBalance());
    }
}
