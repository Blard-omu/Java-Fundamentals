# Java Module 011: Week 11 - Interfaces and Abstract Classes

This module covers advanced OOP concepts in Java, focusing on interfaces, abstract classes, and their roles in abstraction and polymorphism. Designed for beginners building on Weeks 1-10 of the 3-month Java fundamentals plan, it includes detailed explanations, multiple code examples per concept, and practice exercises for each day of Week 11. The module concludes with a console-based Shape Drawing System mini-project to apply these concepts.

---

## Day 1: Interfaces
**Objective**: Learn to define and implement interfaces for abstraction and polymorphism.

### Explanation
- **Interface**: A contract specifying methods that a class must implement, without providing implementation details.
  - Syntax: 
    ```java
    interface InterfaceName {
        returnType methodName(parameters);
    }
    ```
  - Classes implement interfaces using `implements`.
  - All interface methods are implicitly `public` and `abstract` (unless default/static).
- Use interfaces to achieve polymorphism and define common behavior across unrelated classes.
- Requires `implements InterfaceName` in the class declaration.

### Code Examples
**Example 1: Basic Interface**
```java
interface Printable {
    void print();
}

public class Document implements Printable {
    private String title;
    
    Document(String title) {
        this.title = title;
    }
    
    @Override
    public void print() {
        System.out.println("Printing document: " + title);
    }
    
    public static void main(String[] args) {
        Document doc = new Document("Report");
        doc.print();
    }
}
```

**Example 2: Multiple Classes Implementing Interface**
```java
interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing guitar");
    }
}

public class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing piano");
    }
    
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}
```

**Example 3: Interface with Multiple Methods**
```java
interface Vehicle {
    void start();
    void stop();
}

public class Car implements Vehicle {
    private String model;
    
    Car(String model) {
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(model + " is starting");
    }
    
    @Override
    public void stop() {
        System.out.println(model + " is stopping");
    }
    
    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.start();
        car.stop();
    }
}
```

### Practice
1. Create an interface `Drawable` with a `draw` method; implement it in a `Circle` class.
2. Write two classes (`Book` and `Poster`) that implement a `Displayable` interface with a `display` method.
3. Create an interface with two methods and implement it in a class.

**Practice Code**:
```java
interface Drawable {
    void draw();
}

public class CirclePractice implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
    
    public static void main(String[] args) {
        CirclePractice circle = new CirclePractice();
        circle.draw();
    }
}
```

---

## Day 2: Abstract Classes
**Objective**: Use abstract classes for partial implementation and inheritance.

### Explanation
- **Abstract Class**: A class that cannot be instantiated and may contain abstract (unimplemented) and concrete (implemented) methods.
  - Syntax:
    ```java
    abstract class ClassName {
        abstract void methodName();
        void concreteMethod() { // Implementation }
    }
    ```
  - Declared with `abstract` keyword; subclasses extend using `extends`.
- Use for shared code among related classes, unlike interfaces which are for unrelated classes.
- Subclasses must implement all abstract methods or be abstract themselves.

### Code Examples
**Example 1: Basic Abstract Class**
```java
abstract class Animal {
    abstract void makeSound();
    
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

public class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        dog.sleep();
    }
}
```

**Example 2: Abstract Class with Constructor**
```java
abstract class Shape {
    protected String color;
    
    Shape(String color) {
        this.color = color;
    }
    
    abstract double getArea();
}

public class Rectangle extends Shape {
    private double length, width;
    
    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    double getArea() {
        return length * width;
    }
    
    public static void main(String[] args) {
        Rectangle rect = new Rectangle("Blue", 4.0, 3.0);
        System.out.println("Area: " + rect.getArea() + ", Color: " + rect.color);
    }
}
```

**Example 3: Multiple Subclasses**
```java
abstract class Vehicle {
    protected String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    abstract void move();
}

class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }
    
    @Override
    void move() {
        System.out.println(brand + " bike is moving");
    }
}

public class Truck extends Vehicle {
    Truck(String brand) {
        super(brand);
    }
    
    @Override
    void move() {
        System.out.println(brand + " truck is moving");
    }
    
    public static void main(String[] args) {
        Vehicle bike = new Bike("Yamaha");
        Vehicle truck = new Truck("Ford");
        bike.move();
        truck.move();
    }
}
```

