// doubly linked list
class Book {
    // Attributes of Book class
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable; 
    Book next; // Pointer to the next book
    Book prev; // Pointer to the previous book

    // Constructor to initialize book details
    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head; // Points to the first book in the list
    private Book tail; // Points to the last book in the list
    private int totalBooks; //total number of books

    // Method to add a new book at the beginning of the list
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) { // If the list is empty, set head and tail to new book
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook; // Update head to new book
        }
        totalBooks++;
    }

    // Method to add a new book at the end of the list
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) { // If the list is empty
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook; // Update tail to new book
        }
        totalBooks++;
    }

    // Method to add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }
        newBook.next = temp.next;
        temp.next.prev = newBook;
        temp.next = newBook;
        newBook.prev = temp;
        totalBooks++;
    }

    // Method to remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) return;

        Book temp = head;

        // If the book to remove is at the head
        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            totalBooks--;
            return;
        }

        // Traverse the list to find the book
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        // If book not found
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        // Update pointers to remove the book
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev; // Update tail if last book is removed

        totalBooks--;
    }

    // Method to search for a book by Title
    public Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to search for a book by Author
    public Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to update a book’s availability status by Book ID
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Method to display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        System.out.println("Books in Library (Forward Order):");
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Method to display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        System.out.println("Books in Library (Reverse Order):");
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Method to count the total number of books
    public int countTotalBooks() {
        return totalBooks;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addBookAtBeginning("1984", "George Orwell", "Dystopian", 103, false);
        library.addBookAtPosition("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        // Display books in forward order
        library.displayBooksForward();

        // Searching for a book
        System.out.println("\nSearching for '1984':");
        Book foundBook = library.searchByTitle("1984");
        if (foundBook != null) {
            System.out.println("Found -> Title: " + foundBook.title + ", Author: " + foundBook.author + ", Available: " + foundBook.isAvailable);
        }

        // Updating book availability
        System.out.println("\nUpdating availability of Book ID 103:");
        library.updateAvailability(103, true);
        library.displayBooksForward();

        // Counting total books
        System.out.println("\nTotal Books in Library: " + library.countTotalBooks());

        // Removing a book
        System.out.println("\nRemoving Book with ID 102:");
        library.removeBook(102);
        library.displayBooksForward();

        // Displaying books in reverse order
        System.out.println("\nDisplaying books in reverse order:");
        library.displayBooksReverse();
    }
}
