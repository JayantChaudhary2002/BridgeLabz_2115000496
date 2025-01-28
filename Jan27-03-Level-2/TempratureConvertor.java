import java.util.*;
class TemperatureConvertor{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of farenheit, pounds and gallons");
		double farenheit=sc.nextDouble();
		double pounds=sc.nextDouble();
		double gallons=sc.nextDouble();
		System.out.println("Farenheit to celsius: "+farhenheit2celsius(farenheit));
		System.out.println("Celsius to farenheit: "+celsius2farhenheit(farhenheit2celsius(farenheit)));
		System.out.println("Pounds to km: "+pounds2kg(pounds));
		System.out.println("Pounds to km: "+kg2pounds(pounds2kg(pounds)));
		System.out.println("Pounds to km: "+gallons2liters(gallons));
		System.out.println("Pounds to km: "+liters2gallons(gallons2liters(gallons)));
	}
	public static double farhenheit2celsius(double farenheit){
		return (farenheit - 32) * 5 / 9;
	}
	public static double celsius2farhenheit(double celsius){
		return (celsius * 9 / 5) + 32;
	}
	public static double pounds2kg(double pounds){
		return pounds*0.453592;
	}
	public static double kg2pounds(double kg){
		return kg*2.20462;
	}
	public static double gallons2liters(double gallons){
		return gallons*3.78541;
	}
	public static double liters2gallons(double l){
		return l*0.264172;
	}
}