### Practice
1. Create an abstract class `Shape` with an abstract `getPerimeter` method; implement in `Triangle`.
2. Write an abstract class with a constructor and a concrete method; extend it.
3. Create two subclasses of an abstract `Employee` class with an abstract `work` method.

**Practice Code**:
```java
abstract class Shape {
    abstract double getPerimeter();
}

public class TrianglePractice extends Shape {
    private double a, b, c;
    
    TrianglePractice(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    double getPerimeter() {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        TrianglePractice triangle = new TrianglePractice(3, 4, 5);
        System.out.println("Perimeter: " + triangle.getPerimeter());
    }
}
```

---

## Day 3: Interfaces vs Abstract Classes
**Objective**: Understand when to use interfaces versus abstract classes.

### Explanation
- **Interfaces**:
  - For unrelated classes sharing common behavior (e.g., `Drawable` for `Circle` and `Text`).
  - Support multiple implementations (a class can implement multiple interfaces).
  - No fields or constructors; only method signatures (or default/static methods).
- **Abstract Classes**:
  - For related classes sharing code and state (e.g., `Vehicle` for `Car` and `Truck`).
  - Can have fields, constructors, and concrete methods.
  - Single inheritance (a class can extend only one class).
- Use interfaces for flexibility, abstract classes for shared implementation.

### Code Examples
**Example 1: Interface for Unrelated Classes**
```java
interface Displayable {
    void display();
}

class Image implements Displayable {
    @Override
    public void display() {
        System.out.println("Displaying image");
    }
}

public class Text implements Displayable {
    @Override
    public void display() {
        System.out.println("Displaying text");
    }
    
    public static void main(String[] args) {
        Displayable image = new Image();
        Displayable text = new Text();
        image.display();
        text.display();
    }
}
```

**Example 2: Abstract Class for Related Classes**
```java
abstract class Animal {
    protected String name;
    
    Animal(String name) {
        this.name = name;
    }
    
    abstract void eat();
}

public class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    
    @Override
    void eat() {
        System.out.println(name + " eats fish");
    }
    
    public static void main(String[] args) {
        Cat cat = new Cat("Whiskers");
        cat.eat();
    }
}
```

**Example 3: Combining Interface and Abstract Class**
```java
interface Movable {
    void move();
}

abstract class Vehicle {
    protected String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    abstract void start();
}

public class Motorcycle extends Vehicle implements Movable {
    Motorcycle(String brand) {
        super(brand);
    }
    
    @Override
    void start() {
        System.out.println(brand + " motorcycle starts");
    }
    
    @Override
    public void move() {
        System.out.println(brand + " motorcycle moves");
    }
    
    public static void main(String[] args) {
        Motorcycle moto = new Motorcycle("Honda");
        moto.start();
        moto.move();
    }
}
```

### Practice
1. Create an interface `Resizable` and implement it in a `Window` class.
2. Write an abstract class `Device` with a concrete method; extend it in `Phone`.
3. Combine an interface and abstract class in a program (e.g., `Vehicle` and `Movable`).

**Practice Code**:
```java
interface Resizable {
    void resize();
}

abstract class Device {
    protected String type;
    
    Device(String type) {
        this.type = type;
    }
    
    void powerOn() {
        System.out.println(type + " powered on");
    }
}

public class PhonePractice extends Device implements Resizable {
    PhonePractice(String type) {
        super(type);
    }
    
    @Override
    public void resize() {
        System.out.println(type + " resized");
    }
    
    public static void main(String[] args) {
        PhonePractice phone = new PhonePractice("Smartphone");
        phone.powerOn();
        phone.resize();
    }
}
```

---

## Day 4: Polymorphism with Interfaces and Abstract Classes
**Objective**: Use interfaces and abstract classes for polymorphic behavior.

### Explanation
- **Polymorphism**: Treating objects of different classes as instances of a common interface or superclass.
- Use interface or abstract class references to call overridden methods.
- Enables flexible and reusable code.

### Code Examples
**Example 1: Polymorphism with Interface**
```java
interface Drivable {
    void drive();
}

class Car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Driving car");
    }
}

public class Truck implements Drivable {
    @Override
    public void drive() {
        System.out.println("Driving truck");
    }
    
    public static void main(String[] args) {
        Drivable car = new Car();
        Drivable truck = new Truck();
        car.drive();
        truck.drive();
    }
}
```

