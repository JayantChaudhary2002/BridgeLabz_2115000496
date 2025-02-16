import java.io.*;
import java.util.*;

public class ChallengeProblem{

    public static void main(String[] args) throws IOException {
        String str = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1000000 + " milliseconds");

        File file = new File("large_file.txt");

        startTime = System.nanoTime();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int wordCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        bufferedReader.close();
        endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;
        System.out.println("Time taken by FileReader: " + fileReaderTime / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        bufferedReader = new BufferedReader(inputStreamReader);
        wordCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        bufferedReader.close();
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime / 1000000 + " milliseconds");

        System.out.println("Total word count: " + wordCount);
    }
}
