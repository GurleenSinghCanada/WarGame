//package ca.sheridancollege.project;

public class Card {
    private String suit; // Suit of the card (e.g., Spades, Hearts)
    private int value; // Value of the card (1-13)

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" + "suit='" + suit + '\'' + ", value=" + value + '}';
    }
}
