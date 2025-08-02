package Controller;

import constants.Status;
import strategy.ColumnWinningStrategy;
import strategy.DiagonalWinningStrategy;
import strategy.RowWinningStrategy;
import strategy.winningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    Player[] players;
    int turn;
    Status status;
    public Game(int size, Player[] players) {
            this.players = players;
            this.turn = 0;
            List<winningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
            winningStrategies.add(new RowWinningStrategy());
            this.board = new Board(size,winningStrategies);
            status = Status.IN_PROGRESS;
    }

    public boolean playMove(int row, int col,int turn) {
        if(!status.equals(Status.IN_PROGRESS)) {
            throw new IllegalArgumentException("Invalid move.");
        }
        if(!board.isValidInput(row, col)) {
            throw new IllegalArgumentException("Invalid move.");
        }
        board.playMove(row,col,players[turn].getSign());
        if(board.isWin(players[turn].getSign())) {
            status = Status.WIN;
            System.out.println("player " + players[turn].getSign() + " won!");
        }
        if(board.isDraw()){
            status = Status.DRAW;
            System.out.println("player " + players[turn].getSign() + " draw!");
        }
        board.printBoard();
        return true;
    }

    public synchronized void reset() {
        board.reset();
        turn = 0;
        status = Status.IN_PROGRESS;
    }

    public Status getStatus() {
        return status;
    }

    public void printBoard() {
        board.printBoard();
    }
}
