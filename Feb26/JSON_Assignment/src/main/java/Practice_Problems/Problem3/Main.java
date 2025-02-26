package Practice_Problems.Problem3;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Path to the JSON file
        String filePath = "C:/CG_Assignments/JSON_Assignment/src/main/java/Practice_Problems/Problem3/user.json";

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file and map it to the User class
            User user = objectMapper.readValue(new File(filePath), User.class);

            // Extract and print the specific fields (name and email)
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
