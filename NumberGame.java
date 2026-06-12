import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too High!");
                } else {
                    guessedCorrectly = true;
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Attempts Used: " + attempts);
                    System.out.println("Round Score: " + roundScore);

                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}