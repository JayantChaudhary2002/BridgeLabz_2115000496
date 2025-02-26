package Hands_on_Practice_Problems.Problem7;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            // Initialize CSVReader using Apache Commons CSV
            FileReader reader = new FileReader(new File("data.csv"));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            // List to hold the CSV data as a list of maps
            List<Object> csvData = new ArrayList<>();

            // Loop through each CSV record and convert it to a Map
            for (CSVRecord record : records) {
                csvData.add(record.toMap());
            }

            // Initialize Jackson ObjectMapper to convert the List to JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the List to JSON
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);

            // Print the JSON output
            System.out.println(jsonOutput);

            // Optionally, write JSON to a file
            objectMapper.writeValue(new File("output.json"), csvData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
