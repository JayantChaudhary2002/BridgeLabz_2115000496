import java.util.*;
class Division{
        public void solution(int num1, int num2){
                int rem=0,quo=0;
                quo=num1/num2;
		rem=num1%num2;
		System.out.println("The Quotient is "+quo+" and Remainder is "+rem);
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num1=sc.nextInt();
                int num2=sc.nextInt();
                Division obj=new Division();
                obj.solution(num1, num2);
        }
}
