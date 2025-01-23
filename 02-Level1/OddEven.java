import java.util.*;
class OddEven{
	public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);
        	int number = sc.nextInt();
        	if (number < 1){
            		System.out.println("Please enter a positive natural number.");
        	}
		else{
            		for (int i = 1; i <= number; i++){
                		if (i % 2 == 0) {
                    			System.out.println(i + " is even");
                		}
				else{
                    			System.out.println(i + " is odd");
                		}
            		}
        	}
	}
}
