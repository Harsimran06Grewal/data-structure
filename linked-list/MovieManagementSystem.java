//  doubly linked list
class Movie {
    // Attributes of movie class
    String title;  
    String director; 
    int year;  
    double rating;  
    Movie next;  // Pointer to the next movie in the list
    Movie prev;  // Pointer to the previous movie in the list

    // Constructor to initialize movie details
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
    private Movie head;  // First movie in the list
    private Movie tail;  // Last movie in the list

    // Method to add a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) { // If the list is empty
            head = tail = newMovie;
        } else {
            newMovie.next = head; // New movie points to current head
            head.prev = newMovie; // Old head points back to new movie
            head = newMovie; // Update head to the new movie
        }
    }

    // Method to add a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) { // If the list is empty
            head = tail = newMovie;
        } else {
            tail.next = newMovie; // Tail's next points to new movie
            newMovie.prev = tail; // New movie's previous points to old tail
            tail = newMovie; // Update tail to the new movie
        }
    }

    // Method to add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);

        // If inserting at the beginning, use the existing method
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next; // Traverse the list
        }

        // If position is at the end, use the existing method
        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
            return;
        }

        // Insert new movie between temp and temp.next
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Method to remove a movie by title
    public void removeMovie(String title) {
        if (head == null) return; // If list is empty, return

        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next; // Traverse the list
        }

        if (temp == null) return; // Movie not found

        // Adjust pointers to remove the node
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    // Method to search for a movie by director name
    public Movie searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) return temp; // If found, return the movie
            temp = temp.next;
        }
        return null; // Movie not found
    }

    // Method to search for a movie by rating
    public Movie searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) return temp; // If found, return the movie
            temp = temp.next;
        }
        return null; // Movie not found
    }

    // Method to update the rating of a specific movie
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating; // Update the rating
                return;
            }
            temp = temp.next;
        }
    }

    // Method to display the movies in forward order
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                               ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Method to display the movies in backward order
    public void displayBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                               ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding movies
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);

        // Display all movies in forward order
        System.out.println("Movies (Forward):");
        movieList.displayForward();

        // Updating a movie rating
        System.out.println("\nUpdating Rating for 'Interstellar':");
        movieList.updateRating("Interstellar", 8.9);
        movieList.displayForward();

        // Display movies in reverse order
        System.out.println("\nMovies (Backward):");
        movieList.displayBackward();

        // Removing a movie
        System.out.println("\nRemoving 'The Dark Knight':");
        movieList.removeMovie("The Dark Knight");
        movieList.displayForward();
    }
}
