package flyweight;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    private Map<Character, BigChar> pool = new HashMap<>();

    private static BigCharFactory singlton = new BigCharFactory();

    private BigCharFactory(){}

    public static BigCharFactory getInstance(){
        return singlton;
    }

    public synchronized BigChar getBigChar(char c) {
        if (!pool.containsKey(c)) {
            pool.put(c, new BigChar(c));
        }
        return pool.get(c);
    }
}
