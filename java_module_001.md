# Java Module 001: Week 1 - Java Basics

This module covers the foundational concepts of Java, including setup, basic syntax, data types, variables, constants, and operators. Designed for beginners, it includes explanations, code examples, and practice exercises for each day of Week 1. By the end, you'll write simple programs and understand Java's core components.

---

## Day 1: Introduction to Java
**Objective**: Understand Java's ecosystem and write your first program.

### Explanation
- **Java Overview**:
  - **JDK (Java Development Kit)**: Tools for developing Java programs (compiler, libraries).
  - **JRE (Java Runtime Environment)**: Runs Java programs (includes JVM and libraries).
  - **JVM (Java Virtual Machine)**: Executes Java bytecode, enabling platform independence.
- **First Program**: A Java program starts with a `main` method, the entry point. Use `System.out.println` to print output to the console.

### Code Example
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Practice
1. Install the JDK (e.g., OpenJDK or Oracle JDK).
2. Write a program to print your name and a welcome message.
3. Run the program using a terminal or IDE (e.g., IntelliJ, Eclipse).

**Practice Code**:
```java
public class MyFirstProgram {
    public static void main(String[] args) {
        System.out.println("My name is [Your Name]");
        System.out.println("Welcome to Java!");
    }
}
```

---

## Day 2: Comments, Data Types, and Variables
**Objective**: Learn to document code with comments and use basic data types and variables.

### Explanation
- **Comments**:
  - Single-line: `// This is a comment`
  - Multi-line: `/* This is a multi-line comment */`
- **Data Types**:
  - **Primitive**: `int` (integer), `double` (decimal), `char` (single character), `boolean` (true/false).
  - Example: `int age = 25; double price = 19.99; char grade = 'A'; boolean isStudent = true;`
- **Variables**: Named storage for data, declared with a type (e.g., `int number;`).
- **Constants**: Use `final` to make variables unchangeable (e.g., `final double PI = 3.14159;`).

### Code Example
```java
public class DataTypesExample {
    public static void main(String[] args) {
        // Declare variables
        int age = 25;
        double salary = 50000.50;
        char initial = 'J';
        boolean isEmployed = true;
        final double TAX_RATE = 0.1;

        // Print variables
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Initial: " + initial);
        System.out.println("Employed: " + isEmployed);
        System.out.println("Tax Rate: " + TAX_RATE);
    }
}
```

### Practice
1. Write a program to declare and print variables of `int`, `double`, `char`, and `boolean` types.
2. Create a constant for a maximum score (e.g., 100) and print it.
3. Add single-line and multi-line comments to explain your code.

**Practice Code**:
```java
public class VariablesPractice {
    public static void main(String[] args) {
        // Declaring variables
        int score = 85;
        double price = 29.99;
        char grade = 'B';
        boolean isPassing = true;
        final int MAX_SCORE = 100;

        /* Printing variable values
           to demonstrate data types */
        System.out.println("Score: " + score);
        System.out.println("Price: " + price);
        System.out.println("Grade: " + grade);
        System.out.println("Passing: " + isPassing);
        System.out.println("Max Score: " + MAX_SCORE);
    }
}
```

---

## Day 3: Non-Primitive Types and String Operations
**Objective**: Work with `String` (non-primitive type) and perform basic string operations.

### Explanation
- **Non-Primitive Types**: Unlike primitives, these are objects (e.g., `String`, arrays).
- **String**: Represents text, created with quotes (e.g., `String name = "Alice";`).
- Common String operations:
  - Concatenation: `+` (e.g., `"Hello, " + name`).
  - Methods: `.length()`, `.toUpperCase()`, `.toLowerCase()`.

### Code Example
```java
public class StringExample {
    public static void main(String[] args) {
        String name = "Alice";
        String greeting = "Hello, " + name + "!";
        
        System.out.println(greeting);
        System.out.println("Name length: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());
    }
}
```

### Practice
1. Create a program to declare a `String` variable for your name and concatenate it with a greeting.
2. Print the length of the string and convert it to uppercase.
3. Use a constant `String` for a fixed message (e.g., "Welcome").

**Practice Code**:
```java
public class StringPractice {
    public static void main(String[] args) {
        String name = "[Your Name]";
        final String WELCOME = "Welcome to Java!";
        String message = WELCOME + " " + name;

        System.out.println(message);
        System.out.println("Name length: " + name.length());
        System.out.println("Message in uppercase: " + message.toUpperCase());
    }
}
```

