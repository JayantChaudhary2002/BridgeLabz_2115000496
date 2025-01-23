import java.util.*;
class Factorial1{
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                if (num < 0) {
                        System.out.println("Please enter a positive integer.");
                }
                else {
                        int factorial = 1;
                        for(int i=1;i<num;i++){
				factorial*=i;
                        }
                        System.out.println("Factorial of " + num + " is " + factorial);
                }
        }
}
