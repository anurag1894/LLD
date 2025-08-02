package Controller;
import constants.Sign;

public class Cell {

    Sign sign;

    public Cell() {
        this.sign = Sign.EMPTY;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public boolean isEmpty() {
        return sign.equals(Sign.EMPTY);
    }
}
