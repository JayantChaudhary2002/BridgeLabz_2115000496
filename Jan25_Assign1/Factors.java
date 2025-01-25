import java.util.Scanner;
class Factors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (number <= 0) {
			System.out.println("Error: Please enter a positive integer.");
			return;
		}
		int maxFactor = 10;
		int[] factors = new int[maxFactor];
		int index = 0;
		for (int i = 1; i <= number; i++) {
		if (number % i == 0) {
			if (index == maxFactor) {
				maxFactor *= 2;
				int[] temp = new int[maxFactor];
				System.arraycopy(factors, 0, temp, 0, factors.length);
				factors = temp;
			}
			factors[index++] = i;
		}
		System.out.print("Factors of " + number + ": ");
		for (int j = 0; j < index; j++){
			System.out.print(factors[j] + (j < index - 1 ? ", " : "\n"));
		}
	}
}