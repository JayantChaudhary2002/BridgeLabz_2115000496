package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Scanner;

public class csvSearchRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "/home/jayant/Desktop/CG/csvpractise/csvReader/src/main/java/org/example/output.csv";

        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] file;
            System.out.println("Enter the Employee Name:- ");
            String employeeName = sc.nextLine();
            reader.readNext();

            while ((file = reader.readNext()) != null){
                if (file[1].equals(employeeName)){
                    System.out.println("Name :- " + file[1]);
                    System.out.println("Department :- " + file[2]);
                    System.out.println("Salary :- " + file[3]);
                }
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
