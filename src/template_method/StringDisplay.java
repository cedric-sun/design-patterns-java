package template_method;

public class StringDisplay extends AbstractDisplay {
    private String str;
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        width = str.length();
    }

    void printEdge() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < width; i++) sb.append('-');
        System.out.println(String.format("+%s+",sb));
    }
    @Override
    void open() {
        printEdge();
    }

    @Override
    void print() {
        System.out.println(String.format("|%s|",str));
    }

    @Override
    void close() {
        printEdge();
    }
}
