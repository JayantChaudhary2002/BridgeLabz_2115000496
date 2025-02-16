import java.io.*;

public class InputStreamReaderProblem2 {
    public static void main(String[] args) {
        String filePath = "user_input.txt"; 

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath, true)) {
            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = reader.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input + "\n");
            }
            System.out.println("Input has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
