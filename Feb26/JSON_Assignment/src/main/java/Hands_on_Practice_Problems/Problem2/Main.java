package Hands_on_Practice_Problems.Problem2;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a list of Person objects
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John Doe", 30, "john.doe@example.com"));
        personList.add(new Person("Jane Smith", 25, "jane.smith@example.com"));
        personList.add(new Person("Alice Johnson", 35, "alice.johnson@example.com"));

        // Step 2: Convert the list of objects into a JSON array
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert list to JSON string
            String jsonArray = objectMapper.writeValueAsString(personList);

            // Print the JSON array
            System.out.println(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
