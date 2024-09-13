// Main java file
// Main entry point for the console-based Perosonal To-Do List Manager application.
// Implements user interaction, invoking the ToDoManager and supporting the core features like
// add, edit, delete, view tasks and additional functionalities.

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Main class for Console Application
public class ToDoAppMain {
    public static void printMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task Completed");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. View All Tasks");
        System.out.println("6. View Tasks by Priority");
        System.out.println("7. View Tasks by status (completed/pending)");
        System.out.println("8. Start Alert System");
        System.out.println("9. Stop Alert System");
        System.out.println("10. Undo Last Action");
        System.out.println("11. Show History");
        System.out.println("12. Exit");   
        System.out.println("Select an options (1-12):");   
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoManager manager = ToDoManager.getInstance();

        while (true) {
            printMenu();
            int choice = -1;

            try{
                choice = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Unexpected Input!");
            }
            
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    
                    Priority priority = Utils.getPriorityLevelFromUser();
                    LocalDate dueDate = Utils.getDueDateFromUser();            
                    LocalTime dueTime = Utils.getDueTimeFromUser();            
                    String[] tags = Utils.getTagsFromUser();

                    Task.TaskBuilder builder = new Task.TaskBuilder(description);
                    builder.setDueDate(dueDate);
                    builder.setDueTime(dueTime);

                    if (tags.length > 0) {
                        builder.setTags(new ArrayList<String>(Arrays.asList(tags)));
                    }

                    if(priority != null){
                        builder.setPriority(priority);   
                    }

                    manager.addTask(builder.build());

                    break;
                case 2:
                    System.out.print("Enter task description to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    manager.markTaskCompleted(taskToComplete);
                    break;
                case 3:
                    System.out.print("Enter task description to edit: ");
                    String taskToEdit = scanner.nextLine();
                    manager.editTask(taskToEdit);
                    break;
                case 4:
                    System.out.print("Enter task description to delete: ");
                    String taskToDelete = scanner.nextLine();
                    manager.deleteTask(taskToDelete);
                    break;
                case 5:
                    manager.viewTasks("all");
                    break;
                case 6:
                    System.out.print("Enter priority level (LOW/MEDIUM/HIGH): ");
                    String filter = scanner.nextLine();                        
                    manager.viewTasks(filter);
                    break;
                case 7:
                    System.out.print("Enter filter (completed/pending): ");
                    filter = scanner.nextLine();
                    manager.viewTasks(filter);
                    break;
                case 8:
                    manager.startNotifications();
                    break;
                case 9:
                    manager.stopNotifications();
                    break;
                case 10:
                    manager.undo();
                    break;
                case 11:
                    Logger.getInstance().showHistory();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
