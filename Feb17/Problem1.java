
import java.util.*;

public class Problem1{
    public static void main(String[] args) {
        int[] dataSize = {1000, 10000, 100000};
        for (int size : dataSize) {
            System.out.println("Data Size: " + size);
            int[] dataset = generateRandomDataset(size);
            int target = dataset[size / 2];

            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long endTime = System.nanoTime();
            System.out.println("Linear Search time: " + (endTime - startTime) / 1000000.0 + "ms");

            // Binary Search
            Arrays.sort(dataset);
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            endTime = System.nanoTime();
            System.out.println("Binary Search Time: " + (endTime - startTime) / 1000000.0 + "ms");

            System.out.println();
        }
    }

    private static int[] generateRandomDataset(int size) {
        Random random = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = random.nextInt(size * 10);
        }
        return dataset;
    }

    private static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
