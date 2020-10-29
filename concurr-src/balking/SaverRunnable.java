package balking;

import java.io.IOException;

// Simulate the auto-saving background thread in text-editor
// auto save every 1 second
public class SaverRunnable implements Runnable {
    private final Data data;

    public SaverRunnable(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException ignored) {
        }
    }
}
