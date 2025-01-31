import java.util.*;
class Employee{
	private String name;
	private int id;
	private double salary;
	public Employee(String name, int id, double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	} 
	public void displayDetails(){
		System.out.println("Name of Employee is:"+name);
		System.out.println("Id of Employee is:"+id);
		System.out.println("Salary of Employee is:"+salary);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int id=sc.nextInt();
		double salary=sc.nextDouble();
		Employee details=new Employee(name,id,salary);
		details.displayDetails();
	}
}
