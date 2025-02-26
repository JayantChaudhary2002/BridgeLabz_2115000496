package Practice_Problems.Problem2;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Tesla", "Model S", 2023);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the Car object into a JSON string
            String carJson = objectMapper.writeValueAsString(car);

            // Print the JSON string
            System.out.println(carJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
