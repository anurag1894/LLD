public class TurnOffAcCommand implements Icommand{

    AirConditioner airConditioner;

    TurnOffAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.turnOffAc();
    }
}
