public class Main {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(new TurnOnAcCommand(airConditioner));
        remoteControl.setButton();

        remoteControl.setCommand(new TurnOffAcCommand(airConditioner));
        remoteControl.setButton();
    }
}
