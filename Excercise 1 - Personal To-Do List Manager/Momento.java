// Momento class
// Memento class implementing the Memento pattern to store the state of tasks 
// for undo functionality. The Task Object will be stored in state List which is then added
// to history queue of Manager Object

public class Memento {
    private final List<Task> state;

    public Memento(List<Task> tasks) {
        // Deep copy to store the current state of tasks
        this.state = new ArrayList<>(tasks);
    }

    public List<Task> getState() {
        return state;
    }
}
