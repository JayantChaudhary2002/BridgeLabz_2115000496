import java.util.*;
class BMI{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int [] weights=new int [number];
		int [] heights=new int[number];
		System.out.println("Enter the weights");
		for(int i=0;i<number;i++){
			weights[i]=sc.nextInt();
		}
		System.out.println("Enter the heights");
		for(int i=0;i<number;i++){
			heights[i]=sc.nextInt();
		}
		double [] bmi=new double[number];
		for(int i=0;i<number;i++){
			bmi[i]=weights[i]/(heights[i]*heights[i]*0.01);
		}
		for(int i=0;i<number;i++){
			if(bmi[i]<=18.4)
				System.out.println("BMI: "+bmi[i]+" Weight status: Underweight");
			else if(bmi[i]>18.4 && bmi[i]<=24.9) 
				System.out.println("BMI: "+bmi[i]+"Weight status: Normal");
			else if(bmi[i]>=25 &&  bmi[i]<=39.9)
				System.out.println("BMI: "+bmi[i]+"Weight status: Overweight");
			else
				System.out.println("BMI: "+bmi[i]+"Weight status: Obese");
}
	}
}
