abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    private int numberOfTests;

    public OutPatient(String patientId, String name, int age, double consultationFee, int numberOfTests) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.numberOfTests = numberOfTests;
    }

    @Override
    public double calculateBill() {
        return consultationFee + (numberOfTests * 50); // Assuming each test costs 50
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatientRecord implements MedicalRecord {
    private StringBuilder records;

    public InPatientRecord() {
        records = new StringBuilder();
    }

    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return records.toString();
    }
}

class OutPatientRecord implements MedicalRecord {
    private StringBuilder records;

    public OutPatientRecord() {
        records = new StringBuilder();
    }

    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return records.toString();
    }
}

public class HospitalManagement {
    public static void processPatientBill(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: " + patient.calculateBill());
        System.out.println("------");
    }

    public static void main(String[] args) {
        Patient inPatient = new InPatient("IP001", "John Doe", 45, 10, 200);
        Patient outPatient = new OutPatient("OP001", "Jane Smith", 30, 100, 3);

        processPatientBill(inPatient);
        processPatientBill(outPatient);

        InPatientRecord inPatientRecord = new InPatientRecord();
        inPatientRecord.addRecord("Diagnosis: Pneumonia");
        inPatientRecord.addRecord("Treatment: Antibiotics");

        OutPatientRecord outPatientRecord = new OutPatientRecord();
        outPatientRecord.addRecord("Diagnosis: Migraine");
        outPatientRecord.addRecord("Treatment: Pain relievers");

        System.out.println("InPatient Records:\n" + inPatientRecord.viewRecords());
        System.out.println("OutPatient Records:\n" + outPatientRecord.viewRecords());
    }
}
