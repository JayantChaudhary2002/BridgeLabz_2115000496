import java.util.*;
class MeanHeight {
	public static void main(String[] args) {
		int[] heights = new int[11];
		Random random = new Random();
		for (int i = 0; i < heights.length; i++) {
			heights[i] = 150 + random.nextInt(101);
		}
		System.out.print("Player heights: ");
		for (int height : heights) {
			System.out.print(height + " ");
		}
		System.out.println();
		int sum = findSum(heights);
		double mean = findMean(heights);
		int shortest = findShortest(heights);
		int tallest = findTallest(heights);
		System.out.println("Sum of heights: " + sum);
		System.out.println("Mean height: " + mean);
		System.out.println("Shortest height: " + shortest);
		System.out.println("Tallest height: " + tallest);
	}
	public static int findSum(int[] heights) {
		int sum = 0;
		for (int height : heights) {
		sum += height;
		}
		return sum;
	}
	public static double findMean(int[] heights) {
		int sum = findSum(heights);
		return (double) sum / heights.length;
	}
	public static int findShortest(int[] heights) {
		int shortest = heights[0];
		for (int height : heights) {
			if (height < shortest) {
				shortest = height;
			}
		}
		return shortest;
	}
	public static int findTallest(int[] heights) {
		int tallest = heights[0];
		for (int height : heights) {
			if (height > tallest) {
				tallest = height;
			}
		}
	return tallest;
	}
}
