package balking;

import java.io.IOException;

public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // expensive IO methods
    // precondition: actual IO is really necessary.
    public void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " saving content: "
                + content);
        try {
            Thread.sleep(100); // simulate IO latency
        } catch (InterruptedException ignored) {
        }
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            System.out.println("No change since last save; Balking.");
            return; // the "balking" thing is really just an if guard,
            // preventing unnecessary heavy operation from happening

            // balking vs guarded suspension
            // They are both answer to "what to do when the precondition is not satisfied";
            // balking: don't do and return
            // guarded suspension: wait until the precondition is satisfied
            // (someone really changed the content and notify this thread)
        }
        System.out.println("New change saved.");
        doSave();
        changed = false;
    }
}
