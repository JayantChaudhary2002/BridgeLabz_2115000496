import java.util.*;
class Book{
	private String title;
        private String author;
	private double price;
        public Book(String title,String author,double price){
                this.title=title;
		this.author=author;
		this.price=price;
        }
        public void display(){
                System.out.println("Name of the book is:"+title);
                System.out.println("Author of the book is:"+author);
		System.out.println("Price of the book is:"+price);
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		String author=sc.nextLine();
                double price=sc.nextDouble();
                Book details=new Book(name,author,price);
                details.display();
        }
}
