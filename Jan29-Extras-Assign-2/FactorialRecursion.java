import java.util.*;
class FactorialUsingRecursion {
	public static int getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to calculate its factorial: ");
		return sc.nextInt();
	}
	public static int calculateFactorial(int number) {
		if (number == 0 || number == 1) {
			return 1;
		} 
		else {
			return number * calculateFactorial(number - 1);
		}
	}
	public static void displayResult(int number, int factorial) {
		System.out.println("The factorial of " + number + " is: " + factorial);
	}
	public static void main(String[] args) {
		int userInput = getInput();
		int result = calculateFactorial(userInput);
		displayResult(userInput, result);
	}
}
