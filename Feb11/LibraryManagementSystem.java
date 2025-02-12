class Book {
    String title;
    String author;
    String genre;
    int bookId;
    String availability;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, String availability) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;
    int count;

    public Library() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void addBookAtBeginning(String title, String author, String genre, int bookId, String availability) {
        Book newBook = new Book(title, author, genre, bookId, availability);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, String availability) {
        Book newBook = new Book(title, author, genre, bookId, availability);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, String availability) {
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, availability);
        } else if (position == count + 1) {
            addBookAtEnd(title, author, genre, bookId, availability);
        } else {
            Book newBook = new Book(title, author, genre, bookId, availability);
            Book current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
            count++;
        }
    }

    public void removeBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                }
                count--;
                return;
            }
            current = current.next;
        }
        System.out.println("Book with the given ID not found.");
    }

    public void searchBook(String keyword) {
        Book current = head;
        while (current != null) {
            if (current.title.toLowerCase().contains(keyword.toLowerCase()) || current.author.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Book found: " + current.title + ", " + current.author + ", " + current.genre + ", ID: " + current.bookId + ", Available: " + current.availability);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(int bookId, String status) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availability = status;
                System.out.println("Book status updated: " + current.title + " - " + status);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with the given ID not found.");
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + current.availability);
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + current.availability);
            current = current.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("Book 1", "Author 1", "Fiction", 101, "Available");
        library.addBookAtEnd("Book 2", "Author 2", "Science", 102, "Not Available");
        library.addBookAtBeginning("Book 3", "Author 3", "History", 103, "Available");
        library.addBookAtPosition(2, "Book 4", "Author 4", "Technology", 104, "Available");

        System.out.println("Books in forward order:");
        library.displayBooksForward();

        System.out.println("\nBooks in reverse order:");
        library.displayBooksReverse();

        System.out.println("\nSearching for 'Author 2':");
        library.searchBook("Author 2");

        System.out.println("\nUpdating availability for Book 102:");
        library.updateAvailability(102, "Available");

        library.countBooks();

        System.out.println("\nRemoving Book with ID 101:");
        library.removeBookById(101);
        library.displayBooksForward();
    }
}
