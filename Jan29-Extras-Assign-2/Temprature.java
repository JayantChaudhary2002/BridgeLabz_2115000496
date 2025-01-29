import java.util.*;
class TemperatureConverter {
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature value: ");
		double temp = sc.nextDouble();
		System.out.print("Enter 1 for Fahrenheit to Celsius or 2 for Celsius to Fahrenheit: ");
		int choice = sc.nextInt();
		if (choice == 1) {
		System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temp));
		} else if (choice == 2) {
		System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temp));
		} else {
		System.out.println("Invalid choice.");
		}
	}
}
