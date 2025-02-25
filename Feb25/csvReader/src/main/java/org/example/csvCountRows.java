package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class csvCountRows {
    public static void main(String[] args) {
        String path = "/home/jayant/Desktop/CG/csvpractise/csvReader/src/main/java/org/example/data.csv";
        int rows = 0;
        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] file ;
            reader.readNext();
            while ((file = reader.readNext()) != null){
                rows++;
            }
            System.out.println("Total Number of Rows:- " + rows);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
