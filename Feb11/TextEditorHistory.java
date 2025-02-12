class TextState {
    String text;
    TextState prev;
    TextState next;

    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditorHistory {
    private TextState currentState;
    private int maxHistorySize;
    private int historySize;
    private TextState head;
    private TextState tail;

    public TextEditorHistory(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.historySize = 0;
        this.currentState = null;
        this.head = null;
        this.tail = null;
    }

    public void addTextState(String text) {
        TextState newState = new TextState(text);
        if (historySize == maxHistorySize) {
            head = head.next;
            head.prev = null;
            historySize--;
        }

        if (tail != null) {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        } else {
            head = tail = newState;
        }

        currentState = tail;
        historySize++;
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        }
    }

    public String getCurrentText() {
        return currentState != null ? currentState.text : "";
    }

    public static void main(String[] args) {
        TextEditorHistory editor = new TextEditorHistory(10);

        editor.addTextState("First State");
        editor.addTextState("Second State");
        editor.addTextState("Third State");

        System.out.println(editor.getCurrentText());
        editor.undo();
        System.out.println(editor.getCurrentText());
        editor.undo();
        System.out.println(editor.getCurrentText());
        editor.redo();
        System.out.println(editor.getCurrentText());
    }
}