**Example 2: Polymorphism with Abstract Class**
```java
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Square extends Shape {
    private double side;
    
    Square(double side) {
        this.side = side;
    }
    
    @Override
    double getArea() {
        return side * side;
    }
    
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape square = new Square(4.0);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Square Area: " + square.getArea());
    }
}
```

**Example 3: Combining Interface and Abstract Class**
```java
interface Drawable {
    void draw();
}

abstract class Shape {
    protected String name;
    
    Shape(String name) {
        this.name = name;
    }
    
    abstract void describe();
}

public class Rectangle extends Shape implements Drawable {
    Rectangle(String name) {
        super(name);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + name);
    }
    
    @Override
    void describe() {
        System.out.println("This is a " + name);
    }
    
    public static void main(String[] args) {
        Shape rect = new Rectangle("Rectangle");
        Drawable drawable = (Drawable) rect;
        rect.describe();
        drawable.draw();
    }
}
```

### Practice
1. Create an interface `Runnable` and use it polymorphically with two classes.
2. Write an abstract class `Animal` and use it polymorphically with `Dog` and `Cat`.
3. Combine an interface and abstract class in a polymorphic program.

**Practice Code**:
```java
interface Runnable {
    void run();
}

abstract class Animal {
    abstract void makeSound();
}

public class DogPractice extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("Dog is running");
    }
    
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
    
    public static void main(String[] args) {
        Animal dog = new DogPractice();
        Runnable runner = (Runnable) dog;
        dog.makeSound();
        runner.run();
    }
}
```

---

## Day 5: Review and Design with Abstraction
**Objective**: Solidify interfaces, abstract classes, and polymorphic design.

### Explanation
- Review best practices:
  - Use interfaces for defining contracts across unrelated classes.
  - Use abstract classes for shared code in related classes.
  - Leverage polymorphism for flexible code.
  - Combine with Weeks 1-10 concepts (OOP, collections, file I/O).
- Design tip: Choose interfaces for flexibility, abstract classes for shared implementation.

### Code Examples
**Example 1: Interface-Based Design**
```java
interface Payable {
    double calculatePay();
}

class Employee implements Payable {
    private double salary;
    
    Employee(double salary) {
        this.salary = salary;
    }
    
    @Override
    public double calculatePay() {
        return salary;
    }
}

public class Contractor implements Payable {
    private double hours;
    private double rate;
    
    Contractor(double hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }
    
    @Override
    public double calculatePay() {
        return hours * rate;
    }
    
    public static void main(String[] args) {
        Payable emp = new Employee(5000);
        Payable contractor = new Contractor(40, 50);
        System.out.println("Employee Pay: $" + emp.calculatePay());
        System.out.println("Contractor Pay: $" + contractor.calculatePay());
    }
}
```

**Example 2: Abstract Class Design**
```java
abstract class Product {
    protected String name;
    protected double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    abstract void display();
}

public class Book extends Product {
    Book(String name, double price) {
        super(name, price);
    }
    
    @Override
    void display() {
        System.out.println("Book: " + name + ", Price: $" + price);
    }
    
    public static void main(String[] args) {
        Product book = new Book("Java Guide", 29.99);
        book.display();
    }
}
```

**Example 3: Combined Design**
```java
interface Repairable {
    void repair();
}

abstract class Device {
    protected String brand;
    
    Device(String brand) {
        this.brand = brand;
    }
    
    abstract void powerOn();
}

public class Laptop extends Device implements Repairable {
    Laptop(String brand) {
        super(brand);
    }
    
    @Override
    void powerOn() {
        System.out.println(brand + " laptop powers on");
    }
    
    @Override
    public void repair() {
        System.out.println(brand + " laptop repaired");
    }
    
    public static void main(String[] args) {
        Device laptop = new Laptop("Dell");
        Repairable repairable = (Repairable) laptop;
        laptop.powerOn();
        repairable.repair();
    }
}
```

### Practice
1. Create an interface `Calculable` for calculating values; implement in two classes.
2. Write an abstract class `Vehicle` with a concrete method; extend in two subclasses.
3. Combine an interface and abstract class in a program with polymorphism.

