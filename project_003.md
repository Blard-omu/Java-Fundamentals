## Project 003 - Inventory Management System

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

interface Sellable {
    double getPrice();
}

abstract class Item {
    protected String id, name;
    
    Item(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    abstract void displayDetails();
}

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class Product extends Item implements Sellable {
    private double price;
    private int quantity;
    
    Product(String id, String name, double price, int quantity) throws InvalidProductException {
        super(id, name);
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative");
        }
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    void updateQuantity(int qty) throws InvalidProductException {
        if (qty < 0) {
            throw new InvalidProductException("Quantity cannot be negative");
        }
        this.quantity = qty;
    }
    
    @Override
    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }
    
    String toFileString() {
        return id + "," + name + "," + price + "," + quantity;
    }
}

public class InventoryManagementSystem {
    private HashMap<String, Product> products;
    private HashSet<String> categories;
    
    InventoryManagementSystem() {
        products = new HashMap<>();
        categories = new HashSet<>();
    }
    
    void addProduct(String id, String name, double price, int quantity, String category) throws InvalidProductException {
        if (id.isEmpty() || name.isEmpty()) {
            throw new InvalidProductException("ID and name cannot be empty");
        }
        products.put(id, new Product(id, name, price, quantity));
        categories.add(category);
        System.out.println("Added product: " + name);
    }
    
    void updateProductQuantity(String id, int quantity) throws InvalidProductException {
        if (!products.containsKey(id)) {
            throw new InvalidProductException("Product not found: " + id);
        }
        products.get(id).updateQuantity(quantity);
        System.out.println("Updated quantity for: " + id);
    }
    
    void displayProductsByCategory(String category) {
        boolean found = false;
        for (Product product : products.values()) {
            if (category.equals("All") || categories.contains(category)) {
                product.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products in category: " + category);
        }
    }
    
    double getTotalInventoryValue() {
        double total = 0;
        for (Product product : products.values()) {
            total += product.getPrice() * product.quantity;
        }
        return total;
    }
    
    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"))) {
            for (Product product : products.values()) {
                writer.write(product.toFileString());
                writer.newLine();
            }
            System.out.println("Inventory saved");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
    
    void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    products.put(parts[0], new Product(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
                }
            }
            System.out.println("Inventory loaded");
        } catch (IOException | InvalidProductException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        try {
            ims.loadFromFile();
            ims.addProduct("P001", "Laptop", 1200.0, 10, "Electronics");
            ims.addProduct("P002", "Pen", 1.5, 100, "Stationery");
            ims.updateProductQuantity("P001", 8);
            ims.displayProductsByCategory("Electronics");
            System.out.println("Total Inventory Value: $" + ims.getTotalInventoryValue());
            ims.saveToFile();
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```

## Inventory Management System Summary
### Purpose
The Inventory Management System is a console-based application for managing a store’s product inventory, tracking names, prices, quantities, and categories, with data persisted to a file. It integrates concepts from the 3-month Java fundamentals plan, focusing on collections, file I/O, and OOP.
Features

- Product Management: Add products (ID, name, price, quantity, category), update quantities.
Category Display: Show products by category or all products.
Inventory Value: Calculate total inventory value (price × quantity).
Data Persistence: Save products to inventory.txt and load on startup.
Validation: Ensure valid product data (non-negative price/quantity, non-empty ID/name).

### Concepts Used

- OOP: Product class extends Item (abstract) and implements Sellable interface for price access.
Collections: HashMap for products (key: ID, value: Product), HashSet for unique categories.
File I/O: BufferedWriter for saving and BufferedReader for loading inventory.
Exception Handling: Custom InvalidProductException for validation, IOException for file operations.
Polymorphism: Uses Sellable interface for price-related operations.

### Usage

Run in an IDE or via command line (javac InventoryManagementSystem.java && java InventoryManagementSystem).
Ensure inventory.txt is in the same directory.
Test by adding products, updating quantities, displaying categories, and verifying file persistence.

Extension Ideas

Add sales tracking to reduce quantities.
Implement low-stock alerts.
Add a console menu for user interaction.
