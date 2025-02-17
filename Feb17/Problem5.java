public class Problem5{
    public static void main(String[] args) {
        System.out.println("Fibonacci Comparison:");

        int n = 30;

        long startTime = System.currentTimeMillis();
        int fibRecursive = fibonacciRecursive(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Fibonacci(" + n + ") using Recursive: " + fibRecursive);
        System.out.println("Time taken using Recursive: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        int fibIterative = fibonacciIterative(n);
        endTime = System.currentTimeMillis();
        System.out.println("Fibonacci(" + n + ") using Iterative: " + fibIterative);
        System.out.println("Time taken using Iterative: " + (endTime - startTime) + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
