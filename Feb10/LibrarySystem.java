abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem {
    private int loanDuration;

    public Book(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration;
    }
}

class Magazine extends LibraryItem {
    private int loanDuration;

    public Magazine(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration;
    }
}

class DVD extends LibraryItem {
    private int loanDuration;

    public DVD(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration;
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class ReservableBook extends Book implements Reservable {
    private boolean isReserved;

    public ReservableBook(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author, loanDuration);
        this.isReserved = false;
    }

    @Override
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("The book " + getTitle() + " has been reserved.");
        } else {
            System.out.println("The book " + getTitle() + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class ReservableMagazine extends Magazine implements Reservable {
    private boolean isReserved;

    public ReservableMagazine(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author, loanDuration);
        this.isReserved = false;
    }

    @Override
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("The magazine " + getTitle() + " has been reserved.");
        } else {
            System.out.println("The magazine " + getTitle() + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class ReservableDVD extends DVD implements Reservable {
    private boolean isReserved;

    public ReservableDVD(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author, loanDuration);
        this.isReserved = false;
    }

    @Override
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("The DVD " + getTitle() + " has been reserved.");
        } else {
            System.out.println("The DVD " + getTitle() + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 14);
        LibraryItem magazine = new Magazine("M001", "National Geographic", "Various", 7);
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan", 3);

        System.out.println(book.getItemDetails());
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
        System.out.println();

        System.out.println(magazine.getItemDetails());
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");
        System.out.println();

        System.out.println(dvd.getItemDetails());
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
        System.out.println();

        Reservable reservableBook = new ReservableBook("B001", "The Great Gatsby", "F. Scott Fitzgerald", 14);
        Reservable reservableMagazine = new ReservableMagazine("M001", "National Geographic", "Various", 7);
        Reservable reservableDVD = new ReservableDVD("D001", "Inception", "Christopher Nolan", 3);

        System.out.println("Checking availability of the book: " + ((ReservableBook) reservableBook).checkAvailability());
        reservableBook.reserveItem();
        reservableBook.reserveItem();  // Trying to reserve again
        System.out.println("Checking availability of the book: " + ((ReservableBook) reservableBook).checkAvailability());
        
        System.out.println("Checking availability of the magazine: " + ((ReservableMagazine) reservableMagazine).checkAvailability());
        reservableMagazine.reserveItem();
        
        System.out.println("Checking availability of the DVD: " + ((ReservableDVD) reservableDVD).checkAvailability());
        reservableDVD.reserveItem();
    }
}
