import java.util.*;
class Circle{
        private double radius;
        public Circle(double radius){
                this.radius=radius;
        }
	public double area(double radius){
		return 3.14*radius*radius;
	}
	public double circumference(double radius){
		return 2*3.14*radius;
	}
        public void display(){
                System.out.println("Area of the circle is:"+area(radius));
                System.out.println("Circumference is:"+circumference(radius));
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                double radius=sc.nextDouble();
                Circle details=new Circle(radius);
                details.area(radius);
		details.circumference(radius);
		details.display();
        }
}
