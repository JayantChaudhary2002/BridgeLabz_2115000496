class Book1 {
    public String ISBN;
    protected String title;
    private String author;

    public Book1(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        Book1 b1 = new Book1("123-456", "Java Programming", "John Doe");
        System.out.println("Author: " + b1.getAuthor());
        b1.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + b1.getAuthor());

        EBook e1 = new EBook("789-101", "Advanced Java", "Alice Smith", "PDF");
        e1.displayEBookDetails();
    }
}

class EBook extends Book1 {
    private String format;

    public EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Format: " + format);
    }
}
