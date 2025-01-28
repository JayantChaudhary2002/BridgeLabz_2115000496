import java.util.*;
class Factors{
    	public static void main(String[] args) {
        	Scanner sc= new Scanner(System.in);
                int num = sc.nextInt();
        	int[] factors = findFactors(num);
        	int sum = findSum(factors);
        	int product = findProduct(factors);
        	double sumOfSquares = findSumOfSquares(factors);
        	System.out.println("Factors: " + Arrays.toString(factors));
        	System.out.println("Sum: " + sum);
        	System.out.println("Product: " + product);
        	System.out.println("Sum of squares: " + sumOfSquares);
    	}
    	public static int[] findFactors(int num) {
        	int count = 0;
        	for (int i = 1; i <= num; i++) {
            		if (num % i == 0) {
                		count++;
            		}
        	}
        	int[] factors = new int[count];
        	int index = 0;
        	for (int i = 1; i <= num; i++) {
            		if (num % i == 0) {
                		factors[index++] = i;
            		}
        	}
               	return factors;
    	}
    	public static int findSum(int[] factors) {
        	int sum = 0;
        	for (int factor : factors) {
            		sum += factor;
        	}
        	return sum;
    	}
    	public static int findProduct(int[] factors) {
        	int product = 1;
        	for (int factor : factors) {
            		product *= factor;
        	}
        	return product;
    	}
    	public static double findSumOfSquares(int[] factors) {
        	double sumOfSquares = 0;
        		for (int factor : factors) {
            			sumOfSquares += Math.pow(factor, 2);
        		}
        	return sumOfSquares;
    	}
}

