# Java Module 008: Week 8 - More Collections and Student Management System

This module explores advanced Java collections (`HashMap`, `HashSet`), iteration techniques, and their applications, building on Weeks 1-7 of the 3-month Java fundamentals plan. It includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 8. The module concludes with a console-based Student Management System mini-project that integrates OOP, arrays, and collections to manage student data.

---

## Day 1: `HashMap`
**Objective**: Learn to use `HashMap` for key-value pair storage.

### Explanation
- **HashMap**: A collection that stores key-value pairs, allowing fast retrieval by key.
- **Syntax**: `HashMap<KeyType, ValueType> map = new HashMap<>();`
- Common methods:
  - `put(key, value)`: Adds or updates a key-value pair.
  - `get(key)`: Retrieves the value for a key.
  - `remove(key)`: Removes a key-value pair.
  - `containsKey(key)`: Checks if a key exists.
  - `size()`: Returns the number of pairs.
- Requires `import java.util.HashMap;`.
- Keys must be unique; values can be duplicated.

### Code Examples
**Example 1: Basic HashMap**
```java
import java.util.HashMap;

public class BasicHashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        
        System.out.println("Scores: " + scores);
        System.out.println("Bob's score: " + scores.get("Bob"));
    }
}
```

**Example 2: Updating and Removing**
```java
import java.util.HashMap;

public class HashMapUpdateExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(101, "Alice");
        students.put(102, "Bob");
        
        students.put(101, "Alicia"); // Update Alice to Alicia
        students.remove(102); // Remove Bob
        
        System.out.println("Students: " + students);
    }
}
```

**Example 3: Checking Keys**
```java
import java.util.HashMap;

public class HashMapCheckExample {
    public static void main(String[] args) {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Laptop", 1200.0);
        prices.put("Phone", 800.0);
        
        if (prices.containsKey("Laptop")) {
            System.out.println("Laptop price: $" + prices.get("Laptop"));
        } else {
            System.out.println("Laptop not found");
        }
    }
}
```

### Practice
1. Create a `HashMap` to store student IDs (Integer) and names (String); add 3 entries.
2. Write a program to update a value in a `HashMap` and remove another.
3. Check if a key exists in a `HashMap` and print its value if found.

**Practice Code**:
```java
import java.util.HashMap;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Eve");
        students.put(2, "Frank");
        students.put(3, "Grace");
        
        students.put(1, "Evelyn"); // Update
        students.remove(2); // Remove Frank
        
        System.out.println("Students: " + students);
        if (students.containsKey(3)) {
            System.out.println("ID 3: " + students.get(3));
        }
    }
}
```

---

## Day 2: Combining Collections
**Objective**: Use `ArrayList` and `HashMap` together for complex data structures.

### Explanation
- Combine collections to model relationships (e.g., a `HashMap` of student IDs to `ArrayList` of grades).
- Use loops to process multiple collections.
- Validate data when adding to collections to ensure integrity.

### Code Examples
**Example 1: HashMap with ArrayList Values**
```java
import java.util.ArrayList;
import java.util.HashMap;

public class MapListExample {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<>();
        
        ArrayList<Integer> aliceGrades = new ArrayList<>();
        aliceGrades.add(85);
        aliceGrades.add(90);
        studentGrades.put("Alice", aliceGrades);
        
        System.out.println("Alice's grades: " + studentGrades.get("Alice"));
    }
}
```

**Example 2: Adding to Combined Collections**
```java
import java.util.ArrayList;
import java.util.HashMap;

public class AddToMapListExample {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<String>> teams = new HashMap<>();
        
        ArrayList<String> team1 = new ArrayList<>();
        team1.add("Alice");
        team1.add("Bob");
        teams.put(1, team1);
        
        teams.get(1).add("Charlie"); // Add to existing list
        System.out.println("Team 1: " + teams.get(1));
    }
}
```

**Example 3: Processing Combined Collections**
```java
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessMapListExample {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> prices = new HashMap<>();
        ArrayList<Double> electronics = new ArrayList<>();
        electronics.add(1000.0);
        electronics.add(500.0);
        prices.put("Electronics", electronics);
        
        double total = 0;
        for (Double price : prices.get("Electronics")) {
            total += price;
        }
        System.out.println("Total Electronics Price: $" + total);
    }
}
```

### Practice
1. Create a `HashMap` mapping course names to an `ArrayList` of student names.
2. Write a program to add a student to a course’s `ArrayList` in a `HashMap`.
3. Calculate the average of an `ArrayList` of grades stored in a `HashMap` for a specific student.

**Practice Code**:
```java
import java.util.ArrayList;
import java.util.HashMap;

public class CombinedCollectionsPractice {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> courses = new HashMap<>();
        ArrayList<String> javaStudents = new ArrayList<>();
        javaStudents.add("Eve");
        courses.put("Java", javaStudents);
        
        courses.get("Java").add("Frank");
        System.out.println("Java Students: " + courses.get("Java"));
    }
}
```

