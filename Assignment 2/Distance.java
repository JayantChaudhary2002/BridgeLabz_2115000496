import java.util.*;
class Distance{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int distanceInFeet=sc.nextInt();
		double yard=(double)distanceInFeet/3;
		double mile=yard/1760;
		System.out.println("The distance in yards is "+yard+" and the distance in miles is "+mile);
	}
}
