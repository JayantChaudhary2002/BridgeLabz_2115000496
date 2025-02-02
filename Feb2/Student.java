class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA! Must be between 0.0 and 10.0.");
        }
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 8.5);
        s1.displayDetails();
        s1.setCGPA(9.0);

        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Bob", 9.2, "Artificial Intelligence");
        pg1.displayPostgraduateDetails();

        System.out.println("Roll Number (Public): " + pg1.rollNumber);
    }
}

class PostgraduateStudent extends Student {
    private String thesisTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTopic) {
        super(rollNumber, name, CGPA);
        this.thesisTopic = thesisTopic;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student: " + name);
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}
