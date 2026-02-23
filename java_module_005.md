# Java Module 005: Week 5 - Classes and Objects

This module introduces Object-Oriented Programming (OOP) in Java, focusing on classes, objects, constructors, encapsulation, and the `this` keyword. Designed for beginners building on Weeks 1-4 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 5. The module concludes with a console-based Library Management System mini-project to apply these concepts.

---

## Day 1: Classes, Objects, and Attributes
**Objective**: Learn to create classes, instantiate objects, and define attributes.

### Explanation
- **Class**: A blueprint for objects, defining properties (attributes) and behaviors (methods).
  - Syntax: `class ClassName { // attributes and methods }`
- **Object**: An instance of a class, created using the `new` keyword.
  - Example: `ClassName obj = new ClassName();`
- **Attributes**: Variables defined in a class (e.g., `String name; int age;`).
- Access attributes using dot notation (e.g., `obj.name`).

### Code Examples
**Example 1: Basic Class and Object**
```java
public class Student {
    // Attributes
    String name;
    int age;
    
    public static void main(String[] args) {
        // Create object
        Student student1 = new Student();
        student1.name = "Alice";
        student1.age = 20;
        
        System.out.println("Name: " + student1.name + ", Age: " + student1.age);
    }
}
```

**Example 2: Class with Method**
```java
public class Car {
    String brand;
    int speed;
    
    void displayInfo() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
    
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.speed = 120;
        car1.displayInfo();
    }
}
```

**Example 3: Multiple Objects**
```java
public class Book {
    String title;
    String author;
    
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java Basics";
        book1.author = "John Doe";
        
        Book book2 = new Book();
        book2.title = "OOP Guide";
        book2.author = "Jane Smith";
        
        System.out.println("Book 1: " + book1.title + " by " + book1.author);
        System.out.println("Book 2: " + book2.title + " by " + book2.author);
    }
}
```

### Practice
1. Create a `Person` class with attributes `name` (`String`) and `height` (`double`); instantiate an object and set values.
2. Add a method to the `Person` class to print details.
3. Create two objects of a `Product` class with attributes `name` and `price`, then print their details.

**Practice Code**:
```java
public class PersonPractice {
    String name;
    double height;
    
    void printDetails() {
        System.out.println("Name: " + name + ", Height: " + height + " meters");
    }
    
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Bob";
        person1.height = 1.75;
        person1.printDetails();
    }
}
```

---

## Day 2: Constructors
**Objective**: Understand and use constructors to initialize objects.

### Explanation
- **Constructor**: A special method called when an object is created, used to initialize attributes.
  - Same name as the class, no return type.
  - **Default Constructor**: No parameters, provided by Java if none defined.
  - **Parameterized Constructor**: Takes parameters to set initial values.
- Syntax: `ClassName(parameters) { // initialize attributes }`

### Code Examples
**Example 1: Default Constructor**
```java
public class Dog {
    String name;
    int age;
    
    // Default constructor
    Dog() {
        name = "Unknown";
        age = 0;
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println("Name: " + dog.name + ", Age: " + dog.age);
    }
}
```

**Example 2: Parameterized Constructor**
```java
public class Employee {
    String name;
    int id;
    
    // Parameterized constructor
    Employee(String empName, int empId) {
        name = empName;
        id = empId;
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101);
        System.out.println("Employee: " + emp.name + ", ID: " + emp.id);
    }
}
```

**Example 3: Multiple Constructors**
```java
public class Rectangle {
    double length;
    double width;
    
    // Default constructor
    Rectangle() {
        length = 1.0;
        width = 1.0;
    }
    
    // Parameterized constructor
    Rectangle(double l, double w) {
        length = l;
        width = w;
    }
    
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        System.out.println("Rect1: " + rect1.length + " x " + rect1.width);
        System.out.println("Rect2: " + rect2.length + " x " + rect2.width);
    }
}
```

### Practice
1. Create a `Laptop` class with attributes `brand` and `price`; add a default constructor.
2. Add a parameterized constructor to initialize `brand` and `price`.
3. Write a program to create two `Laptop` objects using both constructors and print their details.

**Practice Code**:
```java
public class LaptopPractice {
    String brand;
    double price;
    
    LaptopPractice() {
        brand = "Generic";
        price = 500.0;
    }
    
    LaptopPractice(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
    
    public static void main(String[] args) {
        LaptopPractice laptop1 = new LaptopPractice();
        LaptopPractice laptop2 = new LaptopPractice("Dell", 1200.0);
        System.out.println("Laptop1: " + laptop1.brand + ", $" + laptop1.price);
        System.out.println("Laptop2: " + laptop2.brand + ", $" + laptop2.price);
    }
}
```

---

