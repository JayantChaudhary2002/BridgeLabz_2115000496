package Practice_Problems.Problem5;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonPath = "C:/CG_Assignments/JSON_Assignment/src/main/java/Practice_Problems/Problem5/user.json";  // Path to your JSON file
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(jsonPath));

            // Validate the structure by trying to map to a User object
            validateJsonStructure(rootNode);

            System.out.println("JSON structure is valid.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid JSON structure or cannot parse the file.");
        }
    }

    // Method to validate the structure of the JSON based on the User class
    public static void validateJsonStructure(JsonNode rootNode) {
        // Check if required fields are present
        if (rootNode.hasNonNull("name") && rootNode.hasNonNull("email")) {
            // You can add further validation on data types here if needed
            System.out.println("Required fields are present.");
        } else {
            System.out.println("JSON structure is invalid. Missing required fields.");
            throw new IllegalArgumentException("Missing required fields in JSON.");
        }

        // Check data type of fields if needed
        if (!rootNode.get("name").isTextual()) {
            throw new IllegalArgumentException("Field 'name' should be a text.");
        }

        if (!rootNode.get("email").isTextual()) {
            throw new IllegalArgumentException("Field 'email' should be a text.");
        }
    }
}
