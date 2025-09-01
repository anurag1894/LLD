package cricketInfo.Match;

import cricketInfo.TeamInfo.Team;

import java.util.List;
public class T20Match extends Match {
    private final int maxOvers = 20;

    public T20Match(int matchId, String venue, String startTime, List<Team> teams) {
        super(matchId, venue, startTime, teams);
    }

    @Override
    public void startMatch() {
        this.status = MatchStatus.LIVE;
        System.out.println("T20 Match Started!");
    }

    @Override
    public void endMatch() {
        this.status = MatchStatus.COMPLETED;
        System.out.println("T20 Match Ended!");
    }

    @Override
    public void validateRules() {
        System.out.println("Validating T20 rules: max overs = " + maxOvers);
    }
}