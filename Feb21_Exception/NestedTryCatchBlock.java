import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        
        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();
        
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            try {
                int element = arr[index];
                int result = element / divisor;
                System.out.println("Division result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (Exception e) {
        }
    }
}
