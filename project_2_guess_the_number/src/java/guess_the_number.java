import java.util.Scanner;
import java.util.Random;

public class guess_the_number {
    private static String usersName;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String usersName = "";

        try {
            //Prints a dialogue into console
            System.out.println("Hello! What is your name?");

            // reads the user's name as the input
            usersName = userInput.nextLine();
            setName(usersName);
            //Checks if user's input is empty or is invalid.

            if (usersName.isEmpty()) {
                throw new IllegalArgumentException("Caught Exception: Invalid Name.");
            }
            if (!usersName.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Caught Exception: Invalid Name.");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

            /* loops if user's number doesn't match the computer's number
           otherwise it breaks off and continue.
            */
        do {
            int randNum = randomNumGenerator();
            System.out.println(introDialogue());
            int guessCount = 0;
            while (true) {
                try {
                    String corretlyGuessed = "";
                    // reads the user's inputted number
                    int usersNumGuess = userInput.nextInt();
                    corretlyGuessed = checkResponse(usersNumGuess, randNum);
                    guessCount++;
                    //Checks if user's number is too high, low, or just right to continue the game
                    if (corretlyGuessed != "1") {
                        System.out.println(corretlyGuessed);
                    } else {
                        System.out.println("Good job, " + usersName + "! You guessed my number in " + guessCount + " guesses!");
                        break;
                    }
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Caught Exception: Invalid input.");
                }
            }
            /* if they wish to continue, then inputting "y" will instantiate the game again.
             If "n" then the game will close
             */
        } while (replayGame());

    }

    public static String introDialogue() {
        //Prints a dialogue into console
        return "Well, " + getName() + ", I am thinking of a number between 1 and 20." + '\n' +
                "take a guess.";
    }

    public static int randomNumGenerator() {
        Random rand = new Random();
        return rand.nextInt(20) + 1;
    }

    public static boolean replayGame() {
        boolean playAgain = false;
        do {
            try {
                String replayChoice;
                Scanner userInput = new Scanner(System.in);
                // Asks the user for their input if they want to continue playing or not
                System.out.println("Would you like to play again? (Y or N)");
                replayChoice = userInput.next();
                if (replayChoice.equalsIgnoreCase("y")) {
                    playAgain = true;
                } else if (replayChoice.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Caught Exception: Invalid Choice.");
            }
        } while (!playAgain);
        return playAgain;
    }

    public static String checkResponse(int usersNumGuess, int randNum) {
        if (usersNumGuess > randNum) {
            return "Your Guess is too high." + '\n'
                    + "Take a guess.";
        }
        if (usersNumGuess < randNum) {
            return "Your Guess is too low." + '\n'
                    + "Take a guess.";
        }
        return "1";
    }

    public static void setName(String playerName) {
        guess_the_number.usersName = playerName;
    }

    public static String getName() {
        return usersName;
    }

}