package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HTMLWriter {
    private Writer writer;

    public HTMLWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write(String.format("<title>%s</title>", title));
        writer.write("</head>");
        writer.write("<body>");
        writer.write(String.format("<h1>%s</h1>", title));
    }

    public void paragraph(String msg) throws IOException {
        writer.write(String.format("<p>%s</p>", msg));
    }

    public void link(String href, String caption) throws IOException {
        paragraph(String.format("<a href=\"%s\">%s</a>", href, caption));
    }

    public void mailto(String mailAddr, String username) throws IOException {
        link("mailto:" + mailAddr, username);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.close();
    }
}
