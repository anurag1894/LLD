package Context;

import enums.TransactionType;
import model.Account;
import model.Card;

public class Main {
    public static void main(String[] args) {
        ATMMachineContext atmMachineContext = new ATMMachineContext();
        atmMachineContext.addAccount(new Account(1,1234,34000,1994,"Anurag"));
        atmMachineContext.addAccount(new Account(2,4567,84000,1995,"Monika"));

        Card card = new Card();
        card.setCardNumber(1234);
        card.setPin(1994);
        card.setAccountNumber(1);

        atmMachineContext.insertCard(card);
        atmMachineContext.enterPIN(1994);

        atmMachineContext.selectOperation(TransactionType.BALANCE_CHECK);
        atmMachineContext.performOperation();

        atmMachineContext.selectOperation(TransactionType.WITHDRAW_CASH);
        atmMachineContext.performOperation(17680);

        atmMachineContext.selectOperation(TransactionType.BALANCE_CHECK);
        atmMachineContext.performOperation();

        atmMachineContext.returnCard();

    }
}
