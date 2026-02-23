# Java Module 006: Week 6 - Inheritance and Polymorphism

This module covers Object-Oriented Programming (OOP) concepts in Java, focusing on inheritance (`extends`), method overriding (polymorphism), access modifiers (`public`, `private`, `protected`, `default`), and packages. Designed for beginners building on Weeks 1-5 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 6. The module concludes with a console-based Vehicle Showroom mini-project to apply these concepts.

---

## Day 1: Inheritance (`extends`)
**Objective**: Learn to create parent-child class relationships using inheritance.

### Explanation
- **Inheritance**: Allows a class (child/subclass) to inherit attributes and methods from another class (parent/superclass) using the `extends` keyword.
- **Syntax**: `class ChildClass extends ParentClass { // code }`
- Child classes inherit all non-private members of the parent class.
- Use inheritance to reuse code and model "is-a" relationships (e.g., a `Car` is a `Vehicle`).
- The `super` keyword can call parent class constructors or methods.

### Code Examples
**Example 1: Basic Inheritance**
```java
class Vehicle {
    String brand;
    int year;
    
    void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

public class Car extends Vehicle {
    public static void main(String[] args) {
        Car car = new Car();
        car.brand = "Toyota";
        car.year = 2020;
        car.displayInfo();
    }
}
```

**Example 2: Constructor Inheritance**
```java
class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
    }
}

public class Dog extends Animal {
    Dog(String name) {
        super(name); // Call parent constructor
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        System.out.println("Dog Name: " + dog.name);
    }
}
```

**Example 3: Adding Child-Specific Attributes**
```java
class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
}

public class Employee extends Person {
    int id;
    
    Employee(String name, int id) {
        super(name);
        this.id = id;
    }
    
    void display() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101);
        emp.display();
    }
}
```

### Practice
1. Create a `Vehicle` parent class with attributes `brand` and `speed`; create a `Bike` child class.
2. Add a constructor to `Bike` that calls the parent constructor using `super`.
3. Write a program to create a `Bike` object and print its inherited attributes.

**Practice Code**:
```java
class Vehicle {
    String brand;
    int speed;
    
    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
}

public class BikePractice extends Vehicle {
    BikePractice(String brand, int speed) {
        super(brand, speed);
    }
    
    public static void main(String[] args) {
        BikePractice bike = new BikePractice("Yamaha", 80);
        System.out.println("Bike: " + bike.brand + ", Speed: " + bike.speed);
    }
}
```

---

## Day 2: Method Overriding (Polymorphism)
**Objective**: Understand method overriding to implement polymorphism.

### Explanation
- **Method Overriding**: A child class redefines a parent class method with the same name, parameters, and return type.
- **Polymorphism**: Allows a child class to provide a specific implementation of a parent method.
- Use the `@Override` annotation to ensure correct overriding.
- The `super` keyword can call the parent’s version of the method.

### Code Examples
**Example 1: Basic Overriding**
```java
class Animal {
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}

public class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
    
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeSound();
    }
}
```

**Example 2: Using `super`**
```java
class Vehicle {
    void describe() {
        System.out.println("This is a vehicle");
    }
}

public class Truck extends Vehicle {
    @Override
    void describe() {
        super.describe(); // Call parent method
        System.out.println("This is a truck");
    }
    
    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.describe();
    }
}
```

**Example 3: Overriding with Parameters**
```java
class Shape {
    double getArea() {
        return 0.0;
    }
}

public class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
    
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.getArea());
    }
}
```

### Practice
1. Create a `Shape` parent class with a `getPerimeter` method; override it in a `Rectangle` child class.
2. Use `super` to call the parent method in a child class method.
3. Write a program to create a child class object and call its overridden method.

**Practice Code**:
```java
class Shape {
    double getPerimeter() {
        return 0.0;
    }
}

public class RectanglePractice extends Shape {
    double length, width;
    
    RectanglePractice(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
    
    public static void main(String[] args) {
        RectanglePractice rect = new RectanglePractice(4.0, 3.0);
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
```

---

## Day 3: Access Modifiers
**Objective**: Use access modifiers to control visibility.

### Explanation
- **Access Modifiers**: Control access to class members (fields, methods).
  - `public`: Accessible everywhere.
  - `private`: Accessible only within the same class.
  - `protected`: Accessible within the same package and subclasses.
  - `default` (package-private): Accessible within the same package if no modifier is specified.
- Use modifiers to enforce encapsulation and protect data.

### Code Examples
**Example 1: Public and Private**
```java
public class Account {
    private double balance;
    public String accountHolder;
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public static void main(String[] args) {
        Account acc = new Account();
        acc.accountHolder = "Alice";
        acc.setBalance(1000.0);
        // acc.balance = -500; // Error: private field
        System.out.println("Holder: " + acc.accountHolder + ", Balance: " + acc.getBalance());
    }
}
```

