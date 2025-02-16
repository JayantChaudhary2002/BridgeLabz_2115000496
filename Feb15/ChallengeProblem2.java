import java.util.*;

public class ChallengeProblem2 {

    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                continue;
            }
            int val = Math.abs(arr[i]);
            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        Arrays.sort(arr);
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
