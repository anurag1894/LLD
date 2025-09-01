package cricketInfo.Match;

import cricketInfo.TeamInfo.Team;

import java.util.List;

public class ODIMatch extends Match {
    private final int maxOvers = 50;

    public ODIMatch(int matchId, String venue, String startTime, List<Team> teams) {
        super(matchId, venue, startTime, teams);
    }

    @Override
    public void startMatch() {
        this.status = MatchStatus.LIVE;
        System.out.println("ODI Match Started!");
    }

    @Override
    public void endMatch() {
        this.status = MatchStatus.COMPLETED;
        System.out.println("ODI Match Ended!");
    }

    @Override
    public void validateRules() {
        System.out.println("Validating ODI rules: max overs = " + maxOvers);
    }
}
