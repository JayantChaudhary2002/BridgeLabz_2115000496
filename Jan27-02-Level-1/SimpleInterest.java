import java.util.*;
class SimpleInterest{
	public double simpleInterest(double principal,double rate,int year){
		double interest=(principal*rate*year)/100;
		return interest;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		double principal=sc.nextDouble();
		double rate=sc.nextDouble();
		int year=sc.nextInt();
		SimpleInterest obj=new SimpleInterest();
		double interest=obj.simpleInterest(principal,rate,year);
		System.out.println("The Simple Interest is "+interest+" for principal "+principal+",Rate of Interest "+rate+" and Time "+year);
	}
}
