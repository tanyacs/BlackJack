/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardproject;
import java.util.ArrayList;
/**
 *
 * @author Dell
 */
public class BlackJackPlayer extends Player{
    private String name;
    private ArrayList<BlackjackCard> hand;

    public BlackJackPlayer(String name) {
         super(name);
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }

    public void addCardToHand(BlackjackCard card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aces = 0;
        for (BlackjackCard card : hand) {
            value += card.getValue();
            if (card.getRank().equals("A")) {
                aces++;
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }
     @Override
    public void play() {
        // Logic for player's turn will be handled in the game class
    }
     
    }


