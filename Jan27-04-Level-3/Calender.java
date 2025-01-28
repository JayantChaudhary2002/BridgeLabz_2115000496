import java.util.Scanner;
class Calender {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the month (1-12): ");
		int month=scanner.nextInt();
		System.out.print("Enter the year: ");
		int year=scanner.nextInt();
		printCalendar(month,year);
	}
	public static void printCalendar(int month,int year) {
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(year))daysInMonth[1]=29;
		int firstDayOfMonth=getFirstDayOfMonth(month,year);
		System.out.println("     "+months[month-1]+" "+year);
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		for(int i=0;i<firstDayOfMonth;i++)System.out.print("   ");
		for(int day=1;day<=daysInMonth[month-1];day++) {
		System.out.printf("%3d",day);
		if((firstDayOfMonth+day)%7==0)System.out.println();
		else System.out.print(" ");
		}
		System.out.println();
	}
	public static boolean isLeapYear(int year) {
		return (year%4==0&&(year%100!=0||year%400==0));
	}
	public static int getFirstDayOfMonth(int month,int year) {
		int y=year-(14-month)/12,x=y+y/4-y/100+y/400;
		int m=month+12*((14-month)/12)-2;
		int d=(1+x+31*m/12)%7;
		return d;
	}
}
