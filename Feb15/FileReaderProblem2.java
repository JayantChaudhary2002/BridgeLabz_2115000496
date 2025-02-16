import java.io.*;

public class FileReaderProblem2 {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Replace with your file path
        String targetWord = "hello"; // Replace with the word you want to count
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
