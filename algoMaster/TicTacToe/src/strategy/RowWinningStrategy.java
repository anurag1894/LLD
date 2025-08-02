package strategy;

import Controller.Board;
import constants.Sign;

public class RowWinningStrategy implements winningStrategy {

    @Override
    public boolean winner(Board board, Sign sign) {
        for (int row = 0; row < board.getSize(); row++) {
            boolean flag = true;
            for (int col = 0; col < board.getSize(); col++) {
                if(!board.getSign(row, col).equals(sign)) {
                    flag = false;
                }
            }
            if(flag) {
                return flag;
            }
        }
        return false;

    }
}
