package strategy;

public class Player {
    private String name;
    private Strategy strategy;
    private int winCnt, loseCnt, gameCnt;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCnt++;
        gameCnt++;
    }

    public void lose() {
        strategy.study(false);
        loseCnt++;
        gameCnt++;
    }

    public void even() {
        gameCnt++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", winCnt=" + winCnt +
                ", loseCnt=" + loseCnt +
                ", gameCnt=" + gameCnt +
                '}';
    }
}
