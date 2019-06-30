package adapter;

public class Banner {
    private String str;

    public Banner(String str) {
        this.str = str;
    }

    public void showWithParen() {
        System.out.println(String.format("(%s)", str));
    }

    public void showWithAster() {
        System.out.println(String.format("*%s*", str));
    }
}
