package Splitwise.Expenses;

import Splitwise.Observer.NotificationService;
import Splitwise.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ExpensesService {

    private NotificationService notificationService;
    private List<Expense> expenses;

    public ExpensesService(NotificationService notificationService) {
        this.notificationService = notificationService;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);

        // Calculate splits
        expense.calculateSplits();

        // Notify participants
        notificationService.notifyObservers(new ArrayList<Observer>(expense.getParticipants()),
                "New expense added: " + expense.getPaidBy().getName() +
                        " Amount: " + expense.getAmount());
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}