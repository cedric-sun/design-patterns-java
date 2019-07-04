package decorator;

public class SideBorder extends Border {
    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumnNumber() {
        return display.getColumnNumber() + 2;
    }

    @Override
    public int getRowNumber() {
        return display.getRowNumber();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
