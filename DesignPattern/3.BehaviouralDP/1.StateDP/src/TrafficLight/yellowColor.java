package TrafficLight;

import java.awt.*;

public class yellowColor implements TrafficState{

    @Override
    public void next(TrafficLightContext trafficLightContext) {
        trafficLightContext.setTrafficState(new RedColor());
    }

    @Override
    public String getColor() {
        return "Yellow Color Traffic Light";
    }
}
