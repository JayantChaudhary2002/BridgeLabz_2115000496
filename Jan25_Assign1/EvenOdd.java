import java.util.*;
class EvenOdd{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		boolean decision=number>1;
		if(decision){
			int [] even=new int[number/2];
			int [] odd=new int[number/2];
			int j=0,k=0;
			for(int i=1;i<number;i++){
				if(i%2==0){
					even[j]=i;
					j++;
				}
				else{
					odd[k]=i;
					k++;
				}
			}
			System.out.println("Even numbers are ");
			for(int i=0;i<j;i++){
				System.out.print(even[i]+" ");
			}
			System.out.println();
			System.out.println("Odd numbers are ");
			for(int i=0;i<k;i++){
				System.out.print(odd[i]+" ");
			}
		}
		else
			System.out.println("The number entered is not a natural number");
	}
}
