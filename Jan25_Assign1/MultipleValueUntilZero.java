import java.util.*;
class MultipleValueUntilZero{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double number[]=new double[10];
		int i=0;
		while(true){
			double input=sc.nextDouble();
			if(input==0 || input<0)
			break;
			number[i]=input;
			i++;
			if(i==10)
			break;
		}
		double total=0;
		for(int ind=0;ind<10;ind++){
			total=total+number[ind];
		}
		System.out.println();
		System.out.println("Total of all elements is "+total);
	}
}

