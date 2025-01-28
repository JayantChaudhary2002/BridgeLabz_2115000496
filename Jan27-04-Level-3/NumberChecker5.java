class NumberChecker5 {
	public static void main(String[] args) {
		int number=28;
		System.out.println("Number:"+number);
		int[] factors=findFactors(number);
		System.out.print("Factors: ");
		for(int factor:factors)System.out.print(factor+" ");
		System.out.println();
		System.out.println("Greatest Factor:"+greatestFactor(factors));
		System.out.println("Sum of Factors:"+sumOfFactors(factors));
		System.out.println("Product of Factors:"+productOfFactors(factors));
		System.out.println("Product of Cube of Factors:"+productOfCubeFactors(factors));
		System.out.println("Is Perfect Number:"+isPerfectNumber(number));
		System.out.println("Is Abundant Number:"+isAbundantNumber(number));
		System.out.println("Is Deficient Number:"+isDeficientNumber(number));
		System.out.println("Is Strong Number:"+isStrongNumber(number));
	}
	public static int[] findFactors(int number) {
		int count=0;
		for(int i=1;i<=number;i++) {
			if(number%i==0)count++;
		}
		int[] factors=new int[count];
		int index=0;
		for(int i=1;i<=number;i++) {
			if(number%i==0)factors[index++]=i;
		}
		return factors;
	}
	public static int greatestFactor(int[] factors) {
		int greatest=0;
		for(int factor:factors) {
			if(factor>greatest)greatest=factor;
		}
		return greatest;
	}
	public static int sumOfFactors(int[] factors) {
		int sum=0;
		for(int factor:factors) {
			sum+=factor;
		}
		return sum;
	}
	public static int productOfFactors(int[] factors) {
		int product=1;
		for(int factor:factors) {
			product*=factor;
		}
		return product;
	}
	public static double productOfCubeFactors(int[] factors) {
		double product=1;
		for(int factor:factors) {
			product*=Math.pow(factor,3);
		}
		return product;
	}
	public static boolean isPerfectNumber(int number) {
		int[] factors=findFactors(number);
		int sum=sumOfFactors(factors)-number;
		return sum==number;
	}
	public static boolean isAbundantNumber(int number) {
		int[] factors=findFactors(number);
		int sum=sumOfFactors(factors)-number;
		return sum>number;
	}
	public static boolean isDeficientNumber(int number) {
		int[] factors=findFactors(number);
		int sum=sumOfFactors(factors)-number;
		return sum<number;
	}
	public static boolean isStrongNumber(int number) {
		int original=number,sum=0;
		while(number!=0) {
			int digit=number%10,factorial=1;
			for(int i=1;i<=digit;i++) {
				factorial*=i;
			}
			sum+=factorial;
			number/=10;
		}
		return sum==original;
	}
}

