class Student{
	static String universityName;
	String name;
	int rollNumber;
	String grade;
	static int total=0;
	Student(String name,final int rollNumber, String grade){
		this.name=name;
		this.rollNumber=rollNumber;
		this.grade=grade;
		total++;
	}
	public static void displayTotalStudents(){
		System.out.println("Total number of students are:"+total);
	}
	public static void main(String args[]){
		Student object=new Student("Raj",46,"A");
		new Student("Rashmika",65,"A");
		if(object instanceof Student){
			System.out.println("Object is an instance of Student class");
		}
		else{
			System.out.println("Object is not an instance of Student class");
		}
		Student.displayTotalStudents();
	}
}
