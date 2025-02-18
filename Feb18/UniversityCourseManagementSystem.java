import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private List<T> courseTypes;

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseTypes = new ArrayList<>();
    }

    public void addCourseType(T courseType) {
        courseTypes.add(courseType);
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        for (T courseType : courseTypes) {
            System.out.println(" - Evaluation Type: " + courseType.getEvaluationType());
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {

        Course<ExamCourse> examCourse = new Course<>("Mathematics 101");
        examCourse.addCourseType(new ExamCourse());
        examCourse.displayCourseInfo();

        Course<AssignmentCourse> assignmentCourse = new Course<>("Computer Science 101");
        assignmentCourse.addCourseType(new AssignmentCourse());
        assignmentCourse.displayCourseInfo();

        Course<ResearchCourse> researchCourse = new Course<>("Physics 101");
        researchCourse.addCourseType(new ResearchCourse());
        researchCourse.displayCourseInfo();
    }
}
