package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class LargeCSVProcessor {

    public static void main(String[] args) {
        String csvFilePath = "large_file.csv";  
        int batchSize = 100;
        processCSVInChunks(csvFilePath, batchSize);
    }

    public static void processCSVInChunks(String csvFilePath, int batchSize) {
        int totalProcessed = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] row;
            List<String[]> batch = new ArrayList<>();

            String[] header = reader.readNext();
            if (header != null) {
                System.out.println("Header: " + String.join(", ", header));
            }

            while ((row = reader.readNext()) != null) {
                batch.add(row);

                if (batch.size() == batchSize) {
                    totalProcessed += processBatch(batch);
                    System.out.println("Processed " + totalProcessed + " records so far.");
                    batch.clear(); 
                }
            }

            if (!batch.isEmpty()) {
                totalProcessed += processBatch(batch);
                System.out.println("Processed a total of " + totalProcessed + " records.");
            }

        } catch (Exception e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
    private static int processBatch(List<String[]> batch) {
        for (String[] record : batch) {
            System.out.println("Processing record: " + String.join(", ", record));
        }
        return batch.size();
    }
}

