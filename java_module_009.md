# Java Module 009: Week 9 - Exception Handling

This module introduces exception handling in Java, focusing on `try-catch` blocks, throwing exceptions, creating custom exceptions, and using the `finally` block. Designed for beginners building on Weeks 1-8 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 9. The module concludes with a console-based File Processing System mini-project to apply these concepts.

---

## Day 1: `try-catch` Blocks
**Objective**: Learn to handle exceptions using `try-catch` blocks.

### Explanation
- **Exception**: An error or unexpected event during program execution (e.g., division by zero, accessing invalid array index).
- **try-catch**: Used to catch and handle exceptions to prevent program crashes.
  - **Syntax**:
    ```java
    try {
        // Code that might throw an exception
    } catch (ExceptionType e) {
        // Handle the exception
    }
    ```
- Common exceptions: `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NullPointerException`.
- Use `e.getMessage()` or `e.printStackTrace()` for debugging.

### Code Examples
**Example 1: Handling Division by Zero**
```java
public class DivisionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }
    }
}
```

**Example 2: Array Index Error**
```java
public class ArrayIndexExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index");
        }
    }
}
```

**Example 3: Multiple Catch Blocks**
```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        try {
            int result = arr[0] / arr[2];
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Error: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write a program to divide two numbers and handle division by zero.
2. Create an array and attempt to access an invalid index; handle the exception.
3. Write a program that handles both `ArithmeticException` and `ArrayIndexOutOfBoundsException`.

**Practice Code**:
```java
public class TryCatchPractice {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20};
            int result = numbers[0] / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }
    }
}
```

---

## Day 2: Throwing Exceptions
**Objective**: Learn to throw exceptions using `throw` and `throws`.

### Explanation
- **throw**: Explicitly throws an exception.
  - Syntax: `throw new ExceptionType("message");`
- **throws**: Declares that a method might throw an exception.
  - Syntax: `returnType methodName() throws ExceptionType { // code }`
- Common use: Validate inputs and throw exceptions for invalid cases.

### Code Examples
**Example 1: Throwing an Exception**
```java
public class ThrowExample {
    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        System.out.println("Age is valid: " + age);
    }
}
```

**Example 2: Using `throws`**
```java
public class ThrowsExample {
    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
```

**Example 3: Validating Input**
```java
public class InputValidationExample {
    public static void main(String[] args) {
        try {
            setScore(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void setScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        System.out.println("Score set: " + score);
    }
}
```

### Practice
1. Write a method to validate a positive number; throw `IllegalArgumentException` if negative.
2. Create a method that throws an `ArithmeticException` for division by zero.
3. Write a program to validate a string length (must be > 0) and throw an exception if invalid.

**Practice Code**:
```java
public class ThrowPractice {
    public static void main(String[] args) {
        try {
            validateString("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void validateString(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        System.out.println("Valid string: " + str);
    }
}
```

---

## Day 3: Custom Exceptions
**Objective**: Create and use custom exception classes.

### Explanation
- **Custom Exception**: A user-defined exception class, typically extending `Exception` or `RuntimeException`.
- **Syntax**:
  ```java
  class CustomException extends Exception {
      public CustomException(String message) {
          super(message);
      }
  }
  ```
- Use for specific error scenarios in your application.

### Code Examples
**Example 1: Basic Custom Exception**
```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            checkAge(12);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older");
        }
        System.out.println("Age is valid");
    }
}
```

**Example 2: Custom Exception with Validation**
```java
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class ScoreValidationExample {
    public static void main(String[] args) {
        try {
            setScore(150);
        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void setScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("Score must be between 0 and 100");
        }
        System.out.println("Score set: " + score);
    }
}
```

**Example 3: Custom Exception in Method**
```java
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class NameValidationExample {
    public static void main(String[] args) {
        try {
            validateName("");
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void validateName(String name) throws InvalidNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Name cannot be empty or null");
        }
        System.out.println("Valid name: " + name);
    }
}
```

### Practice
1. Create a custom `InvalidGradeException` and use it to validate grades (0-100).
2. Write a method that throws a custom exception for negative numbers.
3. Create a program to validate a username (non-empty) using a custom exception.

**Practice Code**:
```java
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class CustomExceptionPractice {
    public static void main(String[] args) {
        try {
            addGrade(120);
        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void addGrade(double grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100");
        }
        System.out.println("Grade added: " + grade);
    }
}
```

---

## Day 4: `finally` Block
**Objective**: Use the `finally` block for cleanup tasks.

### Explanation
- **finally**: A block that always executes, regardless of whether an exception is thrown or caught.
- **Syntax**:
  ```java
  try {
      // Code
  } catch (ExceptionType e) {
      // Handle exception
  } finally {
      // Cleanup code
  }
  ```
- Common use: Closing resources (e.g., files, connections).

### Code Examples
**Example 1: Basic Finally Block**
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("This always runs");
        }
    }
}
```

**Example 2: Finally with Exception**
```java
public class FinallyExceptionExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index");
        } finally {
            System.out.println("Cleanup complete");
        }
    }
}
```

**Example 3: Resource Cleanup Simulation**
```java
public class ResourceCleanupExample {
    public static void main(String[] args) {
        try {
            System.out.println("Opening resource");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Closing resource");
        }
    }
}
```

### Practice
1. Write a program with a `try-catch-finally` block to handle division by zero.
2. Create a program to access an array index and use `finally` for cleanup.
3. Simulate opening and closing a resource (e.g., print "Resource closed" in `finally`).

**Practice Code**:
```java
public class FinallyPractice {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index");
        } finally {
            System.out.println("Cleanup done");
        }
    }
}
```

---

## Day 5: Review and Exception Handling Design
**Objective**: Solidify exception handling and design robust error handling.

### Explanation
- Review best practices:
  - Use specific exception types in `catch` blocks.
  - Throw custom exceptions for application-specific errors.
  - Use `finally` for cleanup.
  - Avoid catching generic `Exception` unless necessary.
- Combine with Weeks 1-8 concepts (OOP, collections, loops).

### Code Examples
**Example 1: Specific Exception Handling**
```java
public class SpecificExceptionExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1};
            System.out.println(arr[0] / arr[1]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Error: " + e.getMessage());
        } finally {
            System.out.println("Done");
        }
    }
}
```

**Example 2: Custom Exception in Class**
```java
class InvalidBalanceException extends Exception {
    public InvalidBalanceException(String message) {
        super(message);
    }
}

