package weightCalculator;

public class weightMachineAdapterImpl implements weightCalculator.weightMachine {
    private weightMachineImpl weightMachine;

    public weightMachineAdapterImpl(weightMachineImpl weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeight() {
        return this.weightMachine.getWeightInPound()*1.25;
    }
}
