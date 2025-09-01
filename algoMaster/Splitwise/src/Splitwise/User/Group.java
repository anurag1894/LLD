package Splitwise.User;

import Splitwise.Expenses.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private String id;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    // Add a member to the group
    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
            user.addGroup(this);
        }
    }

    // Remove a member from the group
    public void removeMember(User user) {
        if (members.contains(user)) {
            members.remove(user);
            user.removeGroup(this);
        }
    }

    // Add an expense to the group
    public void addExpense(Expense expense) {
        expenses.add(expense);
        // Update balances for each participant
        Map<User, Double> splitMap = expense.calculateSplits();
        for (Map.Entry<User, Double> entry : splitMap.entrySet()) {
            User u = entry.getKey();
            double amount = entry.getValue();
            u.updateBalance(expense.getPaidBy(), amount);
            expense.getPaidBy().updateBalance(u, -amount);
        }
    }

    // Get all expenses
    public List<Expense> getExpenses() {
        return expenses;
    }

    // Get balances of all members relative to each other
    public Map<User, Double> getBalances(User user) {
        return user.getBalances();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public List<User> getMembers() { return members; }
}
