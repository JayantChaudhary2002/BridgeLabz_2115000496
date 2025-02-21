import java.io.*;

public class Problem7{
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Writing student details to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);

            System.out.println("Student details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student details: " + e.getMessage());
        }

        // Reading student details from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student details: " + e.getMessage());
        }
    }
}
