package org.example;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Writecsv {
    public static void main(String[] args) {
        String Pathname = "/home/jayant/Desktop/CG/csvpractise/csvReader/src/main/java/org/example/output.csv";
        Scanner sc = new Scanner(System.in);
        try(CSVWriter writer = new CSVWriter(new FileWriter(Pathname))){
            String[] Header = {"Id" , "Name" , "Department" , "Salary"};
            writer.writeNext(Header);
            String[] employee1 = {"1" , "Divyanshu" , "Computer Science" , "50000"};
            String[] employee2 = {"2" , "Deepansh" , "Hr" , "5000"};
            String[] employee3 = {"3" , "bhovan" , "Marketing" , "10000"};
            String[] employee4 = {"4" , "daksh" , "Hr" , "6000"};
            String[] employee5 = {"5" , "Krishna" , "Finance" , "4000"};

            writer.writeNext(employee1);
            writer.writeNext(employee2);
            writer.writeNext(employee3);
            writer.writeNext(employee4);
            writer.writeNext(employee5);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
