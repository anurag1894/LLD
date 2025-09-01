package cricketInfo;

import cricketInfo.Commentary.Commentary;
import cricketInfo.InningsInfo.Ball;
import cricketInfo.InningsInfo.Innings;
import cricketInfo.Match.Match;
import cricketInfo.Match.MatchFactory;
import cricketInfo.PlayerInfo.Player;
import cricketInfo.ScoreCard.Scoreboard;
import cricketInfo.TeamInfo.PlayerRole;
import cricketInfo.TeamInfo.Team;
import cricketInfo.Resources.User;

import java.util.Arrays;

public class CricketDemo {
    public static void main(String[] args) {
        // Create Players
        Player batsman1 = new Player(1, "Virat Kohli", PlayerRole.BATSMAN);
        Player batsman2 = new Player(2, "Rohit Sharma", PlayerRole.BATSMAN);
        Player bowler = new Player(3, "Jasprit Bumrah", PlayerRole.BOWLER);

        // Create Teams
        Team teamA = new Team(1, "India");
        teamA.addPlayer(batsman1);
        teamA.addPlayer(batsman2);

        Team teamB = new Team(2, "Australia");
        teamB.addPlayer(bowler);

        // Create a T20 Match using Factory
        Match match = MatchFactory.createMatch("T20", 101, "Wankhede Stadium", "12:00 PM", Arrays.asList(teamA, teamB));
        match.startMatch();

        // Create Innings
        Innings innings1 = new Innings(1, teamA, teamB, 20);

        // Create Scoreboard and Commentary observers
        Scoreboard scoreboard = new Scoreboard(innings1);
        Commentary commentary = new Commentary(innings1);

        // Create User
        User user = new User(1, "Monika", Arrays.asList("India"));
        user.pickMatch(match);

        // Simulate Ball deliveries
        Ball ball1 = new Ball(1, 1, batsman1, bowler, 4, 0, null, "Kohli hits a beautiful cover drive for 4!");
        innings1.addBall(ball1);

        Ball ball2 = new Ball(1, 2, batsman1, bowler, 0, 0, null, "Dot ball. Good line and length by Bumrah.");
        innings1.addBall(ball2);

        Ball ball3 = new Ball(1, 3, batsman1, bowler, 6, 0, null, "Six! Pulled over mid-wicket!");
        innings1.addBall(ball3);

        // User views scoreboard and commentary
        user.viewScoreboard(scoreboard);
        user.viewCommentary(commentary, "1.1");
        user.viewCommentary(commentary, "1.3");

        match.endMatch();
    }
}
