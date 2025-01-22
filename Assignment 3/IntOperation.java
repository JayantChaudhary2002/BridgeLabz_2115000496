import java.util.*;
class IntOperation{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int res1=a+b*c;
		int res2=a*b+c;
		int res3=c+a/b;
		int res4=a%b+c;
		System.out.println("The result of Int Operations are "+res1+","+res2+","+res3+" and "+res4);
	}
}
