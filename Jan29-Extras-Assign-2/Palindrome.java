import java.util.*;
class PalindromeChecker {
	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to check if it's a palindrome: ");
		return sc.nextLine();
	}
	public static boolean checkPalindrome(String str) {
		str = str.replace(" ", "").toLowerCase();
		String reversedStr = new StringBuilder(str).reverse().toString();
		return str.equals(reversedStr);
	}
	public static void displayResult(boolean isPalindrome) {
		if (isPalindrome) {
			System.out.println("The string is a palindrome.");
		}
		else {
			System.out.println("The string is not a palindrome.");
		}
	}
	public static void main(String[] args) {
		String userInput = getInput();
		boolean isPalindrome = checkPalindrome(userInput);
		displayResult(isPalindrome);
	}
}
