package vm.state;

import vm.VendingMachineContext;

public class HasCashVendingState implements VendingMachineState{
    @Override
    public String getState() {
        return "HasCashVendingState";
    }

    @Override
    public void next(VendingMachineContext context) {
        if(context.getCurrentProduct() == null){
            context.setCurrentState(new OutOfStockState());
        } else{
            context.setCurrentState(new DispenseState());
        }

    }
}
