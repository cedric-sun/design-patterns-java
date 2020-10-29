package guardedsuspension;

// Immutable
public class Msg {
    private final String text;

    public Msg(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "text='" + text + '\'' +
                '}';
    }
}
