# Java Module 002: Week 2 - Control Flow (Conditionals)

This module covers Java's conditional control flow constructs, including `if`, `else if`, `else`, nested conditionals, and `switch` statements. Designed for beginners building on Week 1, it includes explanations, code examples, and practice exercises for each day of Week 2 in the 3-month Java fundamentals plan. By the end, you'll be able to write programs that make decisions based on conditions and create a quiz program as a mini-project.

---

## Day 1: `if`, `else if`, `else` Statements
**Objective**: Learn to use `if`, `else if`, and `else` for basic decision-making.

### Explanation
- **Conditional Statements**: Control program flow based on conditions.
- **`if` Statement**: Executes code if a condition is `true`.
  - Syntax: `if (condition) { // code }`
- **`else if`**: Checks additional conditions if the previous `if` is `false`.
- **`else`**: Executes code if no conditions are `true`.
- Conditions use comparison (`==`, `!=`, `>`, `<`, etc.) and logical operators (`&&`, `||`, `!`).

### Code Example
```java
public class IfExample {
    public static void main(String[] args) {
        int number = 15;
        
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println(number + " is zero");
        }
    }
}
```

### Practice
1. Write a program to check if a number is positive, negative, or zero.
2. Create a program to determine if a person can vote (age >= 18).
3. Use `else if` to categorize a score: excellent (90+), good (70-89), or fail (<70).

**Practice Code**:
```java
public class IfPractice {
    public static void main(String[] args) {
        int score = 85;
        
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 70) {
            System.out.println("Good");
        } else {
            System.out.println("Fail");
        }
    }
}
```

---

## Day 2: Nested `if` Statements
**Objective**: Understand and use nested `if` statements for complex conditions.

### Explanation
- **Nested `if`**: An `if` statement inside another `if` or `else` block.
- Used for multi-level decision-making.
- Example: Check if a number is positive, then check if it’s even.
- Avoid excessive nesting for readability; use logical operators when possible.

### Code Example
```java
public class NestedIfExample {
    public static void main(String[] args) {
        int number = 24;
        
        if (number > 0) {
            System.out.println(number + " is positive");
            if (number % 2 == 0) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
        } else {
            System.out.println(number + " is not positive");
        }
    }
}
```

### Practice
1. Write a program to categorize age: child (<13), teen (13-19), adult (20+).
2. Add a nested check to see if an adult is a senior (60+).
3. Rewrite one practice using logical operators instead of nesting (e.g., `age >= 13 && age <= 19` for teen).

**Practice Code**:
```java
public class NestedIfPractice {
    public static void main(String[] args) {
        int age = 65;
        
        if (age < 13) {
            System.out.println("Child");
        } else if (age <= 19) {
            System.out.println("Teen");
        } else {
            System.out.println("Adult");
            if (age >= 60) {
                System.out.println("Senior");
            }
        }
    }
}
```

---

## Day 3: `switch` Statement
**Objective**: Use `switch` for multi-option decision-making.

### Explanation
- **Switch Statement**: Selects code to execute based on a variable’s value.
- Syntax: 
  ```java
  switch (variable) {
      case value1: // code; break;
      case value2: // code; break;
      default: // code;
  }
  ```
- `break`: Exits the switch block.
- `default`: Executes if no case matches.
- Best for discrete values (e.g., integers, strings).

### Code Example
```java
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;
        
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
```

### Practice
1. Write a program to print day names based on numbers (1-7).
2. Create a program to assign grades (A, B, C, etc.) based on a score range (e.g., 90-100 = A).
3. Add a `default` case to handle invalid inputs.

**Practice Code**:
```java
public class SwitchPractice {
    public static void main(String[] args) {
        char grade = 'B';
        
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            case 'C':
                System.out.println("Average");
                break;
            default:
                System.out.println("Invalid grade");
        }
    }
}
```

---

## Day 4: Combining `if` and `switch`
**Objective**: Combine conditionals for menu-driven programs.

### Explanation
- Use `if` and `switch` together for flexible decision-making.
- Example: Use `if` to validate input, then `switch` to handle options.
- Ensures robust programs by checking conditions before switching.

