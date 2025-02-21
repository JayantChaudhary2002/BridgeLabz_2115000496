import java.util.Scanner;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Integer[] array = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input, please enter a numeric value");
        } finally {
            scanner.close();
        }
    }
}
