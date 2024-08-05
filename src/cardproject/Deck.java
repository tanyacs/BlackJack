/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Dell
 */
public class Deck extends GroupOfCards{
     private List<Card> cards;

    public Deck(int size) {
        super(size);
        cards = new ArrayList<>();
    }
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public Deck() {
        super(52);
        cards = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards.add(new BlackjackCard(rank, suit));
            }
        }
        shuffle();
    }
     @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public BlackjackCard dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }
        return (BlackjackCard) cards.remove(cards.size() - 1);
    }
}
