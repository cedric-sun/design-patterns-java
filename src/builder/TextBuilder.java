package builder;

public class TextBuilder extends Builder {
    private StringBuffer sb = new StringBuffer();
    private static final String LINE_SEP = System.lineSeparator();
    private static final String DECO_LINE = "=====================";

    @Override
    public void makeTitle(String title) {
        sb.append(String.format("%s%s", DECO_LINE, LINE_SEP));
        sb.append(String.format("<%s>%s", title, LINE_SEP));
        sb.append(LINE_SEP);
    }

    @Override
    public void makeString(String str) {
        sb.append(String.format("| %s%s", str, LINE_SEP));
        sb.append(LINE_SEP);
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            sb.append(String.format("  - %s%s", items[i], LINE_SEP));
        }
        sb.append(LINE_SEP);
    }

    @Override
    public void close() {
        sb.append(String.format("%s%s", DECO_LINE, LINE_SEP));
    }

    public String getRes() {
        return sb.toString();
    }
}
