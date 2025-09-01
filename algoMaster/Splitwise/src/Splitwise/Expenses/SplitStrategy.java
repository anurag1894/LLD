package Splitwise.Expenses;

import Splitwise.User.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    Map<User, Double> calculateSplit(double totalAmount, User paidBy, List<User> participants, List<Double> exactAmounts);
}
