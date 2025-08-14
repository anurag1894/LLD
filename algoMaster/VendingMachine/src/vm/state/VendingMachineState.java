package vm.state;

import vm.VendingMachineContext;

public interface VendingMachineState {
    public String getState();
    public void next(VendingMachineContext context);
}
