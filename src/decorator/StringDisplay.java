package decorator;

public class StringDisplay extends Display {
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumnNumber() {
        return string.getBytes().length;
    }

    @Override
    public int getRowNumber() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0)
            return string;
        else
            return null;
    }
}
