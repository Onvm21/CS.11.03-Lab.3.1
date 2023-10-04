// this is a game in which i used chat gpt to give me a rough framework -->
// the other text based game is where i expanded on all of this stuff and used other concepts to make it better.

import java.util.Scanner;
import java.util.Random;

public class TreasureHuntGame {
    // Global variables
    static int playerHealth = 100;
    static int playerGold = 0;
    static String playerName = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Treasure Hunt Game!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();

        System.out.println("\n" + playerName + ", your journey begins in a dense, dark forest...");
        System.out.println("You have 100 health points and no gold.");

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Explore deeper into the forest.");
            System.out.println("2. Rest to regain health.");
            System.out.println("3. Search for treasure.");
            System.out.println("4. Quit the game.");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: exploreForest();
                break;
                case 2: rest();
                break;
                case 3: searchForTreasure();
                break;
                case 4: gameOver = true;
                break;
                default: System.out.println("Invalid choice. Try again.");
                break;
            }

            if (playerHealth <= 0) {
                gameOver = true;
                System.out.println("\n" + playerName + ", you have run out of health. Game Over!");
            }
        }

        System.out.println("\nThank you for playing, " + playerName + "!");
        System.out.println("You collected " + playerGold + " gold during your adventure.");
        scanner.close();
    }

    // Explore deeper into the forest
    static void exploreForest() {
        int randomEvent = (int) (Math.random() * 5); // Random event (0 to 4)

        if (randomEvent == 0) {
            System.out.println("You encountered a friendly forest creature.");
            playerHealth += 10;
            System.out.println("Your health increased by 10.");
        } else if (randomEvent == 1) {
            System.out.println("You stumbled upon a dangerous trap!");
            playerHealth -= 20;
            System.out.println("Your health decreased by 20.");
        } else {
            System.out.println("You ventured deeper into the forest but found nothing.");
        }
    }

    // Rest to regain health
    static void rest() {
        int healingAmount = 25;
        playerHealth += healingAmount;
        System.out.println("You rested and regained " + healingAmount + " health points.");
    }

    // Search for treasure
    static void searchForTreasure() {
        Random goldnum = new Random();
        int treasure = goldnum.nextInt(50) + 1; // Random amount of gold (0 to 99)
        int chance = goldnum.nextInt(1) + 0;
        playerGold += treasure;
        System.out.println("You found " + treasure + " gold!");
    }
}
