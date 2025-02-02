import java.util.*;
class Book{
	private String title;
	private String author;
	private double price;
	public Book(){
		this.title="Unknown";
		this.author="Unknown";
		this.price=0.0;
	}
	public Book(String title,String author,double price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getAuthor() {
	        return author;
    	}
	public void setAuthor(String author) {
        	this.author = author;
    	}
	public double getPrice() {
        	return price;
    	}
	public void setPrice(double price) {
        	this.price = price;
        }
	public void displayBookInfo() {
        	System.out.println("Title of the book: " + title);
        	System.out.println("Author of the book: " + author);
        	System.out.println("Price of the book: " + price);
    	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		String author=sc.nextLine();
		Double price=sc.nextDouble();
		Book book1 = new Book();
        	System.out.println("Book 1 Info:");
        	book1.displayBookInfo();
        	Book book2 = new Book(title,author,price);
        	System.out.println("\nBook 2 Info:");
        	book2.displayBookInfo();
        	Book book3 = new Book(title,author,price);
        	book3.setPrice(1400);
        	System.out.println("\nBook 3 Info after price update:");
        	book3.displayBookInfo();
	}	
}
