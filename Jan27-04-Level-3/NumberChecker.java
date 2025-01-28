class NumberChecker {
	public static void main(String[] args) {
		int number = 153;
		System.out.println("Number: " + number);
		System.out.println("Count of digits: " + countDigits(number));
		int[] digits = storeDigits(number);
		System.out.print("Digits array: ");
		for (int digit : digits) System.out.print(digit + " ");
		System.out.println();
		System.out.println("Is Duck Number: " + isDuckNumber(digits));
		System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));
		int[] largest = findLargestAndSecondLargest(digits);
		System.out.println("Largest digit: " + largest[0] + ", Second largest digit: " + largest[1]);
		int[] smallest = findSmallestAndSecondSmallest(digits);
		System.out.println("Smallest digit: " + smallest[0] + ", Second smallest digit: " + smallest[1]);
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
	public static boolean isDuckNumber(int[] digits) {
	for (int digit : digits) {
		if (digit == 0) return true;
	}
	return false;
	}
	public static boolean isArmstrongNumber(int number, int[] digits) {
		int sum = 0, count = digits.length;
		for (int digit : digits) sum += Math.pow(digit, count);
		return sum == number;
	}
	public static int[] findLargestAndSecondLargest(int[] digits) {
		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
		for (int digit : digits) {
			if (digit > largest) {
				secondLargest = largest;
				largest = digit;
			} else if (digit > secondLargest && digit != largest) {
				secondLargest = digit;
			}
		}
	return new int[]{largest, secondLargest};
	}
	public static int[] findSmallestAndSecondSmallest(int[] digits) {
		int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
		for (int digit : digits) {
			if (digit < smallest) {
				secondSmallest = smallest;
				smallest = digit;
			} else if (digit < secondSmallest && digit != smallest) {
				secondSmallest = digit;
			}
		}
		return new int[]{smallest, secondSmallest};
	}
}
