import java.util.*;

public class ZeroSumSubarrays {
    
    public static List<List<Integer>> findSubarraysWithZeroSum(int[] arr) {
        Map<Integer, List<Integer>> cumulativeSumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int cumulativeSum = 0;
        
        cumulativeSumMap.put(cumulativeSum, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            if (cumulativeSumMap.containsKey(cumulativeSum)) {
                List<Integer> indices = cumulativeSumMap.get(cumulativeSum);
                
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            
            cumulativeSumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            cumulativeSumMap.get(cumulativeSum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -3, 3, 1, 1, 2, -2};
        List<List<Integer>> result = findSubarraysWithZeroSum(arr);
        
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
