package enums;

public enum EventType {
    UPVOTE_QUESTION(2),
    UPVOTE_ANSWER(1),
    DOWNVOTE_QUESTION(-2),
    DOWNVOTE_ANSWER(-1),
    ACCEPT_ANSWER(5);

    int value;

    EventType(int i) {
        value = i;
    }
    public int getValue() {
        return value;
    }
}
