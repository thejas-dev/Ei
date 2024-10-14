// Utils Class
// Utility class providing helper methods for user input, including due date, time, priority, and tags.
// Supports user interaction for setting task attributes with default and validation mechanisms.

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Utils{
	static Scanner scanner = new Scanner(System.in);
	
	// Ask Priority Level of Task From User
	public static Priority getPriorityLevelFromUser(){
		System.out.print("Enter priority (LOW/MEDIUM/HIGH): ");
        String tempPriority = scanner.nextLine();
        Priority priority = null;

        if(!tempPriority.isEmpty()){
            try{
                priority = Priority.valueOf(tempPriority.toUpperCase());
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid Priority Level!");
            }
        }

        return priority;
	}

	// Ask Due Date of Task From User
	public static LocalDate getDueDateFromUser(){
        LocalDate today = LocalDate.now(); // Today's Date
		
		System.out.print("Enter due date (format : yyyy-mm-dd, default: Today Date): ");
        String dueDate = scanner.nextLine();
        
        try{
        	LocalDate date = LocalDate.parse(dueDate); 
            return date;
        }catch (Exception e) {
        	if(dueDate.length() > 0) System.out.println("Date Format is incorrect! Using Today's Date");
        	else System.out.println("Assigned Due Date as Today");
            return today;
        }
	}

	// Ask Due Time of Task From User
	public static LocalTime getDueTimeFromUser(){
        LocalTime currentTime = LocalTime.now(); // Current Time
        currentTime = currentTime.plusMinutes(10);
		
		System.out.print("Enter due time (format : hh:mm (AM/PM), default: +10 mins): ");
        String dueTime = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        if(dueTime.length() > 0){
	        try{
                return LocalTime.parse(dueTime,formatter);
	        }catch (Exception e) {
	            System.out.println("Time Format is incorrect! Set due time in ten minutes");
	            return currentTime;
	        }
        }else{
            System.out.println("Due time in ten minutes");
	        return currentTime;
        }
	}

	// Ask Tags of Task From User
	public static String[] getTagsFromUser(){
		System.out.print("Enter tags if any (optional, separate by comma): ");
        String[] tags = scanner.nextLine().split(",");
        return tags;
	}

}