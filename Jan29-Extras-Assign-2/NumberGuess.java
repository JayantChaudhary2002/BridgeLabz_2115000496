import java.util.*;
class NumberGuess{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int low = 1, high = 100;
		System.out.println("Think of a number between 1 and 100. The computer will try to guess it!");
		while (true) {
			int guess = generateGuess(low, high, random);
			System.out.println("Is your number " + guess + "? (Enter 'H' for too high, 'L' for too low, 'C' for correct)");
			char feedback = scanner.next().charAt(0);
			if (feedback == 'C' || feedback == 'c') {
				break;
			}
			if (feedback == 'H' || feedback == 'h') {
				high = guess - 1;
			} 
			else if (feedback == 'L' || feedback == 'l') {
				low = guess + 1;
			}
		}
		System.out.println("Yay! The computer guessed your number correctly!");
	}
	public static int generateGuess(int low, int high, Random random) {
		return low + random.nextInt(high - low + 1);
	}
}

