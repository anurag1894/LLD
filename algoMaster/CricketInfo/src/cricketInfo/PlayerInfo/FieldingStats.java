package cricketInfo.PlayerInfo;


class FieldingStats {
    private int catches;
    private int stumpings;
    private int runOuts;

    public void update(int catches, int stumpings, int runOuts) {
        this.catches += catches;
        this.stumpings += stumpings;
        this.runOuts += runOuts;
    }
}
