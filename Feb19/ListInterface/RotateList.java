import java.util.*;

public class RotateList {
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;

        List<Integer> temp = new ArrayList<>(list.subList(0, positions));
        list.removeAll(temp);
        list.addAll(temp);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + numbers);
        rotateList(numbers, 2);
        System.out.println("Rotated List: " + numbers);
    }
}
