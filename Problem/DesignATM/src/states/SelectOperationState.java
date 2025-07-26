package states;

import Context.ATMMachineContext;
import enums.State;

public class SelectOperationState implements ATMState{
    @Override
    public void nextState(ATMMachineContext context) {

        context.setState(ATMStateFactory.getATMState(State.TRANSACTION_IN_PROGRESS));
    }
}
