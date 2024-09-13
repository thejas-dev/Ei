# Task Documentation

This repository contains two main exercises:

## Exercise 1: Console-Based Personal To-Do List Manager Programming Excercise

### Overview
The Personal To-Do List Manager is a console-based application that helps users manage their tasks effectively. The application supports various functionalities including adding, completing, deleting, viewing tasks, and undo/redo actions. The system is designed with the following requirements:
- **Add Tasks**: Add new tasks to the list.
- **Mark Tasks as Completed**: Update tasks to indicate they are completed.
- **Delete Tasks**: Remove tasks from the list.
- **View Tasks**: Display tasks, with options to filter by completed or pending status.
- **Undo/Redo Actions**: Revert or reapply changes made to the task list.
- **Logging**: Record actions performed within the application.
- **Exception Handling**: Manage errors and invalid operations.

### Key Features
- Uses design patterns like Memento, Builder and Singlethon.
- Follows SOLID principles and Object-Oriented Programming practices.
- Includes comprehensive logging, exception, and error handling.

## Exercise 2: Design Pattern Exercises

### Overview
This exercise demonstrates the application of various design patterns through practical examples. The included patterns are:

### Creational Patterns
- **Builder Pattern**: A URL Builder application that constructs URLs with various components such as protocol, domain name, top-level domain, port, and path.
- **Factory Pattern**: A Vehicle Factory application that creates instances of different vehicle types (Car and Bike) using a factory method.
- **Singleton Pattern**: A Train Ticket Booking system that ensures only a single instance of the `Train` class exists, managing ticket reservations and availability.

### Behavioral Patterns:
  - **Chain of Responsibility Pattern**: An example where multiple handlers process a request in a chain.
  - **Observer Pattern**: A simple implementation demonstrating how observers are notified of changes in a subject.
  - **Memento Pattern**: An example demonstrating how to capture and restore the state of an object without exposing its internal structure.


### Structural Patterns
- **Adapter Pattern**: Media Player example where an adapter allows a `VlcPlayer` to be used with a `MediaPlayer` interface.
- **Facade Pattern**: Home Theater System that provides a simplified interface to control multiple subsystems (DVD player, projector, and sound system).
- **Proxy Pattern**: Bank Application where a proxy controls access to a real bank account, managing deposits, withdrawals, and balance checks.
