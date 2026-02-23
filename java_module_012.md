For **Week 12 - Module 012: Final Project and Review**, the final week of the 3-month Java fundamentals plan, the goal is to tie together all the concepts from Weeks 1-11 (variables, control flow, methods, OOP, collections, exception handling, file I/O, interfaces, and abstract classes) into a comprehensive project that showcases your skills. The final project should be engaging, challenging yet achievable, and allow you to apply everything you've learned while leaving room for creativity. Below, I'll propose **three project ideas** for the final week, each with a clear scope, features, and how they incorporate the course concepts. I'll also outline a detailed plan for one of them as the primary project, with the others as alternatives. Let me know if you want to focus on one or tweak the ideas!

---

## Project Ideas for Week 12

### 1. Library Management System (Primary Choice)
**Description**: A console-based application to manage a library’s book inventory, allowing users to add, remove, search, and borrow books, with data persistence using file I/O.

**Why Choose This?**
- Combines OOP (classes for books and users), collections (`HashMap` for book catalog, `ArrayList` for loans), file I/O (saving/loading data), exception handling (validating inputs), and interfaces/abstract classes (e.g., `Borrowable` interface).
- Practical and relatable, with clear real-world application.
- Scalable for adding features like user management or categories.

**Key Features**:
- Add, remove, and search books by title or ID.
- Track book borrowing and returns.
- Save book and loan data to files and load on startup.
- Validate inputs (e.g., unique book IDs, valid dates).
- Use interfaces for common behaviors and abstract classes for shared logic.

**Concepts Used**:
- OOP (classes, inheritance, polymorphism).
- Collections (`HashMap`, `ArrayList`, `HashSet`).
- File I/O (`BufferedReader`, `BufferedWriter`).
- Exception handling (custom exceptions, `IOException`).
- Interfaces (`Borrowable`) and abstract classes (`Item`).

### 2. Task Management System
**Description**: A console-based to-do list application to manage tasks, with features for adding, completing, and categorizing tasks, and saving them to a file.

**Why Choose This?**
- Emphasizes collections (`ArrayList` for tasks, `HashMap` for categories) and file I/O for persistence.
- Allows practicing exception handling for invalid task inputs.
- Interfaces for task prioritization and abstract classes for task types (e.g., `PersonalTask`, `WorkTask`).
- Simple yet extensible for features like deadlines or priorities.

**Key Features**:
- Add, edit, and delete tasks with descriptions and categories.
- Mark tasks as complete or incomplete.
- Save tasks to a file and load them.
- Validate task data (e.g., non-empty descriptions).
- Filter tasks by category or status.

**Concepts Used**:
- OOP (classes, inheritance).
- Collections (`ArrayList`, `HashMap`).
- File I/O (`Files`, `BufferedWriter`).
- Exception handling (`IllegalArgumentException`, `IOException`).
- Interfaces and abstract classes.

### 3. Inventory Management System
**Description**: A console-based system to manage a store’s inventory, tracking products, quantities, and prices, with file-based persistence.

**Why Choose This?**
- Strong focus on collections (`HashMap` for products, `HashSet` for categories) and file I/O.
- Integrates exception handling for invalid quantities or prices.
- Uses interfaces for product actions (e.g., `Sellable`) and abstract classes for product types.
- Encourages data validation and error handling.

**Key Features**:
- Add, update, and remove products.
- Track stock levels and calculate total inventory value.
- Save/load inventory to/from a file.
- Validate product data (e.g., positive quantities).
- Search products by name or category.

**Concepts Used**:
- OOP (classes, polymorphism).
- Collections (`HashMap`, `HashSet`).
- File I/O (`BufferedReader`, `BufferedWriter`).
- Exception handling (custom exceptions).
- Interfaces and abstract classes.

---

## Detailed Plan for Primary Project: Library Management System

### Project Overview
The **Library Management System** is a console-based application that allows a librarian to manage a collection of books and track borrowing by users. It uses a `HashMap` to store books (key: book ID, value: `Book` object), an `ArrayList` for loan records, and file I/O to save and load data. It incorporates interfaces (`Borrowable`), abstract classes (`Item`), and robust exception handling.

### Requirements
1. **Book Management**:
   - Add a book (title, author, ID).
   - Remove a book by ID.
   - Search for books by title or ID.
2. **Borrowing System**:
   - Borrow a book (track user and book).
   - Return a book.
   - Display all loans.
3. **Data Persistence**:
   - Save books and loans to files.
   - Load data from files on startup.
4. **Validation**:
   - Ensure unique book IDs.
   - Validate book titles/authors (non-empty).
   - Handle invalid file operations.
5. **OOP Design**:
   - Use an interface `Borrowable` for borrowing actions.
   - Use an abstract class `Item` for shared book properties.
   - Use polymorphism for flexible method calls.

