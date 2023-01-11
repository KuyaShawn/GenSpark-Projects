import java.util.Scanner;
import java.util.Random;
public class guess_the_number {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();
        int guessCount = 0;
        String replayChoice;

        //Prints a dialogue into console
        System.out.println("Hello! What is your name?");

        // reads the user's name as the input
        String usersName = userInput.nextLine();

        /* loops if user's number doesn't match the computer's number
           otherwise it breaks off and continue.
         */
        do {
            int randNum = rand.nextInt(20) + 1;

            //Prints a dialogue into console
            System.out.println("Well, " + usersName + ", I am thinking of a number between 1 and 20." + '\n' +
                    "take a guess.");

            while (true) {
                // reads the user's inputted number
                int usersNumGuess = userInput.nextInt();
                //Checks if user's number is too high, low, or just right to continue the game
                if(usersNumGuess > randNum){
                    System.out.println("Your Guess is too high." + '\n'
                    + "Take a guess.");
                    guessCount++;
                } else if (usersNumGuess < randNum) {
                    System.out.println("Your Guess is too low." + '\n'
                    + "Take a guess.");
                    guessCount++;
                }else {
                    guessCount++;
                    System.out.println("Good job, " + usersName + "! You guessed my number in " + guessCount + " guesses!");
                    break;
                }
            }
            // Asks the user for their input if they want to continue playing or not
            System.out.println("Would you like to play again? (Y or N)");
            replayChoice = userInput.next();

            /* if they wish to continue, then inputting "y" will instantiate the game again.
             If "n" then the game will close
             */
        }while (replayChoice.equalsIgnoreCase("y"));

    }
}