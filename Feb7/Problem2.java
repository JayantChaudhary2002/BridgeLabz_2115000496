class Employee{
        public String name;
        public int id;
	public double salary;

        public Employee(String name, int id, double salary){
                this.name=name;
                this.id=id;
		this.salary=salary;
        }

        public void displayDetails(){
                System.out.println("Name of the employee is:"+name);
		System.out.println("Id of the employee is:"+id);
		System.out.println("Salary of the employee is:"+salary);
        }
}
class Manager extends Employee{

	int teamSize;
        public Manager(String name,int id, double salary, int teamSize){
                super(name,id,salary);
		this.teamSize=teamSize;
        }
        @Override
        public void displayDetails(){
		super.displayDetails();
		System.out.println("Team Size handled by the manager:"+teamSize);                
        }
}
class Developer extends Employee{

	String programmingLanguage;
        public Developer(String name,int id,double salary,String programmingLanguage){
                super(name,id,salary);
		this.programmingLanguage=programmingLanguage;
        }
        @Override
        public void displayDetails(){
		super.displayDetails();
		System.out.println("Programming Language used by the developer:"+programmingLanguage);                
        }
}
class Intern extends Employee{
	String timePeriod;
        public Intern(String name,int id,double salary,String timePeriod){
                super(name,id,salary);
		this.timePeriod=timePeriod;
        }
        @Override
        public void displayDetails(){
                super.displayDetails();
                System.out.println("Time Period of intern:"+timePeriod);
        }

}
public class Problem2{
        public static void main(String args[]){
                Employee emp1=new Manager("Pete",1001,50000.00,25);
                emp1.displayDetails();
                Employee emp2=new Developer("Raj",1000,45000.00,"Java");
                emp2.displayDetails();
		Employee emp3=new Intern("Mia",1003,25000.00,"Three Months");
                emp3.displayDetails();
        }
}