## Day 3: `this` Keyword
**Objective**: Use the `this` keyword to refer to instance variables.

### Explanation
- **`this` Keyword**: Refers to the current object, used to distinguish instance variables from parameters or local variables with the same name.
- Common use: In constructors or methods to assign parameter values to instance variables.
- Example: `this.name = name;` (instance variable = parameter).

### Code Examples
**Example 1: Using `this` in Constructor**
```java
public class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name; // Differentiates instance variable from parameter
        this.age = age;
    }
    
    public static void main(String[] args) {
        Person person = new Person("Charlie", 30);
        System.out.println("Name: " + person.name + ", Age: " + person.age);
    }
}
```

**Example 2: `this` in Method**
```java
public class Car {
    String model;
    
    void setModel(String model) {
        this.model = model; // Clarifies instance variable
        System.out.println("Model set to: " + this.model);
    }
    
    public static void main(String[] args) {
        Car car = new Car();
        car.setModel("Honda");
    }
}
```

**Example 3: `this` with Multiple Constructors**
```java
public class Box {
    double length;
    double width;
    
    Box() {
        this(1.0, 1.0); // Calls parameterized constructor
    }
    
    Box(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(4.0, 3.0);
        System.out.println("Box1: " + box1.length + " x " + box1.width);
        System.out.println("Box2: " + box2.length + " x " + box2.width);
    }
}
```

### Practice
1. Create a `Student` class with `name` and `grade`; use `this` in a constructor.
2. Add a method to the `Student` class that uses `this` to update the grade.
3. Write a class with two constructors, one calling the other using `this`.

**Practice Code**:
```java
public class StudentPractice {
    String name;
    int grade;
    
    StudentPractice(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    void updateGrade(int grade) {
        this.grade = grade;
        System.out.println(this.name + "'s new grade: " + this.grade);
    }
    
    public static void main(String[] args) {
        StudentPractice student = new StudentPractice("Eve", 85);
        student.updateGrade(90);
    }
}
```

---

## Day 4: Encapsulation with Getters/Setters
**Objective**: Implement encapsulation using private fields and public getters/setters.

### Explanation
- **Encapsulation**: Hides class data (attributes) and provides controlled access via methods.
- **Private Fields**: Use `private` access modifier to restrict direct access.
- **Getters/Setters**:
  - Getter: Returns the value of a private field (e.g., `getName()`).
  - Setter: Sets the value of a private field with validation (e.g., `setAge(int age)`).
- Benefits: Protects data integrity, allows validation.

### Code Examples
**Example 1: Basic Encapsulation**
```java
public class Employee {
    private String name;
    private int id;
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Bob");
        emp.setId(102);
        System.out.println("Employee: " + emp.getName() + ", ID: " + emp.getId());
    }
}
```

**Example 2: Setter with Validation**
```java
public class Account {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance");
        }
    }
    
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(100.50);
        System.out.println("Balance: $" + account.getBalance());
        account.setBalance(-50); // Invalid
    }
}
```

**Example 3: Full Encapsulation with Constructor**
```java
public class Book {
    private String title;
    private String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid title");
        }
    }
    
    public String getAuthor() {
        return author;
    }
    
    public static void main(String[] args) {
        Book book = new Book("Java Guide", "Jane Doe");
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        book.setTitle(""); // Invalid
    }
}
```

### Practice
1. Create a `Car` class with private fields `model` and `year`; add getters and setters.
2. Add validation in the setter for `year` (e.g., must be >= 1900).
3. Write a program to create a `Car` object, set values, and print them using getters.

**Practice Code**:
```java
public class CarPractice {
    private String model;
    private int year;
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        if (year >= 1900) {
            this.year = year;
        } else {
            System.out.println("Invalid year");
        }
    }
    
    public static void main(String[] args) {
        CarPractice car = new CarPractice();
        car.setModel("Ford");
        car.setYear(2020);
        System.out.println("Car: " + car.getModel() + ", Year: " + car.getYear());
        car.setYear(1800); // Invalid
    }
}
```

---

## Day 5: Review and Object Interactions
**Objective**: Solidify classes, objects, constructors, and encapsulation; explore object interactions.

### Explanation
- **Object Interactions**: Objects can call each other’s methods or access data (via getters).
- Review best practices:
  - Use meaningful class/method names.
  - Encapsulate data with `private` fields.
  - Initialize objects properly with constructors.
- Combine with Week 1-4 concepts (conditionals, loops, methods).

### Code Examples
**Example 1: Object Interaction**
```java
public class Library {
    private Book book;
    
    Library(Book book) {
        this.book = book;
    }
    
    void displayBook() {
        System.out.println("Library Book: " + book.getTitle());
    }
    
    public static void main(String[] args) {
        Book book = new Book("OOP Basics", "John Smith");
        Library library = new Library(book);
        library.displayBook();
    }
}
```

