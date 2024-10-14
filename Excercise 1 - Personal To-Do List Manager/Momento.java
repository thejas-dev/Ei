// Momento class
// Memento class implementing the Memento pattern to store the state of tasks 
// for undo functionality. The Task Object will be stored in state List which is then added
// to history queue of Manager Object
import java.util.List;
import java.util.ArrayList;

public class Momento {
    private List<Task> state;

    public Momento(List<Task> state) {
        this.state = state;
    }

    public List<Task> getState() {
        return state;
    }
}
