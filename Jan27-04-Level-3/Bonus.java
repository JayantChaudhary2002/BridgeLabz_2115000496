import java.util.*;
class Bonus {
	public static void main(String[] args) {
		Random random=new Random();
		int[][] employeeData=new int[10][2];
		for(int i=0;i<10;i++) {
			employeeData[i][0]=random.nextInt(90000)+10000; 
			employeeData[i][1]=random.nextInt(20)+1;
		}
		int[][] updatedData=calculateNewSalaryAndBonus(employeeData);
		displayResults(employeeData,updatedData);
	}
	public static int[][] calculateNewSalaryAndBonus(int[][] employeeData) {
		int[][] updatedData=new int[10][3];
		for(int i=0;i<10;i++) {
			int salary=employeeData[i][0];
			int yearsOfService=employeeData[i][1];
			double bonus=0;
			if(yearsOfService>5) bonus=salary*0.05;
			else bonus=salary*0.02;
			int newSalary=(int)(salary+bonus);
			updatedData[i][0]=salary;
			updatedData[i][1]=newSalary;
			updatedData[i][2]=(int)bonus;
		}
	return updatedData;
	}
	public static void displayResults(int[][] employeeData,int[][] updatedData) {
		int totalOldSalary=0,totalNewSalary=0,totalBonus=0;
		System.out.println("Employee Old Salary | Employee New Salary | Bonus");
		for(int i=0;i<10;i++) {
			System.out.printf("%-20d%-20d%-10d\n",employeeData[i][0],updatedData[i][1],updatedData[i][2]);
			totalOldSalary+=employeeData[i][0];
			totalNewSalary+=updatedData[i][1];
			totalBonus+=updatedData[i][2];
		}
		System.out.println("Total Old Salary: "+totalOldSalary);
		System.out.println("Total New Salary: "+totalNewSalary);
		System.out.println("Total Bonus Amount: "+totalBonus);
	}
}
