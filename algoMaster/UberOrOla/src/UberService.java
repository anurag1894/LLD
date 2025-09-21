import java.util.*;

// ---- Enum for Ride Status ----
enum RideStatus {
    REQUESTED,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}

// ---- Forward Declaration ----


// ---- Observer Interface ----
interface Observer {
    void update(Ride ride);
}

// ---- Observable Interface ----
interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ---- Ride (Observable) ----
class Ride implements Observable {
    private int rideId;
    private RideStatus status;
    private List<Observer> observers;

    public Ride(int rideId) {
        this.rideId = rideId;
        this.status = RideStatus.REQUESTED;
        this.observers = new ArrayList<>();
    }

    public int getRideId() {
        return rideId;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }
}

// ---- User (Observer) ----
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Ride ride) {
        System.out.println("User " + name + " notified: Ride "
                + ride.getRideId() + " is now " + ride.getStatus());
    }
}

// ---- Driver (Observer) ----
class Driver implements Observer {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public void update(Ride ride) {
        System.out.println("Driver " + name + " notified: Ride "
                + ride.getRideId() + " is now " + ride.getStatus());
    }
}

// ---- Notification Service (Observer) ----
class NotificationService implements Observer {
    @Override
    public void update(Ride ride) {
        System.out.println("[NotificationService] Push sent: Ride "
                + ride.getRideId() + " is now " + ride.getStatus());
    }
}

// ---- Demo ----
public class UberService {
    public static void main(String[] args) {
        Ride ride1 = new Ride(101);

        User user1 = new User("Alice");
        Driver driver1 = new Driver("Bob");
        NotificationService notif = new NotificationService();

        // Register observers
        ride1.addObserver(user1);
        ride1.addObserver(driver1);
        ride1.addObserver(notif);

        // Simulate status updates
        ride1.setStatus(RideStatus.ACCEPTED);
        ride1.setStatus(RideStatus.IN_PROGRESS);
        ride1.setStatus(RideStatus.COMPLETED);
    }
}
