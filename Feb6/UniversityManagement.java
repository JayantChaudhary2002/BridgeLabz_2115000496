import java.util.*;
class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> students;
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.professorName + " is assigned to course " + courseName);
    }
    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.studentName + " enrolled in course " + courseName);
    }
    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("  Taught by: " + professor.professorName);
        }
        System.out.println("  Enrolled students:");
        for (Student student : students) {
            System.out.println("    " + student.studentName);
        }
    }
}
class Professor {
    String professorName;
    public Professor(String professorName) {
        this.professorName = professorName;
    }
}
class Student {
    String studentName;
    public Student(String studentName) {
        this.studentName = studentName;
    }
    public void enrollCourse(Course course) {
        course.enrollStudent(this);
    }
}
public class UniversityManagement {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student2.enrollCourse(course2);
        course1.showCourseDetails();
        course2.showCourseDetails();
    }
}
