package strategy;

import Controller.Board;
import constants.Sign;

public class DiagonalWinningStrategy implements winningStrategy {
    @Override
    public boolean winner(Board board, Sign sign) {
        boolean rowCheck = true, colCheck=true;
        int size = board.getSize();
        for (int row = 0; row < board.getSize(); row++) {
            if(!board.getSign(row,row).equals(sign)){
                rowCheck = false;
            }
            if(!board.getSign(row,size-1-row).equals(sign)){
                colCheck = false;
            }
        }

        return rowCheck||colCheck;
    }
}
