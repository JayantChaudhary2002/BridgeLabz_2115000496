import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Policy {
    String policyNumber;
    String policyholderName;
    String expiryDate;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public boolean isExpired() {
        try {
            LocalDate expiry = LocalDate.parse(expiryDate, DateTimeFormatter.ISO_DATE);
            return expiry.isBefore(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName +
                ", Expiry Date: " + expiryDate + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {
    private static Map<String, Policy> policyMap = new HashMap<>();
    private static Map<String, Policy> linkedPolicyMap = new LinkedHashMap<>();
    private static Map<String, Policy> treePolicyMap = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            LocalDate expiry1 = LocalDate.parse(policyMap.get(o1).getExpiryDate(), DateTimeFormatter.ISO_DATE);
            LocalDate expiry2 = LocalDate.parse(policyMap.get(o2).getExpiryDate(), DateTimeFormatter.ISO_DATE);
            return expiry1.compareTo(expiry2);
        }
    });

    public static void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);
        treePolicyMap.put(policy.getPolicyNumber(), policy);
    }

    public static Policy retrievePolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public static List<Policy> listPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            try {
                LocalDate expiry = LocalDate.parse(policy.getExpiryDate(), DateTimeFormatter.ISO_DATE);
                if (expiry.isBefore(LocalDate.now().plusDays(30))) {
                    expiringPolicies.add(policy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return expiringPolicies;
    }

    public static List<Policy> listPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policiesByPolicyholder = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesByPolicyholder.add(policy);
            }
        }
        return policiesByPolicyholder;
    }

    public static void removeExpiredPolicies() {
        Iterator<Map.Entry<String, Policy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().isExpired()) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Policy policy1 = new Policy("P001", "John", "2025-06-01", 1200.50);
        Policy policy2 = new Policy("P002", "Alice", "2024-03-15", 1500.75);
        Policy policy3 = new Policy("P003", "Bob", "2025-02-10", 1100.30);
        Policy policy4 = new Policy("P004", "Alice", "2023-12-31", 1400.00);  // expired

        addPolicy(policy1);
        addPolicy(policy2);
        addPolicy(policy3);
        addPolicy(policy4);

        System.out.println("Retrieve Policy P001: " + retrievePolicy("P001"));

        System.out.println("\nPolicies expiring within the next 30 days:");
        List<Policy> expiringPolicies = listPoliciesExpiringSoon();
        for (Policy policy : expiringPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies for policyholder Alice:");
        List<Policy> alicePolicies = listPoliciesByPolicyholder("Alice");
        for (Policy policy : alicePolicies) {
            System.out.println(policy);
        }

        System.out.println("\nRemoving expired policies...");
        removeExpiredPolicies();

        System.out.println("\nAll policies after removal of expired ones:");
        System.out.println(policyMap);
    }
}
