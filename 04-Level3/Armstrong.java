import java.util.*;
class Armstrong{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		int originalNumber=num;
		while(originalNumber!=0){
			int rem=originalNumber%10;
			int cube=rem*rem*rem;
			sum=sum+cube;
			originalNumber=originalNumber/10;
		}
		if(sum==num){
			System.out.println("The number is Armstrong");
		}
		else{
			System.out.println("The number is not Armstrong");
		}
	}
}
