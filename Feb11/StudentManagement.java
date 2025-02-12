class Student{
	int rollNo;
	String name;
	int age;
	String grade;
	Student next;
	public Student(int rollNo, String name, int age, String grade){
		this.rollNo=rollNo;
		this.name=name;
		this.age=age;
		this.grade=grade;
		this.next=null;
	}
}
class StudentLinkedList{
	private Student head;
	public StudentLinkedList(){
		head=null;
	}
	public void addStudentAtBeginning(int rollNo, String name, int age,String grade){
		Student newStudent=new Student(rollNo, name, age, grade);
		newStudent.next=head;
		head=newStudent;
	}
	public void addStudentAtEnd(int rollNo, String name, int age, String grade){
		Student newStudent=new Student(rollNo, name, age, grade);
		if(head==null){
			head=newStudent;
			return;
		}
		Student current=head;
		while(current.next!=null){
			current=current.next;
		}
		current.next=newStudent;
	}
	public void addStudentAtPosition(int rollNo, String name, int age, String grade, int position){
		Student newStudent=new Student(rollNo, name, age, grade);
		Student current=head;
		while(current!=null && current.rollNo != position){
			current=current.next;
		}
		if(current!=null){
			newStudent.next=current.next;
			current.next=newStudent;
		}
		else{
			System.out.println("Position not found");
		}
	}
	public void deleteByRollNo(int rollNo){
		if(head==null){
			System.out.println("Employee list is empty");
			return;
		}
		if(head.rollNo==rollNo){
			head=head.next;
			return;
		}
		Student current=head;
		Student previous=null;
		while(current!=null && current.rollNo!=rollNo){
			previous=current;
			current=current.next;
		}
		if(current == null){
			System.out.println("Student with roll number "+rollNo+" not found");
			return;
		}
		previous.next=current.next;
	}
	public Student searchStudentByRollNo(int rollNo){
		Student current=head;
		while(current!=null){
			if(current.rollNo == rollNo){
				return current;	
			}
			current=current.next;
		}
		return null;
	}
	public void displayStudents(){
		if(head==null){
			System.out.println("Student list is Empty");
			return;
		}
		Student current=head;
		while(current!=null){
			System.out.println("RollNo: "+current.rollNo+",Name: "+current.name+",Age: "+current.age+",Grade: "+current.grade);
			current=current.next;
		}
	}
	public void updateGradeByRollNo(int rollNo, String grade){
		Student current=head;
		while(current!=null){
			if(current.rollNo == rollNo){
				current.grade=grade;
				System.out.println("Updated grade for "+current.name+" (Roll No: "+rollNo + ")to: "+current.grade);
				return;
			}
		current=current.next;
		}
		System.out.println("Student with roll number "+rollNo+" not found");
	}
}
public class StudentManagement{
	public static void main(String args[]){
		StudentLinkedList studentList=new StudentLinkedList();

		studentList.addStudentAtBeginning(101,"Raj",20,"A+");
		studentList.addStudentAtEnd(102,"Riya",21,"B+");
		studentList.addStudentAtEnd(103,"Rudra",23,"A");

		System.out.println("ALl Student Records:");
		studentList.displayStudents();

		System.out.println("\nUpdating grade for student with roll number 102");
		studentList.updateGradeByRollNo(102,"O");

		studentList.displayStudents();
		System.out.println("\nSearching for student with Roll No 101...");
	        Student foundStudent = studentList.searchStudentByRollNo(101);
        	if (foundStudent != null) {
            		System.out.println("Found Student: " + foundStudent.name);
        	} else {
            		System.out.println("Student not found.");
        	}

                System.out.println("\nDeleting student with Roll No 101...");
        	studentList.deleteByRollNo(101);

                System.out.println("\nRemaining Student Records:");
        	studentList.displayStudents();
	}
}
