/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tasktrackercli;

/**
 *
 * @author SENGOUA NATHAN
 */
import java.util.Scanner;

public class TaskCLI {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task");
            System.out.println("5. List Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    manager.updateTask(updateId, newDescription);
                    break;
                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteTask(deleteId);
                    break;
                case 4:
                    System.out.print("Enter task ID to mark: ");
                    int markId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter status (todo, in-progress, done): ");
                    String status = scanner.nextLine();
                    manager.markTask(markId, status);
                    break;
                case 5:
                    System.out.print("Enter status filter (all, todo, in-progress, done): ");
                    String statusFilter = scanner.nextLine();
                    manager.listTasks(statusFilter);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
