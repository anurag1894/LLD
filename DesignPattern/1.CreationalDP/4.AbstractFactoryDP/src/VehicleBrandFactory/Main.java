package VehicleBrandFactory;

public class Main {
    public static void main(String[] args) {

        /*
        We have two factory of car factory which create different object of car
         */
        carfactory economyCarsFactory = new EconomyCarFactory();
        car anshuCar = economyCarsFactory.create("Nano");
        anshuCar.assemble();
        car anuragCar = economyCarsFactory.create("Honda");
        anuragCar.assemble();
        try {
            car anuCar = economyCarsFactory.create("Audi");
            anuCar.assemble();
        }catch (Exception ex){
            System.out.println("can't get luxury car in this type");
        }

        carfactory luxuryCarsFactory = new LuxuryCarFactory();
        car momCar = luxuryCarsFactory.create("Audi");
        momCar.assemble();
        car papaCar = luxuryCarsFactory.create("BMW");
        papaCar.assemble();
        car anuCar = luxuryCarsFactory.create("mercedz");
        anuCar.assemble();
        try {
            car anshucar = luxuryCarsFactory.create("Honda");
            anshucar.assemble();
        }catch (Exception ex){
            System.out.println("can't get luxury car in this type");
        }



    }
}
