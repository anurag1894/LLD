package strategy;

import Controller.Board;
import constants.Sign;

public interface winningStrategy {
    public boolean winner(Board board, Sign sign);
}
