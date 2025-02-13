import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> visitedNumbers = new HashSet<>();
        
        for (int num : arr) {
            if (visitedNumbers.contains(target - num)) {
                return true;
            }
            visitedNumbers.add(num);
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 5, 7, 8};
        int target = 12;
        
        boolean result = hasPairWithSum(arr, target);
        System.out.println(result);  // Output: true (because 5 + 7 = 12)
    }
}
