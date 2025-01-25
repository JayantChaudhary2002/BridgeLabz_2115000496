import java.util.*;
class CheckNumber{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int []numbers = new int[5];
		for(int i=0; i<5; i++){
			numbers[i]=sc.nextInt();
		}
		for(int i=0; i<5; i++){
			if(numbers[i]<0)
				System.out.println(numbers[i] +" is a negative number");
			else if(numbers[i]>0){
				if(numbers[i]%2==0)
					System.out.println(numbers[i] +"is a even positive number");
				else
					System.out.println(numbers[i] +"is a odd negative number");
			}
			else
				System.out.println(numbers[i] +"is a zero");
		}
		if(numbers[0]==numbers[4])
			System.out.println(numbers[0]+" and “+numbers[4]+" are equal”);
		else if(numbers[0]>numbers[4])
			System.out.println(numbers[0]+" is greater than "+numbers[4]);
		else
			System.out.println(numbers[0] +" is smaller than "+numbers[4]);
	}
}

