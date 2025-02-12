class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private Movie head;
    private Movie tail;

    public MovieLinkedList() {
        head = null;
        tail = null;
    }

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current != null) {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
            if (newMovie.next == null) {
                tail = newMovie;
            }
        } else {
            System.out.println("Position not found.");
        }
    }

    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty.");
            return;
        }

        Movie current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie with title " + title + " not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
        }
        current = null;  // Help garbage collection
    }

    public Movie searchMovieByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Movie searchMovieByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateMovieRatingByTitle(String title, double rating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = rating;
                System.out.println("Updated rating for movie: " + current.title + " to " + rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title " + title + " not found.");
    }

    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class MovieSystem {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtEnd("Titanic", "James Cameron", 1997, 7.8);

        System.out.println("Movies in Forward Order:");
        movieList.displayMoviesForward();

        System.out.println("\nMovies in Reverse Order:");
        movieList.displayMoviesReverse();

        System.out.println("\nUpdating rating for 'Titanic'...");
        movieList.updateMovieRatingByTitle("Titanic", 8.0);

        System.out.println("\nMovies after rating update:");
        movieList.displayMoviesForward();

        System.out.println("\nSearching for movie by director 'Christopher Nolan'...");
        Movie movie = movieList.searchMovieByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("Found movie: " + movie.title);
        } else {
            System.out.println("Movie not found.");
        }

        System.out.println("\nRemoving movie 'Inception'...");
        movieList.removeMovieByTitle("Inception");

        System.out.println("\nMovies after removal:");
        movieList.displayMoviesForward();
    }
}
