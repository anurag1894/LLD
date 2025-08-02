package Controller;

import constants.Sign;
import strategy.winningStrategy;

import java.util.List;

public class Board {

    Cell[][] grid;
    List<winningStrategy> winningStrategies;
    int size;
    int moves;

    public Board(int size, List<winningStrategy> winningStrategies) {
       this.size = size;
       this.grid = new Cell[size][size];
       this.winningStrategies = winningStrategies;
       setTheGame(grid,size);
       moves = 0;
    }

    private void setTheGame(Cell[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }


    public void reset() {
        setTheGame(grid,size);
    }

    public boolean isWin(Sign sign) {
        for (winningStrategy strategy : winningStrategies) {
            if (strategy.winner(this, sign))
                return true;
        }
        return false;
    }

    public boolean isDraw() {
        return moves==size*size;
    }

    public Sign getSign(int xPos, int yPos) {
        return grid[xPos][yPos].getSign();
    }

    public boolean isValidInput(int xPos, int yPos) {
        return xPos >= 0 && yPos >= 0 && xPos < size && yPos < size &&getSign(xPos, yPos).equals(Sign.EMPTY);
    }

    public void playMove(int xPos, int yPos, Sign sign) {
        grid[xPos][yPos].setSign(sign);
        moves++;
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                System.out.print(cell.getSign() + " ");
            }
            System.out.println();
        }
    }
}
