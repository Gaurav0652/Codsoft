import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundNumber = 1;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.println("\nRound " + roundNumber);
            int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int guess;

                // Validate user input
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You've guessed the number!");
                    totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + targetNumber + ".");
            }

            System.out.println("Your total score so far: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

            roundNumber++;
        } while (playAgain);

        System.out.println("Thanks for playing! Your final score is " + totalScore + ".");
        scanner.close();
    }
}

