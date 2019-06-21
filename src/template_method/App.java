package template_method;

public class App {
    public static void main(String[] args) {
        AbstractDisplay ad = new StringDisplay("Android Girl");
        ad.display();
        ad = new CharDisplay('P');
        ad.display();
    }
}
