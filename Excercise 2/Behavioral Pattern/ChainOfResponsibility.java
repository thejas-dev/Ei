// Chain of Responsibility Pattern: Ticket Handling System

// Abstract Handler
abstract class TicketHandler {
    protected TicketHandler nextHandler;

    // Set the next handler in the chain
    public void setNextHandler(TicketHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Handle the ticket request
    public abstract void handleRequest(String ticketType);
}

// Concrete Handler 1: IT Support
class ITSupportHandler extends TicketHandler {
    @Override
    public void handleRequest(String ticketType) {
        if (ticketType.equalsIgnoreCase("IT")) {
            System.out.println("IT Support is handling the ticket.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticketType);
        } else {
            System.out.println("No handler found for the ticket.");
        }
    }
}

// Concrete Handler 2: HR Department
class HRHandler extends TicketHandler {
    @Override
    public void handleRequest(String ticketType) {
        if (ticketType.equalsIgnoreCase("HR")) {
            System.out.println("HR Department is handling the ticket.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticketType);
        } else {
            System.out.println("No handler found for the ticket.");
        }
    }
}

// Concrete Handler 3: Maintenance
class MaintenanceHandler extends TicketHandler {
    @Override
    public void handleRequest(String ticketType) {
        if (ticketType.equalsIgnoreCase("Maintenance")) {
            System.out.println("Maintenance team is handling the ticket.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticketType);
        } else {
            System.out.println("No handler found for the ticket.");
        }
    }
}

// Client Code
public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Creating handlers
        TicketHandler itSupport = new ITSupportHandler();
        TicketHandler hrHandler = new HRHandler();
        TicketHandler maintenanceHandler = new MaintenanceHandler();

        // Setting up the chain of responsibility
        itSupport.setNextHandler(hrHandler);
        hrHandler.setNextHandler(maintenanceHandler);

        // Testing the chain with different ticket types
        itSupport.handleRequest("IT"); // Output: IT Support is handling the ticket.
        itSupport.handleRequest("HR"); // Output: HR Department is handling the ticket.
        itSupport.handleRequest("Maintenance"); // Output: Maintenance team is handling the ticket.
        itSupport.handleRequest("Finance"); // Output: No handler found for the ticket.
    }
}

// The Chain of Responsibility pattern is used here to manage ticket handling in an 
// office. Handlers (IT, HR, and Maintenance) are set up in a chain, each capable of 
// processing specific ticket types. If a handler cannot process a ticket, it 
// passes the request to the next handler in the chain. This allows the system to 
// flexibly handle different types of tickets and easily extend or modify the chain 
// as needed.