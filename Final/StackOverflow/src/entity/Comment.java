package entity;

import java.util.UUID;

public class Comment extends Content{
    public Comment(String body, User user) {
        super(UUID.randomUUID().toString(), body, user);
    }
}
