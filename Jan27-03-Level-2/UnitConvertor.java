import java.util.*;
class UnitConvertor{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the units in yards and meters");
		double yards=sc.nextDouble();
		double meter=sc.nextDouble();
		System.out.println("yards to feet: "+yardstofeet(yards));
		System.out.println("feet to yards: "+feettoyards(yardstofeet(yards)));
		System.out.println("Meters to inches: "+metertoinch(meter));
		System.out.println("inches to meters: "+inchtometer(metertoinch(meter)));
		System.out.println("inches to centimeters: "+inchtocm(metertoinch(meter)));
	}
	public static double yardstofeet(double yards){
		return yards*3;
	}
	public static double feettoyards(double feet){
		return feet*0.333333;
	}
	public static double metertoinch(double meter){
		return meter*39.3701;
	}
	public static double inchtometer(double inch){
		return inch*0.0254;
	}
	public static double inchtocm(double inch){
		return inch*2.54;
	}
}
