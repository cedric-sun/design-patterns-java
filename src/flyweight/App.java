package flyweight;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        BigString bs = new BigString(args[0]);
        bs.print();
    }
}
