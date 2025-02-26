package Practice_Problems.Problem7;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String jsonFilePath = "C:/CG_Assignments/JSON_Assignment/src/main/java/Practice_Problems/Problem7/people.json";  // Path to your JSON file
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Convert JsonNode to List of Person objects
            List<Person> people = new ArrayList<>();
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                int age = node.get("age").asInt();

                // Create a Person object and add to the list
                people.add(new Person(name, email, age));
            }

            // Filter the list for people with age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered list
            System.out.println("Filtered records (age > 25):");
            for (Person person : filteredPeople) {
                System.out.println(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
