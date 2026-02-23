# Java Module 004: Week 4 - Methods and Calculator Project

This module covers Java methods, including declaration, parameters, return types, overloading, and variable scope. Designed for beginners building on Weeks 1-3 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 4. The module culminates in a console-based Simple Calculator project. By the end, you'll be able to create reusable methods and apply them in a practical program.

---

## Day 1: Method Declaration, Calling, and Return Types
**Objective**: Learn to create and use methods with and without return values.

### Explanation
- **Methods**: Reusable blocks of code that perform specific tasks.
- **Components**:
  - **Declaration**: Includes return type, method name, and parameters (e.g., `int add(int a, int b)`).
  - **Return Type**: Specifies what the method returns (`void` for no return, or types like `int`, `double`).
  - **Calling**: Invoke a method by its name and arguments (e.g., `add(5, 3)`).
- **Syntax**:
  ```java
  returnType methodName(parameters) {
      // code
      return value; // if not void
  }
  ```

### Code Examples
**Example 1: Void Method**
```java
public class VoidMethodExample {
    public static void main(String[] args) {
        printGreeting("Alice");
    }
    
    // Void method: no return value
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
```

**Example 2: Method with Return**
```java
public class ReturnMethodExample {
    public static void main(String[] args) {
        int result = squareNumber(5);
        System.out.println("Square: " + result);
    }
    
    // Returns an int
    public static int squareNumber(int num) {
        return num * num;
    }
}
```

**Example 3: Method with Multiple Parameters**
```java
public class MultiParamExample {
    public static void main(String[] args) {
        double area = calculateArea(4.5, 3.2);
        System.out.println("Area: " + area);
    }
    
    // Returns double, takes two parameters
    public static double calculateArea(double length, double width) {
        return length * width;
    }
}
```

### Practice
1. Write a method to print a welcome message with a name parameter.
2. Create a method that returns the cube of a number (`num * num * num`).
3. Write a method that takes two integers and returns their product.

**Practice Code**:
```java
public class MethodPractice {
    public static void main(String[] args) {
        displayWelcome("Bob");
        int cube = cubeNumber(3);
        System.out.println("Cube: " + cube);
        int product = multiply(4, 5);
        System.out.println("Product: " + product);
    }
    
    public static void displayWelcome(String name) {
        System.out.println("Welcome, " + name + "!");
    }
    
    public static int cubeNumber(int num) {
        return num * num * num;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}
```

---

## Day 2: Methods with Parameters
**Objective**: Explore methods with multiple parameters and different types.

### Explanation
- **Parameters**: Inputs to a method, defined in the method signature.
- Can have multiple parameters of different types (e.g., `int`, `double`, `String`).
- Parameters act as local variables inside the method.
- Use parameters to make methods flexible and reusable.

### Code Examples
**Example 1: Multiple Parameter Types**
```java
public class ParamTypeExample {
    public static void main(String[] args) {
        printDetails("Alice", 25);
    }
    
    public static void printDetails(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

**Example 2: Parameter Validation**
```java
public class ParamValidationExample {
    public static void main(String[] args) {
        checkAge(15);
        checkAge(-5);
    }
    
    public static void checkAge(int age) {
        if (age >= 0) {
            System.out.println("Valid age: " + age);
        } else {
            System.out.println("Invalid age");
        }
    }
}
```

**Example 3: Complex Calculation**
```java
public class ComplexCalcExample {
    public static void main(String[] args) {
        double total = calculateTotal(100.50, 0.1, 2);
        System.out.println("Total with tax: " + total);
    }
    
    public static double calculateTotal(double price, double taxRate, int quantity) {
        return price * quantity * (1 + taxRate);
    }
}
```

### Practice
1. Write a method that takes a `String` name and `int` score, then prints a formatted result.
2. Create a method that takes two `double` values and returns their average.
3. Write a method to check if a number is positive, taking an `int` parameter.

**Practice Code**:
```java
public class ParamPractice {
    public static void main(String[] args) {
        printResult("Charlie", 85);
        double avg = average(10.5, 20.5);
        System.out.println("Average: " + avg);
        isPositive(7);
    }
    
    public static void printResult(String name, int score) {
        System.out.println(name + " scored " + score + " points");
    }
    
    public static double average(double num1, double num2) {
        return (num1 + num2) / 2;
    }
    
