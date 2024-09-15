// Momento pattern : Text editor example

import java.util.*;

// Originator class
class TextArea {
    private String text;

    public void set(String text) {
        this.text = text;
    }

    public void getText() {
        System.out.println(this.text);
    }

    public Momento takeSnapshot() {
        return new Momento(this.text);
    }

    public void restore(Momento momento) {
        this.text = momento.getSavedText();
    }

    // Memento class
    public static class Momento {
        private final String text;

        private Momento(String textToSave) {
            this.text = textToSave;
        }

        private String getSavedText() {
            return text;
        }
    }
}

// Caretaker class
class Editor {
    private Deque<TextArea.Momento> history;
    private TextArea textArea;

    public Editor() {
        history = new ArrayDeque<>();
        textArea = new TextArea();
    }

    public void write(String text) {
        history.addLast(textArea.takeSnapshot());
        textArea.set(text);
    }

    public void undo() {
        if (!history.isEmpty()) {
            textArea.restore(history.removeLast());
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void getLastAddedText() {
        textArea.getText();
    }
}

// Client code
public class MomentoPattern {
    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.write("Hello World");
        editor.write("Good Morning");
        editor.write("Good Evening");

        editor.getLastAddedText(); // Output: Good Evening

        editor.undo(); // Undo "Good Evening"

        editor.getLastAddedText(); // Output: Good Morning

        editor.undo(); // Undo "Good Morning"

        editor.getLastAddedText(); // Output: Hello World
    }
}

// The code implements the Memento Pattern where TextArea serves as the originator 
// that manages its state (text). It can create and restore from snapshots 
// represented by the Momento class. The Editor class acts as the caretaker, 
// managing a history of text snapshots and allowing undo operations. The client 
// code demonstrates writing text, viewing the current text, and undoing changes 
// to revert to previous text states.