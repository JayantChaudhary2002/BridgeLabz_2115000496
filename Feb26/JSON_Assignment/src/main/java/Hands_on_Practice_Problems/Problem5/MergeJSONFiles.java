package Hands_on_Practice_Problems.Problem5;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.File;
import java.io.IOException;

public class MergeJSONFiles {
    public static void main(String[] args) {
        try {
            // Initialize Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Load two JSON files
            JsonNode json1 = objectMapper.readTree(new File("C:/CG_Assignments/JSON_Assignment/src/main/java/Hands_on_Practice_Problems/Problem5/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("C:/CG_Assignments/JSON_Assignment/src/main/java/Hands_on_Practice_Problems/Problem5/file2.json"));

            // Merge JSON objects
            JsonNode mergedJson = mergeJson(json1, json2);

            // Output the merged JSON
            System.out.println(mergedJson.toString());

            // Optionally, write the merged JSON to a new file
            objectMapper.writeValue(new File("mergedFile.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonNode mergeJson(JsonNode json1, JsonNode json2) {
        // If json1 is an object, merge the fields of json2 into it
        if (json1.isObject()) {
            json2.fieldNames().forEachRemaining(fieldName -> {
                ((ObjectNode) json1).set(fieldName, json2.get(fieldName));
            });
        }
        return json1;
    }
}
