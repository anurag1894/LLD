package TMS.data;

import TMS.observer.TaskObserver;

import java.util.UUID;

public class User {
    String name;
    String id;
    public User(String name, String id) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
