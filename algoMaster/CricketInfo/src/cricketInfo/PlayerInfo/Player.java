package cricketInfo.PlayerInfo;

import cricketInfo.TeamInfo.PlayerRole;

public class Player {
    private int playerId;
    private String name;
    private PlayerRole role;

    private BattingStats battingStats;
    private BowlingStats bowlingStats;
    private FieldingStats fieldingStats;

    public Player(int playerId, String name, PlayerRole role) {
        this.playerId = playerId;
        this.name = name;
        this.role = role;
        this.battingStats = new BattingStats();
        this.bowlingStats = new BowlingStats();
        this.fieldingStats = new FieldingStats();
    }

    // Update methods
    public void updateBattingStats(int runs, int ballsFaced) {
        battingStats.update(runs, ballsFaced);
    }

    public void updateBowlingStats(int oversBowled, int runsConceded, int wicketsTaken) {
        bowlingStats.update(oversBowled, runsConceded, wicketsTaken);
    }

    public void updateFieldingStats(int catches, int stumpings, int runOuts) {
        fieldingStats.update(catches, stumpings, runOuts);
    }

    // Getters
    public int getPlayerId() { return playerId; }
    public String getName() { return name; }
    public PlayerRole getRole() { return role; }
    public BattingStats getBattingStats() { return battingStats; }
    public BowlingStats getBowlingStats() { return bowlingStats; }
    public FieldingStats getFieldingStats() { return fieldingStats; }
}
