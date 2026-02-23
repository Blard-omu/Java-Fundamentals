# Java Module 010: Week 10 - File I/O

This module covers file input/output (I/O) in Java, focusing on reading and writing text files using `BufferedReader`, `BufferedWriter`, and `Files` classes, along with handling file-related exceptions. Designed for beginners building on Weeks 1-9 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 10. The module concludes with a console-based Contact Management System mini-project to apply these concepts.

---

## Day 1: Writing to Files
**Objective**: Learn to write text to files using `BufferedWriter` and `Files`.

### Explanation
- **File Writing**: Saving data to a file on disk.
- **BufferedWriter**: Efficiently writes text to a file.
  - Requires `import java.io.BufferedWriter; import java.io.FileWriter;`.
  - Syntax:
    ```java
    BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
    writer.write("Text");
    writer.close();
    ```
- **Files** (Java NIO): A modern way to handle files.
  - Requires `import java.nio.file.Files; import java.nio.file.Paths;`.
  - Syntax: `Files.write(Paths.get("file.txt"), "Text".getBytes());`
- Always close resources or use try-with-resources to avoid leaks.

### Code Examples
**Example 1: Writing with BufferedWriter**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, Java!");
            writer.newLine();
            writer.write("Writing to a file.");
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
```

**Example 2: Writing with Files**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FilesWriteExample {
    public static void main(String[] args) {
        try {
            Files.write(Paths.get("output2.txt"), "Hello, NIO!\nSecond line.".getBytes());
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
```

