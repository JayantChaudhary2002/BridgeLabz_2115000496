import java.util.*;
class Person{
    	private String name;
    	private int age;
    	public Person(String name, int age){
        	this.name = name;
        	this.age = age;
    	}
	public Person(Person other) {
        	this.name = other.name;
        	this.age = other.age;
    	}
	public String getName() {
        	return name;
    	}
	public int getAge() {
        	return age;
    	}
	public void displayPerson() {
        	System.out.println("Name of the person is: " + name);
        	System.out.println("Age of the person is: " + age);
        }
    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int age=sc.nextInt();
        	Person person1 = new Person(name,age);
        	Person person2 = new Person(person1);
		System.out.println("Original Person:");
        	person1.displayPerson();
		System.out.println("\nCopied Person:");
        	person2.displayPerson();
    	}
}
