package Hands_on_Practice_Problems.Problem3;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String jsonFilePath = "C:/CG_Assignments/JSON_Assignment/src/main/java/Hands_on_Practice_Problems/Problem3/users.json";  // Path to your JSON file
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Convert the JsonNode into a list of User objects
            List<User> userList = new ArrayList<>();
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                int age = node.get("age").asInt();
                String email = node.get("email").asText();

                // Add each user to the list
                userList.add(new User(name, age, email));
            }

            // Filter the users older than 25
            List<User> filteredUsers = userList.stream()
                    .filter(user -> user.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered list of users
            System.out.println("Users older than 25 years:");
            for (User user : filteredUsers) {
                System.out.println(user);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
