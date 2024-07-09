import java.util.Random;
import java.util.Scanner;

    public class NumberGuessingGame {
        public static void main(String[] args) {
            playGame();
        }

        public static void playGame() {
            // Set the range for the random number
            int min = 1;
            int max = 100;

            // Generate a random number within the range
            Random rand = new Random();
            int secretNumber = rand.nextInt(max - min + 1) + min;

            // Set the number of attempts
            int maxAttempts = 5;

            // Initialize the number of attempts made
            int attempts = 0;

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Game loop
            while (attempts < maxAttempts) {
                // Prompt the user to guess the number
                System.out.println("Guess a number between " + min + " and " + max + ":");
                int userGuess = scanner.nextInt();

                // Check if the user's guess is correct
                if (userGuess == secretNumber) {
                    System.out.println(" Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low. Try again!");
                } else {
                    System.out.println("Your guess is too high. Try again!");
                }

                // Increment the number of attempts
                attempts++;
            }

            // Check if the user ran out of attempts
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The correct answer was " + secretNumber + ".");
            }

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (y/n)");
            String response = scanner.next();

            if (response.equalsIgnoreCase("y")) {
                playGame();
            } else {
                System.out.println("Thanks for playing!");
            }
        }
    }

