package Hands_on_Practice_Problems.Problem4;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.*;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class EmailValidation {
    public static void main(String[] args) {
        try {
            // Load the JSON Schema from the file
            File schemaFile = new File("email_schema.json");
            JSONObject schemaObject = new JSONObject(new ObjectMapper().readTree(schemaFile).toString());
            Schema schema = SchemaLoader.load(schemaObject);

            // Create a JSON object with an email field to validate
            String jsonString = "{\"email\":\"invalid-email@domain\"}"; // Example of invalid email
            JSONObject jsonObject = new JSONObject(jsonString);

            // Validate the JSON object against the schema
            schema.validate(jsonObject);  // This will throw an exception if invalid

            System.out.println("Email is valid.");

        } catch (ValidationException e) {
            // Handle invalid JSON
            System.out.println("Invalid email: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