---

## Day 3: `HashSet` and Iteration
**Objective**: Use `HashSet` for unique elements and iterate over collections.

### Explanation
- **HashSet**: A collection that stores unique elements, with no duplicates.
- **Syntax**: `HashSet<Type> set = new HashSet<>();`
- Common methods:
  - `add(element)`: Adds an element if not already present.
  - `remove(element)`: Removes an element.
  - `contains(element)`: Checks if an element exists.
  - `size()`: Returns the number of elements.
- Requires `import java.util.HashSet;`.
- Use `for-each` for iteration since `HashSet` has no order.

### Code Examples
**Example 1: Basic HashSet**
```java
import java.util.HashSet;

public class BasicHashSetExample {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("New York");
        cities.add("London");
        cities.add("New York"); // Ignored (duplicate)
        
        System.out.println("Cities: " + cities);
        System.out.println("Size: " + cities.size());
    }
}
```

**Example 2: Iteration with For-Each**
```java
import java.util.HashSet;

public class HashSetIterationExample {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        for (Integer num : numbers) {
            System.out.println("Number: " + num);
        }
    }
}
```

**Example 3: Checking and Removing**
```java
import java.util.HashSet;

public class HashSetCheckExample {
    public static void main(String[] args) {
        HashSet<String> tags = new HashSet<>();
        tags.add("Java");
        tags.add("Python");
        
        if (tags.contains("Java")) {
            System.out.println("Java found");
            tags.remove("Java");
        }
        System.out.println("Tags after removal: " + tags);
    }
}
```

### Practice
1. Create a `HashSet` of unique student names; add duplicates and print.
2. Write a program to check if an element exists in a `HashSet` and remove it if found.
3. Use a `for-each` loop to print elements of a `HashSet` of integers.

**Practice Code**:
```java
import java.util.HashSet;

public class HashSetPractice {
    public static void main(String[] args) {
        HashSet<String> students = new HashSet<>();
        students.add("Grace");
        students.add("Grace"); // Ignored
        students.add("Henry");
        
        System.out.println("Students: " + students);
        
        if (students.contains("Grace")) {
            students.remove("Grace");
            System.out.println("After removing Grace: " + students);
        }
    }
}
```

---

## Day 4: Collection Methods and Use Cases
**Objective**: Explore additional collection methods and real-world applications.

### Explanation
- Common methods for collections:
  - `ArrayList`: `clear()`, `isEmpty()`, `contains(element)`.
  - `HashMap`: `keySet()`, `values()`, `entrySet()` for iteration.
  - `HashSet`: `clear()`, `isEmpty()`.
- Use cases: Storing unique IDs (`HashSet`), mapping data (`HashMap`), dynamic lists (`ArrayList`).

### Code Examples
**Example 1: ArrayList Methods**
```java
import java.util.ArrayList;

public class ArrayListMethodsExample {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Study");
        tasks.add("Code");
        
        System.out.println("Is empty? " + tasks.isEmpty());
        System.out.println("Contains 'Study'? " + tasks.contains("Study"));
        tasks.clear();
        System.out.println("After clear, is empty? " + tasks.isEmpty());
    }
}
```

**Example 2: HashMap Iteration**
```java
import java.util.HashMap;

public class HashMapIterationExample {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        
        for (String name : ages.keySet()) {
            System.out.println(name + ": " + ages.get(name));
        }
    }
}
```

**Example 3: HashSet Use Case**
```java
import java.util.HashSet;

public class UniqueTagsExample {
    public static void main(String[] args) {
        HashSet<String> tags = new HashSet<>();
        tags.add("Java");
        tags.add("Python");
        tags.add("Java");
        
        System.out.println("Unique tags: " + tags);
        System.out.println("Size: " + tags.size());
    }
}
```

### Practice
1. Use `ArrayList` methods to check if a list is empty and clear it.
2. Iterate over a `HashMap` using `keySet()` to print key-value pairs.
3. Create a `HashSet` to store unique product codes and check its size.

**Practice Code**:
```java
import java.util.ArrayList;
import java.util.HashMap;

public class CollectionMethodsPractice {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Pen");
        System.out.println("Is empty? " + items.isEmpty());
        items.clear();
        System.out.println("After clear, is empty? " + items.isEmpty());
        
        HashMap<Integer, String> products = new HashMap<>();
        products.put(101, "Laptop");
        products.put(102, "Phone");
        for (Integer id : products.keySet()) {
            System.out.println("ID " + id + ": " + products.get(id));
        }
    }
}
```

---

## Day 5: Review and Real-World Use Cases
**Objective**: Solidify collections and explore their applications.

### Explanation
- Review best practices:
  - Use `HashMap` for key-value mappings, `HashSet` for unique elements, `ArrayList` for ordered lists.
  - Validate inputs before adding to collections.
  - Use `for-each` for simple iteration; use indexed loops for modifications.
- Combine with Weeks 1-7 concepts (OOP, loops, methods).

