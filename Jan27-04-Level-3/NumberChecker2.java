class NumberChecker2 {
	public static void main(String[] args) {
		int number = 21;
		System.out.println("Number: " + number);
		System.out.println("Count of digits: " + countDigits(number));
		int[] digits = storeDigits(number);
		System.out.print("Digits array: ");
		for (int digit : digits) System.out.print(digit + " ");
		System.out.println();
		System.out.println("Sum of digits: " + sumOfDigits(digits));
		System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));
		System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));
		int[][] frequency = findDigitFrequency(digits);
		System.out.println("Digit frequencies:");
		for (int[] freq : frequency) System.out.println("Digit: " + freq[0] + ", Frequency: " + freq[1]);
	}
	public static int countDigits(int number) {
		int count = 0;
		while (number != 0) {
			count++;
			number /= 10;
		}
		return count;
	}
	public static int[] storeDigits(int number) {
		int count = countDigits(number);
		int[] digits = new int[count];
		for (int i = count - 1; i >= 0; i--) {
			digits[i] = number % 10;
			number /= 10;
		}
		return digits;
	}
	public static int sumOfDigits(int[] digits) {
		int sum = 0;
		for (int digit : digits) sum += digit;
		return sum;
	}
	public static int sumOfSquaresOfDigits(int[] digits) {
		int sum = 0;
		for (int digit : digits) sum += Math.pow(digit, 2);
		return sum;
	}
	public static boolean isHarshadNumber(int number, int[] digits) {
		int sum = sumOfDigits(digits);
		return number % sum == 0;
	}
	public static int[][] findDigitFrequency(int[] digits) {
		int[][] frequency = new int[10][2];
		for (int i = 0; i < 10; i++) frequency[i][0] = i;
		for (int digit : digits) frequency[digit][1]++;
		return frequency;
	}
}
