package Practice_Problems.Problem6;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of User objects
        List<User> users = new ArrayList<>();
        users.add(new User("John Doe", "johndoe@example.com"));
        users.add(new User("Jane Smith", "janesmith@example.com"));
        users.add(new User("Alice Johnson", "alicej@example.com"));

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the List of Users into a JSON array
            String jsonArray = objectMapper.writeValueAsString(users);

            // Print the JSON array
            System.out.println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
