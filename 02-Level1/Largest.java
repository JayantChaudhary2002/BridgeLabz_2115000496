import java.util.*;
class Largest{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num1=sc.nextInt();
                int num2=sc.nextInt();
                int num3=sc.nextInt();
                if(num1>num2 && num1>num3){
                        System.out.println("Is the first number the Largest? Yes");
                }
                else{
                        System.out.println("Is the first number the Largest? No");
                }
		if(num2>num1 && num2>num3){
                        System.out.println("Is the second number the Largest? Yes");
                }
                else{
                        System.out.println("Is the second number the Largest? No");
                }
		if(num3>num1 && num3>num2){
                        System.out.println("Is the third number the Largest? Yes");
                }
                else{
                        System.out.println("Is the third number the Largest? No");
                }
        }
}
