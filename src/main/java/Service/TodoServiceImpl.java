package Service;

import model.Todo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoServiceImpl implements TodoService {

    private ArrayList<Todo> todos;
    private Scanner scanner;

    public TodoServiceImpl(ArrayList<Todo> todos, Scanner scanner) {
        this.todos = todos;
        this.scanner = scanner;
    }

    @Override
    public void addTodo() {
        System.out.println("AddTools");
        System.out.println("*******");
        System.out.println("Enter Your Items :");
        String itemName = scanner.next();
        Todo todo = new Todo();
        todo.setId(todos.size() + 1);
        todo.setItemName(itemName);
        todo.setCompleted(false);
        todos.add(todo);

    }

    @Override
    public void viewTodo() {
        System.out.println("ViewTools");
        System.out.println("*******");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + " . " + todo.getItemName() +
                    " Completed Status -" + (todo.isCompleted() ? "Yes" : "No"));
        }

    }

    @Override
    public void updateTodo() {
        System.out.println("UpdateTools");
        System.out.println("*******");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + " . " + todo.getItemName() +
                    " Completed Status -" + (todo.isCompleted() ? "Yes" : "No"));
        }
        System.out.println("Enter Your Choice:");
        int Choice = scanner.nextInt();
        Todo todo = todos.get(Choice-1);
        todo.setCompleted(true);
        System.out.println("*******");


    }

    public void printMainMenu() {
        while (true) {

            System.out.println("1. AddTodo");
            System.out.println("2. ViewTodo");
            System.out.println("3. UpdateTodo");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice :");
            int Choice = 0;
            try {
                Choice = scanner.nextInt();
                switch (Choice) {
                    case 1 -> addTodo();
                    case 2 -> viewTodo();
                    case 3 -> updateTodo();
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid Choice");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid Choice");
                printMainMenu();
            }

        }

    }
}
