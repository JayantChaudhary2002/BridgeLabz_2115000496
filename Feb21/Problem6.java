import java.io.*;

public class Problem6 {
    public static void main(String[] args) {
        String inputFile = "source.txt";
        String outputFile = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }
            
            System.out.println("File conversion successful.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
