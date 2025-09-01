package cricketInfo.Commentary;

import cricketInfo.InningsInfo.Ball;
import cricketInfo.InningsInfo.BallObserver;
import cricketInfo.InningsInfo.Innings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commentary implements BallObserver {
    // Map ballId (or over.ball) to list of comments
    private Map<String, List<String>> commentaryMap;

    public Commentary(Innings innings) {
        this.commentaryMap = new HashMap<>();
        // Register as observer
        innings.registerObserver(this);
    }

    @Override
    public void onBallDelivered(Ball ball) {
        String ballKey = ball.getOverNumber() + "." + ball.getBallNumber();
        commentaryMap.putIfAbsent(ballKey, new ArrayList<>());
        commentaryMap.get(ballKey).add(ball.getCommentary());
        displayBallCommentary(ballKey);
    }

    // Display commentary for a specific ball
    private void displayBallCommentary(String ballKey) {
        List<String> comments = commentaryMap.get(ballKey);
        System.out.println("Ball " + ballKey + " Commentary:");
        for (String comment : comments) {
            System.out.println("- " + comment);
        }
    }

    // Get all commentary for a specific ball
    public List<String> getCommentary(String ballKey) {
        return commentaryMap.getOrDefault(ballKey, new ArrayList<>());
    }

    // Get all commentary for innings
    public Map<String, List<String>> getAllCommentary() {
        return commentaryMap;
    }
}

