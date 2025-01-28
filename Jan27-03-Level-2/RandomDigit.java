import java.util.*;
class RandomDigit{
	public static int[] generate4DigitRandomArray(int size) {
        	Random random = new Random();
        	int[] numbers = new int[size];
        	for (int i = 0; i < size; i++) {
            		numbers[i] = 1000 + random.nextInt(9000);
        	}
        	return numbers;
    	}
    	public static double[] findAverageMinMax(int[] numbers) {
        	int sum = 0;
        	int min = numbers[0];
        	int max = numbers[0];
		for (int number : numbers) {
            		sum += number;
            		min = Math.min(min, number);
            		max = Math.max(max, number);
        	}
		double average = (double) sum / numbers.length;
        	return new double[]{average, min, max};
    	}
	public static void main(String[] args) {
        	int[] randomNumbers = generate4DigitRandomArray(5);
        	double[] results = findAverageMinMax(randomNumbers);
        	System.out.println("Generated numbers: " + Arrays.toString(randomNumbers));
        	System.out.printf("Average: %.2f\n", results[0]);
        	System.out.println("Minimum: " + (int) results[1]);
        	System.out.println("Maximum: " + (int) results[2]);
    	}
}

