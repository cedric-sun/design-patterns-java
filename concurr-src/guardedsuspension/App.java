package guardedsuspension;

public class App {
    public static final int MSG_CNT = 10;

    public static void main(String[] args) {
        MsgQueue q = new MsgQueue();
        Thread receiverThread = new Thread(new ReceiverRunnable(MSG_CNT, q));
        Thread senderThread = new Thread(new SenderRunnable(MSG_CNT, q));
        receiverThread.start();
        senderThread.start();
        try {
            receiverThread.join();
            senderThread.join();
        } catch (InterruptedException ignored) {

        }
    }
}
