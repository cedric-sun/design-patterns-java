package memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();

    private Random random = new Random();

    private static String[] fruitsName = {
            "Apple", "Grape", "Banana", "Orange"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void roll() {
        int dice = random.nextInt(6) + 1;
        switch (dice) {
            case 1:
                money += 100;
                System.out.println("Money increases by 100");
                break;
            case 2:
                money >>= 1;
                System.out.println("Money is halved");
                break;
            case 6:
                String f = newFruit();
                System.out.println(String.format("New fruit: %s.", f));
                fruits.add(f);
                break;
                default:
                    System.out.println("Nothing happened...");
        }
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String str : fruits) {
            if (str.startsWith("delicious")) {
                m.addFruit(str);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruitsCopy();
    }

    private String newFruit() {
        String prefix = "";
        if (random.nextBoolean())
            prefix = "delicious";
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
}
