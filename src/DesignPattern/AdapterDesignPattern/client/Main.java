package AdapterDesignPattern.client;

import AdapterDesignPattern.Adaptee.weightMachine;
import AdapterDesignPattern.Adaptee.weightMachineImp;
import AdapterDesignPattern.Adaptor.weightMachineAdaptor;
import AdapterDesignPattern.Adaptor.weightMachineAdaptorImp;

public class Main {
    public static void main(String[] args) {
        weightMachine weightInPounds = new weightMachineImp();
        weightMachineAdaptor weightAdaptor = new weightMachineAdaptorImp(weightInPounds);

         // here we are adding weightAdaptor over Adaptee to get data in kg,
        System.out.println("The weight of baby in kg : " + weightAdaptor.getWeightInKg());
    }
}
