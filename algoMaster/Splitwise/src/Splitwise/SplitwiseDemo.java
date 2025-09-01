package Splitwise;

import Splitwise.Expenses.*;
import Splitwise.Observer.NotificationService;
import Splitwise.User.User;

import java.util.*;

import java.util.*;

public class SplitwiseDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Notification service
        NotificationService notificationService = new NotificationService();

        // Users
        User alice = new User("1", "Alice", "abc");
        User bob = new User("2", "Bob", "def");
        User charlie = new User("3", "Charlie", "gehj");

        List<User> allUsers = Arrays.asList(alice, bob, charlie);

        // Subscribe users to notifications
        notificationService.subscribe(alice);
        notificationService.subscribe(bob);
        notificationService.subscribe(charlie);

        // Expenses service
        ExpensesService expensesService = new ExpensesService(notificationService);

        System.out.println("Welcome to Splitwise Demo!");

        while (true) {
            System.out.println("\n1. Add Expense\n2. Show Balances\n3. Settle Amount\n4. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 4) break;

            switch (option) {
                case 1 -> {
                    System.out.print("Enter expense description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    // Choose payer
                    System.out.print("Who paid? (Alice/Bob/Charlie): ");
                    String payerName = scanner.nextLine();
                    User payer = findUserByName(allUsers, payerName);

                    // Choose participants
                    System.out.print("Add participants (comma separated, e.g., Alice,Bob): ");
                    String[] participantNames = scanner.nextLine().split(",");
                    List<User> participants = new ArrayList<>();
                    for (String name : participantNames) {
                        User u = findUserByName(allUsers, name.trim());
                        if (u != null) participants.add(u);
                    }

                    // Choose split type
                    System.out.print("Split type? (equal/exact): ");
                    String splitType = scanner.nextLine().trim().toLowerCase();
                    SplitContext splitContext = splitType.equals("exact") ?
                            new SplitContext(new ExactSplit()) :
                            new SplitContext(new EqualSplit());

                    // Create expense
                    Expense expense = new Expense(1, amount, payer, participants, splitContext);
                    expensesService.addExpense(expense);
                }
                case 2 -> showBalances(allUsers);
                case 3 -> {
                    System.out.print("Who is paying? ");
                    User payer = findUserByName(allUsers, scanner.nextLine().trim());
                    System.out.print("Who to settle with? ");
                    User payee = findUserByName(allUsers, scanner.nextLine().trim());
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();

                    payee.settle(payer, amt);
                    System.out.println("Amount settled successfully!");
                }
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Exiting Splitwise Demo. Goodbye!");
        scanner.close();
    }

    private static User findUserByName(List<User> users, String name) {
        for (User u : users) if (u.getName().equalsIgnoreCase(name)) return u;
        return null;
    }

    private static void showBalances(List<User> users) {
        System.out.println("\nUser balances:");
        for (User u : users) {
            System.out.println(u.getName() + " balances: ");
            Map<User,Double> val = u.getBalances();
            for (Map.Entry<User,Double> e : val.entrySet()) {
                System.out.println("        " + e.getKey().getName() + " : " + e.getValue());
            }
        }
    }
}
