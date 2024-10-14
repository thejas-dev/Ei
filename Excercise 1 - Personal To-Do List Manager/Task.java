// Task class file
// Task class representing individual tasks with attributes like due date, time, priority, and tags.
// Implements the Builder design pattern to simplify task creation with optional parameters.
// It also display the Task information with the toString() method

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

// Task Class
class Task {
    private String description;
    private LocalDate dueDate;
    private LocalTime dueTime;
    private boolean isCompleted;
    private Priority priority;

    // Optional attributes : tags
    private List<String> tags;

    // Task Constructed by Builder
    private Task(TaskBuilder builder) {
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.dueTime = builder.dueTime;
        this.priority = builder.priority;
        this.tags = builder.tags;
        this.isCompleted = false;
    }

    // Editing Task Details
    public void updateTask(TaskBuilder builder, boolean isCompleted){
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.dueTime = builder.dueTime;
        this.priority = builder.priority;
        this.tags = builder.tags;
        this.isCompleted = isCompleted;
    }

    // Builder Pattern : Task Builder 
    public static class TaskBuilder {
        private final String description;
        private LocalDate dueDate;
        private LocalTime dueTime;
        private List<String> tags;
        private Priority priority;

        public TaskBuilder(String description) {
            this.description = description;
        }

        public TaskBuilder setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public TaskBuilder setDueTime(LocalTime dueTime) {
            this.dueTime = dueTime;
            return this;
        }

        public TaskBuilder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public TaskBuilder setPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Task build() {
            if(!this.description.isEmpty()) return new Task(this);
            else {
                System.out.print("Cannot create task, description is empty\n");
                return null;
            }
        }
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Pending") + 
            (priority != null ? ", Priority: " + priority : "") + (dueDate != null ? ", Due Date: " + dueDate : "")
            + (dueTime != null ? ", Due Time: " + DateTimeFormatter.ofPattern("hh:mm a").format(dueTime) : "");
    }
}