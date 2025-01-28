import java.util.*;
class CheckNumber{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int [] numbers=new int[5];
		for(int i=0;i<5;i++){
			numbers[i]=sc.nextInt();
		}
		for(int i=0;i<5;i++){
			isPositive(numbers[i]);
		}
		compare(numbers);
	}
	public static void isPositive(int number){
		if(number<0)
			System.out.println(number+" is a Negative Number");
		else if(number>0){
			isEven(number);
		}
		else
			System.out.println(number+" is a zero");
	}
	public static void isEven(int number){
		if(number%2==0)
			System.out.println(number+" is an even Positive number");
		else
			System.out.println(number+" is an odd Positive number");
	}
	public static void compare(int [] numbers){
		if(numbers[0]==numbers[4])
			System.out.println(numbers[0]+" and "+numbers[4]+" are equal");
		else if(numbers[0]>numbers[4])
			System.out.println(numbers[0]+" is greater than "+numbers[4]);
		else
			System.out.println(numbers[0]+" is smaller than "+numbers[4]);
	}
}
