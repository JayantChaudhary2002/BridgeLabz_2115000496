import java.io.*;

public class Problem2{
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Change as needed
        String destinationFile = "destination.txt";
        final int BUFFER_SIZE = 4096;

        long startTime, endTime;
        
        // Buffered Streams
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            startTime = System.nanoTime();
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            endTime = System.nanoTime();
            System.out.println("Buffered Streams copy completed in: " + (endTime - startTime) + " nanoseconds.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }

        // Unbuffered Streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            startTime = System.nanoTime();
            
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            endTime = System.nanoTime();
            System.out.println("Unbuffered Streams copy completed in: " + (endTime - startTime) + " nanoseconds.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
