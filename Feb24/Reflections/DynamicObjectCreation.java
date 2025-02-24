class Student {
    public Student() {
        System.out.println("Student object created");
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Student student = (Student) Class.forName("Student").getDeclaredConstructor().newInstance();
    }
}
