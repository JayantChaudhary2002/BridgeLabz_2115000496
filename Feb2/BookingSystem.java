import java.util.*;
public class BookingSystem {
    	private String title;
    	private String author;
    	private double price;
    	private boolean isAvailable;
	public BookingSystem(String title, String author, double price, boolean isAvailable) {
        	this.title = title;
        	this.author = author;
        	this.price = price;
        	this.isAvailable = isAvailable;
    	}
	public String getTitle() {
        	return title;
    	}
	public void setTitle(String title) {
        	this.title = title;
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
	public boolean isAvailable() {
        	return isAvailable;
    	}
	public void setAvailable(boolean isAvailable) {
        	this.isAvailable = isAvailable;
    	}
	public String borrowBook() {
        	if (isAvailable) {
            		isAvailable = false;
            		return "You have successfully borrowed the book: " + title;
        	}
		else {
            		return "Sorry, the book '" + title + "' is not available at the moment.";
        	}
    	}
	public void returnBook() {
        	isAvailable = true;
    	}
	public String toString() {
        	return "Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + (isAvailable ? "Yes" : "No");
    	}	
    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		String author=sc.nextLine();
		double price=sc.nextDouble();
		Boolean isAvailable=sc.nextBoolean();
        	BookingSystem book1 = new BookingSystem(title, author, price, isAvailable);
        	System.out.println(book1);
        	System.out.println(book1.borrowBook());
        	System.out.println(book1);
        	System.out.println("After returning the book");
	        book1.returnBook();
        	System.out.println(book1);
    	}
}
