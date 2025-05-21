public class AirConditioner {
    Boolean isOn = false;
    int temperature;

    public void turnOnAc(){
        isOn = true;
        System.out.println("Turning on the air conditioner");
    }
    public void turnOffAc(){
        isOn = false;
        System.out.println("Turning off the air conditioner");
    }
    public void changeTemperature(int temp){
        temperature = temp;
        System.out.println("Changing temperature to " + temperature);
    }
}
