import java.io.*;

public class Problem5 {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";

        try {
            // Read image file into byte array
            byte[] imageBytes = readImageToByteArray(inputImagePath);

            // Write byte array back to image file
            writeByteArrayToImage(outputImagePath, imageBytes);

            System.out.println("Image conversion successful.");
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }

    private static byte[] readImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(String imagePath, byte[] imageBytes) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(imagePath)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
