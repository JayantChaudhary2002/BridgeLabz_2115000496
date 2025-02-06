import java.util.ArrayList;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "'}";
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name; // Getter for name
    }

    public void addEmployee(String employeeName) {
        Employee newEmployee = new Employee(employeeName);
        employees.add(newEmployee);
    }

    public void displayEmployees() {
        System.out.println("Employees in " + name + " Department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department newDepartment = new Department(departmentName);
        departments.add(newDepartment);
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) { // Use getter
                department.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            System.out.println(department.getName()); // Use getter
            department.displayEmployees();
        }
    }

    public void deleteCompany() {
        departments.clear();
        System.out.println("All departments and employees have been deleted from " + name + ".");
    }
}

public class CompanyMain {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        company.addDepartment("Development");
        company.addDepartment("Marketing");

        company.addEmployeeToDepartment("Development", "Alice");
        company.addEmployeeToDepartment("Development", "Bob");
        company.addEmployeeToDepartment(" Marketing", "Charlie");

        company.displayDepartments();

        company.deleteCompany();
        company.displayDepartments(); // Should show no departments
    }
}
