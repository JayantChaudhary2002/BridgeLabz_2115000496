import java.util.*;

public class BankSystem {
    private static Map<String, Double> customerAccounts = new HashMap<>();
    private static Map<String, Double> sortedAccounts = new TreeMap<>(Comparator.comparing(customerAccounts::get));
    private static Queue<String> withdrawalRequests = new LinkedList<>();

    public static void createAccount(String accountNumber, double initialBalance) {
        customerAccounts.put(accountNumber, initialBalance);
        sortedAccounts.put(accountNumber, initialBalance);
    }

    public static void deposit(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
            sortedAccounts.put(accountNumber, customerAccounts.get(accountNumber));
        }
    }

    public static void withdraw(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            if (customerAccounts.get(accountNumber) >= amount) {
                customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) - amount);
                sortedAccounts.put(accountNumber, customerAccounts.get(accountNumber));
            }
        }
    }

    public static void requestWithdrawal(String accountNumber) {
        withdrawalRequests.offer(accountNumber);
    }

    public static void processWithdrawals() {
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            withdraw(accountNumber, 100);
        }
    }

    public static void displayAccounts() {
        for (Map.Entry<String, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }

    public static void displaySortedAccounts() {
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        createAccount("A001", 1000);
        createAccount("A002", 2000);
        createAccount("A003", 500);

        deposit("A001", 500);
        deposit("A002", 300);

        requestWithdrawal("A003");
        requestWithdrawal("A001");

        displayAccounts();
        displaySortedAccounts();

        processWithdrawals();

        displayAccounts();
        displaySortedAccounts();
    }
}