---

## Day 4: Arithmetic Operators
**Objective**: Use arithmetic operators to perform calculations.

### Explanation
- **Arithmetic Operators**:
  - `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), `%` (modulus).
  - Example: `int sum = 5 + 3; int remainder = 10 % 3; // remainder is 1`
- Division:
  - Integer division truncates decimals (e.g., `5 / 2 = 2`).
  - Use `double` for decimal results (e.g., `5.0 / 2 = 2.5`).

### Code Example
```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));
        System.out.println("Decimal Division: " + (a / (double)b));
    }
}
```

### Practice
1. Write a program to calculate the area of a rectangle (length * width).
2. Compute the remainder when dividing two numbers.
3. Perform division with decimal output using type casting.

**Practice Code**:
```java
public class ArithmeticPractice {
    public static void main(String[] args) {
        int length = 10, width = 5;
        int area = length * width;
        int num1 = 17, num2 = 4;
        
        System.out.println("Rectangle Area: " + area);
        System.out.println("Remainder of " + num1 + " / " + num2 + ": " + (num1 % num2));
        System.out.println("Decimal Division: " + (num1 / (double)num2));
    }
}
```

---

## Day 5: Comparison and Logical Operators
**Objective**: Use comparison and logical operators for decision-making.

### Explanation
- **Comparison Operators**:
  - `==` (equal), `!=` (not equal), `>` (greater), `<` (less), `>=`, `<=`.
  - Example: `int x = 5; boolean isEqual = (x == 5); // true`
- **Logical Operators**:
  - `&&` (AND), `||` (OR), `!` (NOT).
  - Example: `boolean result = (x > 0 && x < 10); // true if x is between 0 and 10`

### Code Example
```java
public class OperatorsExample {
    public static void main(String[] args) {
        int number = 7;
        boolean isPositive = number > 0;
        boolean isEven = number % 2 == 0;
        boolean isValid = isPositive && !isEven;

        System.out.println("Is " + number + " positive? " + isPositive);
        System.out.println("Is " + number + " even? " + isEven);
        System.out.println("Is positive and odd? " + isValid);
    }
}
```

### Practice
1. Write a program to check if a number is positive and even.
2. Use logical operators to check if a number is between 1 and 100.
3. Combine comparison and logical operators to validate input.

**Practice Code**:
```java
public class OperatorsPractice {
    public static void main(String[] args) {
        int number = 42;
        boolean isPositive = number > 0;
        boolean isEven = number % 2 == 0;
        boolean inRange = number >= 1 && number <= 100;

        System.out.println(number + " is positive: " + isPositive);
        System.out.println(number + " is even: " + isEven);
        System.out.println(number + " is between 1 and 100: " + inRange);
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 1 learning with a small project.

### Review
- Revisit:
  - JDK/JRE/JVM roles.
  - Comments, data types, variables, constants.
  - String operations and arithmetic operators.
  - Comparison and logical operators.
- Debug common errors (e.g., missing `;`, wrong data types).

### Mini-Project: Personal Info Program
Create a console-based program that:
1. Stores your name (`String`), age (`int`), height (`double`), and student status (`boolean`).
2. Uses a constant for a maximum age (e.g., 120).
3. Performs calculations (e.g., height in meters if given in cm).
4. Checks if the person is a student and age is valid (0 to max age).
5. Prints all details with appropriate formatting.

**Project Code**:
```java
public class PersonalInfo {
    public static void main(String[] args) {
        // Declare variables and constant
        String name = "[Your Name]";
        int age = 25;
        double heightCm = 175.5;
        boolean isStudent = true;
        final int MAX_AGE = 120;

        // Perform calculations
        double heightMeters = heightCm / 100;
        boolean isAgeValid = age > 0 && age <= MAX_AGE;

        // Print details
        System.out.println("Personal Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " (Valid: " + isAgeValid + ")");
        System.out.println("Height: " + heightMeters + " meters");
        System.out.println("Student: " + isStudent);
    }
}
```

### Weekend Practice
1. Run and test the project with different inputs.
2. Add comments to explain each section.
3. Modify the program to include another calculation (e.g., age in months).

---

## Tips for Week 1
- **Practice**: Run each code example in an IDE or terminal.
- **Debug**: Check for syntax errors (e.g., missing semicolons, incorrect capitalization).
- **Resources**: Use Oracle’s Java Tutorials or W3Schools for reference.
- **Experiment**: Try modifying code examples to see how changes affect output.
