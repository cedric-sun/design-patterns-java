package guardedsuspension;

import java.util.ArrayDeque;
import java.util.Queue;

// An blocking queue with unbounded capacity. i.e. adding new element to tail never blocks
public class MsgQueue {
    private final Queue<Msg> q = new ArrayDeque<>();

    public synchronized Msg getMsg() throws InterruptedException {
        while (q.isEmpty()) {
            wait();
        }
        return q.poll();
    }

    public synchronized void pugMsg(Msg msg) {
        q.offer(msg);
        notify(); // or notifyAll;
    }
}
