package Splitwise.Expenses;

import Splitwise.User.User;

import java.util.List;
import java.util.Map;

public class SplitContext {
    private SplitStrategy splitStrategy;

    // Constructor to set initial strategy
    public SplitContext(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    // Set or change the strategy at runtime
    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    // Calculate splits using the current strategy
    public Map<User, Double> calculateSplits(double totalAmount, User paidBy, List<User> participants, List<Double> exactAmounts) {
        if (splitStrategy == null) {
            throw new IllegalStateException("SplitStrategy not set");
        }
        return splitStrategy.calculateSplit(totalAmount, paidBy, participants, exactAmounts);
    }
}
