import java.util.*;
class TriangleArea{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int base=sc.nextInt();
		int height=sc.nextInt();

		//Area in square centimeter
		double area=(1/2)*(double)base*(double)height;
		double baseinch=base/2.54;
		double heightinch=height/2.54;

		//Area in square inches
		double areainch=(1/2)*baseinch*heightinch;
		System.out.println("The area of triangle in square centimeters is "+area+" and in square inches is "+areainch);
	}
}