### Code Example
```java
public class MenuExample {
    public static void main(String[] args) {
        int choice = 2;
        
        if (choice >= 1 && choice <= 3) {
            switch (choice) {
                case 1:
                    System.out.println("Start Game");
                    break;
                case 2:
                    System.out.println("Load Game");
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
}
```

### Practice
1. Create a menu-driven program with options (e.g., 1: Add, 2: Subtract, 3: Exit).
2. Use `if` to validate the choice before processing with `switch`.
3. Add a message for invalid inputs.

**Practice Code**:
```java
public class MenuPractice {
    public static void main(String[] args) {
        int operation = 1;
        int a = 10, b = 5;
        
        if (operation >= 1 && operation <= 3) {
            switch (operation) {
                case 1:
                    System.out.println("Add: " + (a + b));
                    break;
                case 2:
                    System.out.println("Subtract: " + (a - b));
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        } else {
            System.out.println("Invalid operation");
        }
    }
}
```

---

## Day 5: Review and Edge Cases
**Objective**: Solidify conditionals and handle edge cases.

### Explanation
- **Edge Cases**: Unexpected inputs (e.g., negative numbers, zero, invalid types).
- Use conditionals to validate inputs and prevent errors.
- Example: Check if input is within a valid range before processing.

### Code Example
```java
public class EdgeCaseExample {
    public static void main(String[] args) {
        int score = -10;
        
        if (score < 0 || score > 100) {
            System.out.println("Invalid score: must be between 0 and 100");
        } else if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 70) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: C or below");
        }
    }
}
```

### Practice
1. Write a program to validate a test score (0-100) and assign a grade.
2. Handle edge cases (negative scores, scores > 100).
3. Combine `if` and `switch` to process a validated input.

**Practice Code**:
```java
public class EdgeCasePractice {
    public static void main(String[] args) {
        int score = 95;
        
        if (score < 0 || score > 100) {
            System.out.println("Invalid score");
        } else {
            char grade;
            if (score >= 90) grade = 'A';
            else if (score >= 70) grade = 'B';
            else grade = 'C';
            
            switch (grade) {
                case 'A':
                    System.out.println("Excellent");
                    break;
                case 'B':
                    System.out.println("Good");
                    break;
                case 'C':
                    System.out.println("Needs Improvement");
                    break;
            }
        }
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 2 learning with a quiz program.

### Review
- Revisit:
  - `if`, `else if`, `else` for decision-making.
  - Nested `if` for multi-level conditions.
  - `switch` for discrete options.
  - Combining conditionals and handling edge cases.
- Debug common errors (e.g., missing `break` in `switch`, incorrect conditions).

### Mini-Project: Simple Quiz Program
Create a console-based quiz program that:
1. Asks a multiple-choice question (e.g., "What is 2 + 2? A: 3, B: 4, C: 5").
2. Uses `char` or `String` for user input (e.g., 'A', 'B', 'C').
3. Validates input with `if` (e.g., ensure input is A, B, or C).
4. Uses `switch` to check the answer and print feedback.
5. Handles invalid inputs (e.g., 'D') with a default message.

**Project Code**:
```java
public class QuizProgram {
    public static void main(String[] args) {
        char answer = 'B'; // Simulate user input
        
        // Validate input
        if (answer == 'A' || answer == 'B' || answer == 'C') {
            System.out.println("Question: What is 2 + 2?");
            System.out.println("A: 3, B: 4, C: 5");
            
            switch (answer) {
                case 'A':
                    System.out.println("Incorrect. The answer is 4.");
                    break;
                case 'B':
                    System.out.println("Correct! 2 + 2 = 4.");
                    break;
                case 'C':
                    System.out.println("Incorrect. The answer is 4.");
                    break;
            }
        } else {
            System.out.println("Invalid answer. Please choose A, B, or C.");
        }
    }
}
```

### Weekend Practice
1. Run and test the quiz program with different inputs.
2. Add a second question with different options.
3. Modify the program to track a score (e.g., +1 for correct, 0 for incorrect).

---

## Tips for Week 2
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Watch for missing `break` statements in `switch` or incorrect logical conditions.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for control flow details.
- **Experiment**: Modify code to test different conditions and edge cases.