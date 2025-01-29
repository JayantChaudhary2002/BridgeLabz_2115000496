import java.util.*;
class Calculator {
	public static double add(double a, double b) {
		return a + b;
	}
	public static double subtract(double a, double b) {
		return a - b;
	}
	public static double multiply(double a, double b) {
		return a * b;
	}
	public static double divide(double a, double b) {
		if (b == 0) {
			System.out.println("Error: Division by zero is not allowed.");
			return Double.NaN;
		}
		return a / b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		double num1 = sc.nextDouble();
		System.out.print("Enter second number: ");
		double num2 = sc.nextDouble();
		System.out.println("Choose operation: 1 for Addition, 2 for Subtraction, 3 for Multiplication, 4 for Division");
		int choice = sc.nextInt();
		double result = 0;
		boolean valid = true;
		if (choice == 1) {
			result = add(num1, num2);
		} else if (choice == 2) {
			result = subtract(num1, num2);
		} else if (choice == 3) {
			result = multiply(num1, num2);
		} else if (choice == 4) {
			result = divide(num1, num2);
		} else {
			System.out.println("Invalid choice.");
			valid = false;
		}
		if (valid) {
			System.out.println("Result: " + result);
		}
	}
}
