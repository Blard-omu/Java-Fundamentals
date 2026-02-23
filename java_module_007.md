# Java Module 007: Week 7 - Arrays and Collections

This module covers Java's array and collection data structures, focusing on one-dimensional and multi-dimensional arrays, `ArrayList`, `LinkedList`, and iteration with loops and `for-each`. Designed for beginners building on Weeks 1-6 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 7. The module concludes with a console-based Student Grade Management System mini-project to apply these concepts.

---

## Day 1: One-Dimensional Arrays
**Objective**: Learn to declare, initialize, and manipulate one-dimensional arrays.

### Explanation
- **Array**: A fixed-size collection of elements of the same type.
- **Syntax**:
  - Declaration: `type[] arrayName;`
  - Initialization: `arrayName = new type[size];` or `type[] arrayName = {value1, value2, ...};`
- Access elements using index (0-based): `arrayName[index]`.
- Use `.length` to get array size.

### Code Examples
**Example 1: Basic Array**
```java
public class BasicArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);
    }
}
```

**Example 2: Array Initialization**
```java
public class ArrayInitExample {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + names[i]);
        }
    }
}
```

**Example 3: Array with Loop**
```java
public class ArrayLoopExample {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.75, 15.0};
        double sum = 0;
        
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        System.out.println("Total: $" + sum);
    }
}
```

### Practice
1. Create an array of 5 integers and print each element.
2. Write a program to calculate the average of an array of doubles.
3. Create a `String` array of names and print them in reverse order.

**Practice Code**:
```java
public class ArrayPractice {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Number: " + numbers[i]);
        }
        
        double[] grades = {85.5, 90.0, 78.5};
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        System.out.println("Average: " + (sum / grades.length));
    }
}
```

---

## Day 2: Multi-Dimensional Arrays
**Objective**: Work with multi-dimensional arrays (e.g., 2D arrays).

### Explanation
- **Multi-Dimensional Array**: An array of arrays, often used for matrices or grids.
- **Syntax**:
  - Declaration: `type[][] arrayName;`
  - Initialization: `arrayName = new type[rows][columns];` or `type[][] arrayName = {{...}, {...}};`
- Access elements: `arrayName[row][col]`.
- Use nested loops for iteration.

### Code Examples
**Example 1: 2D Array Declaration**
```java
public class MatrixExample {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        
        System.out.println("Element at [1][2]: " + matrix[1][2]);
    }
}
```

**Example 2: 2D Array Initialization**
```java
public class MatrixInitExample {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

**Example 3: Sum of 2D Array**
```java
public class MatrixSumExample {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20}, {30, 40}, {50, 60}};
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Matrix Sum: " + sum);
    }
}
```

### Practice
1. Create a 2x3 integer matrix and print all elements.
2. Write a program to find the maximum value in a 2D array.
3. Create a 2D array to store student scores (rows: students, columns: subjects) and calculate each student’s average.

**Practice Code**:
```java
public class MatrixPractice {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
        System.out.println("Max: " + max);
    }
}
```

---

## Day 3: `ArrayList`
**Objective**: Use `ArrayList` for dynamic lists.

### Explanation
- **ArrayList**: A resizable array from the Java Collections Framework.
- **Syntax**: `ArrayList<Type> list = new ArrayList<>();`
- Common methods:
  - `add(element)`: Adds an element.
  - `remove(index)`: Removes an element.
  - `get(index)`: Accesses an element.
  - `size()`: Returns the number of elements.
- Requires `import java.util.ArrayList;`.

### Code Examples
**Example 1: Basic ArrayList**
```java
import java.util.ArrayList;

public class ArrayListBasicExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        System.out.println("Names: " + names);
        System.out.println("Size: " + names.size());
    }
}
```

**Example 2: Manipulating ArrayList**
```java
import java.util.ArrayList;

public class ArrayListManipExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        numbers.remove(1); // Remove 20
        System.out.println("After removal: " + numbers);
        System.out.println("First element: " + numbers.get(0));
    }
}
```

**Example 3: ArrayList with Loop**
```java
import java.util.ArrayList;

