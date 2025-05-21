package TrafficLight;

public class GreenColor implements TrafficState{
    @Override
    public void next(TrafficLightContext context) {
        context.setTrafficState(new yellowColor());
    }

    @Override
    public String getColor() {
        return "Green Traffic Light";
    }
}
