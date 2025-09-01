package cricketInfo.Resources;

import cricketInfo.Commentary.Commentary;
import cricketInfo.Match.Match;
import cricketInfo.ScoreCard.Scoreboard;

import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<String> preferences; // e.g., favorite teams, formats
    private Match selectedMatch;

    public User(int userId, String name, List<String> preferences) {
        this.userId = userId;
        this.name = name;
        this.preferences = preferences;
    }

    // Pick a match to view
    public void pickMatch(Match match) {
        this.selectedMatch = match;
        System.out.println(name + " is now viewing match: " + match.getMatchSummary());
    }

    // View live scoreboard
    public void viewScoreboard(Scoreboard scoreboard) {
        System.out.println("Scoreboard for " + selectedMatch.getMatchSummary() + ":");
        scoreboard.displayLiveScore();
    }

    // View commentary
    public void viewCommentary(Commentary commentary, String ballKey) {
        System.out.println("Commentary for Ball " + ballKey + ":");
        List<String> comments = commentary.getCommentary(ballKey);
        for (String comment : comments) {
            System.out.println("- " + comment);
        }
    }

    // Getters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public Match getSelectedMatch() { return selectedMatch; }
}

