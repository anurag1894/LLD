package Splitwise.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {

    private List<Observer> observers;

    public NotificationService() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void notifyObservers(List<Observer> specificObservers, String message) {
        for (Observer observer : specificObservers) {
            observer.update(message);
        }
    }
}
