import java.util.*;
class QuoRem{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int quo=a/b;
		int rem=a%b;
		System.out.println("The Quotient is "+quo+" and Remainder is "+rem+" of two number "+a+" and "+b);
	}
}
