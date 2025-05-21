package TrafficLight;

public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLightContext = new TrafficLightContext();
        System.out.println(trafficLightContext.getColor());
        trafficLightContext.nextState();
        System.out.println(trafficLightContext.getColor());
        trafficLightContext.nextState();
        System.out.println(trafficLightContext.getColor());
        trafficLightContext.setTrafficState(new GreenColor());
        trafficLightContext.nextState();
        trafficLightContext.setTrafficState(new GreenColor());
        System.out.println(trafficLightContext.getColor());
    }
}
