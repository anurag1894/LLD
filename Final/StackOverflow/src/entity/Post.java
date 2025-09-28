package entity;

import enums.EventType;
import enums.VoteType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

abstract public class Post  extends Content{
    private Map<String, VoteType> votes; // User id to vote
    private AtomicInteger voteCount;
    List<Comment> comments;

    public Post(String body, User user) {
        super(UUID.randomUUID().toString(), body, user);
        this.votes = new HashMap<>();
        this.voteCount = new AtomicInteger(0);
        this.comments = new ArrayList<>();
    }

    public synchronized void vote(User user, VoteType voteType) {
        if(votes.containsKey(user.getName())) {
            return ;
        }
        votes.put(user.getName(), voteType);
        voteCount.incrementAndGet();
        User currUser = this.user;
        EventType eventType;
        if(this instanceof Answer){
             eventType = voteType.equals(VoteType.UPVOTE) ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        } else {
            eventType = voteType.equals(VoteType.UPVOTE) ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }
        currUser.updateReput(eventType.getValue());

    }

}
