import java.util.*;
class UnitConvertor2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the units in km and miles");
		double km=sc.nextDouble();
		double miles=sc.nextDouble();
		System.out.println("km to miles: "+kmtomiles(km));
		System.out.println("miles to km: "+milestokm(kmtomiles(km)));
		System.out.println("Meters to feet: "+meterstofeet(miles));
		System.out.println("feet to meters: "+feettometers(meterstofeet(miles)));
	}
	public static double kmtomiles(double km){
		return km*0.621371;
	}
	public static double milestokm(double miles){
		return miles*1.60934;
	}
	public static double meterstofeet(double meters){
		return meters*3.28084;
	}
	public static double feettometers(double feet){
		return feet*0.3048;
	}
}

