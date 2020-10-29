package guardedsuspension;

public class ReceiverRunnable implements Runnable {
    private final MsgQueue q;
    private final int n;

    public ReceiverRunnable(int n, MsgQueue q) {
        this.n = n;
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            Msg msg = null;
            try {
                msg = q.getMsg();
            } catch (InterruptedException ignored) {
            }
            System.out.println("Receiver " + Thread.currentThread().getName()
                    + " handling: " + msg.toString());
        }
    }
}
