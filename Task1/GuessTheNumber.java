package Task1;
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            int Number = random.nextInt(100) ;
            int attempts = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I'm thinking of a number between 1 to 100.");

            while (true) {
                System.out.print("Take a guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < Number) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > Number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + Number + " in " + attempts
                            + " attempts.");
                    break;
                }
            }

            System.out.print("Do you want to play again? (Yes/No): ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("Yes")) {
                System.out.println("Thanks for playing... Goodbye!");
                break;
            }
        } 
        while (true);

        sc.close();
    }
}