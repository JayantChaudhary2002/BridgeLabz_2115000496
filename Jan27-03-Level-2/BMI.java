import java.util.*;
class BMI2{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		double personData[][]=new double[number][3];
		System.out.println("Enter the weights");
		for(int i=0;i<number;i++){
			for(int j=0;j<2;j++){
				personData[i][j]=sc.nextInt();
			}
			personData[i][2]=personData[i][0]/(personData[i][1]*personData[i][1]*0.01);
		}
		String weightStatus[]=new String[number*3];
		for(int i=0;i<number;i++){
			if(personData[i][2]<=18.4)
				weightStatus[i]="Underweight";
			else if(personData[i][2]>18.4 && personData[i][2]<=24.9)
				weightStatus[i]="Normal";
			else if(personData[i][2]>=25 &&  personData[i][2]<=39.9)
				weightStatus[i]= "Overweight";
			else
				weightStatus[i]="Obese";
		}
		for(int i=0;i<weightStatus.length;i++){
			System.out.println("Person with weight "+personData[i][0]+", height "+personData[i][1]+" and BMI "+personData[i][2]+" is "+weightStatus[i]);
		}
	}
}
