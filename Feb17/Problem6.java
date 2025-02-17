import java.util.*;

public class Problem6{
    public static void main(String[] args) {
        System.out.println("Data Structure Search Comparison:");
        
        int dataSize = 1_000_000;
        int searchElement = dataSize / 2;

        int[] array = new int[dataSize];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < dataSize; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startTime = System.currentTimeMillis();
        boolean foundInArray = searchInArray(array, searchElement);
        long endTime = System.currentTimeMillis();
        System.out.println("Element found in Array: " + foundInArray);
        System.out.println("Time taken using Array: " + (endTime - startTime) + " ms\n");

        startTime = System.currentTimeMillis();
        boolean foundInHashSet = hashSet.contains(searchElement);
        endTime = System.currentTimeMillis();
        System.out.println("Element found in HashSet: " + foundInHashSet);
        System.out.println("Time taken using HashSet: " + (endTime - startTime) + " ms\n");

        startTime = System.currentTimeMillis();
        boolean foundInTreeSet = treeSet.contains(searchElement);
        endTime = System.currentTimeMillis();
        System.out.println("Element found in TreeSet: " + foundInTreeSet);
        System.out.println("Time taken using TreeSet: " + (endTime - startTime) + " ms\n");
    }

    private static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
