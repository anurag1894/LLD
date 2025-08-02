import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        List<Snake> snakes = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79)
        );

        List<Ladder> ladders = List.of(
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84)
        );

        Board board = new Board(100, ladders, snakes);

        List<String> players = Arrays.asList("Player 1", "Player 2", "Player 3");

        Game game = new Game.Builder()
                .setBoard(board)
                .setPlayers(players)
                .setDice(new Dice())
                .build();
        try {
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
