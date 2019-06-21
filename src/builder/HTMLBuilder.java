package builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder {
    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = String.format("%s.html", title);

        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(String.format(
                "<html><head><title>%s</title></head></html>", title));
        writer.println(String.format("<h1>%s</h1>", title));
    }

    @Override
    public void makeString(String str) {
        writer.println(String.format("<p>%s</p>", str));
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println(String.format("<li>%s</li>", items[i]));
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getRes() {
        return filename;
    }
}
