import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class game{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        try{
        
            System.out.println("Welcome to the Number Guessing Game!\nI am thinking of a number between 1-100.\nYou have 5 chances to guess the number!\n\n");

            System.out.print("Please Select Difficulty level:\n 1. Easy (10 chances)\n 2. Medium (5 chances)\n 3. Hard (3 chances)\n:");
        
            int choice = scanner.nextInt();

            if (choice > 3 || choice < 1 || choice == 0) {
                System.out.println("Invalid Choice.");
                return;
            }

            if (choice == 1) {
                String difficulty = "Easy";
                System.out.printf("\nOh Great! You have chose the %s difficulty level!", difficulty);
            } else if (choice == 2) {
                String difficulty = "Medium";
                System.out.printf("\nOh Great! You have chose the %s difficulty level!", difficulty);
            } else if (choice == 3) {
                String difficulty = "Hard";
                System.out.printf("\nOh Great! You have chose the %s difficulty level!", difficulty);
            }
            int randomNumber = random.nextInt(100);            
            System.out.println("\nLet's start the game!");
            //Syntax: (condition) ? TRUE : FALSE
            int numberOfTotalGuesses = (choice == 1) ? 10 :
                                       (choice == 2) ? 5  :
                                       (choice == 3) ? 3 : null;
            while (!(numberOfTotalGuesses == 0)) {
                System.out.print("Guess a number: ");
                int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.printf("You guessed the number in %d guesses!", numberOfTotalGuesses);
                break;
            } else if (guess < randomNumber) {
                System.out.println("Incorrect! The number is more than " + guess);
            } else if (guess > randomNumber) {
                System.out.println("Incorrect! The number is less than " + guess);
            } else {
                numberOfTotalGuesses--;
                
                if (numberOfTotalGuesses == 0) {
                    System.out.printf("Aw Dang It! You Failed.\n The correct answer was %d", randomNumber);
                }
                
                continue;
            }
        }
        } catch (InputMismatchException e){
            System.out.println("Invalid Choice");
        } finally{
            scanner.close();
        }
    }
}
