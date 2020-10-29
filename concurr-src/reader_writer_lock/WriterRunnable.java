package reader_writer_lock;

import java.util.concurrent.ThreadLocalRandom;

public class WriterRunnable implements Runnable {
    private final Data data;
    private final char[][] stuffsToWrite;
    ThreadLocalRandom r = ThreadLocalRandom.current();

    public WriterRunnable(Data data) {
        this.data = data;
        stuffsToWrite = new char[16][data.n];
        for (int i = 0; i < stuffsToWrite.length; i++) {
            for (int j = 0; j < data.n; j++) {
                stuffsToWrite[i][j] = (char) r.nextInt(Character.MAX_VALUE);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            data.write(stuffsToWrite[r.nextInt(16)]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
