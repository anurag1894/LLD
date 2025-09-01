package cricketInfo.TeamInfo;

class TeamStats {
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;

    public void update(MatchResult result) {
        matchesPlayed++;
        if (result == MatchResult.WIN) matchesWon++;
        else if (result == MatchResult.LOSS) matchesLost++;
    }

    // Getters
    public int getMatchesPlayed() { return matchesPlayed; }
    public int getMatchesWon() { return matchesWon; }
    public int getMatchesLost() { return matchesLost; }
}
