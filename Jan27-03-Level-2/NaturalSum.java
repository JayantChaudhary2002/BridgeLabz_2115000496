import java.util.*;
class NaturalSum {
	public static int sumUsingRecursion(int n) {
        	if (n == 1) {
            		return 1;
        	}
        	return n + sumUsingRecursion(n - 1);
    	}
     	public static int sumUsingFormula(int n) {
        	return n * (n + 1) / 2;
    	}
	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a natural number: ");
        	int number = scanner.nextInt();
		if(number <= 0) {
            		System.out.println(" Please enter a positive natural number.");
            		return;
        	}
        	int sumRecursion = sumUsingRecursion(number);
		int sumFormula = sumUsingFormula(number);
		System.out.println("Sum using recursion: " + sumRecursion);
        	System.out.println("Sum using formula: " + sumFormula);
		if(sumRecursion == sumFormula) {
            		System.out.println("The results match! The calculation is correct.");
        	} 
		else{
            		System.out.println("The results do not match. There might be an error.");
        	}
	}
}

