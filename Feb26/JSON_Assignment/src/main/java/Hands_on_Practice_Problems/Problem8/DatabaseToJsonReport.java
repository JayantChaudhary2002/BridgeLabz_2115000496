package Hands_on_Practice_Problems.Problem8;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // JDBC URL, username, and password for your database
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "your_username";
        String password = "your_password";

        // Database query to fetch records
        String query = "SELECT id, name, age, email FROM users";  // Example query

        // Establish connection to the database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // List to store the database records
            List<Map<String, Object>> records = new ArrayList<>();

            // Process the result set
            while (resultSet.next()) {
                // Create a map for each row
                Map<String, Object> row = new HashMap<>();
                row.put("id", resultSet.getInt("id"));
                row.put("name", resultSet.getString("name"));
                row.put("age", resultSet.getInt("age"));
                row.put("email", resultSet.getString("email"));

                // Add the row to the records list
                records.add(row);
            }

            // Convert the records list to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

            // Print the JSON report to the console
            System.out.println(jsonReport);

            // Optionally, write the JSON report to a file
            // objectMapper.writeValue(new File("report.json"), records);

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
