class Employee{
        static String companyName;
        String name;
        final int id;
	String designation;
	static int count=0;
        Employee(String name, int id, String designation){
                this.name=name;
                this.id=id;
                this.designation=designation;
		++count;
        }
        public static void displayTotalEmployees(){
                System.out.println("Total Employees are:" +count);
        }
        public static void main(String args[]){
                Employee object=new Employee("Robert", 456281,"IT");
                new Employee("Rick", 127193,"HR");
                if(object instanceof Employee){
                        System.out.println("object is an instance of the Employee");
                }
                Employee.displayTotalEmployees();
        }
}
