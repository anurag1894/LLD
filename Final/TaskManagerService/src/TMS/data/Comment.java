package TMS.data;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    String comment;
    String id;
    User author;
    LocalDateTime date;
    public Comment(String comment, User author) {
        this.comment = comment;
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.date = LocalDateTime.now();
    }
    public User getAuthor() {
        return author;
    }

}
