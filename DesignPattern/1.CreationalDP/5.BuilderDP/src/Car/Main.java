package Car;

public class Main {
    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder();
        Car car1  =  builder.setColor("Blue")
                .setEngine("Honda")
                .setSeats(5)
                .setNavigationSystem(true)
                .setWheels(4)
                .build();
        System.out.println(car1);
        // New builder marked engine as null But if we use same builder but generate new
        // object it will get the old result, Please see car2 and car3.
        Car car2  =  builder.setColor("Blue")
                .setNavigationSystem(true)
                .setWheels(4)
                .build();
        System.out.println(car2);

        Car.CarBuilder builder2 = new Car.CarBuilder();
        Car car3  =  builder2.setColor("Blue")
                .setWheels(4)
                .build();
        System.out.println(car3);


    }
}
