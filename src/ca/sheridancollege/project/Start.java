package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Get the name of the player
        String name = Prompter.askPlayerName();

        // Welcome the player
        System.out.println("Welcome to Blackjack, " + name + "!");
        System.out.println();

        // Create the player and the dealer
        MainPlayer player = new MainPlayer(name);
        Dealer dealer = new Dealer();

        // Create the game
        MainGame game = new MainGame(name, dealer, player);

        // Start the game
        String userAnswer = "yes";
        while (userAnswer.equals("yes")) {
            // Ask the player to bet
            Prompter.askPlayerBet(player);

            // Play the game
            game.play();

            // If the player has no chips, exit the game
            if (player.getChips() == 0) {
                break;
            }

            // Reset the game
            game.reset();
            
            // Ask if the player wants to play again
            userAnswer =Prompter.askPlayerToPLayAgain();
        }

        // Display the result
        Displayer.displayResult(player);

        // Exit the game
        System.out.println();
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
