package cricketInfo.Match;

import cricketInfo.TeamInfo.Team;

import java.util.List;
public class TestMatch extends Match {
    private final int inningsPerTeam = 2;

    public TestMatch(int matchId, String venue, String startTime, List<Team> teams) {
        super(matchId, venue, startTime, teams);
    }

    @Override
    public void startMatch() {
        this.status = MatchStatus.LIVE;
        System.out.println("Test Match Started!");
    }

    @Override
    public void endMatch() {
        this.status = MatchStatus.COMPLETED;
        System.out.println("Test Match Ended!");
    }

    @Override
    public void validateRules() {
        System.out.println("Validating Test match rules: innings per team = " + inningsPerTeam);
    }
}
