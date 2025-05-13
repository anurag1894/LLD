package VehicleBrandFactory;

public class EconomyCarFactory implements carfactory{

    @Override
    public car create(String carType) {
        switch (carType) {
            case "Honda": return new Honda();
            case "Nano": return new Nano();
            case "suzki": return new suzki();
            default: throw new IllegalArgumentException("Unknown economic car type");
        }
    }
}
