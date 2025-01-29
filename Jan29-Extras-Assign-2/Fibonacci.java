import java.util.*;
class Fibonacci{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number<1){
			System.out.println("Enter the positive number");
		}
		else if(number==1){
			System.out.println("Fibonacci sequence:0");
		}
		else{
			fib(number);
		}
	}
	public static void fib(int number) {
		int first = 0, second = 1;
		System.out.print("Fibonacci Sequence: " + first + " " + second);
		for (int i = 3; i <= number; i++) {
			int next = first + second;
			System.out.print(" " + next);
			first = second;
			second = next;
		}
		System.out.println();
	}
}

