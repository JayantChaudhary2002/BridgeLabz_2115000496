class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "ABC University";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 6, 500.0);
        Course course2 = new Course("Data Science", 12, 1200.0);
        
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();
        
        Course.updateInstituteName("Tech Academy");
        
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}
