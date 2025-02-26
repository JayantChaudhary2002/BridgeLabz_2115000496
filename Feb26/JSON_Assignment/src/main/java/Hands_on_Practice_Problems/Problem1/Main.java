package Hands_on_Practice_Problems.Problem1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String jsonFilePath = "C:/CG_Assignments/JSON_Assignment/src/main/java/Hands_on_Practice_Problems/Problem1/example.json";  // Path to your JSON file
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Print all keys and values
            printJsonKeysAndValues(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print all keys and values from JSON
    private static void printJsonKeysAndValues(JsonNode node) {
        if (node.isObject()) {
            // If it's an object, iterate over fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String key = field.getKey();
                JsonNode value = field.getValue();

                // Print the key and value
                System.out.println("Key: " + key + ", Value: " + value);

                // Recursively print values if it's another object or array
                if (value.isObject() || value.isArray()) {
                    printJsonKeysAndValues(value);
                }
            }
        } else if (node.isArray()) {
            // If it's an array, iterate over elements
            for (JsonNode arrayElement : node) {
                printJsonKeysAndValues(arrayElement);
            }
        }
    }
}
