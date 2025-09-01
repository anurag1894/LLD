package cricketInfo.ScoreCard;

import cricketInfo.InningsInfo.Ball;
import cricketInfo.InningsInfo.BallObserver;
import cricketInfo.InningsInfo.Innings;

public class Scoreboard implements BallObserver {
    private int runs;
    private int wickets;
    private double overs;
    private Innings innings;

    public Scoreboard(Innings innings) {
        this.innings = innings;
        this.runs = 0;
        this.wickets = 0;
        this.overs = 0.0;
        // Register itself as observer
        this.innings.registerObserver(this);
    }

    @Override
    public void onBallDelivered(Ball ball) {

        // Update runs and wickets

        runs += ball.getRuns() + ball.getExtras();
        if (ball.getWicket() != null) {
            wickets++;
        }

        // Calculate overs safely using public getter

        int ballsBowled = innings.getTotalBallsBowled();
        int completedOvers = ballsBowled / 6;
        int ballsInCurrentOver = ballsBowled % 6;
        overs = completedOvers + ballsInCurrentOver * 0.1;

        displayLiveScore();
    }

    public void displayLiveScore() {
        System.out.println("Live Score: " + runs + "/" + wickets + " in " + overs + " overs.");
    }

    // Optional: get run rate
    public double getRunRate() {
        return overs > 0 ? runs / overs : 0.0;
    }

    // Getters
    public int getRuns() { return runs; }
    public int getWickets() { return wickets; }
    public double getOvers() { return overs; }
}

