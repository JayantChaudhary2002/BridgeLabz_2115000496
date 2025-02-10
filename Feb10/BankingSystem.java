abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        System.out.println("Savings Account Interest: " + interest);
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void calculateInterest() {
        double fee = getBalance() * 0.05 / 100;
        System.out.println("Current Account Fee: " + fee);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    void calculateLoanEligibility();
}

class LoanAccount extends BankAccount implements Loanable {
    private double loanAmount;

    public LoanAccount(String accountNumber, String holderName, double balance, double loanAmount) {
        super(accountNumber, holderName, balance);
        this.loanAmount = loanAmount;
    }

    public void calculateInterest() {
        System.out.println("Loan Account Interest: " + (loanAmount * 0.1 / 100));
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan application for: " + amount);
    }

    public void calculateLoanEligibility() {
        if (getBalance() >= loanAmount * 0.2) {
            System.out.println("Eligible for loan.");
        } else {
            System.out.println("Not eligible for loan.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA001", "John Doe", 5000, 5);
        BankAccount current = new CurrentAccount("CA001", "Jane Smith", 2000, 1000);
        BankAccount loan = new LoanAccount("LA001", "Bob Brown", 1000, 20000);

        savings.deposit(500);
        current.withdraw(300);
        loan.calculateInterest();

        ((LoanAccount) loan).applyForLoan(5000);
        ((LoanAccount) loan).calculateLoanEligibility();
    }
}
