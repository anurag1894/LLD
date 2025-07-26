package states;

import enums.State;

public class ATMStateFactory {
    public static ATMState getATMState(State state) {
        if(State.IDLE.equals(state)) {
            return new IdleState();
        } else if (State.SELECT_OPERATION_STATE.equals(state)) {
            return new SelectOperationState();
        } else if (State.HAS_CARD.equals(state)) {
            return new HasCardState();
        } else if (State.TRANSACTION_IN_PROGRESS.equals(state)) {
            return new TrasnscationState();
        } else {
            System.out.println("Invalid state");
            return null;
        }
    }
}
