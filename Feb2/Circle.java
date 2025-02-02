import java.util.*;
class Circle{
	private double radius;
	public Circle(){
		this.radius=0.0;
	}
	public Circle(double radius){
		this.radius=radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getRadius() {
	        return radius;
    	}
	public void display() {
        	System.out.println("Radius of the circle: " + radius);
    	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Double radius=sc.nextDouble();
		Circle circle1 = new Circle();
        	System.out.println("Circle 1 Info:");
        	circle1.display();
        	Circle circle2 = new Circle(radius);
        	System.out.println("\nCircle 2 Info:");
        	circle2.display();
	}	
}

