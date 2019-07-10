package state;

public class App {
    public static void main(String[] args) throws InterruptedException{
        SafeFrame frame = new SafeFrame("State Pattern Demo");
        frame.setVisible(true);
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                Thread.sleep(1000);
            }
        }
    }
}
