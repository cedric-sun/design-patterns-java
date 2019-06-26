package abstract_factory.listfactory;

import abstract_factory.factory.Item;
import abstract_factory.factory.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();
        for (Item item : content) {
            sb.append(item.makeHTML());
        }
        return String.format(
                "<html><head><title>%s</title></head>" +
                        "<body><h1>%s</h1><ul>%s</ul><hr/>" +
                        "<address>%s</address></body></html>",
                title, title, sb, author
        );
    }
}
