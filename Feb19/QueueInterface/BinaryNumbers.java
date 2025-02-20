import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String binaryNumber = queue.remove();
            System.out.print(binaryNumber + " ");
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " binary numbers:");
        generateBinaryNumbers(N);
    }
}
