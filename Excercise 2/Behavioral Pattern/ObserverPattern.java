// Observer Pattern: News Notification System
import java.util.*;

// Observer Interface
interface Subscriber {
    void update(String news);
}

// Subject Class
class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber)  {
        subscribers.remove(subscriber);
    }

    public void notify(String news){
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

// Concrete Observer Class
class UserSubscriber implements Subscriber {
	String name;

    // Constructor to set the name of the subscriber
    UserSubscriber(String name) {
    	this.name = name;
    }

    // Implementing the update method to receive news notifications
    @Override
    public void update(String news) {
        System.out.println(this.name + " received news " + news);
    }
}


// Client Code
public class ObserverPattern{
	public static void main(String[] args) {
        // Creating the subject (NewsAgency)
		NewsAgency newsAgency = new NewsAgency();

		// Creating Observers
		UserSubscriber user1 = new UserSubscriber("Alice");
		UserSubscriber user2 = new UserSubscriber("Bob");

		// Subscribing users to new agency
		newsAgency.subscribe(user1);
		newsAgency.subscribe(user2);

        // Sending notifications to all subscribers
		newsAgency.notify("Breaking News: New Java Version Released!");

		newsAgency.unsubscribe(user1);

		// Sending another notification after removing 1 user
		newsAgency.notify("Update: Java 20 Released!");
	}
}

// Created a simple notification system where subscribers can receive updates from a news agency.
// The NewsAgency class is the Subject that maintains a list of Observers (subscribers) and notifies them of any updates.
// The UserSubscriber class implements the Observer interface, receiving updates from the Subject.