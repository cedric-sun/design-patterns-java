package guardedsuspension;

import java.util.concurrent.ThreadLocalRandom;

// the thread that generates Msg
public class SenderRunnable implements Runnable {
    private final ThreadLocalRandom randSrc;
    private final MsgQueue q;
    private final int n;

    public SenderRunnable(int n, MsgQueue q) {
        this.n = n;
        this.q = q;
        this.randSrc = ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            Msg msg = new Msg("Hello world " + i);
            q.pugMsg(msg);
            System.out.println("Sender " + Thread.currentThread().getName() + " sent: "
                    + msg.toString());
            try {
                // sleep a random duration up to 1 second
                Thread.sleep(randSrc.nextInt(1000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
