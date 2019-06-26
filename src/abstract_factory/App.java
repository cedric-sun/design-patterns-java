package abstract_factory;

import abstract_factory.factory.*;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage stuff");
            System.exit(0);
        }

        Factory factory = Factory.getFactory(args[0]);

        Link amazonUS = factory.createLink(
                "Amazon US", "http://www.amazon.com");
        Link amazonJP = factory.createLink(
                "Amazon JP", "http://www.amazon.jp");
        Link uo = factory.createLink(
                "Urban outfitter", "https://www.urbanoutfitters.com");

        Link facebook = factory.createLink(
                "Facebook", "http://www.facebook.com");
        Link twitter = factory.createLink(
                "Twitter", "http://www.twitter.com");

        Tray amazonTray = factory.createTray("Amazon");
        amazonTray.add(amazonUS);
        amazonTray.add(amazonJP);

        Tray shopping = factory.createTray("Shopping");
        shopping.add(amazonTray);
        shopping.add(uo);

        Tray sns = factory.createTray("SNS");
        sns.add(facebook);
        sns.add(twitter);

        Page page = factory.createPage("Link Page", "CED");
        page.add(shopping);
        page.add(sns);
        page.output();
    }
}
