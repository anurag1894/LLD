package cricketInfo.TeamInfo;

import cricketInfo.PlayerInfo.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamId;
    private String name;
    private List<Player> players;
    private Player captain;
    private Player wicketKeeper;

    // Team-level stats (aggregated from players)
    private TeamStats stats;

    public Team(int teamId, String name) {
        this.teamId = teamId;
        this.name = name;
        this.players = new ArrayList<>();
        this.stats = new TeamStats();
    }

    // Add player to team
    public void addPlayer(Player player) {
        players.add(player);
        if (player.getRole() == PlayerRole.CAPTAIN) {
            this.captain = player;
        }
        if (player.getRole() == PlayerRole.WICKET_KEEPER) {
            this.wicketKeeper = player;
        }
    }

    // Remove player from team
    public void removePlayer(Player player) {
        players.remove(player);
        if (captain == player) captain = null;
        if (wicketKeeper == player) wicketKeeper = null;
    }

    // Get Playing XI (first 11 players for simplicity)
    public List<Player> getPlayingXI() {
        return players.subList(0, Math.min(11, players.size()));
    }

    // Update team stats after match
    public void updateStats(MatchResult result) {
        stats.update(result);
    }

    // Getters
    public String getName() { return name; }
    public int getTeamId() { return teamId; }
    public TeamStats getStats() { return stats; }
    public List<Player> getPlayers() { return players; }
}
