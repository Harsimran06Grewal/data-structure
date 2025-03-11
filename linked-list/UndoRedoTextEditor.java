// doubly linked list
class TextState {
    // Attributes of text state class
    String content;
    TextState prev; // Pointer to previous state (Undo)
    TextState next; // Pointer to next state (Redo)

    // Constructor to initialize the text state
    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState currentState; 
    private int maxHistorySize = 10; 
    private int historySize = 0; 

    // Method to add a new text state 
    public void addState(String newText) {
        TextState newState = new TextState(newText);
        if (currentState != null) {
            newState.prev = currentState;
            currentState.next = newState;
        }
        currentState = newState;

        // Manage history size (keep only last 10 states)
        historySize++;
        if (historySize > maxHistorySize) {
            trimOldestState();
        }
    }

    // Method to remove the oldest state when exceeding history size limit
    private void trimOldestState() {
        TextState temp = currentState;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null;
        }
        historySize--;
    }

    // Undo function (revert to the previous state)
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.content);
        } else {
            System.out.println("No previous state to undo.");
        }
    }

    // Redo function (revert back to the next state after undo)
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.content);
        } else {
            System.out.println("No next state to redo.");
        }
    }

    // Method to display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulating user actions
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello, this is a test.");
        editor.displayCurrentState();

        // Performing Undo operations
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        // Performing Redo operations
        editor.redo();
        editor.displayCurrentState();

        // Adding new state after undo (clears forward history)
        editor.addState("New Text After Undo");
        editor.displayCurrentState();

        // Undo and Redo Again
        editor.undo();
        editor.redo();
    }
}
