package Practice_Problems.Problem4;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJson {
    public static void main(String[] args) {
        String json1Path = "C:/CG_Assignments/JSON_Assignment/src/main/java/Practice_Problems/Problem4/json1.json";  // Path to first JSON file
        String json2Path = "C:/CG_Assignments/JSON_Assignment/src/main/java/Practice_Problems/Problem4/json2.json";  // Path to second JSON file

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON files into JsonNode objects
            JsonNode json1 = objectMapper.readTree(new File(json1Path));
            JsonNode json2 = objectMapper.readTree(new File(json2Path));

            // Merge json2 into json1
            JsonNode merged = mergeJsonObjects(json1, json2);

            // Print the merged JSON object
            System.out.println(merged.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to merge two JsonNode objects
    public static JsonNode mergeJsonObjects(JsonNode json1, JsonNode json2) {
        // Create a new ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a new node to store the merged result
        JsonNode merged = json1.deepCopy(); // Copy json1 to avoid modifying the original

        // Iterate over fields of json2 and merge them into json1
        json2.fieldNames().forEachRemaining(field -> {
            ((ObjectNode) merged).set(field, json2.get(field));
        });

        return merged;
    }
}
