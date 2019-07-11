package proxy;

public class App {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println(p.getName());
        p.setName("Bob");
        System.out.println(p.getName());
        p.print("Hello World");
    }
}
