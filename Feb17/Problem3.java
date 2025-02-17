import java.util.*;

public class Problem3{
    private static final int NUM_OPERATION = 1000000;

    public static void main(String[] args) {
        System.out.println("String concatenation comparison");

        long startTime = System.currentTimeMillis();
        concateUsingString(NUM_OPERATION);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by String: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        concateUsingStringBuilder(NUM_OPERATION);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        concateUsingStringBuffer(NUM_OPERATION);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + "ms");
    }

    private static void concateUsingString(int numOperation) {
        String str = " ";
        for (int i = 0; i < numOperation; i++) {
            str += "a";
        }
    }

    private static void concateUsingStringBuilder(int numOperation) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numOperation; i++) {
            str.append("a");
        }
    }

    private static void concateUsingStringBuffer(int numOperation) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < numOperation; i++) {
            str.append("a");
        }
    }
}