public class ArrayListLoopExample {
    public static void main(String[] args) {
        ArrayList<Double> prices = new ArrayList<>();
        prices.add(15.99);
        prices.add(29.99);
        prices.add(9.99);
        
        double sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
        }
        System.out.println("Total: $" + sum);
    }
}
```

### Practice
1. Create an `ArrayList` of strings to store cities; add and print 3 cities.
2. Write a program to remove an element from an `ArrayList` of integers.
3. Calculate the sum of an `ArrayList` of doubles.

**Practice Code**:
```java
import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        System.out.println("Cities: " + cities);
        
        cities.remove(1);
        System.out.println("After removing London: " + cities);
    }
}
```

---

## Day 4: `for-each` Loop and `LinkedList`
**Objective**: Use `for-each` for iteration and explore `LinkedList`.

### Explanation
- **For-Each Loop**: Simplifies iteration over arrays or collections.
  - Syntax: `for (Type var : collection) { // code }`
- **LinkedList**: A dynamic list similar to `ArrayList`, but uses a linked structure (better for frequent insertions/deletions).
- Requires `import java.util.LinkedList;`.
- Common methods: Same as `ArrayList` (`add`, `remove`, `get`, `size`).

### Code Examples
**Example 1: For-Each with Array**
```java
public class ForEachArrayExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};
        
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
    }
}
```

**Example 2: For-Each with ArrayList**
```java
import java.util.ArrayList;

public class ForEachArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
```

**Example 3: LinkedList**
```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Double> scores = new LinkedList<>();
        scores.add(85.5);
        scores.add(90.0);
        scores.addFirst(95.0); // Add to start
        
        for (Double score : scores) {
            System.out.println("Score: " + score);
        }
    }
}
```

### Practice
1. Use a `for-each` loop to print elements of an integer array.
2. Create a `LinkedList` of strings; add and remove elements.
3. Use a `for-each` loop to sum an `ArrayList` of integers.

**Practice Code**:
```java
import java.util.ArrayList;
import java.util.LinkedList;

public class ForEachLinkedListPractice {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
        
        LinkedList<String> tasks = new LinkedList<>();
        tasks.add("Study");
        tasks.add("Code");
        tasks.addFirst("Plan");
        for (String task : tasks) {
            System.out.println("Task: " + task);
        }
    }
}
```

---

## Day 5: Review and Collections Use Cases
**Objective**: Solidify arrays, `ArrayList`, `LinkedList`, and iteration techniques.

### Explanation
- Review best practices:
  - Use arrays for fixed-size data; use `ArrayList`/`LinkedList` for dynamic data.
  - Choose `for-each` for simple iteration; use indexed loops for modifications.
  - Validate indices to avoid `ArrayIndexOutOfBoundsException`.
- Combine with Weeks 1-6 concepts (OOP, loops, methods).

### Code Examples
**Example 1: Array vs ArrayList**
```java
import java.util.ArrayList;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        int[] fixedArray = {1, 2, 3};
        ArrayList<Integer> dynamicList = new ArrayList<>();
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
        
        for (int num : fixedArray) {
            System.out.println("Array: " + num);
        }
        for (int num : dynamicList) {
            System.out.println("ArrayList: " + num);
        }
    }
}
```

**Example 2: LinkedList with Validation**
```java
import java.util.LinkedList;

public class LinkedListValidation {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        
        addName(names, "Alice");
        addName(names, "");
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
    
    static void addName(LinkedList<String> list, String name) {
        if (name != null && !name.isEmpty()) {
            list.add(name);
        } else {
            System.out.println("Invalid name");
        }
    }
}
```

**Example 3: Combining Arrays and Collections**
```java
import java.util.ArrayList;

public class ArrayToArrayList {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : numbers) {
            if (num > 15) {
                list.add(num);
            }
        }
        System.out.println("Filtered List: " + list);
    }
}
```

### Practice
1. Convert an array of doubles to an `ArrayList` and print it.
2. Write a method to add valid names to a `LinkedList` (non-empty strings).
3. Create a program to filter numbers greater than 50 from an array into an `ArrayList`.

**Practice Code**:
```java
import java.util.ArrayList;

public class CollectionsReviewPractice {
    public static void main(String[] args) {
        double[] values = {10.5, 20.75, 15.0};
        ArrayList<Double> list = new ArrayList<>();
        for (double val : values) {
            list.add(val);
        }
        System.out.println("ArrayList: " + list);
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 7 learning with a Student Grade Management System.

### Review
- Revisit:
  - One-dimensional and multi-dimensional arrays.
  - `ArrayList` and `LinkedList` for dynamic data.
  - `for-each` loop for iteration.
  - Combining arrays and collections.
- Debug common errors (e.g., index out of bounds, null elements).

### Mini-Project: Student Grade Management System
Create a console-based program that:
1. Defines a `Student` class with private fields `name` and `grades` (use `ArrayList<Double>`).
2. Uses methods to add grades, calculate average, and display details.
3. Stores multiple `Student` objects in an array or `ArrayList`.
4. Uses `for-each` to iterate and print student details.
5. Validates grades (0-100).

**Project Code**:
```java
import java.util.ArrayList;

public class StudentGradeSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));
        
        students.get(0).addGrade(85.5);
        students.get(0).addGrade(90.0);
        students.get(1).addGrade(78.0);
        
        for (Student student : students) {
            student.displayDetails();
        }
    }
}

class Student {
    private String name;
    private ArrayList<Double> grades;
    
    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("Added grade " + grade + " for " + name);
        } else {
            System.out.println("Invalid grade");
        }
    }
    
    double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    void displayDetails() {
        System.out.println("Student: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}
```

### Weekend Practice
1. Run and test the system with different students and grades.
2. Add a method to find the student with the highest average grade.
3. Extend the program to use a 2D array for grades (e.g., multiple subjects).

**Extended Practice Code** (with highest average):
```java
import java.util.ArrayList;

public class ExtendedStudentGradeSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));
        
        students.get(0).addGrade(85.5);
        students.get(0).addGrade(90.0);
        students.get(1).addGrade(78.0);
        
        findTopStudent(students);
    }
    
    static void findTopStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students");
            return;
        }
        Student topStudent = students.get(0);
        double maxAverage = topStudent.calculateAverage();
        
        for (Student student : students) {
            double avg = student.calculateAverage();
            if (avg > maxAverage) {
                maxAverage = avg;
                topStudent = student;
            }
        }
        System.out.println("Top Student: " + topStudent.getName() + ", Average: " + maxAverage);
    }
}

class Student {
    private String name;
    private ArrayList<Double> grades;
    
    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        }
    }
    
    double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    String getName() {
        return name;
    }
}
```

---

## Tips for Week 7
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Watch for `IndexOutOfBoundsException` or null elements in collections.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for arrays and collections.
- **Experiment**: Try different array sizes or collection operations to see their effects.