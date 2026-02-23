### Project 002 - Task Management System

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

interface Prioritizable {
    String getPriority();
}

class InvalidTaskException extends Exception {
    public InvalidTaskException(String message) {
        super(message);
    }
}

class Task implements Prioritizable {
    private String description, category, priority;
    private boolean isComplete;
    
    Task(String description, String category, String priority) throws InvalidTaskException {
        if (description.isEmpty() || category.isEmpty()) {
            throw new InvalidTaskException("Description and category cannot be empty");
        }
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.isComplete = false;
    }
    
    void markComplete() {
        isComplete = true;
        System.out.println("Task completed: " + description);
    }
    
    @Override
    public String getPriority() {
        return priority;
    }
    
    String getDescription() { return description; }
    String getCategory() { return category; }
    boolean isComplete() { return isComplete; }
    
    String toFileString() {
        return description + "," + category + "," + priority + "," + isComplete;
    }
    
    void display() {
        System.out.println("Task: " + description + ", Category: " + category + ", Priority: " + priority + ", Complete: " + isComplete);
    }
}

public class TaskManagementSystem {
    private ArrayList<Task> tasks;
    private HashMap<String, ArrayList<Task>> categories;
    
    TaskManagementSystem() {
        tasks = new ArrayList<>();
        categories = new HashMap<>();
    }
    
    void addTask(String description, String category, String priority) throws InvalidTaskException {
        Task task = new Task(description, category, priority);
        tasks.add(task);
        categories.computeIfAbsent(category, k -> new ArrayList<>()).add(task);
        System.out.println("Added task: " + description);
    }
    
    void markTaskComplete(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description) && !task.isComplete()) {
                task.markComplete();
                return;
            }
        }
        System.out.println("Task not found or already complete: " + description);
    }
    
    void displayTasksByCategory(String category) {
        ArrayList<Task> catTasks = categories.get(category);
        if (catTasks == null || catTasks.isEmpty()) {
            System.out.println("No tasks in category: " + category);
            return;
        }
        for (Task task : catTasks) {
            task.display();
        }
    }
    
    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            System.out.println("Tasks saved");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    
    void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Task task = new Task(parts[0], parts[1], parts[2]);
                    if (Boolean.parseBoolean(parts[3])) {
                        task.markComplete();
                    }
                    tasks.add(task);
                    categories.computeIfAbsent(parts[1], k -> new ArrayList<>()).add(task);
                }
            }
            System.out.println("Tasks loaded");
        } catch (IOException | InvalidTaskException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
    
    void listHighPriorityTasks() {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equals("High")) {
                task.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No high-priority tasks");
        }
    }
    
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        try {
            tms.loadFromFile();
            tms.addTask("Study Java", "Work", "High");
            tms.addTask("Buy groceries", "Personal", "Low");
            tms.markTaskComplete("Study Java");
            tms.displayTasksByCategory("Work");
            tms.listHighPriorityTasks();
            tms.saveToFile();
        } catch (InvalidTaskException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```

## Task Management System Summary
### Purpose
The Task Management System is a console-based to-do list application that allows users to manage tasks by adding, completing, and categorizing them, with data persisted to a file. It integrates key concepts from the 3-month Java fundamentals plan, emphasizing collections, file I/O, and exception handling.
Features

- Task Management: Add tasks with descriptions, categories, and priorities (e.g., High, Low); mark tasks as complete.
Category Filtering: Display tasks by category.
Data Persistence: Save tasks to tasks.txt and load on startup.
Validation: Ensure non-empty descriptions and categories using custom exceptions.
Additional Feature: List all high-priority tasks.

### Concepts Used

- OOP: Task class implements Prioritizable interface for priority access.
Collections: ArrayList for tasks, HashMap for grouping tasks by category.
File I/O: BufferedWriter for saving and BufferedReader for loading tasks.
Exception Handling: Custom InvalidTaskException for validation, IOException for file operations.
Polymorphism: Uses Prioritizable interface for priority-based operations.

### Usage

Run in an IDE or via command line (javac TaskManagementSystem.java && java TaskManagementSystem).
Ensure tasks.txt is in the same directory.
Test by adding tasks, marking complete, filtering by category, and verifying file persistence.

Extension Ideas

Add deadlines for tasks.
Implement task sorting by priority.
Add a console menu for user interaction.
