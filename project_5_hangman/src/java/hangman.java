import java.util.*;

public class hangman {

    // Starting Dialog for the Hangman Game
    public static String startingDialog() {
        String startingDialog = "Welcome to the Hangman game, you will be given a number by a computer and all you " +
                "have to do is guess the word, good luck!";

        // returns the dialog for starting the game
        return startingDialog;
    }

    // Player one is the computer who guesses the word for player two
    public static String getPlayerOne() {

        return null;
    }

    // creates a player for guessing the word given by the computer
    public static String getPlayerTwo() {
        // code for getting player name
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello please Input your name!");
        String playerTwoName = userInput.nextLine();

        if (playerTwoName.isEmpty()) {
            throw new IllegalArgumentException("Caught Exception: Invalid Name.");
        }
        if (!playerTwoName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Caught Exception: Invalid Name.");
        }

        // return Name
        return playerTwoName;
    }

    public void printHangingMan() {
        // code for printing off the hangman

    }

    public static ArrayList<String> missingLetters() {
        // code for missing letters

        // returns a string of arrays that the player is missing
        return null;
    }


    public static String inputGuess(char guessLetter, ArrayList<String> word) {

        if (word.contains(guessLetter)) {
            // Add stuff here
        }
        // returns a string if player guesses right or not
        return null;
    }

    public static boolean replayGame() {
        // code for replaying the game
        boolean playAgain = false;
        do {
            try {
                String replayChoice;
                Scanner userInput = new Scanner(System.in);
                // Asks the user for their input if they want to continue playing or not
                System.out.println("Do you want to play again? (yes or no)");
                replayChoice = userInput.nextLine();

                if (replayChoice.equalsIgnoreCase("yes")) {
                    playAgain = true;
                } else if (replayChoice.equalsIgnoreCase("no")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Caught Exception: Invalid Choice.");
            }
            // stop when playAgain is true or returned out of the loop
        } while (!playAgain);

        // return T or F if player wants to replay the game
        return playAgain;
    }

    public static void main(String[] args) {
        System.out.println(startingDialog());
        System.out.println(getPlayerTwo());

    }
}