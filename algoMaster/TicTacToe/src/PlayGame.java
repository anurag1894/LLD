import Controller.Game;
import Controller.Player;
import constants.Sign;
import constants.Status;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Player p1 = new Player("P1",Sign.XSIGN);
        Player p2 = new Player("P2", Sign.OSIGN);
        Game game = new Game(3, new Player[]{p1, p2});
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        while(true){
            try {
                System.out.println("Enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                game.playMove(row, col, turn);
                turn = (turn + 1) % 2;
                if (game.getStatus().equals(Status.DRAW) || game.getStatus().equals(Status.WIN)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
