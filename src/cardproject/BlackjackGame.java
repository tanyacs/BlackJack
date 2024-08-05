/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardproject;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class BlackjackGame extends Game{
     private Deck deck;

    public BlackjackGame() {
        super("Blackjack");
        deck = new Deck();
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting a new game of Blackjack...");

        // Initialize players
        BlackJackPlayer player = new BlackJackPlayer("Player");
        BlackJackPlayer dealer = new BlackJackPlayer("Dealer");

        getPlayers().add(player);
        getPlayers().add(dealer);

        // Initial deal
        player.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());
        player.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        // Player's turn
        while (true) {
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Dealer's up card: " + dealer.getHand().get(0));
            System.out.print("Do you want to (h)it or (s)tand? ");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("h")) {
                player.addCardToHand(deck.dealCard());
                if (player.getHandValue() > 21) {
                    System.out.println("You busted with a hand value of " + player.getHandValue() + ". Dealer wins.");
                    return;
                }
            } else if (action.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Dealer's turn
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(deck.dealCard());
        }

        // Determine winner
        System.out.println("Your hand: " + player.getHand() + " (value: " + player.getHandValue() + ")");
        System.out.println("Dealer's hand: " + dealer.getHand() + " (value: " + dealer.getHandValue() + ")");
        if (dealer.getHandValue() > 21 || player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You win!");
        } else if (player.getHandValue() < dealer.getHandValue()) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }

    @Override
    public void declareWinner() {
        // This method is implemented in the play method above
    }

   
}

