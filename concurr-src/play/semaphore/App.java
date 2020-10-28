package play.semaphore;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(10);
        sema.release(12);
        System.out.println(sema.availablePermits());//22
    }
}
