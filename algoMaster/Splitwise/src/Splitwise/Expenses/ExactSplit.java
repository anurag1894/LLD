package Splitwise.Expenses;

import Splitwise.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactSplit implements SplitStrategy{

    @Override
    public Map<User, Double> calculateSplit(double totalAmount, User paidBy, List<User> participants, List<Double> exactAmounts) {
        Map<User, Double> splitMap = new HashMap<>();
        if (exactAmounts.size() != participants.size()) {
            throw new IllegalArgumentException("Exact amounts size must match participants size");
        }
        for (int i = 0; i < participants.size(); i++) {
            splitMap.put(participants.get(i), exactAmounts.get(i));
            paidBy.updateBalance(participants.get(i), exactAmounts.get(i));
            participants.get(i).updateBalance(paidBy, - exactAmounts.get(i));
        }
        return splitMap;
    }
}
