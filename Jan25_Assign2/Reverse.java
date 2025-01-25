import java.util.*;
class Reverse{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int digit=0;
		int original=number;
		while(number>0){
			digit++;
			number/=10;
		}
		int [] digits=new int[digit];
		for(int i=0;i<digit;i++){
			digits[i]=original%10;
			original/=10;
		}
		for(int i=0;i<digit;i++){
			System.out.print(digits[i]);
		}
	}
}
