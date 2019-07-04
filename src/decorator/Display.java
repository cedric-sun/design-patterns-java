package decorator;

public abstract class Display {
    public abstract int getColumnNumber();

    public abstract int getRowNumber();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRowNumber(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
