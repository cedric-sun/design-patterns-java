package adapter.object_adapter;

import adapter.Banner;

public class PrintBanner extends Printable {
    private Banner banner;

    public PrintBanner(String str) {
        banner = new Banner(str);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
