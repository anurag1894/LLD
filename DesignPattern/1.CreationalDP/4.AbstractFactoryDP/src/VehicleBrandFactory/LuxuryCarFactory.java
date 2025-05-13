package VehicleBrandFactory;

public class LuxuryCarFactory implements carfactory{

    @Override
    public car create(String carType) {
        switch (carType) {
            case "BMW": return new BMW();
            case "Audi": return new Audi();
            case "mercedz": return new Mercedz();
            default: throw new IllegalArgumentException("Unknown Luxury car type");
        }
    }
}
