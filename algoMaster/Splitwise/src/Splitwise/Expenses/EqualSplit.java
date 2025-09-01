package Splitwise.Expenses;

import Splitwise.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitStrategy{

    @Override
    public Map<User, Double> calculateSplit(double totalAmount, User paidBy, List<User> participants, List<Double> equalAmounts) {
        Map<User, Double> splitMap = new HashMap<>();
        double share = totalAmount / participants.size();
        for (User user : participants) {
            splitMap.put(user, share);
            paidBy.updateBalance(user,  share);
            user.updateBalance(paidBy, - share);
        }
        return splitMap;
    }
}
