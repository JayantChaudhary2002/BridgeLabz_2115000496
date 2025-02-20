import java.util.LinkedList;

public class NthElementFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        LinkedList<String> tempList = new LinkedList<>(list);
        while (tempList.size() > n) {
            tempList.pollFirst();
        }
        return tempList.pollFirst();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        System.out.println("Nth element from the end: " + findNthFromEnd(list, n));
    }
}