**Practice Code**:
```java
interface Calculable {
    double calculate();
}

abstract class Vehicle {
    protected String type;
    
    Vehicle(String type) {
        this.type = type;
    }
    
    void start() {
        System.out.println(type + " starts");
    }
}

public class CarPractice extends Vehicle implements Calculable {
    private double speed;
    
    CarPractice(String type, double speed) {
        super(type);
        this.speed = speed;
    }
    
    @Override
    public double calculate() {
        return speed * 1.5; // Example calculation
    }
    
    public static void main(String[] args) {
        Vehicle car = new CarPractice("Car", 60.0);
        Calculable calc = (Calculable) car;
        car.start();
        System.out.println("Calculated value: " + calc.calculate());
    }
}
```

---

## Weekend: Review and Mini-Project
**Objective**: Consolidate Week 11 learning with a Shape Drawing System.

### Review
- Revisit:
  - Interfaces for defining contracts and enabling polymorphism.
  - Abstract classes for shared code and partial implementation.
  - Polymorphism for flexible designs.
  - Combining interfaces and abstract classes.
- Debug common errors (e.g., missing method implementations, incorrect casting).

### Mini-Project: Shape Drawing System
Create a console-based program that:
1. Defines an interface `Drawable` with a `draw` method.
2. Creates an abstract class `Shape` with fields `color` and abstract method `getArea`.
3. Implements `Drawable` and extends `Shape` in `Circle` and `Rectangle` classes.
4. Uses a `HashMap` to store shapes (name as key, `Shape` object as value).
5. Demonstrates polymorphism by calling `draw` and `getArea`.

**Project Code**:
```java
import java.util.HashMap;

interface Drawable {
    void draw();
}

abstract class Shape {
    protected String color;
    
    Shape(String color) {
        this.color = color;
    }
    
    abstract double getArea();
}

class Circle extends Shape implements Drawable {
    private double radius;
    
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing Circle, Color: " + color + ", Area: " + getArea());
    }
}

class Rectangle extends Shape implements Drawable {
    private double length, width;
    
    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    double getArea() {
        return length * width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle, Color: " + color + ", Area: " + getArea());
    }
}

public class ShapeDrawingSystem {
    private HashMap<String, Shape> shapes;
    
    ShapeDrawingSystem() {
        shapes = new HashMap<>();
    }
    
    void addShape(String name, Shape shape) {
        shapes.put(name, shape);
    }
    
    void drawAll() {
        for (Shape shape : shapes.values()) {
            if (shape instanceof Drawable) {
                ((Drawable) shape).draw();
            }
        }
    }
    
    public static void main(String[] args) {
        ShapeDrawingSystem system = new ShapeDrawingSystem();
        system.addShape("Circle1", new Circle("Red", 5.0));
        system.addShape("Rect1", new Rectangle("Blue", 4.0, 3.0));
        system.drawAll();
    }
}
```

### Weekend Practice
1. Run and test the system with different shapes.
2. Add a `Triangle` class implementing `Drawable` and extending `Shape`.
3. Extend the program to calculate the total area of all shapes.

**Extended Practice Code** (with total area):
```java
import java.util.HashMap;

interface Drawable {
    void draw();
}

abstract class Shape {
    protected String color;
    
    Shape(String color) {
        this.color = color;
    }
    
    abstract double getArea();
}

class Circle extends Shape implements Drawable {
    private double radius;
    
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing Circle, Color: " + color + ", Area: " + getArea());
    }
}

public class ExtendedShapeDrawingSystem {
    private HashMap<String, Shape> shapes;
    
    ExtendedShapeDrawingSystem() {
        shapes = new HashMap<>();
    }
    
    void addShape(String name, Shape shape) {
        shapes.put(name, shape);
    }
    
    double getTotalArea() {
        double total = 0;
        for (Shape shape : shapes.values()) {
            total += shape.getArea();
        }
        return total;
    }
    
    public static void main(String[] args) {
        ExtendedShapeDrawingSystem system = new ExtendedShapeDrawingSystem();
        system.addShape("Circle1", new Circle("Red", 5.0));
        System.out.println("Total Area: " + system.getTotalArea());
    }
}
```

---

## Tips for Week 11
- **Practice**: Test each code example in an IDE or terminal.
- **Debug**: Check for missing interface implementations or abstract method overrides.
- **Resources**: Refer to Oracle’s Java Tutorials or W3Schools for interfaces and abstract classes.
- **Experiment**: Modify interfaces or add methods to see polymorphic behavior.