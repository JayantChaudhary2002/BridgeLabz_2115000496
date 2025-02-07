class Book{
    String title;
    int publicationYear;
    public Book(String title, int publicationYear){
        this.title=title;
        this.publicationYear=publicationYear;
    }
    public void displayDetails(){
        System.out.println("title of the book is "+title);
        System.out.println("Publicatioin year of Book is "+publicationYear);

    }
}
class Author extends Book{
    String authorname;
    String bio;
    public Author(String title, int publicationYear, String authorname,String bio){
        super(title, publicationYear);
        this.authorname=authorname;
        this.bio=bio;
    }
    @Override
    public void displayDetails(){
        System.out.println("Name of the author is "+authorname);
        super.displayDetails();
        System.out.println("Bio of the book is "+bio);
    }


}
public class Q4_Library {
    public static void main(String[] args) {
        Author author=new Author("Dont care", 2025, "kanishk", "basic need");
        author.displayDetails();
    }
}
