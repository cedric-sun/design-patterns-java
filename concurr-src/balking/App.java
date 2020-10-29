package balking;

// balking, a new fancy name for if-guard.
public class App {
    public static void main(String[] args) {
        Data data = new Data("abc.txt", "");
        Thread changerThread = new Thread(new ChangerRunnable(data));
        Thread saverThread = new Thread(new SaverRunnable(data));
        changerThread.start();
        saverThread.start();
        try {
            changerThread.join();
            saverThread.join();
        } catch (InterruptedException ignored) {

        }
    }
}
