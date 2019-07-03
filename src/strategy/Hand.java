package strategy;

public class Hand {
    public static final int HAND_ROCK = 0;
    public static final int HAND_PAPER =1;
    public static final int HAND_SCISSORS=2;

    public static final Hand[] hand = {
            new Hand(HAND_ROCK),
            new Hand(HAND_PAPER),
            new Hand(HAND_SCISSORS),
    };
    private static final String[] name = {
            "ROCK", "PAPER", "SCISSORS"
    };

    private int value;

    private Hand(int value) {
        this.value = value;
    }

    public static Hand getHand(int value) {
        return hand[value];
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand)==1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if ((value+1)%3 == hand.value) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return name[value];
    }
}
