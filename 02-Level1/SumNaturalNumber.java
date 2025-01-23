import java.util.*;
class SumNaturalNumber{
	public static void main(String[] args){
        	Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
	        if (n <= 0) {
            		return;
        	}
        	int formulaSum = n * (n + 1) / 2;
        	int loopSum = 0;
        	int i = 1;
        	while (i <= n){
            		loopSum += i;
            		i++;
        	}
		System.out.println("Sum using formula: " + formulaSum);
        	System.out.println("Sum using while loop: " + loopSum);
        	if(formulaSum == loopSum) {
            		System.out.println("Both computations are correct and match!");
        	}
	}
}
