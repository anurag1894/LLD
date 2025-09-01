package Splitwise.Observer;

import java.util.List;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String message);
    void notifyObservers(List<Observer> observers, String message);
}
