import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}

public class GroupByDepartment {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<String>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            departmentMap
                .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                .add(employee.getName());
        }

        for (Map.Entry<String, List<String>> entry : departmentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
