class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "IT", 50000);
        System.out.println("Salary: " + e1.getSalary());
        e1.setSalary(60000);
        System.out.println("Updated Salary: " + e1.getSalary());

        Manager m1 = new Manager(201, "HR", 70000, "Recruitment");
        m1.displayManagerDetails();
    }
}

class Manager extends Employee {
    private String team;

    public Manager(int employeeID, String department, double salary, String team) {
        super(employeeID, department, salary);
        this.team = team;
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Team: " + team);
    }
}
