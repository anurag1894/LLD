package AdapterDesignPattern.Adaptor;

import AdapterDesignPattern.Adaptee.weightMachine;
import AdapterDesignPattern.Adaptee.weightMachineImp;

public class weightMachineAdaptorImp implements weightMachineAdaptor{
    weightMachine weight;
    public weightMachineAdaptorImp(weightMachine w){
        this.weight =w;
    }

    @Override
    public double getWeightInKg(){
        return weight.getWeightInPound()*15; // 15 is just assuming the value change to kg.
    }

}
