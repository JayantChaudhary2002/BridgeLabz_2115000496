package Hands_on_Practice_Problems.Problem6;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) {
        // Sample JSON String
        String json = "{ \"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\" }";

        try {
            // Create Jackson ObjectMapper to parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);

            // Create Jackson XmlMapper to convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();

            // Convert the JSON to XML
            String xml = xmlMapper.writeValueAsString(jsonNode);

            // Print the XML result
            System.out.println(xml);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
