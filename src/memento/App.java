package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class App {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento meme = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println(String.format("=====Round %d=====", i));
            System.out.println("Current:" + gamer);

            gamer.roll();

            System.out.println("Money left: "+gamer.getMoney());

            if (gamer.getMoney() > meme.getMoney()) {
                System.out.println("SLCheater: Money increases, saving state...");
                meme = gamer.createMemento();
            } else if (gamer.getMoney() <= meme.getMoney() >> 1) {
                System.out.println("SLCheater: Money decreases, restoring state...");
                gamer.restoreMemento(meme);
            }

            try { Thread.sleep(1000);}
            catch (InterruptedException e){e.printStackTrace();}

            System.out.print(System.lineSeparator());
        }
    }
}
