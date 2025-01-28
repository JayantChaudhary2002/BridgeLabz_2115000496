class NumberChecker3 {
	public static void main(String[] args) {
		int number=121;
		System.out.println("Number:"+number);
		System.out.println("Count of digits:"+countDigits(number));
		int[] digits=storeDigits(number);
		System.out.print("Digits array:");
		for(int digit:digits)System.out.print(digit+" ");
		System.out.println();
		int[] reversed=reverseArray(digits);
		System.out.print("Reversed digits array:");
		for(int digit:reversed)System.out.print(digit+" ");
		System.out.println();
		System.out.println("Arrays are equal:"+compareArrays(digits,reversed));
		System.out.println("Is Palindrome:"+isPalindrome(digits));
		System.out.println("Is Duck Number:"+isDuckNumber(digits));
	}
	public static int countDigits(int number) {
		int count=0;
		while(number!=0) {
		count++;
		number/=10;
		}
		return count;
	}
	public static int[] storeDigits(int number) {
		int count=countDigits(number);
		int[] digits=new int[count];
		for(int i=count-1;i>=0;i--) {
			digits[i]=number%10;
			number/=10;
		}
		return digits;
	}
	public static int[] reverseArray(int[] array) {
		int[] reversed=new int[array.length];
		for(int i=0;i<array.length;i++) {
			reversed[i]=array[array.length-1-i];
		}
		return reversed;
	}
	public static boolean compareArrays(int[] array1,int[] array2) {
		if(array1.length!=array2.length)return false;
		for(int i=0;i<array1.length;i++) {
			if(array1[i]!=array2[i])return false;
		}
		return true;
	}
	public static boolean isPalindrome(int[] digits) {
		int[] reversed=reverseArray(digits);
		return compareArrays(digits,reversed);
	}
	public static boolean isDuckNumber(int[] digits) {
		for(int i=1;i<digits.length;i++) {
			if(digits[i]==0)return true;
		}
	return false;
	}
}
