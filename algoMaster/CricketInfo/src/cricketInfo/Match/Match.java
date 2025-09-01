package cricketInfo.Match;

import cricketInfo.InningsInfo.Innings;
import cricketInfo.TeamInfo.Team;

import java.util.List;
public abstract class Match {
    protected int matchId;
    protected String venue;
    protected String startTime;
    protected MatchStatus status;
    protected List<Team> teams;
    protected List<Innings> inningsList;
    protected String result;

    public Match(int matchId, String venue, String startTime, List<Team> teams) {
        this.matchId = matchId;
        this.venue = venue;
        this.startTime = startTime;
        this.teams = teams;
        this.status = MatchStatus.UPCOMING;
    }

    // Abstract methods for format-specific behavior (Strategy Pattern)
    public abstract void startMatch();
    public abstract void endMatch();
    public abstract void validateRules();

    // Common method
    public String getMatchSummary() {
        return "Match at " + venue + " between " + teams.get(0).getName() + " and " + teams.get(1).getName() +
                " Status: " + status;
    }
}