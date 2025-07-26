package states;

import Context.ATMMachineContext;
import enums.State;

public class IdleState implements ATMState {
    @Override
    public void nextState(ATMMachineContext context) {
        context.setState(ATMStateFactory.getATMState(State.HAS_CARD));
    }

}
