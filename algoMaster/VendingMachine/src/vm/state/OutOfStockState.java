package vm.state;

import vm.VendingMachineContext;

public class OutOfStockState implements VendingMachineState{

    @Override
    public String getState() {
        return "OutOfStockState";
    }

    @Override
    public void next(VendingMachineContext context) {
        if(context.getCurrentProduct()==null) {
            context.setCurrentState(new IdleMachineState());
        }
    }
}
