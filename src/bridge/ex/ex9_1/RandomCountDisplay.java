package bridge.ex.ex9_1;

import bridge.CountDisplay;
import bridge.DisplayImpl;

import java.util.Random;

public class RandomCountDisplay extends CountDisplay {
    static Random random = new Random();

    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times + 1));
    }
}
