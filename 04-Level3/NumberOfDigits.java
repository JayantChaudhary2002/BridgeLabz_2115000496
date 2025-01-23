import java.util.*;
class NumberOfDigits{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
                int count=0;
                int originalNumber=num;
                while(originalNumber!=0){
                        int rem=originalNumber%10;
                        count=count+1;
                        originalNumber=originalNumber/10;
                }
                System.out.println("The number of digits are "+count);
        }
}
