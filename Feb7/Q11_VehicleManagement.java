// Superclass Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable for Petrol Vehicles
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass inheriting from Vehicle
class ElectricVehicle extends Vehicle {
    private int batteryCapacity; // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging electric vehicle...");
    }

    public void displayVehicleType() {
        System.out.println("Vehicle Type: Electric Vehicle");
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle subclass inheriting from Vehicle and implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle...");
    }

    public void displayVehicleType() {
        System.out.println("Vehicle Type: Petrol Vehicle");
        super.displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

public class Q11_VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 240, 60);

        System.out.println("--- Electric Vehicle Details ---");
        ev.displayVehicleType();
        ev.charge();

        System.out.println("\n--- Petrol Vehicle Details ---");
        pv.displayVehicleType();
        pv.refuel();
    }
}


