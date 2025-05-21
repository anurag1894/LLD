package TrafficLight;

public class TrafficLightContext {
    TrafficState trafficState;
    TrafficLightContext(){
        this.trafficState = new RedColor();
    }

    public void setTrafficState(TrafficState trafficState) {
        this.trafficState = trafficState;
    }

    public void nextState(){
         trafficState.next(this);
    }

    public String getColor() {
        return trafficState.getColor();
    }
}
