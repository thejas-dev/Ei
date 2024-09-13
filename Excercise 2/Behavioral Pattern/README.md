# Behavioral Design Patterns

This folder contains implementations of various behavioral design patterns. Each pattern is demonstrated through a different example, showcasing its application and benefits. Below are the details for each pattern:

## 1. Chain of Responsibility Pattern: Ticket Handling System

The **Chain of Responsibility Pattern** is utilized to manage ticket handling within an office environment. This pattern allows a chain of handlers to process requests, with each handler passing the request along the chain if it cannot handle it. This implementation includes:

- **Abstract Handler**: `TicketHandler`
- **Concrete Handlers**: `ITSupportHandler`, `HRHandler`, `MaintenanceHandler`
- **Client Code**: `ChainOfResponsibility.java`

The system allows flexible handling of different ticket types and can be easily extended with additional handlers.

## 2. Memento Pattern: Text Editor Example

The **Memento Pattern** is implemented in a text editor example, enabling undo functionality by capturing and restoring the state of the text. Key components include:

- **Originator**: `TextArea`
- **Memento**: `Momento`
- **Caretaker**: `Editor`
- **Client Code**: `MomentoPattern.java`

This pattern facilitates the management of text states and supports undo operations while encapsulating the text's internal state.

## 3. Observer Pattern: News Notification System

The **Observer Pattern** is demonstrated in a news notification system where subscribers receive updates from a news agency. This pattern allows dynamic subscription and notification of changes. Components include:

- **Observer Interface**: `Subscriber`
- **Subject**: `NewsAgency`
- **Concrete Observer**: `UserSubscriber`
- **Client Code**: `ObserverPattern.java`

This implementation enables real-time news distribution and management of subscribers.
