import java.util.*;
class HeightConversion{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		double height=sc.nextDouble();
		double inch=height/2.54;
		double feet=inch/12;
		System.out.println("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inch);
	}
}
