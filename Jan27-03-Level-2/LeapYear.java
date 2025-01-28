import java.util.*;
class LeapYear{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a year (>= 1582): ");
		int year=sc.nextInt();
		check(year);
	}
	public static void check(int year){
		if(year<1582) {
			System.out.println("The year must be 1582 or later.");
		} 
		else{
			if(year%4==0) {
				if(year%100==0) {
					if(year%400==0) {
						System.out.println(year + " is a leap year.");
					}
					else{
						System.out.println(year + " is not a leap year.");
					}
					}
				else{
					System.out.println(year + " is a leap year.");
					}
			}
			else{
				System.out.println(year + " is not a leap year.");
			}
			if((year%4==0 && year%100!=0) || (year%400==0)) {
				System.out.println("[Single Condition Check] " + year + " is a leap year.");
			}
			else{
				System.out.println("[Single Condition Check] " + year + " is not a leap year.");
			}
		}
	}
}