    public static void isPositive(int num) {
        if (num > 0) {
            System.out.println(num + " is positive");
        } else {
            System.out.println(num + " is not positive");
        }
    }
}
```

---

## Day 3: Method Overloading
**Objective**: Understand method overloading for flexible method use.

### Explanation
- **Method Overloading**: Multiple methods with the same name but different parameter lists (number, type, or order).
- Java selects the correct method based on the arguments provided.
- Enhances code reusability and readability.

### Code Examples
**Example 1: Overloading by Number of Parameters**
```java
public class OverloadNumberExample {
    public static void main(String[] args) {
        System.out.println("Sum (2 params): " + add(3, 4));
        System.out.println("Sum (3 params): " + add(3, 4, 5));
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

**Example 2: Overloading by Type**
```java
public class OverloadTypeExample {
    public static void main(String[] args) {
        System.out.println("Int product: " + multiply(5, 3));
        System.out.println("Double product: " + multiply(5.5, 3.2));
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
}
```

**Example 3: Overloading with Mixed Types**
```java
public class OverloadMixedExample {
    public static void main(String[] args) {
        printInfo("Alice");
        printInfo("Bob", 30);
    }
    
    public static void printInfo(String name) {
        System.out.println("Name: " + name);
    }
    
    public static void printInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

### Practice
1. Write overloaded methods to calculate the area of a rectangle (`int` and `double` parameters).
2. Create overloaded methods to print a message (one with just a `String`, another with a `String` and `int` repeat count).
3. Write overloaded methods to find the maximum of two or three integers.

**Practice Code**:
```java
public class OverloadPractice {
    public static void main(String[] args) {
        System.out.println("Rectangle area (int): " + area(5, 3));
        System.out.println("Rectangle area (double): " + area(5.5, 3.2));
        printMessage("Hello", 2);
    }
    
    public static int area(int length, int width) {
        return length * width;
    }
    
    public static double area(double length, double width) {
        return length * width;
    }
    
    public static void printMessage(String msg) {
        System.out.println(msg);
    }
    
    public static void printMessage(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }
}
```

---

## Day 4: Variable Scope and Lifetime
**Objective**: Understand variable scope and lifetime in methods.

### Explanation
- **Scope**: Where a variable is accessible (e.g., within a method, block, or class).
  - **Local Variables**: Declared inside a method or block, accessible only there.
  - **Class/Instance Variables**: Declared at the class level (covered later).
- **Lifetime**: How long a variable exists (e.g., local variables exist only during method execution).
- Use parameters and local variables to avoid naming conflicts.

### Code Examples
**Example 1: Local Variable Scope**
```java
public class LocalScopeExample {
    public static void main(String[] args) {
        int x = 10; // Local to main
        printNumber(x);
        // System.out.println(y); // Error: y is not accessible
    }
    
    public static void printNumber(int y) {
        System.out.println("Number: " + y); // y is local to this method
    }
}
```

**Example 2: Block Scope**
```java
public class BlockScopeExample {
    public static void main(String[] args) {
        int x = 5;
        if (x > 0) {
            int y = 10; // Local to this block
            System.out.println("x: " + x + ", y: " + y);
        }
        // System.out.println(y); // Error: y is out of scope
    }
}
```

**Example 3: Parameter vs Local Variable**
```java
public class ParamScopeExample {
    public static void main(String[] args) {
        calculateSum(3, 4);
    }
    
    public static void calculateSum(int a, int b) {
        int sum = a + b; // sum is local
        System.out.println("Sum of " + a + " and " + b + ": " + sum);
    }
}
```

### Practice
1. Write a method with a local variable to store a temporary result.
2. Create a method that uses a parameter and a local variable with different names.
3. Experiment with a block-scoped variable in a loop and try accessing it outside.

**Practice Code**:
```java
public class ScopePractice {
    public static void main(String[] args) {
        countTo(5);
        // int temp; // Try declaring here and see what happens
    }
    
    public static void countTo(int limit) {
        for (int i = 1; i <= limit; i++) {
            int temp = i * 2; // Local to block
            System.out.println("i: " + i + ", temp: " + temp);
        }
        // System.out.println(temp); // Error: temp is out of scope
    }
}
```

---

## Day 5: Review and Method Design
**Objective**: Solidify method concepts and design robust methods.

### Explanation
- **Method Design**:
  - Use clear, descriptive names (e.g., `calculateArea` instead of `calc`).
  - Keep methods focused on one task.
  - Validate inputs to handle edge cases.
- Combine methods with Week 1-3 concepts (variables, conditionals, loops).

### Code Examples
**Example 1: Well-Designed Method**
```java
public class WellDesignedMethod {
    public static void main(String[] args) {
        boolean isEven = checkEven(6);
        System.out.println("Is 6 even? " + isEven);
    }
    
    public static boolean checkEven(int num) {
        return num % 2 == 0;
    }
}
```

**Example 2: Method with Validation**
```java
public class ValidateMethod {
    public static void main(String[] args) {
        divideNumbers(10, 0);
        divideNumbers(10, 2);
    }
    
    public static double divideNumbers(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0.0;
        }
        return (double) a / b;
    }
}
```

**Example 3: Combining Loops and Methods**
```java
public class LoopMethodExample {
    public static void main(String[] args) {
        printMultiples(3, 5);
    }
    
