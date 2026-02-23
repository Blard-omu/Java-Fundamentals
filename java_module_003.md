# Java Module 003: Week 3 - Control Flow (Loops)

This module covers Java's loop constructs: `for`, `while`, `do-while`, `break`, and `continue`. Designed for beginners building on Weeks 1 and 2, it includes explanations, code examples, and practice exercises for each day of Week 3 in the 3-month Java fundamentals plan. By the end, you'll write programs that repeat tasks efficiently and create a prime number checker as a mini-project.

---

## Day 1: `for` Loop
**Objective**: Learn to use the `for` loop for controlled repetition.

### Explanation
- **For Loop**: Executes a block of code a specific number of times.
- **Syntax**:
  ```java
  for (initialization; condition; update) {
      // code
  }
  ```
- **Components**:
  - Initialization: Sets loop variable (e.g., `int i = 0`).
  - Condition: Checked before each iteration (e.g., `i < 10`).
  - Update: Modifies loop variable (e.g., `i++`).
- Use for known iteration counts (e.g., iterating 1 to 10).

### Code Example
```java
public class ForLoopExample {
    public static void main(String[] args) {
        // Print numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
    }
}
```

### Practice
1. Write a program to print numbers 1 to 10 using a `for` loop.
2. Calculate and print the sum of numbers 1 to 10.
3. Print even numbers from 2 to 20.

**Practice Code**:
```java
public class ForLoopPractice {
    public static void main(String[] args) {
        // Print 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        
        // Calculate sum
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
```

---

## Day 2: `while` Loop
**Objective**: Use the `while` loop for condition-based repetition.

### Explanation
- **While Loop**: Executes code as long as a condition is `true`.
- **Syntax**:
  ```java
  while (condition) {
      // code
  }
  ```
- Requires manual variable update to avoid infinite loops.
- Best for unknown iteration counts (e.g., waiting for user input).

### Code Example
```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Number: " + i);
            i++; // Update to prevent infinite loop
        }
    }
}
```

### Practice
1. Print even numbers from 2 to 20 using a `while` loop.
2. Calculate the sum of numbers until the sum exceeds 50.
3. Print numbers in reverse (10 to 1).

**Practice Code**:
```java
public class WhileLoopPractice {
    public static void main(String[] args) {
        // Print even numbers
        int num = 2;
        while (num <= 20) {
            System.out.println(num);
            num += 2;
        }
        
        // Sum until > 50
        int sum = 0, i = 1;
        while (sum <= 50) {
            sum += i;
            i++;
        }
        System.out.println("Sum: " + sum);
    }
}
```

---

## Day 3: `do-while` Loop
**Objective**: Understand the `do-while` loop for guaranteed execution.

### Explanation
- **Do-While Loop**: Executes code at least once, then repeats if condition is `true`.
- **Syntax**:
  ```java
  do {
      // code
  } while (condition);
  ```
- Useful when code must run before checking the condition (e.g., user input prompts).

### Code Example
```java
public class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println("Number: " + i);
            i++;
        } while (i <= 5);
    }
}
```

### Practice
1. Write a program to print numbers 1 to 5 using `do-while`.
2. Simulate a user input loop that continues until a positive number is entered (use a hardcoded value for now).
3. Compare `while` and `do-while` by rewriting a Day 2 practice with `do-while`.

**Practice Code**:
```java
public class DoWhilePractice {
    public static void main(String[] args) {
        // Print 1 to 5
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
        
        // Simulate input until positive
        int input = -1;
        do {
            System.out.println("Input: " + input);
            input++; // Simulate changing input
        } while (input <= 0);
    }
}
```

---

## Day 4: `break` and `continue`
**Objective**: Control loop flow with `break` and `continue`.

### Explanation
- **Break**: Exits the loop immediately.
- **Continue**: Skips the current iteration and continues with the next.
- Use `break` to stop early (e.g., when a condition is met).
- Use `continue` to skip specific iterations (e.g., skip odd numbers).

### Code Example
```java
public class BreakContinueExample {
    public static void main(String[] args) {
        // Break example: Stop at 5
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("Number: " + i);
        }
        
        // Continue example: Skip odd numbers
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println("Even: " + i);
        }
    }
}
```

### Practice
1. Use `break` to stop a loop when a number exceeds 50.
2. Use `continue` to print only odd numbers from 1 to 20.
3. Combine `break` and `continue` in a loop to print numbers divisible by 3 until 30.

**Practice Code**:
```java
public class BreakContinuePractice {
    public static void main(String[] args) {
        // Continue: Print odd numbers
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("Odd: " + i);
        }
        
        // Break: Stop when divisible by 3 and > 30
        for (int i = 1; i <= 50; i++) {
            if (i % 3 != 0) {
                continue;
            }
            System.out.println("Divisible by 3: " + i);
            if (i > 30) {
                break;
            }
        }
    }
}
```

---

## Day 5: Combining Loops and Conditionals
**Objective**: Integrate loops with conditionals for complex programs.

### Explanation
- Combine `if` statements with loops to filter or process data.
- Example: Use a loop to iterate numbers and `if` to check conditions (e.g., prime numbers).
- Ensure proper loop termination to avoid infinite loops.

### Code Example
```java
public class LoopConditionalExample {
    public static void main(String[] args) {
        // Print multiplication table for 5
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) { // Only even multipliers
                System.out.println("5 * " + i + " = " + (5 * i));
            }
        }
    }
}
```

### Practice
1. Write a program to print a multiplication table for a given number (e.g., 7).
2. Use a loop and `if` to print numbers divisible by both 2 and 3 (up to 50).
3. Create a program to count how many numbers from 1 to 100 are divisible by 5.

**Practice Code**:
```java
public class LoopConditionalPractice {
    public static void main(String[] args) {
        // Multiplication table for 7
        int num = 7;
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        
        // Count numbers divisible by 5
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                count++;
            }
        }
        System.out.println("Numbers divisible by 5: " + count);
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 3 learning with a prime number checker.

### Review
- Revisit:
  - `for` loop for fixed iterations.
  - `while` and `do-while` for condition-based loops.
  - `break` and `continue` for loop control.
  - Combining loops with conditionals.
- Debug common errors (e.g., infinite loops, off-by-one errors).

### Mini-Project: Prime Number Checker
Create a console-based program that:
1. Takes a number (hardcoded for now) and checks if it’s prime.
2. Uses a loop to test divisibility from 2 to the square root of the number.
3. Uses `if` to determine primality.
4. Prints all prime numbers up to 50 using a loop.

**Project Code**:
```java
public class PrimeNumberChecker {
    public static void main(String[] args) {
        // Check if a single number is prime
        int num = 17;
        boolean isPrime = true;
        
        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(num + " is prime: " + isPrime);
        
        // Print all primes up to 50
        System.out.println("Primes up to 50:");
        for (int n = 2; n <= 50; n++) {
            isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(n + " ");
            }
        }
    }
}
```

### Weekend Practice
1. Run and test the prime number checker with different inputs.
2. Modify to count how many primes are found up to 50.
3. Add a feature to check if a number is composite (not prime).

---

## Tips for Week 3
- **Practice**: Run each code example in an IDE or terminal.
- **Debug**: Watch for infinite loops (e.g., missing `i++`) or incorrect conditions.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for loop details.
- **Experiment**: Modify loop bounds or conditions to see how output changes.