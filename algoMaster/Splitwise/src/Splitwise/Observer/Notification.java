package Splitwise.Observer;

import Splitwise.User.User;

import java.util.Date;

public class Notification {
    private String id;
    private User user;
    private String message;
    private boolean isRead;
    private Date timestamp;

    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
        this.isRead = false;
        this.timestamp = new Date();
        this.id = "N" + timestamp.getTime(); // simple unique id
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public boolean isRead() {
        return isRead;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }
}