### Project Structure
- **Classes**:
  - `Item` (abstract): Base class for library items with fields `id`, `title`.
  - `Book` (extends `Item`, implements `Borrowable`): Represents a book with `author` and borrowing status.
  - `Loan`: Tracks a book borrowing (book ID, user name, date).
  - `Library`: Manages books (`HashMap`) and loans (`ArrayList`), with file I/O.
- **Files**:
  - `books.txt`: Stores book data (e.g., `id,title,author,isBorrowed`).
  - `loans.txt`: Stores loan data (e.g., `bookId,user,date`).
- **Exceptions**:
  - `InvalidBookException`: For invalid book data.
  - `IOException`: For file operations.

### Project Code
```java
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

public class Library {
    private HashMap<String, Book> books;
    private ArrayList<Loan> loans;
    
    Library() {
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
    
    public static void main(String[] args) {
        Library library = new Library();
        try {
            library.loadFromFile();
            library.addBook("B001", "Java Basics", "John Doe");
            library.addBook("B002", "OOP Guide", "Jane Smith");
            library.borrowBook("B001", "Alice", "2025-09-02");
            library.searchBook("Java");
            library.displayLoans();
            library.saveToFile();
        } catch (InvalidBookException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Project Breakdown
- **Day 1**: Set up `Item` (abstract), `Book` (extends `Item`, implements `Borrowable`), and `Loan` classes.
- **Day 2**: Implement `Library` class with `addBook`, `removeBook`, and `searchBook` using `HashMap`.
- **Day 3**: Add borrowing functionality (`borrowBook`, `returnBook`, `displayLoans`) with `ArrayList`.
- **Day 4**: Implement file I/O (`saveToFile`, `loadFromFile`) with exception handling.
- **Day 5**: Test the system, add validation, and debug.

### Weekend Practice
1. Run and test with various books and loans.
2. Add a method to find all borrowed books.
3. Extend to support user management (e.g., store user details in a `HashMap`).

**Extended Practice Code** (with borrowed books):
```java
import java.util.HashMap;

interface Borrowable {
    void borrow(String user);
    boolean isBorrowed();
}

abstract class Item {
    protected String id;
    
    Item(String id) {
        this.id = id;
    }
}

class Book extends Item implements Borrowable {
    private boolean isBorrowed;
    
    Book(String id) {
        super(id);
        this.isBorrowed = false;
    }
    
    @Override
    public void borrow(String user) {
        isBorrowed = true;
    }
    
    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }
}

public class ExtendedLibrary {
    private HashMap<String, Book> books;
    
    ExtendedLibrary() {
        books = new HashMap<>();
    }
    
    void addBook(String id) {
        books.put(id, new Book(id));
    }
    
    void listBorrowedBooks() {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.isBorrowed()) {
                System.out.println("Borrowed Book ID: " + book.id);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No borrowed books");
        }
    }
    
    public static void main(String[] args) {
        ExtendedLibrary library = new ExtendedLibrary();
        library.addBook("B001");
        library.books.get("B001").borrow("Alice");
        library.listBorrowedBooks();
    }
}
```

---

## Alternative Project Plans

### Task Management System
- **Classes**: `Task` (implements `Prioritizable`), `TaskManager` (uses `ArrayList` and `HashMap`).
- **Features**: Add/edit tasks, categorize, mark complete, save to file.
- **Day Breakdown**:
  - Day 1: `Task` class and `Prioritizable` interface.
  - Day 2: `TaskManager` with `ArrayList` for tasks.
  - Day 3: Categorize tasks with `HashMap`.
  - Day 4: File I/O for persistence.
  - Day 5: Test and add validation.
- **Concepts**: OOP, collections, file I/O, interfaces, exception handling.

### Inventory Management System
- **Classes**: `Product` (extends `Item`, implements `Sellable`), `Inventory` (uses `HashMap`).
- **Features**: Add/update products, track stock, calculate total value, save to file.
- **Day Breakdown**:
  - Day 1: `Product` and `Sellable` interface.
  - Day 2: `Inventory` with `HashMap`.
  - Day 3: Stock tracking and validation.
  - Day 4: File I/O for persistence.
  - Day 5: Test and add search functionality.
- **Concepts**: OOP, collections, file I/O, interfaces, abstract classes.

---

## Why Library Management System?
- **Comprehensive**: Uses all major concepts from the course.
- **Engaging**: Mimics a real-world system with clear user interactions.
- **Extensible**: Easy to add features like user accounts or categories.
- **Challenging**: Combines file I/O, collections, and OOP in a cohesive way.

## Tips for Week 12
- **Practice**: Test the project incrementally each day.
- **Debug**: Watch for file I/O errors, duplicate keys, or unhandled exceptions.
- **Resources**: Use Oracle’s Java Tutorials for file I/O and collections; Stack Overflow for debugging.
- **Experiment**: Add features like book categories or due dates to stretch your skills.