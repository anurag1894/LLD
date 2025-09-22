package PLMulti.PL;

import PLMulti.PL.entities.Floor;
import PLMulti.PL.entities.Spot;
import PLMulti.PL.entities.Ticket;
import PLMulti.PL.entities.Vehicle;
import PLMulti.PL.enums.VehicleType;
import PLMulti.PL.strategy.fee.HourlyFeeStrategy;
import PLMulti.PL.strategy.parking.FirstFitStrategy;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedMain {
    private static final Random random = new Random();
    
    public static void main(String[] args) throws InterruptedException {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

        // Setup parking lot
        setupParkingLot(parkingLotSystem);

        // Single-threaded demo first
        System.out.println("=== Single-threaded Demo ===");
        singleThreadedDemo(parkingLotSystem);
        
        System.out.println("\n=== Multi-threaded Demo ===");
        multiThreadedDemo(parkingLotSystem);
        
        System.out.println("\n=== Stress Test Demo ===");
        stressTestDemo(parkingLotSystem);
    }
    
    private static void setupParkingLot(ParkingLotSystem parkingLotSystem) {
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);

        // Floor 1 - Mixed spots
        floor1.addSpot(new Spot(VehicleType.SMALL));
        floor1.addSpot(new Spot(VehicleType.SMALL));
        floor1.addSpot(new Spot(VehicleType.MEDIUM));
        floor1.addSpot(new Spot(VehicleType.LARGE));

        // Floor 2 - More spots
        floor2.addSpot(new Spot(VehicleType.MEDIUM));
        floor2.addSpot(new Spot(VehicleType.LARGE));
        floor2.addSpot(new Spot(VehicleType.LARGE));
        floor2.addSpot(new Spot(VehicleType.SMALL));

        parkingLotSystem.add(floor1);
        parkingLotSystem.add(floor2);
        parkingLotSystem.setParkingStrategy(new FirstFitStrategy());
        parkingLotSystem.setFeeStrategy(new HourlyFeeStrategy());
    }
    
    private static void singleThreadedDemo(ParkingLotSystem parkingLotSystem) {
        Vehicle vehicle1 = new Vehicle(123, VehicleType.SMALL);
        Vehicle vehicle2 = new Vehicle(1234, VehicleType.MEDIUM);
        Vehicle vehicle3 = new Vehicle(5678, VehicleType.LARGE);

        Optional<Ticket> ticket1 = parkingLotSystem.parkVehicle(vehicle1);
        Optional<Ticket> ticket2 = parkingLotSystem.parkVehicle(vehicle2);
        Optional<Ticket> ticket3 = parkingLotSystem.parkVehicle(vehicle3);

        // Simulate some time
        simulateTime(1000);

        if (ticket1.isPresent()) {
            Optional<Double> fee1 = parkingLotSystem.unparkVehicle(ticket1.get());
            System.out.println("Ticket 1 fee: " + fee1.orElse(0.0));
        }
        if (ticket2.isPresent()) {
            Optional<Double> fee2 = parkingLotSystem.unparkVehicle(ticket2.get());
            System.out.println("Ticket 2 fee: " + fee2.orElse(0.0));
        }
        if (ticket3.isPresent()) {
            Optional<Double> fee3 = parkingLotSystem.unparkVehicle(ticket3.get());
            System.out.println("Ticket 3 fee: " + fee3.orElse(0.0));
        }
    }
    
    private static void multiThreadedDemo(ParkingLotSystem parkingLotSystem) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        
        // Create 10 concurrent parking operations
        for (int i = 0; i < 10; i++) {
            final int vehicleId = 2000 + i;
            final VehicleType type = VehicleType.values()[i % 3];
            
            executor.submit(() -> {
                try {
                    Vehicle vehicle = new Vehicle(vehicleId, type);
                    System.out.println("Thread " + Thread.currentThread().getName() + 
                                     " attempting to park vehicle " + vehicleId);
                    
                    Optional<Ticket> ticket = parkingLotSystem.parkVehicle(vehicle);
                    
                    if (ticket.isPresent()) {
                        // Simulate parking duration
                        simulateTime(random.nextInt(2000) + 500);
                        
                        Optional<Double> fee = parkingLotSystem.unparkVehicle(ticket.get());
                        System.out.println("Thread " + Thread.currentThread().getName() + 
                                         " unparked vehicle " + vehicleId + 
                                         " with fee: " + fee.orElse(0.0));
                    } else {
                        System.out.println("Thread " + Thread.currentThread().getName() + 
                                         " failed to park vehicle " + vehicleId);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await(30, TimeUnit.SECONDS);
        executor.shutdown();
    }
    
    private static void stressTestDemo(ParkingLotSystem parkingLotSystem) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(50);
        
        System.out.println("Starting stress test with 50 concurrent operations...");
        
        for (int i = 0; i < 50; i++) {
            final int vehicleId = 3000 + i;
            final VehicleType type = VehicleType.values()[i % 3];
            
            executor.submit(() -> {
                try {
                    Vehicle vehicle = new Vehicle(vehicleId, type);
                    Optional<Ticket> ticket = parkingLotSystem.parkVehicle(vehicle);
                    
                    if (ticket.isPresent()) {
                        // Random parking duration
                        simulateTime(random.nextInt(1000) + 100);
                        parkingLotSystem.unparkVehicle(ticket.get());
                        System.out.print("✓");
                    } else {
                        System.out.print("✗");
                    }
                } catch (Exception e) {
                    System.out.print("E");
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await(60, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println("\nStress test completed!");
    }
    
    private static void simulateTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}