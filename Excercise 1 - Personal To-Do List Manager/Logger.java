// Logger class
// Logger class implementing the Singleton pattern to track and display history of actions performed in the application.
// It stores all the actions in a ArrayList which can be used to display the history records.

import java.util.ArrayList;
import java.util.List;

public class Logger{
	private ArrayList<String> history;
	private static Logger instance;

	// Private Constructor
	private Logger(){
		history = new ArrayList<>();
	}

	// Singlethon Pattern Implementation
	public static synchronized Logger getInstance(){
		if(instance == null){
			instance = new Logger();
		}
		return instance;
	}

	// Adding date to history
	public void addToHistroy(String data){
		history.add(data);
	}

	// Displaying history line by line
	public void showHistory(){
		if(!history.isEmpty()){
			System.out.println("History :- ");
			for(String text : history){
				System.out.println(text);
			}
		}else{
			System.out.println("Nothing to show in history!");
		}
	}
}