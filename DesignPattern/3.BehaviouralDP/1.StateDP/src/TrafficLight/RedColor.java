package TrafficLight;

public class RedColor implements TrafficState{
    @Override
    public void next(TrafficLightContext trafficLightContext) {
        trafficLightContext.setTrafficState(new GreenColor());
    }

    @Override
    public String getColor() {
        return "RED Traffic Light";
    }
}
