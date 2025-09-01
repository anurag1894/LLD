package cricketInfo.InningsInfo;

import cricketInfo.TeamInfo.Team;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private int inningsId;
    private Team battingTeam;
    private Team bowlingTeam;
    private int overs;
    private int runs;
    private int wickets;
    private List<Ball> ballList;

    // Observers
    private List<BallObserver> observers;

    public Innings(int inningsId, Team battingTeam, Team bowlingTeam, int overs) {
        this.inningsId = inningsId;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.overs = overs;
        this.runs = 0;
        this.wickets = 0;
        this.ballList = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Observer registration
    public void registerObserver(BallObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BallObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Ball ball) {
        for (BallObserver observer : observers) {
            observer.onBallDelivered(ball);
        }
    }

    // Add ball to innings
    public void addBall(Ball ball) {
        ballList.add(ball);
        runs += ball.getRuns() + ball.getExtras();
        if (ball.getWicket() != null) {
            wickets++;
        }
        // Notify all observers
        notifyObservers(ball);
    }

    // Getters
    public int getRuns() { return runs; }
    public int getWickets() { return wickets; }
    public int getOvers() { return overs; }
    public Team getBattingTeam() { return battingTeam; }
    public Team getBowlingTeam() { return bowlingTeam; }

    public List<Ball> getBallList() {
        return new ArrayList<>(ballList); // return a copy for safety
    }

    // Optional: get total balls bowled
    public int getTotalBallsBowled() {
        return ballList.size();
    }
}
