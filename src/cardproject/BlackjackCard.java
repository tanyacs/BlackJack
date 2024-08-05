/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardproject;

/**
 *
 * @author Dell
 */
public class BlackjackCard extends Card{
     private String rank;
    private String suit;

    public BlackjackCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": case "J": case "Q": case "K": return 10;
            case "A": return 11; // or 1, but we will handle this logic in the game
            default: throw new IllegalArgumentException("Unknown rank: " + rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
