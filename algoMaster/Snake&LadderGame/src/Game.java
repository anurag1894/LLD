import java.lang.module.ModuleDescriptor;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    final Dice dice;

    public Game(Builder builder) {
        this.board = builder.board;
        this.players = new LinkedList<>(builder.players);
        this.dice = builder.dice;
    }

    public void play() throws InterruptedException {
        while(!isGameOver()){
            Thread.sleep(3000);
            Player currentPlayer = players.poll();
            int diceRoll = dice.rollDice();
            int newPosition = currentPlayer.getPosition() + diceRoll;

            if (newPosition <= board.getSize()) {
                currentPlayer.setPosition(board.nextMove(newPosition));
                System.out.println(currentPlayer.getName() + " rolled a " + diceRoll +
                        " and moved to position " + currentPlayer.getPosition());
            }

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            players.offer(currentPlayer);
        }
    }


    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getPosition() == board.getSize()) {
                return true;
            }
        }
        return false;
    }




    public static class Builder {
        Board board;
        Dice dice;
        Queue<Player> players;
        public Builder() {
            players = new LinkedList<>();
        }
        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<String> playerNames) {
            this.players = new LinkedList<>();
            for (String playerName : playerNames) {
                players.add(new Player(playerName));
            }
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build() {
            if (board == null || players == null || dice == null) {
                throw new IllegalStateException("Board, Players, and Dice must be set.");
            }
            return new Game(this);
        }
    }
}
