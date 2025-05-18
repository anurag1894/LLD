package weightCalculator;

public class WeightCalculator {
    public static void main(String[] args) {
        weightMachineImpl weightMachine = new weightMachineImpl();
        weightMachineAdapterImpl weightMachineAdapter = new weightMachineAdapterImpl(weightMachine);
        System.out.println("weight in kg "+ weightMachineAdapter.getWeight());
        System.out.println("weight in pound was "+ weightMachine.getWeightInPound());
    }
}
