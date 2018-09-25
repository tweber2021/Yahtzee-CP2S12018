

public class Yahtzee {

    Player player;

public static void main(String[] args) {
    Yahtzee yahtzee = new Yahtzee();
    yahtzee.run();

    }

    public void run() {
        player = new Player();
    player.takeTurn(0);
    }
}
