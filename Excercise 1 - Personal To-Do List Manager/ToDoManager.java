// ToDoManager class
// This class implements the core functionalities of the To-Do list manager, 
// using the Singleton pattern to ensure a single instance. It handles adding, 
// editing, deleting, viewing tasks, and provides undo functionality via the 
// Momento pattern of Momento Class. It also manages notifications for task
// deadlines and logs actions for task operations.

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;

// ToDoManager Class
public class ToDoManager {
    private static ToDoManager instance;
    private List<Task> tasks;
    private Deque<Momento> history;
    private Timer notificationTimer;
    private Logger logger;

    // Constructor
    private ToDoManager() {
        tasks = new ArrayList<>();
        history = new LinkedList<>();
        notificationTimer = new Timer();
        logger = Logger.getInstance();   
    }

    // Singlethon Pattern Implemented to ensure only single instance of manager is created
    public static synchronized ToDoManager getInstance(){
        if(instance == null){
            instance = new ToDoManager();
        }
        return instance;
    }

    // Add a task
    public void addTask(Task task) {
        if(!this.checkForConflicts(task)){
            saveState();
            tasks.add(task);
            String timestamp = LocalDateTime.now().toString();
            logger.addToHistroy(timestamp + " : Task Created - " + task.getDescription());
            System.out.println("Task Created Successfully!");
        }
    }

    // Mark task as complete
    public void markTaskCompleted(String description) {
        saveState();
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                System.out.println(description + " : Marked as Completed");
                String timestamp = LocalDateTime.now().toString();
                logger.addToHistroy(timestamp + " : " + task.getDescription() + " Marked as Completed");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Delete a task
    public void deleteTask(String description) {
        saveState();
        if(!tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description))){
            System.out.println("Task Not Found!");
        }else{
            System.out.println(description + " : Task Successfully Deleted!");
            String timestamp = LocalDateTime.now().toString();
            logger.addToHistroy(timestamp + " : " + description + " - Task Deleted");
        }
    }

    // View tasks (all, completed, pending)
    public void viewTasks(String filter) {
        System.out.println();
        if(tasks.isEmpty()) {System.out.println("Task List is Empty!"); return;}
        switch (filter.toLowerCase()) {
            case "all":
                tasks.forEach(System.out::println);
                break;
            case "completed":
                tasks.stream().filter(task -> task.isCompleted()).forEach(System.out::println);
                break;
            case "pending":
                tasks.stream().filter(task -> !task.isCompleted()).forEach(System.out::println);
                break;
            case "high":
            case "medium":
            case "low":
                tasks.stream().filter(task -> task.getPriority() != null && 
                    task.getPriority().toString().equalsIgnoreCase(filter))
                    .forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid filter.");
        }
    }

    // Edit tasks based on search field
    public void editTask(String filter){
        Task result = this.findTaskByDescription(filter);

        if(result != null){
            saveState();
            System.out.println("Found! Current Task Information:- ");
            System.out.println(result.toString());

            Priority priority = Utils.getPriorityLevelFromUser();
            LocalDate dueDate = Utils.getDueDateFromUser();            
            LocalTime dueTime = Utils.getDueTimeFromUser();            
            String[] tags = Utils.getTagsFromUser();

            Task.TaskBuilder builder = new Task.TaskBuilder(result.getDescription());
            
            builder.setDueDate(dueDate);
            builder.setDueTime(dueTime);

            if (tags.length > 0) {
                builder.setTags(new ArrayList<String>(Arrays.asList(tags)));
            }

            if(priority != null){
                builder.setPriority(priority);   
            }

            result.updateTask(builder,result.isCompleted());
            System.out.println("Task Updated Successfully!");
            String timestamp = LocalDateTime.now().toString();
            logger.addToHistroy(timestamp + " : " + result.getDescription() + " Updated");
        }
    }


    // Undo last action
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop().getState();
            System.out.println("Undo Successful!");
            String timestamp = LocalDateTime.now().toString();
            logger.addToHistroy(timestamp + " : Undo Operation Performed");
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Find task by its description
    private Task findTaskByDescription(String description) {
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().equals(description.toLowerCase())) {
                return task;
            }
        }
        System.out.println("Task not found: " + description);
        return null;
    }

    // Start checking for notifications
    public void startNotifications() {
        System.out.println("Starting alert System!");

        notificationTimer = new Timer();
        notificationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                tasks.forEach(task -> {
                    LocalDateTime dueDateTime = LocalDateTime.of(task.getDueDate(), task.getDueTime());
                    if (!task.isCompleted() && shouldAlert(dueDateTime, now)) {
                        System.out.println("Alert: Task \"" + task.getDescription() + "\" is approaching its due time of " 
                            + DateTimeFormatter.ofPattern("hh:mm a").format(task.getDueTime()) + " Having due date of " 
                            + task.getDueDate() + ".");
                    }else if(!task.isCompleted() && isOverdue(dueDateTime, now)){
                        System.out.println("Overdue Alert: Task \"" + task.getDescription() + "\" is overdue, its due time is " 
                            + DateTimeFormatter.ofPattern("hh:mm a").format(task.getDueTime()) + " Having due date of " 
                            + task.getDueDate() + ".");
                    }
                });
            }
        }, 0, 60000); // Check every minute
    }

    // Stop notifications
    public void stopNotifications() {
        System.out.println("Stopping alert System!");
        notificationTimer.cancel();
    }

    // Check if a task is approaching its due time based on thresholds
    private boolean shouldAlert(LocalDateTime dueDateTime, LocalDateTime now) {
        long minutesUntilDue = ChronoUnit.MINUTES.between(now, dueDateTime);
        return minutesUntilDue > -1 && (minutesUntilDue <= 30 || minutesUntilDue <= 60 || minutesUntilDue <= 120 ||
           minutesUntilDue <= 180 || minutesUntilDue <= 360 || minutesUntilDue <= 720 ||
           minutesUntilDue <= 1440 || now.toLocalDate().isEqual(dueDateTime.toLocalDate()));
    }

    // Check if a task is overdue its due time based on thresholds
    private boolean isOverdue(LocalDateTime dueDateTime, LocalDateTime now) {
        long minutesUntilDue = ChronoUnit.MINUTES.between(now, dueDateTime);
        return minutesUntilDue < -1 && (now.toLocalDate().isEqual(dueDateTime.toLocalDate()));
    }

    // Check For Existing Task Description
    private boolean checkForConflicts(Task newTask) {
        for (Task task : tasks) {
            // Comparing for Conflicts
            if (
            task.getDescription().toLowerCase().equals(newTask.getDescription().toLowerCase())
            && task.getDueDate().compareTo(newTask.getDueDate()) == 0
            && DateTimeFormatter.ofPattern("hh:mm a").format(task.getDueTime())
            .equals(DateTimeFormatter.ofPattern("hh:mm a").format(newTask.getDueTime()))
            ) {
                System.out.println("Conflicts Found, Cannot create task!");
                return true;
            }
        }
        return false;
    }

    // Save the current state to history
    private void saveState() {
        history.push(new Momento(new ArrayList<>(tasks)));
    }
}