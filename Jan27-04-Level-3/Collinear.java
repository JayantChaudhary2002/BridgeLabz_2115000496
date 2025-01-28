import java.util.Scanner;
class Collinear {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter x1: ");
		int x1=scanner.nextInt();
		System.out.print("Enter y1: ");
		int y1=scanner.nextInt();
		System.out.print("Enter x2: ");
		int x2=scanner.nextInt();
		System.out.print("Enter y2: ");
		int y2=scanner.nextInt();
		System.out.print("Enter x3: ");
		int x3=scanner.nextInt();
		System.out.print("Enter y3: ");
		int y3=scanner.nextInt();
		if(areCollinearUsingSlope(x1,y1,x2,y2,x3,y3))
			System.out.println("Points are collinear using slope formula.");
		else
			System.out.println("Points are not collinear using slope formula.");
		if(areCollinearUsingArea(x1,y1,x2,y2,x3,y3))
			System.out.println("Points are collinear using area of triangle formula.");
		else
			System.out.println("Points are not collinear using area of triangle formula.");
	}
	public static boolean areCollinearUsingSlope(int x1,int y1,int x2,int y2,int x3,int y3) {
		double slopeAB=(double)(y2-y1)/(x2-x1);
		double slopeBC=(double)(y3-y2)/(x3-x2);
		double slopeAC=(double)(y3-y1)/(x3-x1);
		return slopeAB==slopeBC&&slopeAB==slopeAC;
	}
	public static boolean areCollinearUsingArea(int x1,int y1,int x2,int y2,int x3,int y3) {
		double area=0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
		return area==0;
	}
}
