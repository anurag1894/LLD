package Youtube;

public class EmailSubscriber implements Subscriber {
    String email;
    String name;
    EmailSubscriber(String email, String name) {
        this.email = email;
        this.name = name;
    }
    @Override
    public void update(String video) {
        System.out.println(name + " has been watching the "+video+" has email " + email);
    }
}
