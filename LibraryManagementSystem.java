import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

interface Borrowable {
    void borrow(String user);
    void returnBook();
    boolean isBorrowed();
}

abstract class Item {
    protected String id, title;
    
    Item(String id, String title) {
        this.id = id;
        this.title = title;
    }
    
    abstract void displayDetails();
}

class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}

class Book extends Item implements Borrowable {
    private String author;
    private boolean isBorrowed;
    
    Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
        this.isBorrowed = false;
    }
    
    @Override
    public void borrow(String user) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book already borrowed");
        }
    }
    
    @Override
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned: " + title);
        }
    }
    
    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    @Override
    void displayDetails() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed);
    }
    
    String toFileString() {
        return id + "," + title + "," + author + "," + isBorrowed;
    }
}

class Loan {
    private String bookId, user, date;
    
    Loan(String bookId, String user, String date) {
        this.bookId = bookId;
        this.user = user;
        this.date = date;
    }
    
    String toFileString() {
        return bookId + "," + user + "," + date;
    }
    
    void display() {
        System.out.println("Loan: Book ID " + bookId + ", User: " + user + ", Date: " + date);
    }
}

public class LibraryManagementSystem {
    private HashMap<String, Book> books;
    private ArrayList<Loan> loans;
    
    LibraryManagementSystem() {
        books = new HashMap<>();
        loans = new ArrayList<>();
    }
    
    void addBook(String id, String title, String author) throws InvalidBookException {
        if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
            throw new InvalidBookException("Book details cannot be empty");
        }
        if (books.containsKey(id)) {
            throw new InvalidBookException("Book ID already exists");
        }
        books.put(id, new Book(id, title, author));
        System.out.println("Added book: " + title);
    }
    
    void removeBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("Removed book: " + id);
        } else {
            System.out.println("Book not found: " + id);
        }
    }
    
    void borrowBook(String id, String user, String date) throws InvalidBookException {
        if (!books.containsKey(id)) {
            throw new InvalidBookException("Book not found: " + id);
        }
        books.get(id).borrow(user);
        loans.add(new Loan(id, user, date));
    }
    
    void returnBook(String id) throws InvalidBookException {
        if (!books.containsKey(id)) {
            throw new InvalidBookException("Book not found: " + id);
        }
        books.get(id).returnBook();
    }
    
    void searchBook(String query) {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.title.contains(query) || book.id.equals(query)) {
                book.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for: " + query);
        }
    }
    
    void displayLoans() {
        if (loans.isEmpty()) {
            System.out.println("No loans");
            return;
        }
        for (Loan loan : loans) {
            loan.display();
        }
    }
    
    void saveToFile() {
        try (BufferedWriter bookWriter = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books.values()) {
                bookWriter.write(book.toFileString());
                bookWriter.newLine();
            }
            System.out.println("Books saved");
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
        
        try (BufferedWriter loanWriter = new BufferedWriter(new FileWriter("loans.txt"))) {
            for (Loan loan : loans) {
                loanWriter.write(loan.toFileString());
                loanWriter.newLine();
            }
            System.out.println("Loans saved");
        } catch (IOException e) {
            System.out.println("Error saving loans: " + e.getMessage());
        }
    }
    
    void loadFromFile() {
        try (BufferedReader bookReader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = bookReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    if (Boolean.parseBoolean(parts[3])) {
                        book.borrow("Unknown");
                    }
                    books.put(parts[0], book);
                }
            }
            System.out.println("Books loaded");
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        
        try (BufferedReader loanReader = new BufferedReader(new FileReader("loans.txt"))) {
            String line;
            while ((line = loanReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    loans.add(new Loan(parts[0], parts[1], parts[2]));
                }
            }
            System.out.println("Loans loaded");
        } catch (IOException e) {
            System.out.println("Error loading loans: " + e.getMessage());
        }
    }
    
    void listBorrowedBooks() {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.isBorrowed()) {
                book.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are borrowed");
        }
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        try {
            library.loadFromFile();
            library.addBook("B001", "Java Basics", "John Doe");
            library.addBook("B002", "OOP Guide", "Jane Smith");
            library.borrowBook("B001", "Alice", "2025-09-02");
            library.searchBook("Java");
            library.displayLoans();
            library.listBorrowedBooks();
            library.saveToFile();
        } catch (InvalidBookException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}