package cricketInfo.InningsInfo;

import cricketInfo.PlayerInfo.Player;

public class Ball {
    private int overNumber;
    private int ballNumber;
    private Player batsman;
    private Player bowler;
    private int runs;
    private int extras;
    private String wicket; // null if no wicket
    private String commentary;

    public Ball(int overNumber, int ballNumber, Player batsman, Player bowler, int runs, int extras, String wicket, String commentary) {
        this.overNumber = overNumber;
        this.ballNumber = ballNumber;
        this.batsman = batsman;
        this.bowler = bowler;
        this.runs = runs;
        this.extras = extras;
        this.wicket = wicket;
        this.commentary = commentary;
    }

    // Getters
    public int getOverNumber() {
        return overNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public Player getBatsman() {
        return batsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public int getRuns() {
        return runs;
    }
    public int getExtras() { return extras; }
    public String getWicket() { return wicket; }
    public String getCommentary() { return commentary; }
}
