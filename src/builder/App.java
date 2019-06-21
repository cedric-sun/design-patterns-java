package builder;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(0);
        }

        if (args[0].equals("plain")) {
            TextBuilder tb = new TextBuilder();
            Director director = new Director(tb);
            director.construct();
            String res = tb.getRes();
            System.out.println(res);
        } else if (args[0].equals("html")) {
            HTMLBuilder hb = new HTMLBuilder();
            Director director = new Director(hb);
            director.construct();

            String filename = hb.getRes();
            System.out.println(
                    String.format("Done writing: %s",filename));
        } else {
            System.exit(0);
        }
    }
}
