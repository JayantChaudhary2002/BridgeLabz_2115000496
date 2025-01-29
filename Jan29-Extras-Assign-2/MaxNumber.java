import java.util.*;
class MaxNumber{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int first=getInput(sc);
		int second=getInput(sc);
		int third=getInput(sc);
		int result=maximum(first,second,third);
		System.out.println("The maximum number is "+result);
		
	}
	public static int getInput(Scanner sc){
		return sc.nextInt();
	}
	public static int maximum(int first, int second, int third){
		if(first>second && first>third)
			return first;
		else if(second>first && second>third)
			return second;
		else
			return third;
	}
}
