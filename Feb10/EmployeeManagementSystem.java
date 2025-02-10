abstract class Employee {
	private int employeeId;
	private String name;
 	private double baseSalary;

	public Employee(int employeeId, String name, double baseSalary) {
        	this.employeeId = employeeId;
        	this.name = name;
        	this.baseSalary = baseSalary;
    	}

	public int getEmployeeId() {
        	return employeeId;
    	}

	public void setEmployeeId(int employeeId) {
        	this.employeeId = employeeId;
    	}

    	public String getName() {
        	return name;
    	}

    	public void setName(String name) {
        	this.name = name;
    	}

    	public double getBaseSalary() {
        	return baseSalary;
    	}

    	public void setBaseSalary(double baseSalary) {
        	this.baseSalary = baseSalary;
    	}

    	public abstract double calculateSalary();

    	public void displayDetails() {
        	System.out.println("Employee ID: " + employeeId);
        	System.out.println("Name: " + name);
        	System.out.println("Base Salary: " + baseSalary);
        	System.out.println("Total Salary: " + calculateSalary());
    	}
}

class FullTimeEmployee extends Employee {
    	private double annualBonus;

    	public FullTimeEmployee(int employeeId, String name, double baseSalary, double annualBonus) {
        	super(employeeId, name, baseSalary);
        	this.annualBonus = annualBonus;
    	}

    	public double getAnnualBonus() {
        	return annualBonus;
    	}

    	public void setAnnualBonus(double annualBonus) {
        	this.annualBonus = annualBonus;
    	}

    	@Override
    	public double calculateSalary() {
        	return getBaseSalary() + annualBonus;
    	}
}

class PartTimeEmployee extends Employee {
    	private int hoursWorked;
    	private double hourlyRate;

    	public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        	super(employeeId, name, baseSalary);
        	this.hoursWorked = hoursWorked;
        	this.hourlyRate = hourlyRate;
    	}

    	public int getHoursWorked() {
        	return hoursWorked;
    	}

    	public void setHoursWorked(int hoursWorked) {
        	this.hoursWorked = hoursWorked;
    	}

    	public double getHourlyRate() {
        	return hourlyRate;
    	}

    	public void setHourlyRate(double hourlyRate) {
        	this.hourlyRate = hourlyRate;
    	}

    	@Override
    	public double calculateSalary() {
        	return getBaseSalary() + (hoursWorked * hourlyRate);
    	}
}

interface Department {
    	void assignDepartment(String department);
    	String getDepartmentDetails();
}

class FullTimeEmployeeWithDepartment extends FullTimeEmployee implements Department {
    	private String department;

    	public FullTimeEmployeeWithDepartment(int employeeId, String name, double baseSalary, double annualBonus) {
        	super(employeeId, name, baseSalary, annualBonus);
    	}

    	@Override
    	public void assignDepartment(String department) {
        	this.department = department;
    	}

    	@Override
    	public String getDepartmentDetails() {
        	return "Department: " + department;
    	}
}

class PartTimeEmployeeWithDepartment extends PartTimeEmployee implements Department {
    	private String department;

    	public PartTimeEmployeeWithDepartment(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        	super(employeeId, name, baseSalary, hoursWorked, hourlyRate);
    	}

    	@Override
    	public void assignDepartment(String department) {
        	this.department = department;
    	}

    	@Override
    	public String getDepartmentDetails() {
        	return "Department: " + department;
    	}
}

public class EmployeeManagementSystem {
    	public static void main(String[] args) {
        	Employee fullTimeEmployee = new FullTimeEmployeeWithDepartment(101, "Anu", 50000, 10000);
        	Employee partTimeEmployee = new PartTimeEmployeeWithDepartment(102, "Raj", 20000, 80, 25);

        	((Department) fullTimeEmployee).assignDepartment("Human Resources");
        	((Department) partTimeEmployee).assignDepartment("IT Support");

        	Employee[] employees = {fullTimeEmployee, partTimeEmployee};
        	for (Employee employee : employees) {
            		employee.displayDetails();
            		if (employee instanceof Department) {
                		System.out.println(((Department) employee).getDepartmentDetails());
            		}
            		System.out.println();
        	}
    	}
}
