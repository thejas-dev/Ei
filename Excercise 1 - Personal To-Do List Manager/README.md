# Personal To-Do List Manager Programming Excercise

## Problem Statement
Create a simple To-Do List Manager where users can add tasks, mark them as completed, and delete them. The user should also have the option to view all tasks or filter them based on their completion status. Additionally, the system should support undo functionality to revert actions, alert users when tasks are approaching their due time, and log important actions performed within the application.

---

## Project Overview
This project implements a console-based **Personal To-Do List Manager** with several advanced features:
- **Task Creation**: Users can add tasks with optional due dates, times, and priority levels.
- **Task Management**: Tasks can be marked as complete, edited, and deleted.
- **Task Filters**: Users can filter tasks based on their completion status (all, completed, pending) or priority (high, medium, low).
- **Undo Functionality**: Actions can be reverted using the undo feature.
- **Task Notifications**: Notifications are generated for upcoming and overdue tasks.
- **Logging**: All significant events (such as task creation, deletion, or completion) are logged with timestamps for reference.

---

## Project Structure
Below is an explanation of the files that make up the project:

### 1. **ToDoAppMain.java**
This file contains the entry point for the application. The `Main` class presents a console-based user interface, allowing users to interact with the To-Do List Manager by adding, viewing, editing, deleting tasks, and performing undo operations. The main loop is interactive, prompting the user for inputs and offering different functionalities based on the options selected.

### 2. **Priority.java**
This file contains the `Priority` enumeration used to define the priority levels of tasks. There are three priority levels:
- **HIGH**
- **MEDIUM**
- **LOW**

### 3. **Task.java**
This file defines the `Task` class, which represents individual tasks in the to-do list. Implements the **Builder** design pattern to simplify task creation with optional attributes. Each task has attributes such as:
- **Description**: The task's main name/information.
- **Due Date and Time**: Optional fields to specify deadlines.
- **Priority**: Enum-based priority system (`HIGH`, `MEDIUM`, `LOW`).
- **Tags**: Optional tags that can be associated with tasks.
- **Completion Status**: Tracks whether the task has been completed.

The class supports operations like marking a task as completed, updating task details, and displaying task information.

### 4. **ToDoManager.java**
The `ToDoManager` class is the central component that manages all functionalities of the to-do list. It is implemented as a **Singleton** to ensure only one instance of the manager exists throughout the program's lifecycle. Key features include:
- **Task Management**: Adding, deleting, editing, and viewing tasks.
- **Undo Functionality**: Using the **Memento Pattern**, the manager allows users to undo their last actions.
- **Task Filters**: Users can filter tasks based on completion status (all, completed, pending) or priority.
- **Notifications**: Periodically checks for tasks that are due soon and alerts the user.
- **Conflict Management**: Prevents duplicate tasks with the same description, due date, and time.
  

### 5. **Utils.java**
The `Utils` class is a helper class responsible for handling user input and validation. It contains methods to:
- Collect priority levels from the user.
- Capture the task's due date and due time.
- Input and validate task tags.

This class improves the overall user experience by simplifying and streamlining user inputs.

### 6. **Memento.java**
This file implements the **Memento Pattern**, which is used for the undo functionality. Each memento captures the current state of the task list, allowing for rollback to previous states. The `Memento` class contains a deep copy of the task list, preserving its state at the time of creation.

### 7. **Logger.java**
The `Logger` class is a **Singleton** that handles logging of important events in the application. All significant actions like task creation, deletion, and completion are logged with timestamps. The log history can be viewed at any time, and it provides a useful audit trail for the user.

---

## How to Use the To-Do List Manager

1. **Run the Application**: Execute the `ToDoAppMain` class, and you will be presented with a console interface.
2. **Add a Task**: Input task details such as description, due date, due time, priority, and tags.
3. **View Tasks**: Choose to view all tasks or filter them based on status (completed, pending) or priority (high, medium, low).
4. **Edit a Task**: Find a task by its description and update its details such as due date, priority, etc.
5. **Delete a Task**: Remove a task by its description.
6. **Mark Task as Completed**: Change a task's status to completed.
7. **Undo an Action**: Revert the last action you performed.
8. **Notifications**: Alerts will be generated for tasks that are nearing or have passed their due time.
9. **View History**: Check the log to see a history of all task-related actions.

---

## Design Patterns Used

1. **Singleton Pattern**: 
   - Used in both `Logger` and `ToDoManager` to ensure only one instance of these classes exists throughout the application.
   
2. **Memento Pattern**: 
   - Implemented in `Memento.java` to enable undo functionality by storing snapshots of the current task list.

3. **Builder Pattern**: 
   - Used in the `Task` class to handle task creation, allowing optional fields like tags, due date, and priority to be set flexibly.

--- 

## Summary

The Personal To-Do List Manager is a console-based application that allows users to create, manage, and filter tasks with features like undo functionality and task notifications. It leverages design patterns such as Singleton and Memento to ensure a clean, efficient user experience. Future updates will focus on developing interactive UI.

---
