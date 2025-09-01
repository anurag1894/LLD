package Splitwise.Expenses;

import Splitwise.Observer.Observer;
import Splitwise.User.User;

import java.util.List;
import java.util.Map;

public class Expense {
    private int id;
    private double amount;
    private User payer;
    private List<User> participants;
    private ExpensesStatus state;
    private SplitContext splitContext;

    public Expense(int id, double amount, User payer, List<User> participants, SplitContext splitContext) {
        this.id = id;
        this.amount = amount;
        this.payer = payer;
        this.participants = participants;
        this.splitContext = splitContext;
        this.state = ExpensesStatus.CREATED;
    }

    public Map<User, Double> calculateSplits() {
        this.state = ExpensesStatus.PENDING;
        return splitContext.calculateSplits(amount, payer, participants, null); // need to look exact amounts
    }

    // Add participant
    public void addParticipant(User user) {
        if (!participants.contains(user)) {
            participants.add(user);
        }
    }

    // Remove participant
    public void removeParticipant(User user) {
        participants.remove(user);
    }

    // Settle the expense
    public void settle() {
        state =  ExpensesStatus.SETTLE;
    }


    public int getId() {
        return id;
    }

    public User getPaidBy() {
        return payer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public double getAmount() {
        return amount;
    }


}
