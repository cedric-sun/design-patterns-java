package decorator;

public class FullBorder extends Border{
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumnNumber() {
        return display.getColumnNumber() + 2;
    }

    @Override
    public int getRowNumber() {
        return display.getRowNumber() + 2;
    }

    private String makeLine(char ch, int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRowNumber() + 1) {
            return String.format("+%s+", makeLine('-', display.getColumnNumber()));
        } else {
            return String.format("|%s|", display.getRowText(row - 1));
        }
    }
}
