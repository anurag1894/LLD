package entity;

abstract public class Content {
    String id;
    String body;
    User user;
    public Content(String id, String body, User user) {
        this.id = id;
        this.body = body;
        this.user = user;
    }
}
