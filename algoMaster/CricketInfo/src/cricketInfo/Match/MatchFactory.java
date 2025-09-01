package cricketInfo.Match;

import cricketInfo.Match.Match;
import cricketInfo.Match.ODIMatch;
import cricketInfo.Match.T20Match;
import cricketInfo.Match.TestMatch;
import cricketInfo.TeamInfo.Team;

import java.util.List;

public class MatchFactory {
    public static Match createMatch(String format, int matchId, String venue, String startTime, List<Team> teams) {
        switch (format.toUpperCase()) {
            case "ODI":
                return new ODIMatch(matchId, venue, startTime, teams);
            case "T20":
                return new T20Match(matchId, venue, startTime, teams);
            case "TEST":
                return new TestMatch(matchId, venue, startTime, teams);
            default:
                throw new IllegalArgumentException("Invalid match format: " + format);
        }
    }
}
