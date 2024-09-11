// Singlethon Pattern : Train Ticket Booking System

// Singleton Train class
class Train{
	private static Train instance;
	private int availableTickets; 

	private Train(){ // Private Constructor to ensure no direct access to constructor
		availableTickets = 10;
		System.out.println("Train Singlethon Instance Created Successfully with " + availableTickets + " Tickets");
	}

	// Public method to provide global access to the instance
	// Used synchronized for Thread-Safety 
	public static synchronized Train getInstance(){
		if(instance == null){
			instance = new Train();
		}
		return instance;
	}

	// Method to reserve a seat
	public boolean reserveTicket(){
		if(availableTickets > 0){
			availableTickets--;
            System.out.println("Seat reserved successfully. Seats left: " + availableTickets);
			return true;
		}else{
            System.out.println("No seats available for reservation.");
			return false;
		}
	}

	// Method to show available seats
    public void showAvailableTickets() {
        System.out.println("Available seats: " + availableTickets);
    }
} 

public class SinglethonPattern{
	public static void main(String[] args){
		// Singlethon Instance Of Train
        Train train = Train.getInstance();

        train.showAvailableTickets(); // Output : Available seats: 10

        train.reserveTicket(); // Output: Seat reserved successfully. Seats left: 9
        train.reserveTicket(); // Output: Seat reserved successfully. Seats left: 8

        Train train2 = Train.getInstance();
        train2.reserveTicket(); // Output: Seat reserved successfully. Seats left: 7

        // Shared instance
        if (train == train2) {
            System.out.println("Both train instances are the same.");
        }

        train2.showAvailableTickets(); // Output : Available seats: 7

	}
}

// The Train class is a Singleton, ensuring only one instance exists. 
// No matter how many times getInstance() is called, it returns the same 
// Train object.