public class AccountExample {
    private double balance;
    
    void deposit(double amount) throws InvalidBalanceException {
        if (amount <= 0) {
            throw new InvalidBalanceException("Amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    public static void main(String[] args) {
        AccountExample account = new AccountExample();
        try {
            account.deposit(-50);
        } catch (InvalidBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Example 3: Combining Collections and Exceptions**
```java
import java.util.ArrayList;

public class CollectionExceptionExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        
        try {
            System.out.println(numbers.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index");
        } finally {
            System.out.println("List access complete");
        }
    }
}
```

### Practice
1. Write a method to validate an array index and throw a custom exception if invalid.
2. Create a program with a `try-catch-finally` block to handle a collection access error.
3. Combine a `HashMap` with exception handling to validate key existence.

**Practice Code**:
```java
import java.util.HashMap;

public class ExceptionReviewPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        
        try {
            getScore(scores, "Bob");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operation complete");
        }
    }
    
    static int getScore(HashMap<String, Integer> scores, String name) {
        if (!scores.containsKey(name)) {
            throw new IllegalArgumentException("Student not found: " + name);
        }
        return scores.get(name);
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 9 learning with a File Processing System.

### Review
- Revisit:
  - `try-catch` for handling exceptions.
  - `throw` and `throws` for custom error handling.
  - Custom exceptions for specific scenarios.
  - `finally` for cleanup.
- Debug common errors (e.g., unhandled exceptions, missing `finally` cleanup).

### Mini-Project: File Processing System
Create a console-based program that simulates file processing:
1. Defines a `File` class with fields `name` and `size` (in KB).
2. Uses a `HashMap` to store files (name as key, `File` object as value).
3. Includes methods to add a file, access a file, and validate size.
4. Uses custom exceptions for invalid file names or sizes.
5. Uses `try-catch-finally` to handle operations and simulate cleanup.

**Project Code**:
```java
import java.util.HashMap;

class InvalidFileException extends Exception {
    public InvalidFileException(String message) {
        super(message);
    }
}

public class FileProcessingSystem {
    private HashMap<String, File> files;
    
    FileProcessingSystem() {
        files = new HashMap<>();
    }
    
    void addFile(String name, double size) throws InvalidFileException {
        try {
            if (name == null || name.isEmpty()) {
                throw new InvalidFileException("File name cannot be empty");
            }
            if (size <= 0) {
                throw new InvalidFileException("File size must be positive");
            }
            files.put(name, new File(name, size));
            System.out.println("Added file: " + name);
        } finally {
            System.out.println("File operation complete");
        }
    }
    
    void accessFile(String name) throws InvalidFileException {
        try {
            if (!files.containsKey(name)) {
                throw new InvalidFileException("File not found: " + name);
            }
            files.get(name).displayDetails();
        } finally {
            System.out.println("Access operation complete");
        }
    }
    
    public static void main(String[] args) {
        FileProcessingSystem system = new FileProcessingSystem();
        try {
            system.addFile("doc.txt", 100);
            system.addFile("", 50); // Invalid
            system.accessFile("doc.txt");
            system.accessFile("image.jpg"); // Invalid
        } catch (InvalidFileException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class File {
    private String name;
    private double size;
    
    File(String name, double size) {
        this.name = name;
        this.size = size;
    }
    
    void displayDetails() {
        System.out.println("File: " + name + ", Size: " + size + " KB");
    }
}
```

### Weekend Practice
1. Run and test the system with different files and invalid inputs.
2. Add a method to calculate the total size of all files.
3. Extend the program to handle `NullPointerException` for null inputs.

**Extended Practice Code** (with total size):
```java
import java.util.HashMap;

class InvalidFileException extends Exception {
    public InvalidFileException(String message) {
        super(message);
    }
}

public class ExtendedFileProcessingSystem {
    private HashMap<String, File> files;
    
    ExtendedFileProcessingSystem() {
        files = new HashMap<>();
    }
    
    void addFile(String name, double size) throws InvalidFileException {
        try {
            if (name == null || name.isEmpty()) {
                throw new InvalidFileException("File name cannot be empty");
            }
            files.put(name, new File(name, size));
        } finally {
            System.out.println("Add operation complete");
        }
    }
    
    double getTotalSize() {
        double total = 0;
        for (File file : files.values()) {
            total += file.getSize();
        }
        return total;
    }
    
    public static void main(String[] args) {
        ExtendedFileProcessingSystem system = new ExtendedFileProcessingSystem();
        try {
            system.addFile("doc.txt", 100);
            System.out.println("Total Size: " + system.getTotalSize() + " KB");
        } catch (InvalidFileException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class File {
    private String name;
    private double size;
    
    File(String name, double size) {
        this.name = name;
        this.size = size;
    }
    
    double getSize() {
        return size;
    }
}
```

---

## Tips for Week 9
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Check for unhandled exceptions or missing `finally` blocks.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for exception handling details.
- **Experiment**: Modify exception messages or add validation to see effects.