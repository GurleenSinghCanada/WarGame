//package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                this.cards.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
