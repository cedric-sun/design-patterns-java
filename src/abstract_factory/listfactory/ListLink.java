package abstract_factory.listfactory;

import abstract_factory.factory.Link;

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<li><a href=\"%s\">%s</a></li>", url, caption);
    }
}