**Example 2: Protected in Inheritance**
```java
class Vehicle {
    protected String brand = "Generic";
    
    protected void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

public class Motorcycle extends Vehicle {
    public static void main(String[] args) {
        Motorcycle moto = new Motorcycle();
        moto.brand = "Honda";
        moto.displayBrand();
    }
}
```

**Example 3: Default Access**
```java
class Person {
    String name = "Unknown"; // Default access
    
    void display() {
        System.out.println("Name: " + name);
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Bob"; // Accessible in same package
        person.display();
    }
}
```

### Practice
1. Create a `Product` class with a `private` price and `public` name; add getters/setters.
2. Create a parent class with a `protected` method; access it in a child class.
3. Write a program with a `default` access field and test access within the same package.

**Practice Code**:
```java
class Product {
    private double price;
    public String name;
    
    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

public class ProductPractice {
    public static void main(String[] args) {
        Product prod = new Product();
        prod.name = "Phone";
        prod.setPrice(500.0);
        System.out.println("Product: " + prod.name + ", Price: $" + prod.getPrice());
    }
}
```

---

## Day 4: Packages
**Objective**: Organize code using packages.

### Explanation
- **Packages**: Group related classes to avoid naming conflicts and improve organization.
- **Syntax**: `package com.example;`
- Use `import` to access classes from other packages (e.g., `import com.example.MyClass;`).
- Common convention: Use reverse domain name (e.g., `com.mycompany.project`).

### Code Examples
**Example 1: Basic Package**
```java
// File: com/example/Vehicle.java
package com.example;

public class Vehicle {
    public String brand = "Generic";
    
    public void display() {
        System.out.println("Vehicle Brand: " + brand);
    }
}

// File: com/example/TestVehicle.java
package com.example;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.display();
    }
}
```

**Example 2: Importing Across Packages**
```java
// File: com/example/models/Car.java
package com.example.models;

public class Car {
    public String model = "Sedan";
}

// File: com/example/main/Main.java
package com.example.main;

import com.example.models.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("Car Model: " + car.model);
    }
}
```

**Example 3: Package with Inheritance**
```java
// File: com/example/vehicles/Vehicle.java
package com.example.vehicles;

public class Vehicle {
    protected String type = "Vehicle";
}

// File: com/example/vehicles/Bus.java
package com.example.vehicles;

public class Bus extends Vehicle {
    public void showType() {
        System.out.println("Type: " + type);
    }
    
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.showType();
    }
}
```

### Practice
1. Create a package `com.example.animals` with an `Animal` class.
2. Create another package `com.example.main` and import the `Animal` class to use it.
3. Write a program with a parent and child class in the same package.

**Practice Code**:
```java
// File: com/example/animals/Animal.java
package com.example.animals;

public class Animal {
    public String name = "Unknown";
}

// File: com/example/main/AnimalTest.java
package com.example.main;

import com.example.animals.Animal;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "Lion";
        System.out.println("Animal: " + animal.name);
    }
}
```

---

## Day 5: Review and Inheritance/Polymorphism
**Objective**: Solidify inheritance, polymorphism, access modifiers, and packages.

### Explanation
- Review best practices:
  - Use inheritance for "is-a" relationships.
  - Override methods to customize behavior.
  - Choose appropriate access modifiers for encapsulation.
  - Organize code with packages for clarity.
- Combine with Weeks 1-5 concepts (methods, loops, classes).

### Code Examples
**Example 1: Polymorphism in Action**
```java
class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

public class Lion extends Animal {
    @Override
    void eat() {
        System.out.println("Lion eats meat");
    }
    
    public static void main(String[] args) {
        Animal animal = new Lion(); // Polymorphism
        animal.eat();
    }
}
```

**Example 2: Protected Access in Package**
```java
// File: com/example/vehicles/Vehicle.java
package com.example.vehicles;

public class Vehicle {
    protected String brand = "Generic";
}

// File: com/example/vehicles/SUV.java
package com.example.vehicles;

public class SUV extends Vehicle {
    void display() {
        System.out.println("SUV Brand: " + brand);
    }
    
    public static void main(String[] args) {
        SUV suv = new SUV();
        suv.display();
    }
}
```

**Example 3: Complex Inheritance**
```java
class Device {
    String brand;
    
    Device(String brand) {
        this.brand = brand;
    }
    
    void powerOn() {
        System.out.println(brand + " powers on");
    }
}

public class Smartphone extends Device {
    int storage;
    
    Smartphone(String brand, int storage) {
        super(brand);
        this.storage = storage;
    }
    
    @Override
    void powerOn() {
        System.out.println(brand + " smartphone powers on with " + storage + "GB");
    }
    
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", 64);
        phone.powerOn();
    }
}
```

### Practice
1. Create a `Person` parent class and a `Student` child class with an overridden method.
2. Use `protected` fields in a parent class and access them in a child class.
3. Organize a parent and child class in a package and test them.