**Example 3: Appending to a File**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendFileExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write("Appended text.");
            writer.newLine();
            System.out.println("File appended successfully");
        } catch (IOException e) {
            System.out.println("Error appending file: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write a program to create a file "notes.txt" with two lines of text.
2. Use `Files` to write a single line to "data.txt".
3. Write a program to append a line to an existing file.

**Practice Code**:
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritePractice {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("notes.txt"))) {
            writer.write("First note");
            writer.newLine();
            writer.write("Second note");
            System.out.println("Notes written");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## Day 2: Reading from Files
**Objective**: Learn to read text from files using `BufferedReader` and `Files`.

### Explanation
- **File Reading**: Retrieving data from a file.
- **BufferedReader**: Reads text efficiently line by line.
  - Requires `import java.io.BufferedReader; import java.io.FileReader;`.
  - Syntax:
    ```java
    BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
    String line = reader.readLine();
    reader.close();
    ```
- **Files**: Reads all lines at once.
  - Syntax: `List<String> lines = Files.readAllLines(Paths.get("file.txt"));`
- Handle `IOException` for file operations.

### Code Examples
**Example 1: Reading with BufferedReader**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

**Example 2: Reading with Files**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class FilesReadExample {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("output.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

**Example 3: Counting Lines**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCountExample {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            while (reader.readLine() != null) {
                count++;
            }
            System.out.println("Total lines: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write a program to read and print all lines from "notes.txt".
2. Use `Files` to read "data.txt" and print its contents.
3. Create a program to count the number of lines in a file.

**Practice Code**:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadPractice {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## Day 3: File-Related Exceptions
**Objective**: Handle file-specific exceptions with custom handling.

### Explanation
- **Common File Exceptions**:
  - `FileNotFoundException`: File does not exist.
  - `IOException`: General I/O error (e.g., permission issues).
- Use specific `catch` blocks for file operations.
- Custom exceptions can enhance error handling for file operations.

### Code Examples
**Example 1: Handling FileNotFoundException**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileNotFoundExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("missing.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
```

**Example 2: Custom File Exception**
```java
class InvalidFileSizeException extends Exception {
    public InvalidFileSizeException(String message) {
        super(message);
    }
}

public class CustomFileExceptionExample {
    public static void main(String[] args) {
        try {
            writeFile("data.txt", -100);
        } catch (InvalidFileSizeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
    
    static void writeFile(String filename, long size) throws InvalidFileSizeException, IOException {
        if (size <= 0) {
            throw new InvalidFileSizeException("File size must be positive");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Size: " + size);
        }
    }
}
```

**Example 3: Multiple Exceptions**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultipleFileExceptionsExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line = reader.readLine();
            int num = Integer.parseInt(line); // Potential NumberFormatException
            System.out.println("Number: " + num);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write a program to read a file and handle `FileNotFoundException`.
2. Create a custom exception for invalid file content and use it in a read operation.
3. Write a program to handle both `IOException` and `NumberFormatException` when reading numbers.

**Practice Code**:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionPractice {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## Day 4: Combining File I/O with Collections
**Objective**: Use files with collections to store and retrieve data.

### Explanation
- Store collection data (e.g., `ArrayList`, `HashMap`) in files.
- Read file data into collections for processing.
- Combine with exception handling for robust programs.

### Code Examples
**Example 1: Writing ArrayList to File**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToFileExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt"))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Names written to file");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
```

**Example 2: Reading into HashMap**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileToHashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                scores.put(parts[0], Integer.parseInt(parts[1]));
            }
            System.out.println("Scores: " + scores);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

**Example 3: Writing HashMap to File**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HashMapToFileExample {
    public static void main(String[] args) {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Laptop", 1200.0);
        prices.put("Phone", 800.0);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prices.txt"))) {
            for (String key : prices.keySet()) {
                writer.write(key + "," + prices.get(key));
                writer.newLine();
            }
            System.out.println("Prices written to file");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write an `ArrayList` of integers to a file.
2. Read a file of student names and scores into a `HashMap`.
3. Write a `HashMap` of product names and prices to a file.

**Practice Code**:
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CollectionFilePractice {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt"))) {
            for (Integer num : numbers) {
                writer.write(num.toString());
                writer.newLine();
            }
            System.out.println("Numbers written");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## Day 5: Review and File I/O Design
**Objective**: Solidify file I/O and design robust file-handling programs.

### Explanation
- Review best practices:
  - Use try-with-resources to auto-close files.
  - Handle specific exceptions (`FileNotFoundException`, `IOException`).
  - Validate data before writing to files.
  - Combine file I/O with collections for data persistence.
- Combine with Weeks 1-9 concepts (OOP, collections, exceptions).

### Code Examples
**Example 1: Robust File Writing**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RobustWriteExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("Robust write");
            writer.newLine();
            System.out.println("File written");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Example 2: Reading and Processing**
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadProcessExample {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.toUpperCase());
            }
            System.out.println("Processed lines: " + lines);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Example 3: Combining Collections and Files**
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CollectionFileExample {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Pen", 50);
        inventory.put("Notebook", 30);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"))) {
            for (String item : inventory.keySet()) {
                writer.write(item + "," + inventory.get(item));
                writer.newLine();
            }
            System.out.println("Inventory written");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Practice
1. Write a program to write a `HashMap` of names and ages to a file.
2. Read a file into an `ArrayList` and print it in reverse order.
3. Combine file reading with a `HashMap` to store key-value pairs from a file.

**Practice Code**:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReviewPractice {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 10 learning with a Contact Management System.

### Review
- Revisit:
  - Writing files with `BufferedWriter` and `Files`.
  - Reading files with `BufferedReader` and `Files`.
  - Handling file-related exceptions.
  - Combining file I/O with collections.
- Debug common errors (e.g., unclosed files, missing exception handling).

### Mini-Project: Contact Management System
Create a console-based program that:
1. Defines a `Contact` class with fields `name`, `email`, and `phone`.
2. Uses a `HashMap` to store contacts (email as key, `Contact` object as value).
3. Saves contacts to a file and loads them back into the `HashMap`.
4. Handles file-related exceptions and validates inputs.
5. Uses try-with-resources for file operations.

**Project Code**:
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class InvalidContactException extends Exception {
    public InvalidContactException(String message) {
        super(message);
    }
}

public class ContactManagementSystem {
    private HashMap<String, Contact> contacts;
    
    ContactManagementSystem() {
        contacts = new HashMap<>();
    }
    
    void addContact(String name, String email, String phone) throws InvalidContactException {
        if (email == null || email.isEmpty()) {
            throw new InvalidContactException("Email cannot be empty");
        }
        contacts.put(email, new Contact(name, email, phone));
        System.out.println("Added contact: " + name);
    }
    
    void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts.values()) {
                writer.write(contact.getName() + "," + contact.getEmail() + "," + contact.getPhone());
                writer.newLine();
            }
            System.out.println("Contacts saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    
    void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addContact(parts[0], parts[1], parts[2]);
                }
            }
            System.out.println("Contacts loaded from " + filename);
        } catch (IOException | InvalidContactException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
    
    void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts");
            return;
        }
        for (Contact contact : contacts.values()) {
            contact.displayDetails();
        }
    }
    
    public static void main(String[] args) {
        ContactManagementSystem cms = new ContactManagementSystem();
        try {
            cms.addContact("Alice", "alice@example.com", "123-456-7890");
            cms.addContact("Bob", "bob@example.com", "098-765-4321");
            cms.saveToFile("contacts.txt");
            cms.loadFromFile("contacts.txt");
            cms.displayContacts();
        } catch (InvalidContactException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Contact {
    private String name, email, phone;
    
    Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    String getName() { return name; }
    String getEmail() { return email; }
    String getPhone() { return phone; }
    
    void displayDetails() {
        System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}
```

### Weekend Practice
1. Run and test the system with different contacts and invalid inputs.
2. Add a method to find a contact by email.
3. Extend the program to delete a contact and update the file.

**Extended Practice Code** (with find method):
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class InvalidContactException extends Exception {
    public InvalidContactException(String message) {
        super(message);
    }
}

public class ExtendedContactManagementSystem {
    private HashMap<String, Contact> contacts;
    
    ExtendedContactManagementSystem() {
        contacts = new HashMap<>();
    }
    
    void addContact(String name, String email, String phone) throws InvalidContactException {
        if (email == null || email.isEmpty()) {
            throw new InvalidContactException("Email cannot be empty");
        }
        contacts.put(email, new Contact(name, email, phone));
    }
    
    void findContact(String email) {
        if (contacts.containsKey(email)) {
            contacts.get(email).displayDetails();
        } else {
            System.out.println("Contact not found: " + email);
        }
    }
    
    void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts.values()) {
                writer.write(contact.getName() + "," + contact.getEmail() + "," + contact.getPhone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ExtendedContactManagementSystem cms = new ExtendedContactManagementSystem();
        try {
            cms.addContact("Alice", "alice@example.com", "123-456-7890");
            cms.findContact("alice@example.com");
            cms.saveToFile("contacts.txt");
        } catch (InvalidContactException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Contact {
    private String name, email, phone;
    
    Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    String getName() { return name; }
    String getEmail() { return email; }
    String getPhone() { return phone; }
    
    void displayDetails() {
        System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}
```

---

## Tips for Week 10
- **Practice**: Test each code example in an IDE or terminal, ensuring files are created/read.
- **Debug**: Check for unhandled `IOException` or unclosed resources.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for file I/O details.
- **Experiment**: Modify file formats or add validation to see effects.