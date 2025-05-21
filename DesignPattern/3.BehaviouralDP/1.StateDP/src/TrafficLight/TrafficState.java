package TrafficLight;

public interface TrafficState {
    void next(TrafficLightContext trafficLightContext);
    public String getColor();
}
