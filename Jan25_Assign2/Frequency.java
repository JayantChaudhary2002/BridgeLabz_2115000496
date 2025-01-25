import java.util.*;
class Frequency{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int digit=0;
		int original=number;
		while(number>0){
			digit++;
			number/=10;
		}
		int [] digits=new int[10];
		for(int i=0;i<digit;i++){
			int d=original%10;
			digits[d]++;
			original/=10;
		}
		for(int i=0;i<10;i++){
			System.out.println("Frequency of digit "+i+" is "+digits[i]);
		}
	}
}
