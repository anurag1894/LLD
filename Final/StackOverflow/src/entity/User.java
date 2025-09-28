package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private String name;
    private String id;
    private AtomicInteger reput
            = new AtomicInteger(0);
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void updateReput(int value) {
        this.reput.getAndAdd(value);
    }
    public int getReput() {
        return this.reput.get();
    }
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
}
