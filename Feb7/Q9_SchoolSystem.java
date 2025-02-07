class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

public class Q9_SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Alice", 16, 10);
        Staff staff = new Staff("Mrs. Patel", 35, "Administration");

        System.out.println("--- Teacher Details ---");
        teacher.displayRole();

        System.out.println("\n--- Student Details ---");
        student.displayRole();

        System.out.println("\n--- Staff Details ---");
        staff.displayRole();
    }
}



