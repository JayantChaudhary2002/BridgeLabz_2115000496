import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public String toString() {
        return "Policy Number: " + policyNumber + ", Name: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage Type: " + coverageType + ", Premium: " + premiumAmount;
    }

    public boolean isExpiringSoon() {
        LocalDate today = LocalDate.now();
        long daysUntilExpiry = ChronoUnit.DAYS.between(today, expiryDate);
        return daysUntilExpiry <= 30;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

public class InsurancePolicyManagement {

    private static Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private static Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private static Set<InsurancePolicy> treeSetPolicies = new TreeSet<>(Comparator.comparing(InsurancePolicy::getExpiryDate));

    public static void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public static void retrieveAllPolicies() {
        System.out.println("All Unique Policies:");
        System.out.println("HashSet: " + hashSetPolicies);
        System.out.println("LinkedHashSet: " + linkedHashSetPolicies);
        System.out.println("TreeSet: " + treeSetPolicies);
    }

    public static void retrievePoliciesExpiringSoon() {
        System.out.println("\nPolicies Expiring Soon:");
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.isExpiringSoon()) {
                System.out.println(policy);
            }
        }
    }

    public static void retrievePoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with coverage type " + coverageType + ":");
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public static void findDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Set<String> seenPolicyNumbers = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println("Duplicate: " + policy);
            }
        }
    }

    public static void comparePerformance() {
        int n = 10000;
        InsurancePolicy policy = new InsurancePolicy("P001", "John Doe", LocalDate.now().plusMonths(1), "Health", 200.0);

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashSetPolicies.add(policy);
        }
        long endTime = System.nanoTime();
        System.out.println("\nHashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetPolicies.contains(policy);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetPolicies.remove(policy);
        endTime = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashSetPolicies.add(policy);
        }
        endTime = System.nanoTime();
        System.out.println("\nLinkedHashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.contains(policy);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.remove(policy);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSetPolicies.add(policy);
        }
        endTime = System.nanoTime();
        System.out.println("\nTreeSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.contains(policy);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.remove(policy);
        endTime = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicy policy1 = new InsurancePolicy("P001", "John Doe", LocalDate.now().plusMonths(1), "Health", 200.0);
        InsurancePolicy policy2 = new InsurancePolicy("P002", "Jane Smith", LocalDate.now().plusDays(10), "Auto", 150.0);
        InsurancePolicy policy3 = new InsurancePolicy("P003", "Bob Johnson", LocalDate.now().plusMonths(3), "Home", 300.0);
        InsurancePolicy policy4 = new InsurancePolicy("P004", "Alice Brown", LocalDate.now().plusMonths(1), "Health", 220.0);

        addPolicy(policy1);
        addPolicy(policy2);
        addPolicy(policy3);
        addPolicy(policy4);

        retrieveAllPolicies();
        retrievePoliciesExpiringSoon();
        retrievePoliciesByCoverageType("Health");
        findDuplicatePolicies();
        comparePerformance();
    }
}
