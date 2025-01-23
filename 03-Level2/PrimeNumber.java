import java.util.Scanner;
class PrimeNumber{
	public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
          	boolean isPrime = true;
        	if (num > 1) {
            		for (int i = 2; i < num; i++) {
                		if (num % i == 0) {
                    			isPrime = false;
                    			break;
                		}
            		}
        	} else {
            		isPrime = false;
        	}
        
        	if (isPrime) {
            		System.out.println(num + " is a prime number.");
        	} else {
            		System.out.println(num + " is not a prime number.");
        	}
        
        }
}
