package states;

import Context.ATMMachineContext;

public interface ATMState {

    public void nextState(ATMMachineContext context);
}
