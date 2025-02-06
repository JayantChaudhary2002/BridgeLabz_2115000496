import java.util.ArrayList;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Faculty{name='" + name + "'}";
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        if (!facultyMembers.contains(faculty)) {
            facultyMembers.add(faculty);
        }
    }

    public void displayFaculty() {
        System.out.println("Faculty in " + name + " Department:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(faculty);
        }
    }
}

class University {
    private String name;
    private ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department newDepartment = new Department(departmentName);
        departments.add(newDepartment);
    }

    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                department.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            System.out.println(department.getName());
            department.displayFaculty();
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("All departments have been deleted from " + name + ".");
    }
}

public class UniversityMain {
    public static void main(String[] args) {
        University university = new University("Tech University");

        Department csDepartment = new Department("Computer Science");
        Department eeDepartment = new Department("Electrical Engineering");

        university.addDepartment(csDepartment.getName());
        university.addDepartment(eeDepartment.getName());

        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");

        university.addFacultyToDepartment("Computer Science", faculty1);
        university.addFacultyToDepartment("Computer Science", faculty2);
        university.addFacultyToDepartment("Electrical Engineering", faculty1);

        university.displayDepartments();

        university.deleteUniversity();
        university.displayDepartments(); // Should show no departments
    }
}
