package cricketInfo.PlayerInfo;

class BowlingStats {
    private int oversBowled;
    private int runsConceded;
    private int wicketsTaken;

    public void update(int overs, int runs, int wickets) {
        this.oversBowled += overs;
        this.runsConceded += runs;
        this.wicketsTaken += wickets;
    }

    public double getEconomyRate() {
        return oversBowled > 0 ? (runsConceded * 1.0 / oversBowled) : 0.0;
    }

    public int getWicketsTaken() { return wicketsTaken; }
}