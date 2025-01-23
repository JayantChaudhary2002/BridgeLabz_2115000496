import java.util.*;
class NaturalNumber{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
		int sum=0;
                if(num<0){
                        System.out.println("The number "+num+" is not a natural number");
                }
                else{
			sum=(num*(num+1))/2;
                        System.out.println("The sum of "+num+" natural numbers is "+sum);
                }
        }
}
