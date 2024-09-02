import java.util.Random;
import java.util.Scanner;
public class NumberGame
 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 3;
        int rounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Number Game!");

        for (int round = 1; round <= rounds; round++) 
        {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round + " of " + rounds + ":");
            System.out.println("Guess the number between : " + min + " and " + max + ":");

            while (attempts < maxAttempts && !guessedCorrectly)
             {
                System.out.print("Enter your Number: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) 
                {
                    System.out.println("Congratulations! You won The Game.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1) * 10;
                } else if (guess < randomNumber) 
                {
                    System.out.println("It is too low.");
                } else
                 {
                    System.out.println("It is too high.");
                }
            }

            if (!guessedCorrectly) 
            {
                System.out.println("You've Completed all attempts. The correct number was: " + randomNumber);
            }

            System.out.println("It is the score for this round:"+((guessedCorrectly)?(maxAttempts-attempts +1)*10:0));
            System.out.println();
        }

        System.out.println("Game is over! It is the total score is : " + totalScore);
        scanner.close();
    }
}