    public static void printMultiples(int num, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }
}
```

### Practice
1. Write a method to check if a number is prime (using a loop).
2. Create a method to print a range of numbers with validation (e.g., start <= end).
3. Design a method that combines loops and conditionals to count even numbers in a range.

**Practice Code**:
```java
public class MethodDesignPractice {
    public static void main(String[] args) {
        System.out.println("Is 17 prime? " + isPrime(17));
        printRange(1, 5);
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static void printRange(int start, int end) {
        if (start > end) {
            System.out.println("Error: Start must be <= end");
            return;
        }
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 4 learning with a Simple Calculator project.

### Review
- Revisit:
  - Method declaration, calling, and return types.
  - Parameters and their types.
  - Method overloading for flexibility.
  - Variable scope and lifetime.
  - Designing robust methods with validation.
- Debug common errors (e.g., incorrect return types, parameter mismatches).

### Mini-Project: Simple Calculator
Create a console-based calculator that:
1. Defines methods for addition, subtraction, multiplication, and division.
2. Uses method overloading for `int` and `double` inputs.
3. Validates inputs (e.g., division by zero).
4. Uses a menu-driven interface (from Week 2) with a loop to repeat operations.
5. Prints results with clear formatting.

**Project Code**:
```java
public class SimpleCalculator {
    public static void main(String[] args) {
        int choice = 1; // Simulate user input
        int a = 10, b = 5;
        double x = 10.5, y = 2.5;
        
        // Menu loop (simplified with hardcoded choice)
        if (choice >= 1 && choice <= 4) {
            switch (choice) {
                case 1:
                    System.out.println("Add (int): " + add(a, b));
                    System.out.println("Add (double): " + add(x, y));
                    break;
                case 2:
                    System.out.println("Subtract: " + subtract(a, b));
                    break;
                case 3:
                    System.out.println("Multiply: " + multiply(a, b));
                    break;
                case 4:
                    double result = divide(a, b);
                    System.out.println("Divide: " + result);
                    break;
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
    
    // Overloaded add methods
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Subtract method
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    // Multiply method
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    // Divide method with validation
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0.0;
        }
        return (double) a / b;
    }
}
```

### Weekend Practice
1. Run and test the calculator with different inputs.
2. Add a `while` loop to allow multiple operations until the user chooses to exit.
3. Extend the calculator with a method for modulus (`%`) operation.

**Extended Practice Code** (with loop):
```java
public class ExtendedCalculator {
    public static void main(String[] args) {
        int choice = 1; // Hardcoded for testing
        int a = 10, b = 5;
        
        while (choice != 5) {
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        System.out.println("Add: " + add(a, b));
                        break;
                    case 2:
                        System.out.println("Subtract: " + subtract(a, b));
                        break;
                    case 3:
                        System.out.println("Multiply: " + multiply(a, b));
                        break;
                    case 4:
                        System.out.println("Divide: " + divide(a, b));
                        break;
                }
            } else {
                System.out.println("Invalid choice");
            }
            choice = 5; // Exit loop for testing
        }
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0.0;
        }
        return (double) a / b;
    }
}
```

---

## Tips for Week 4
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Check for return type mismatches, missing `return` statements, or scope errors.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for method details.
- **Experiment**: Modify method parameters or add validation to see effects.