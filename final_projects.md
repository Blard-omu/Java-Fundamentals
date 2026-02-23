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


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

interface Prioritizable {
    String getPriority();
}

class InvalidTaskException extends Exception {
    public InvalidTaskException(String message) {
        super(message);
    }
}

class Task implements Prioritizable {
    private String description, category, priority;
    private boolean isComplete;
    
    Task(String description, String category, String priority) throws InvalidTaskException {
        if (description.isEmpty() || category.isEmpty()) {
            throw new InvalidTaskException("Description and category cannot be empty");
        }
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.isComplete = false;
    }
    
    void markComplete() {
        isComplete = true;
        System.out.println("Task completed: " + description);
    }
    
    @Override
    public String getPriority() {
        return priority;
    }
    
    String getDescription() { return description; }
    String getCategory() { return category; }
    boolean isComplete() { return isComplete; }
    
    String toFileString() {
        return description + "," + category + "," + priority + "," + isComplete;
    }
    
    void display() {
        System.out.println("Task: " + description + ", Category: " + category + ", Priority: " + priority + ", Complete: " + isComplete);
    }
}

public class TaskManagementSystem {
    private ArrayList<Task> tasks;
    private HashMap<String, ArrayList<Task>> categories;
    
    TaskManagementSystem() {
        tasks = new ArrayList<>();
        categories = new HashMap<>();
    }
    
    void addTask(String description, String category, String priority) throws InvalidTaskException {
        Task task = new Task(description, category, priority);
        tasks.add(task);
        categories.computeIfAbsent(category, k -> new ArrayList<>()).add(task);
        System.out.println("Added task: " + description);
    }
    
