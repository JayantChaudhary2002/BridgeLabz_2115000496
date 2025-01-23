import java.util.*;
class HarshadNumber{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
                int sum=0;
                int originalNumber=num;
                while(originalNumber!=0){
                        int rem=originalNumber%10;
                        sum=sum+rem;
                        originalNumber=originalNumber/10;
                }
		if(num%sum==0){
                	System.out.println("Harshad Number");
		}
		else{
			System.out.println("Not a Harshad Number");
		}
	}
}
