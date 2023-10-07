import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WarGame game = new WarGame("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        game.setPlayers(players);
        game.play();
    }
}

