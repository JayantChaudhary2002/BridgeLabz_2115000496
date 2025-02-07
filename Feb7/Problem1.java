class Animal{
	public String name;
	public int age;

	public Animal(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public void makeSound(){
		System.out.println("Animal is making sound");
	}
}
class Dog extends Animal{

	public Dog(String name,int age){
		super(name,age);
	}
	@Override
	public void makeSound(){
		System.out.println("The dog is barking.");
	}
}
class Cat extends Animal{

	public Cat(String name,int age){
		super(name,age);
	}
	@Override
	public void makeSound(){
		System.out.println("The cat is whisking.");
	}
}
class Bird extends Animal{

	public Bird(String name,int age){
		super(name,age);
	}
	@Override
	public void makeSound(){
		System.out.println("The bird is chirping.");
	}
}
public class Problem1{
	public static void main(String args[]){
		Animal dog=new Dog("Pete",4);
		dog.makeSound();
		Animal cat=new Cat("Meow",3);
		cat.makeSound();
		Animal bird=new Bird("Jack",5);
		bird.makeSound();
	}
}
