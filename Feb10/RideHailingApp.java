abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    private static final double CAR_RATE = 15.0;  // Rate per Km for Car

    public Car(String vehicleId, String driverName) {
        super(vehicleId, driverName, CAR_RATE);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    private static final double BIKE_RATE = 5.0;  // Rate per Km for Bike

    public Bike(String vehicleId, String driverName) {
        super(vehicleId, driverName, BIKE_RATE);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    private static final double AUTO_RATE = 10.0;  // Rate per Km for Auto

    public Auto(String vehicleId, String driverName) {
        super(vehicleId, driverName, AUTO_RATE);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class GPSImpl implements GPS {
    private String currentLocation;

    public GPSImpl(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Location updated to: " + currentLocation);
    }
}

public class RideHailingApp {
    public static void calculateFare(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Total Fare for " + distance + " Km: " + vehicle.calculateFare(distance));
        System.out.println("------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C001", "John Doe");
        Vehicle bike = new Bike("B001", "Jane Smith");
        Vehicle auto = new Auto("A001", "Mike Johnson");

        calculateFare(car, 10);  // Calculate fare for Car for 10 Km
        calculateFare(bike, 5);   // Calculate fare for Bike for 5 Km
        calculateFare(auto, 8);   // Calculate fare for Auto for 8 Km

        // Using GPS
        GPS gps = new GPSImpl("123 Main St");
        System.out.println("Current Location: " + gps.getCurrentLocation());
        gps.updateLocation("456 Oak St");
        System.out.println("Updated Location: " + gps.getCurrentLocation());
    }
}
