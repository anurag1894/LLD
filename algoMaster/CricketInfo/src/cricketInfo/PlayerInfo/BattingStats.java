package cricketInfo.PlayerInfo;

class BattingStats {
    private int runsScored;
    private int ballsFaced;

    public void update(int runs, int balls) {
        this.runsScored += runs;
        this.ballsFaced += balls;
    }

    public double getStrikeRate() {
        return ballsFaced > 0 ? (runsScored * 100.0 / ballsFaced) : 0.0;
    }

    public int getRunsScored() { return runsScored; }
    public int getBallsFaced() { return ballsFaced; }
}