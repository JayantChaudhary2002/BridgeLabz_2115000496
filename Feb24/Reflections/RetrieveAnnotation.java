import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
}

public class RetrieveAnnotation {
    public static void main(String[] args) {
        Author author = Book.class.getAnnotation(Author.class);
        System.out.println(author.name());
    }
}
