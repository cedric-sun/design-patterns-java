package strategy;

public class App {
    public static void main(String[] args) {
        if (args.length !=2) {
            System.err.println("Usage: java strategy.App RAND_SEED1 RAND_SEED2");
            return;
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);

        Player player1 = new Player("JOJO", new WinningStrategy(seed1));
        Player player2 = new Player("DIO", new ProbStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: "+player1);
                player1.win();
                player2.lose();
            } else if (nextHand1.isWeakerThan(nextHand2)) {
                System.out.println("Winner: "+player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even");
                player1.even();
                player2.even();
            }
        }

        System.out.println("=============");
        System.out.println("Total Result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
