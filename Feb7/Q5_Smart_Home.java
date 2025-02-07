class Device {
    protected String deviceId;
    protected String status;
    
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    private double temperatureSetting;
    
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class Q5_Smart_Home {
    public static void main(String[] args) {
        Device genericDevice = new Device("D123", "ON");
        Thermostat thermostat = new Thermostat("T456", "OFF", 22.5);
        
        System.out.println("--- Generic Device Status ---");
        genericDevice.displayStatus();
        
        System.out.println("\n--- Thermostat Status ---");
        thermostat.displayStatus();
    }
}
