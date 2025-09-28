package vm.state;

import vm.VendingMachineContext;

public class IdleMachineState implements VendingMachineState{
    @Override
    public String getState() {
        return "IdleMachineState";
    }

    @Override
    public void next(VendingMachineContext context) {
        if(context.getCurrentProduct() == null){
            context.setCurrentState(new OutOfStockState());
        } else {
            context.setCurrentState(new HasCashVendingState());
        }
    }
}
