package states;

import Context.ATMMachineContext;
import enums.State;

public class HasCardState implements ATMState {

    @Override
    public void nextState(ATMMachineContext context) {
        context.setState(ATMStateFactory.getATMState(State.SELECT_OPERATION_STATE));
    }
}
