package adapter.object_adapter;

public class App {
    public static void main(String[] args) {
        Printable p = new PrintBanner("the star spangled banner");
        p.printWeak();
        p.printStrong();
    }
}
