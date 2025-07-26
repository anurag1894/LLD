package Context;

import enums.Cash;
import enums.State;
import enums.TransactionType;
import states.*;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATMMachineContext {
    ATMState currState;
    Card currCard;
    Account currAccount;
    private Map<Integer, Account> accounts;;
    ATMInventory inventory;
    TransactionType currTransactionType;

    public ATMMachineContext() {
        inventory = ATMInventory.getInstance();
        accounts = new HashMap<>();
        currState = ATMStateFactory.getATMState(State.IDLE);
    }


    public void addAccount(Account account) {
        this.accounts.put(account.getAccountNo(), account);
    }


    public Account getCurrAccount() {
        return currAccount;
    }

    public void setCurrAccount(Account currAccount) {
        this.currAccount = currAccount;
    }


    public Card getCurrCard() {
        return currCard;
    }

    public void setCurrCard(Card currCard) {
        this.currCard = currCard;
    }



    public void setState(ATMState state) {
        this.currState = state;
    }



    public void insertCard(Card card) {
        if(currState instanceof IdleState) {
            currState.nextState(this);
            System.out.println("Card inserted");
            this.currCard = card;
            currAccount = accounts.get(currCard.getAccountNumber());
        } else {
            System.out.println(
                    "Cannot insert card " );
        }
    }


    public void enterPIN(int pin){
        if(currState instanceof HasCardState) {
            if(currCard.getPin()==pin) {
                currState.nextState(this);
                System.out.println("Pin entered correctly");
            } else {
                System.out.println("Pin entered wrong");
            }

        } else{
            System.out.println("Cannot enter pin");
        }
    }

    public void selectOperation(TransactionType transactionType){
        if(currState instanceof SelectOperationState) {
            currTransactionType = transactionType;
            currState.nextState(this);
            System.out.println("Selected operation " + transactionType);
        } else {
            System.out.println("Cannot select operation");
        }
    }
    public void performOperation(int amount){
       Map<Cash, Integer> dispense = inventory.withdrawCash(amount);
       for(Map.Entry<Cash, Integer> entry : dispense.entrySet()){
           System.out.println("Cash type "+ entry.getKey() + " dispensed " + entry.getValue());
       }
       currAccount.setBalance(currAccount.getBalance()-amount);
    }

    public void performOperation(){
        System.out.println("Performing operation");
        System.out.println("Curr Balance: " + currAccount.getBalance());
        currState.nextState(this);
    }

    public void returnCard() {
        if (currState instanceof HasCardState
                || currState instanceof SelectOperationState
                || currState instanceof TrasnscationState) {
            System.out.println("Card returned to customer");
            resetATM();
        } else {
            System.out.println("No card to return in " );
        }
    }

    private void resetATM() {
        currState = null;
        currCard = null;
        currAccount = null;
        currTransactionType = null;
    }
}
