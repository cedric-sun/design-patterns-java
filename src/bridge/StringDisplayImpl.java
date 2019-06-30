package bridge;

public class StringDisplayImpl extends DisplayImpl {
    private String str;
    private int width;

    public StringDisplayImpl(String str) {
        this.str = str;
        width = str.getBytes().length;
    }

    private void printLine() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < width; i++) {
            sb.append('-');
        }
        System.out.println(String.format("+%s+",sb));
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println(String.format("|%s|", str));
    }

    @Override
    public void rawClose() {
        printLine();
    }
}
