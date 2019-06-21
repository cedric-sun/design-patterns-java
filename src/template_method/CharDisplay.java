package template_method;

public class CharDisplay extends AbstractDisplay {
    private char c;

    public CharDisplay(char c) {
        this.c = c;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.print(c);
    }

    @Override
    void close() {
        System.out.print(">>");
    }
}
