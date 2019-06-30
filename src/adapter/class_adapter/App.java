package adapter.class_adapter;

public class App {
    public static void main(String[] args) {
        Printable p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