### Code Examples
**Example 1: Student Grade Mapping**
```java
import java.util.HashMap;

public class GradeMappingExample {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Math", 90);
        grades.put("Science", 85);
        
        for (String subject : grades.keySet()) {
            System.out.println(subject + ": " + grades.get(subject));
        }
    }
}
```

**Example 2: Unique IDs with HashSet**
```java
import java.util.HashSet;

public class UniqueIdsExample {
    public static void main(String[] args) {
        HashSet<Integer> ids = new HashSet<>();
        ids.add(1001);
        ids.add(1002);
        ids.add(1001); // Ignored
        
        for (Integer id : ids) {
            System.out.println("ID: " + id);
        }
    }
}
```

**Example 3: Combined Collections**
```java
import java.util.ArrayList;
import java.util.HashMap;

public class CombinedCollectionsExample {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> classGrades = new HashMap<>();
        ArrayList<Integer> mathGrades = new ArrayList<>();
        mathGrades.add(80);
        mathGrades.add(90);
        classGrades.put("Math", mathGrades);
        
        for (Integer grade : classGrades.get("Math")) {
            System.out.println("Math Grade: " + grade);
        }
    }
}
```

### Practice
1. Create a `HashMap` to map books to their prices; iterate and print.
2. Use a `HashSet` to store unique email addresses.
3. Combine `ArrayList` and `HashMap` to map students to their grades and calculate an average.

**Practice Code**:
```java
import java.util.ArrayList;
import java.util.HashMap;

public class ReviewPractice {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<>();
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(85);
        grades.add(90);
        studentGrades.put("Eve", grades);
        
        double sum = 0;
        for (Integer grade : studentGrades.get("Eve")) {
            sum += grade;
        }
        System.out.println("Eve's Average: " + (sum / studentGrades.get("Eve").size()));
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 8 learning with a Student Management System.

### Review
- Revisit:
  - `HashMap` for key-value pairs.
  - `HashSet` for unique elements.
  - Combining `ArrayList` and `HashMap`.
  - Iteration with `for-each` and collection methods.
- Debug common errors (e.g., missing keys in `HashMap`, null values).

### Mini-Project: Student Management System
Create a console-based program that:
1. Defines a `Student` class with private fields `id`, `name`, and `grades` (`ArrayList<Double>`).
2. Uses a `HashMap` to map student IDs to `Student` objects.
3. Includes methods to add a student, add a grade, and display all students.
4. Uses a `HashSet` to track unique course codes.
5. Validates inputs (e.g., unique IDs, valid grades).

**Project Code**:
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StudentManagementSystem {
    private HashMap<Integer, Student> students;
    private HashSet<String> courses;
    
    StudentManagementSystem() {
        students = new HashMap<>();
        courses = new HashSet<>();
    }
    
    void addStudent(int id, String name) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name));
            System.out.println("Added student: " + name);
        } else {
            System.out.println("ID already exists");
        }
    }
    
    void addGrade(int id, double grade, String course) {
        if (students.containsKey(id)) {
            students.get(id).addGrade(grade);
            courses.add(course);
        } else {
            System.out.println("Student not found");
        }
    }
    
    void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students");
            return;
        }
        for (Student student : students.values()) {
            student.displayDetails();
        }
        System.out.println("Courses: " + courses);
    }
    
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(101, "Alice");
        sms.addStudent(102, "Bob");
        sms.addGrade(101, 85.5, "Math");
        sms.addGrade(101, 90.0, "Science");
        sms.addGrade(102, 78.0, "Math");
        sms.displayStudents();
    }
}

class Student {
    private int id;
    private String name;
    private ArrayList<Double> grades;
    
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade");
        }
    }
    
    double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}
```

### Weekend Practice
1. Run and test the system with different students, grades, and courses.
2. Add a method to find a student by ID and print their details.
3. Extend the program to calculate the highest average grade across all students.

**Extended Practice Code** (with find method):
```java
import java.util.ArrayList;
import java.util.HashMap;

public class ExtendedStudentManagementSystem {
    private HashMap<Integer, Student> students;
    
    ExtendedStudentManagementSystem() {
        students = new HashMap<>();
    }
    
    void addStudent(int id, String name) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name));
        }
    }
    
    void findStudent(int id) {
        if (students.containsKey(id)) {
            students.get(id).displayDetails();
        } else {
            System.out.println("Student not found");
        }
    }
    
    public static void main(String[] args) {
        ExtendedStudentManagementSystem sms = new ExtendedStudentManagementSystem();
        sms.addStudent(101, "Alice");
        sms.addStudent(102, "Bob");
        sms.findStudent(101);
        sms.findStudent(103);
    }
}

class Student {
    private int id;
    private String name;
    private ArrayList<Double> grades;
    
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
```

---

## Tips for Week 8
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Watch for missing keys in `HashMap` or null values in collections.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for collections details.
- **Experiment**: Modify collection operations or add validation to see effects.