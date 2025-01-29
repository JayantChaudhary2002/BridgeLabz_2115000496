import java.time.*;
import java.util.*;
class DateComparison {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first date (yyyy-MM-dd): ");
		LocalDate date1 = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.print("Enter the second date (yyyy-MM-dd): ");
		LocalDate date2 = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		if (date1.isBefore(date2)) {
			System.out.println("The first date is before the second date.");
		} 
		else if (date1.isAfter(date2)) {
			System.out.println("The first date is after the second date.");
		} 
		else {
			System.out.println("Both dates are the same.");
		}
	}
}