**Example 2: Multiple Objects**
```java
public class Team {
    private String teamName;
    private Player player1;
    private Player player2;
    
    Team(String teamName, Player p1, Player p2) {
        this.teamName = teamName;
        this.player1 = p1;
        this.player2 = p2;
    }
    
    void displayTeam() {
        System.out.println("Team: " + teamName);
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());
    }
}

class Player {
    private String name;
    
    Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static void main(String[] args) {
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Team team = new Team("Winners", p1, p2);
        team.displayTeam();
    }
}
```

**Example 3: Validation in Interaction**
```java
public class Order {
    private Product product;
    private int quantity;
    
    Order(Product product, int quantity) {
        this.product = product;
        setQuantity(quantity);
    }
    
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid quantity");
            this.quantity = 1;
        }
    }
    
    public void displayOrder() {
        System.out.println("Order: " + product.getName() + ", Quantity: " + quantity);
    }
}

class Product {
    private String name;
    
    Product(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static void main(String[] args) {
        Product prod = new Product("Laptop");
        Order order = new Order(prod, 3);
        order.displayOrder();
        order.setQuantity(0); // Invalid
        order.displayOrder();
    }
}
```

### Practice
1. Create a `Library` class that holds a `Book` object and displays its details.
2. Write a `School` class that contains two `Student` objects and prints their names.
3. Add validation to ensure objects passed to a class are not null.

**Practice Code**:
```java
public class LibraryPractice {
    private Book book;
    
    LibraryPractice(Book book) {
        if (book != null) {
            this.book = book;
        } else {
            System.out.println("Invalid book");
            this.book = new Book("Unknown", "Unknown");
        }
    }
    
    void displayBook() {
        System.out.println("Library Book: " + book.getTitle() + " by " + book.getAuthor());
    }
    
    public static void main(String[] args) {
        Book book = new Book("Java Guide", "Jane Doe");
        LibraryPractice library = new LibraryPractice(book);
        library.displayBook();
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 5 learning with a Library Management System.

### Review
- Revisit:
  - Classes and objects for modeling real-world entities.
  - Constructors (default and parameterized).
  - `this` keyword for clarity.
  - Encapsulation with private fields and getters/setters.
  - Object interactions.
- Debug common errors (e.g., null objects, missing `this`, public fields).

### Mini-Project: Library Management System
Create a console-based program that:
1. Defines a `Book` class with private fields `title` and `author`, getters/setters, and a constructor.
2. Creates a `Library` class that holds multiple `Book` objects (use an array for now).
3. Includes methods to add a book and display all books.
4. Validates inputs (e.g., non-empty title, non-null book).
5. Uses loops and conditionals from Weeks 2-3 for processing.

**Project Code**:
```java
public class LibrarySystem {
    private Book[] books;
    private int bookCount;
    
    LibrarySystem(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }
    
    void addBook(Book book) {
        if (book == null || book.getTitle().isEmpty()) {
            System.out.println("Invalid book");
            return;
        }
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Added: " + book.getTitle());
        } else {
            System.out.println("Library full");
        }
    }
    
    void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in library");
            return;
        }
        System.out.println("Library Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i].getTitle() + " by " + books[i].getAuthor());
        }
    }
    
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem(3);
        Book book1 = new Book("Java Basics", "John Doe");
        Book book2 = new Book("OOP Guide", "Jane Smith");
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(new Book("", "Invalid")); // Invalid
        library.displayBooks();
    }
}

class Book {
    private String title;
    private String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid title");
        }
    }
}
```

### Weekend Practice
1. Run and test the library system with different books.
2. Add a method to the `Library` class to find a book by title.
3. Extend the program to count how many books are in the library.

**Extended Practice Code** (with find method):
```java
public class ExtendedLibrarySystem {
    private Book[] books;
    private int bookCount;
    
    ExtendedLibrarySystem(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }
    
    void addBook(Book book) {
        if (book == null || book.getTitle().isEmpty()) {
            System.out.println("Invalid book");
            return;
        }
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Added: " + book.getTitle());
        } else {
            System.out.println("Library full");
        }
    }
    
    void findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                System.out.println("Found: " + books[i].getTitle() + " by " + books[i].getAuthor());
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }
    
    public static void main(String[] args) {
        ExtendedLibrarySystem library = new ExtendedLibrarySystem(3);
        Book book1 = new Book("Java Basics", "John Doe");
        library.addBook(book1);
        library.findBook("Java Basics");
        library.findBook("Python Guide");
    }
}
```

---

## Tips for Week 5
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Check for null objects, missing `this`, or public fields exposing data.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for OOP basics.
- **Experiment**: Modify constructors or add validation to see how objects behave.