**Practice Code**:
```java
class Person {
    protected String name;
    
    Person(String name) {
        this.name = name;
    }
    
    void introduce() {
        System.out.println("I am " + name);
    }
}

public class StudentPractice extends Person {
    StudentPractice(String name) {
        super(name);
    }
    
    @Override
    void introduce() {
        System.out.println("I am student " + name);
    }
    
    public static void main(String[] args) {
        StudentPractice student = new StudentPractice("Eve");
        student.introduce();
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 6 learning with a Vehicle Showroom mini-project.

### Review
- Revisit:
  - Inheritance with `extends` and `super`.
  - Method overriding for polymorphism.
  - Access modifiers for encapsulation.
  - Packages for code organization.
- Debug common errors (e.g., missing `super`, incorrect access modifiers).

### Mini-Project: Vehicle Showroom
Create a console-based program that:
1. Defines a `Vehicle` parent class with attributes `brand` and `price`, and a method `displayDetails`.
2. Creates child classes `Car` and `Motorcycle` with overridden `displayDetails` methods.
3. Organizes classes in a package (e.g., `com.example.showroom`).
4. Uses a `Showroom` class to manage multiple vehicles in an array.
5. Validates inputs (e.g., positive price) and displays all vehicles.

**Project Code**:
```java
// File: com/example/showroom/Vehicle.java
package com.example.showroom;

public class Vehicle {
    protected String brand;
    protected double price;
    
    Vehicle(String brand, double price) {
        this.brand = brand;
        if (price > 0) this.price = price;
        else this.price = 1000.0;
    }
    
    void displayDetails() {
        System.out.println("Brand: " + brand + ", Price: $" + price);
    }
}

// File: com/example/showroom/Car.java
package com.example.showroom;

public class Car extends Vehicle {
    Car(String brand, double price) {
        super(brand, price);
    }
    
    @Override
    void displayDetails() {
        System.out.println("Car - Brand: " + brand + ", Price: $" + price);
    }
}

// File: com/example/showroom/Motorcycle.java
package com.example.showroom;

public class Motorcycle extends Vehicle {
    Motorcycle(String brand, double price) {
        super(brand, price);
    }
    
    @Override
    void displayDetails() {
        System.out.println("Motorcycle - Brand: " + brand + ", Price: $" + price);
    }
}

// File: com/example/showroom/Showroom.java
package com.example.showroom;

public class Showroom {
    private Vehicle[] vehicles;
    private int vehicleCount;
    
    Showroom(int capacity) {
        vehicles = new Vehicle[capacity];
        vehicleCount = 0;
    }
    
    void addVehicle(Vehicle vehicle) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount] = vehicle;
            vehicleCount++;
            System.out.println("Added: " + vehicle.brand);
        } else {
            System.out.println("Showroom full");
        }
    }
    
    void displayVehicles() {
        if (vehicleCount == 0) {
            System.out.println("No vehicles in showroom");
            return;
        }
        System.out.println("Showroom Vehicles:");
        for (int i = 0; i < vehicleCount; i++) {
            vehicles[i].displayDetails();
        }
    }
    
    public static void main(String[] args) {
        Showroom showroom = new Showroom(3);
        showroom.addVehicle(new Car("Toyota", 25000.0));
        showroom.addVehicle(new Motorcycle("Honda", 12000.0));
        showroom.displayVehicles();
    }
}
```

### Weekend Practice
1. Run and test the showroom with different vehicles.
2. Add a method to the `Showroom` class to find a vehicle by brand.
3. Extend the program to calculate the total price of all vehicles.

**Extended Practice Code** (with find method):
```java
// File: com/example/showroom/ShowroomExtended.java
package com.example.showroom;

public class ShowroomExtended {
    private Vehicle[] vehicles;
    private int vehicleCount;
    
    ShowroomExtended(int capacity) {
        vehicles = new Vehicle[capacity];
        vehicleCount = 0;
    }
    
    void addVehicle(Vehicle vehicle) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount] = vehicle;
            vehicleCount++;
            System.out.println("Added: " + vehicle.brand);
        } else {
            System.out.println("Showroom full");
        }
    }
    
    void findVehicle(String brand) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].brand.equals(brand)) {
                vehicles[i].displayDetails();
                return;
            }
        }
        System.out.println("Vehicle not found: " + brand);
    }
    
    public static void main(String[] args) {
        ShowroomExtended showroom = new ShowroomExtended(3);
        showroom.addVehicle(new Car("Ford", 30000.0));
        showroom.findVehicle("Ford");
        showroom.findVehicle("BMW");
    }
}
```

---

## Tips for Week 6
- **Practice**: Test each code example in an IDE or terminal, ensuring proper package structure.
- **Debug**: Check for missing `super` calls, incorrect overriding, or access modifier issues.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for inheritance and package details.
- **Experiment**: Modify child classes or access modifiers to see their effects.