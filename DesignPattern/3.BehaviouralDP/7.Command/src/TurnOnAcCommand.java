public class TurnOnAcCommand implements Icommand{

    AirConditioner airConditioner;

    TurnOnAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOnAc();
    }
}