    void markTaskComplete(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description) && !task.isComplete()) {
                task.markComplete();
                return;
            }
        }
        System.out.println("Task not found or already complete: " + description);
    }
    
    void displayTasksByCategory(String category) {
        ArrayList<Task> catTasks = categories.get(category);
        if (catTasks == null || catTasks.isEmpty()) {
            System.out.println("No tasks in category: " + category);
            return;
        }
        for (Task task : catTasks) {
            task.display();
        }
    }
    
    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            System.out.println("Tasks saved");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    
    void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Task task = new Task(parts[0], parts[1], parts[2]);
                    if (Boolean.parseBoolean(parts[3])) {
                        task.markComplete();
                    }
                    tasks.add(task);
                    categories.computeIfAbsent(parts[1], k -> new ArrayList<>()).add(task);
                }
            }
            System.out.println("Tasks loaded");
        } catch (IOException | InvalidTaskException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
    
    void listHighPriorityTasks() {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equals("High")) {
                task.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No high-priority tasks");
        }
    }
    
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        try {
            tms.loadFromFile();
            tms.addTask("Study Java", "Work", "High");
            tms.addTask("Buy groceries", "Personal", "Low");
            tms.markTaskComplete("Study Java");
            tms.displayTasksByCategory("Work");
            tms.listHighPriorityTasks();
            tms.saveToFile();
        } catch (InvalidTaskException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

interface Sellable {
    double getPrice();
}

abstract class Item {
    protected String id, name;
    
    Item(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    abstract void displayDetails();
}

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class Product extends Item implements Sellable {
    private double price;
    private int quantity;
    
    Product(String id, String name, double price, int quantity) throws InvalidProductException {
        super(id, name);
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative");
        }
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    void updateQuantity(int qty) throws InvalidProductException {
        if (qty < 0) {
            throw new InvalidProductException("Quantity cannot be negative");
        }
        this.quantity = qty;
    }
    
    @Override
    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }
    
    String toFileString() {
        return id + "," + name + "," + price + "," + quantity;
    }
}

public class InventoryManagementSystem {
    private HashMap<String, Product> products;
    private HashSet<String> categories;
    
    InventoryManagementSystem() {
        products = new HashMap<>();
        categories = new HashSet<>();
    }
    
    void addProduct(String id, String name, double price, int quantity, String category) throws InvalidProductException {
        if (id.isEmpty() || name.isEmpty()) {
            throw new InvalidProductException("ID and name cannot be empty");
        }
        products.put(id, new Product(id, name, price, quantity));
        categories.add(category);
        System.out.println("Added product: " + name);
    }
    
    void updateProductQuantity(String id, int quantity) throws InvalidProductException {
        if (!products.containsKey(id)) {
            throw new InvalidProductException("Product not found: " + id);
        }
        products.get(id).updateQuantity(quantity);
        System.out.println("Updated quantity for: " + id);
    }
    
    void displayProductsByCategory(String category) {
        boolean found = false;
        for (Product product : products.values()) {
            if (category.equals("All") || categories.contains(category)) {
                product.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products in category: " + category);
        }
    }
    
    double getTotalInventoryValue() {
        double total = 0;
        for (Product product : products.values()) {
            total += product.getPrice() * product.quantity;
        }
        return total;
    }
    
    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"))) {
            for (Product product : products.values()) {
                writer.write(product.toFileString());
                writer.newLine();
            }
            System.out.println("Inventory saved");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
    
    void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    products.put(parts[0], new Product(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
                }
            }
            System.out.println("Inventory loaded");
        } catch (IOException | InvalidProductException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        try {
            ims.loadFromFile();
            ims.addProduct("P001", "Laptop", 1200.0, 10, "Electronics");
            ims.addProduct("P002", "Pen", 1.5, 100, "Stationery");
            ims.updateProductQuantity("P001", 8);
            ims.displayProductsByCategory("Electronics");
            System.out.println("Total Inventory Value: $" + ims.getTotalInventoryValue());
            ims.saveToFile();
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Project Summaries and Concepts

#### final_project_001: Library Management System
- **Description**: Manages a library’s book inventory and borrowing system, with file-based persistence.
- **Features**:
  - Add/remove books, search by title/ID, borrow/return books, list loans, list borrowed books.
  - Saves books (`books.txt`) and loans (`loans.txt`) to files.
  - Validates book IDs and data.
- **Concepts**:
  - **OOP**: `Book` extends `Item` (abstract), implements `Borrowable` (interface).
  - **Collections**: `HashMap` for books, `ArrayList` for loans.
  - **File I/O**: `BufferedWriter`/`BufferedReader` for persistence.
  - **Exception Handling**: `InvalidBookException`, `IOException`.
  - **Polymorphism**: Uses `Borrowable` for borrowing actions.

#### final_project_002: Task Management System
- **Description**: A to-do list system to manage tasks, categorize them, and track completion.
- **Features**:
  - Add tasks with descriptions, categories, and priorities; mark tasks complete; filter by category; list high-priority tasks.
  - Saves tasks to `tasks.txt`.
  - Validates task data.
- **Concepts**:
  - **OOP**: `Task` implements `Prioritizable` (interface).
  - **Collections**: `ArrayList` for tasks, `HashMap` for categories.
  - **File I/O**: `BufferedWriter`/`BufferedReader` for persistence.
  - **Exception Handling**: `InvalidTaskException`, `IOException`.
  - **Polymorphism**: Uses `Prioritizable` for priority access.

#### final_project_003: Inventory Management System
- **Description**: Manages a store’s product inventory, tracking quantities and prices.
- **Features**:
  - Add/update products, display by category, calculate total inventory value.
  - Saves inventory to `inventory.txt`.
  - Validates product data.
- **Concepts**:
  - **OOP**: `Product` extends `Item` (abstract), implements `Sellable` (interface).
  - **Collections**: `HashMap` for products, `HashSet` for categories.
  - **File I/O**: `BufferedWriter`/`BufferedReader` for persistence.
  - **Exception Handling**: `InvalidProductException`, `IOException`.
  - **Polymorphism**: Uses `Sellable` for price access.

---

### How to Use These Projects
1. **Run Each Project**:
   - Copy each `.java` file into an IDE (e.g., IntelliJ, Eclipse) or compile/run via command line (`javac`, `java`).
   - Ensure `books.txt`, `loans.txt`, `tasks.txt`, and `inventory.txt` are in the same directory as the compiled classes.
2. **Test Cases**:
   - **Library**: Add books, borrow/return, search, check loans, and verify file persistence.
   - **Task**: Add tasks, mark complete, filter by category, check high-priority tasks, and verify file save/load.
   - **Inventory**: Add products, update quantities, display by category, check total value, and verify file persistence.
3. **Extend**:
   - **Library**: Add user management or due date tracking.
   - **Task**: Add deadlines or sort tasks by priority.
   - **Inventory**: Add sales tracking or low-stock alerts.

---

### Tips for Week 12
- **Practice**: Test each project incrementally, checking file I/O and exception handling.
- **Debug**: Watch for `IOException`, duplicate keys, or invalid inputs.
- **Resources**: Refer to Oracle’s Java Tutorials for file I/O and collections; Stack Overflow for debugging.
- **Experiment**: Add features like user interfaces (console menus) or additional validations.