import java.util.*;
class TriangleRun{
        public double roundsNumber(int side1, int side2, int side3){
                int perimeter=side1+side2+side3;
		double rounds=(double)(5000/perimeter);
		return rounds;
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int side1=sc.nextInt();
		int side2=sc.nextInt();
		int side3=sc.nextInt();
		TriangleRun obj=new TriangleRun();
		double result=obj.roundsNumber(side1, side2, side3);
		System.out.println("The number of rounds to be travelled "+result);
        }
}
