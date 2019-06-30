package bridge.ex.ex9_2;

import bridge.Display;

public class App {
    public static void main(String[] args) {
        Display d1 = new Display(
                new FileDisplayImpl("test-res/bridge-ex-9-2-testdata.txt"));
        d1.display();
    }
}
