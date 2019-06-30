package adapter.class_adapter;

import adapter.Banner;

public class PrintBanner extends Banner implements Printable {
    public PrintBanner(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
