package balking;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ChangerRunnable implements Runnable {
    private final Data data;
    private final ThreadLocalRandom randSrc = ThreadLocalRandom.current();

    public ChangerRunnable(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("#" + i + " Hello world");
                Thread.sleep(randSrc.nextInt(1000));
                data.save();
            }
        } catch (IOException | InterruptedException ignored) {

        }
    }
}
