package abstract_factory.listfactory;

import abstract_factory.factory.Item;
import abstract_factory.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();
        for (Item item : tray) {
            sb.append(item.makeHTML());
        }
        return String.format("<li>%s<ul>%s</ul></li>", caption, sb);
    }
}
