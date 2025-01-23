import java.util.Scanner;
class FizzBuzz1{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
		if(num>0){
			int i=0;
                	while(i<=num){
				if(i%3==0 && i%5==0){
					System.out.print("FizzBuzz");
				}
				else if(i%5==0){
                                	System.out.print("Buzz");
                        	}
				else if(i%3==0){
                                	System.out.print("Fizz");
                        	}
				else{
					System.out.print(i);
				}
				i++;
			}
		else{
			System.out.println("Enter positive number");
		}
        }
}
