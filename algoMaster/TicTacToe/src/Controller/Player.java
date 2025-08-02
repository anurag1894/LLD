package Controller;

import constants.Sign;

public class Player {
    public String name;
    public Sign sign;

    public Player(String name, Sign sign) {
         this.name = name;
         this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }

}
