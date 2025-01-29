import java.util.*;
class GCDAndLCMCalculator {
	public static int[] getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int num1 = sc.nextInt();
		System.out.print("Enter the second number: ");
		int num2 = sc.nextInt();
		return new int[]{num1, num2};
	}
	public static int calculateGCD(int num1, int num2) {
		while (num2 != 0) {
			int temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}
		return num1;
	}
	public static int calculateLCM(int num1, int num2, int gcd) {
		return (num1 * num2) / gcd;
	}
	public static void displayResult(int gcd, int lcm) {
		System.out.println("The Greatest Common Divisor (GCD) is: " + gcd);
		System.out.println("The Least Common Multiple (LCM) is: " + lcm);
	}
	public static void main(String[] args) {
		int[] numbers = getInput();
		int num1 = numbers[0];
		int num2 = numbers[1];
		int gcd = calculateGCD(num1, num2);
		int lcm = calculateLCM(num1, num2, gcd);
		displayResult(gcd, lcm);
	}
}
