import java.util.*;

public class VotingSystem {
    private static Map<String, Integer> voteMap = new HashMap<>();
    private static Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();
    private static Map<String, Integer> treeVoteMap = new TreeMap<>();

    public static void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        linkedVoteMap.put(candidate, linkedVoteMap.getOrDefault(candidate, 0) + 1);
        treeVoteMap.put(candidate, treeVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public static void displayResults() {
        System.out.println("Results (HashMap):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        System.out.println("\nResults (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        System.out.println("\nResults (TreeMap):");
        for (Map.Entry<String, Integer> entry : treeVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        castVote("Alice");
        castVote("Bob");
        castVote("Alice");
        castVote("Charlie");
        castVote("Bob");
        castVote("Alice");

        displayResults();
    }
}
