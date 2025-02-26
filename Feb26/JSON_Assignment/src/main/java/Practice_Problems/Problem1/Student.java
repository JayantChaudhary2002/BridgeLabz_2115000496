package Practice_Problems.Problem1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Student {
    private String name;
    private int age;
    private String[] subjects;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public static void main(String[] args) {
        String json = "{ \"name\": \"John Doe\", \"age\": 20, \"subjects\": [\"Math\", \"Science\", \"History\"] }";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserialize JSON into a Student object
            Student student = objectMapper.readValue(json, Student.class);
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Subjects: " + String.join(", ", student.getSubjects()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
