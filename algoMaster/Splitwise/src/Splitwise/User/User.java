package Splitwise.User;

import Splitwise.Observer.Notification;
import Splitwise.Observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Observer {
    private String id;
    private String name;
    private String email;

    private List<Group> groupsJoined;
    private Map<User, Double> balances;
    private List<Notification> notifications;

    // Constructor
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.groupsJoined = new ArrayList<>();
        this.balances = new HashMap<>();
        this.notifications = new ArrayList<>();
    }

    // Observer method
    @Override
    public void update(String message) {
        Notification notification = new Notification(this, message);
        notifications.add(notification);
        System.out.println("Notification for " + name + ": " + message);
    }

    // Add user to a group
    public void addGroup(Group group) {
        if (!groupsJoined.contains(group)) {
            groupsJoined.add(group);
        }
    }

    // Remove user from a group
    public void removeGroup(Group group) {
        groupsJoined.remove(group);
    }

    // Update balance with another user
    public void updateBalance(User other, double amount) {
        balances.put(other, balances.getOrDefault(other, 0.0) + amount);
    }

    // Get balances with all users
    public Map<User, Double> getBalances() {
        return balances;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void settle(User user, double amount) {
        updateBalances(user, amount);
        user.updateBalances(this, -amount);
    }

    public void updateBalances(User user, double amount) {
        double current = balances.getOrDefault(user, 0.0);
        balances.put(user, current - amount);
    }
}
