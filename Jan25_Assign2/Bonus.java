import java.util.*;
class Bonus{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int [] salary=new int[10];
		int [] years=new int[10];
		System.out.println("Enter the salaries of employees");
		for(int i=0;i<10;i++){
			salary[i]=sc.nextInt();
		}
		System.out.println("Enter the years of service of employees");
		for(int i=0;i<10;i++){
			years[i]=sc.nextInt();
		}
		double [] bonus=new double[10];
		for(int i=0;i<10;i++){
			if(years[i]>=5){
				bonus[i]=salary[i]+(salary[i]*0.05);
			}
			else
				bonus[i]=salary[i]+(salary[i]*0.02);
		}
		System.out.println("The new salaries of employees after adding bonuses are");
		for(int i=0;i<10;i++){
			System.out.println(bonus[i]);
		}
	}
}
