class Course {
    protected String courseName;
    protected int duration; // in weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void printDetails() {
        System.out.println("Course: " + courseName + " | Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Platform: " + platform + " | Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Fee: $" + fee + " | Discount: " + discount + "% | Final Fee: $" + finalFee);
    }
}

public class Q7_EducationCourse {
    public static void main(String[] args) {
        Course basicCourse = new Course("Java Basics", 6);
        OnlineCourse onlineCourse = new OnlineCourse("Web Development", 8, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Data Science", 12, "Coursera", true, 500, 20);

        System.out.println("--- Basic Course ---");
        basicCourse.printDetails();

        System.out.println("\n--- Online Course ---");
        onlineCourse.printDetails();

        System.out.println("\n--- Paid Online Course ---");
        paidCourse.printDetails();
    }
}



