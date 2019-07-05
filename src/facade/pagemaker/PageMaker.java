package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {

    }

    public static void makeWelcomePage(String mailAddr, String filename) {
        try {
            Properties mailProps = Database.getProperties("maildata");
            String username = mailProps.getProperty(mailAddr);
            HTMLWriter writer = new HTMLWriter(new FileWriter(filename));

            writer.title(String.format("Welcome to %s's page",username));
            writer.paragraph(String.format("Welcome to the index page of %s.", username));
            writer.paragraph("I'm waiting for your email!");
            writer.mailto(mailAddr,username);
            writer.close();
            System.out.println(String.format("%s is created for %s (%s)",filename,mailAddr,username));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
