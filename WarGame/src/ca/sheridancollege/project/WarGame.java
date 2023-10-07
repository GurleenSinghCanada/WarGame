import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WarGame extends Game {

    private Queue<Card> player1Deck;
    private Queue<Card> player2Deck;

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        GroupOfCards deck = new GroupOfCards(52);
        deck.shuffle();

        player1Deck = new LinkedList<>(deck.getCards().subList(0, 26));
        player2Deck = new LinkedList<>(deck.getCards().subList(26, 52));

        Player player1 = getPlayers().get(0);
        Player player2 = getPlayers().get(1);

        int roundsPlayed = 0;
        final int maxRounds = 150;

        while (!player1Deck.isEmpty() && !player2Deck.isEmpty() && roundsPlayed < maxRounds) {
            roundsPlayed++;
            System.out.println("Round " + roundsPlayed + ":");

            Card card1 = player1Deck.poll();
            Card card2 = player2Deck.poll();

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getValue() > card2.getValue()) {
                player1Deck.add(card1);
                player1Deck.add(card2);
                System.out.println(player1.getName() + " wins the round!");
            } else if (card2.getValue() > card1.getValue()) {
                player2Deck.add(card2);
                player2Deck.add(card1);
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("It's a tie! Entering War scenario...");

                // War scenario
                ArrayList<Card> warPile = new ArrayList<>();
                warPile.add(card1);
                warPile.add(card2);

                System.out.println("Both players draw 3 cards for war:");

                for (int i = 0; i < 3; i++) {
                    if (player1Deck.isEmpty() || player2Deck.isEmpty()) {
                        break;
                    }
                    Card warCard1 = player1Deck.poll();
                    Card warCard2 = player2Deck.poll();
                    warPile.add(warCard1);
                    warPile.add(warCard2);
                    System.out.println(player1.getName() + " draws " + warCard1);
                    System.out.println(player2.getName() + " draws " + warCard2);
                }

                if (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
                    Card warCard1 = warPile.get(warPile.size() - 2);
                    Card warCard2 = warPile.get(warPile.size() - 1);

                    System.out.println("War cards drawn:");
                    System.out.println(player1.getName() + " draws " + warCard1);
                    System.out.println(player2.getName() + " draws " + warCard2);

                    if (warCard1.getValue() > warCard2.getValue()) {
                        player1Deck.addAll(warPile);
                        System.out.println(player1.getName() + " wins the war!");
                    } else if (warCard2.getValue() > warCard1.getValue()) {
                        player2Deck.addAll(warPile);
                        System.out.println(player2.getName() + " wins the war!");
                    } else {
                        System.out.println("War ends in a tie! Cards are discarded.");
                    }
                }
            }

            System.out.println(player1.getName() + " has " + player1Deck.size() + " cards left.");
            System.out.println(player2.getName() + " has " + player2Deck.size() + " cards left.");
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        if (player1Deck.size() > player2Deck.size()) {
            System.out.println(getPlayers().get(0).getName() + " wins the game with " + player1Deck.size() + " cards left!");
        } else if (player2Deck.size() > player1Deck.size()) {
            System.out.println(getPlayers().get(1).getName() + " wins the game with " + player2Deck.size() + " cards left!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

// Rest of the code remains the same.
