package DW;

import DW.model.Account;
import DW.model.Wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Digital Wallet");
        Account account = new Account(1,"AnuragJha",1000);
        Account account2 = new Account(2,"Monika",2000);
        Map<Integer,Account> accounts = new HashMap<Integer,Account>();
        accounts.put(1, account);
        accounts.put(2, account2);
        WalletManager walletManager = WalletManager.getInstance();
        while(true){
            System.out.println("Please enter your choice");
            System.out.println("1. Register as new  User");
            System.out.println("2. create Wallet (already registered)");
            System.out.println("3. link Bank account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("Enter your name");
                String name = scanner.next();
                System.out.println("Enter your Id");
                int id = scanner.nextInt();
                walletManager.registerUser(id, name);
            }
            else if(choice == 2){
                System.out.println("Enter your userId");
                int userId = scanner.nextInt();
                System.out.println("Enter your walletId");
                int walletId = scanner.nextInt();
                walletManager.createWallet(userId,walletId);
            }
            else if(choice == 3){
                System.out.println("Enter your userId");
                int userId = scanner.nextInt();
                System.out.println("Enter your accountId");
                int accountId = scanner.nextInt();
                walletManager.linkAccount(userId,accounts.get(accountId));
            } else if(choice == 4){
                System.out.println("Enter your userId");
                int userId = scanner.nextInt();
                System.out.println("Enter your amount");
                int amount = scanner.nextInt();
                boolean flag = walletManager.deposit(userId,amount);
                if(flag){
                    walletManager.showWalletBalance(userId);
                    walletManager.showAccountBalance(userId);
                    walletManager.showTransactions(userId);
                }

            } else if(choice == 5){
                System.out.println("Enter your userId");
                int userId = scanner.nextInt();
                System.out.println("Enter your amount");
                int amount = scanner.nextInt();
                boolean flag = walletManager.withdraw(userId,amount);
                if(flag){
                    walletManager.showWalletBalance(userId);
                    walletManager.showAccountBalance(userId);
                    walletManager.showTransactions(userId);
                }
            } else if(choice == 6){
                System.out.println("Enter your userId");
                int userId = scanner.nextInt();
                System.out.println("Enter your receiverUserId");
                int receiverUserId = scanner.nextInt();
                System.out.println("Enter your amount");
                int amount = scanner.nextInt();
                boolean flag = walletManager.transfer(userId,receiverUserId,amount);
                if(flag ){
                    walletManager.showWalletBalance(userId);
                    walletManager.showAccountBalance(userId);
                    walletManager.showTransactions(userId);
                    walletManager.showWalletBalance(receiverUserId);
                    walletManager.showAccountBalance(receiverUserId);
                    walletManager.showTransactions(receiverUserId);
                }

            } else if(choice == 7){
                break;
            }
        }
    }
}
