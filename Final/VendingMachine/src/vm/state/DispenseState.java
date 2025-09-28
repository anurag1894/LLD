package vm.state;

import vm.VendingMachineContext;

public class DispenseState implements VendingMachineState {

    @Override
    public String getState() {
        return "DispenseState";
    }

    @Override
    public void next(VendingMachineContext context) {
        context.setCurrentState(new IdleMachineState());
    }
}
