import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hangman {
    private static String randomWord;

    // Starting Dialog for the Hangman Game
    public static String startingDialog() {
        String startingDialog = "Welcome to the Hangman game, you will be given a word by a computer and all you " +
                "have to do is guess the word with, good luck! \n" +
                "\nH A N G M A N\n" +
                "   +---+\n" +
                "       |\n" +
                "       |\n" +
                "       |\n" +
                " ========\n";

        // returns the dialog for starting the game
        return startingDialog;
    }

    // Player one is the computer who guesses the word for player two
    public static String getPlayerOne() {
        // Create a Random object to generate a random index
        Random random = new Random();
        String fileName = "C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_5_hangman/src/resources/wordlist.txt";
        // Declares an empty List of strings called "words"
        List<String> words = new ArrayList<>();

        // Try to read from the file
        try {
            // Create a File object from the fileName
            File file = new File(fileName);
            // Create a Scanner object to read the file
            Scanner readFile = new Scanner(file);

            // While there is another line in the file, add it to the list of words
            while (readFile.hasNextLine()) {
                words.add(readFile.nextLine());
            }
            // close the Scanner for reading the file
            readFile.close();
        } catch (FileNotFoundException e) {
            // if the file is not found, print the stack traces of the exception
            System.out.println("Caught Exception: Invalid Choice.");
        }

        // Generate a random index between 0 and the number of words in the word list
        int randomIndex = random.nextInt(words.size());

        // returns the random word given
        return words.get(randomIndex);
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

    public void printHangingMan(int wrongGuesses) {
        // TODO: 1/24/2023 construct something that doesn't use if statement for printing the hangman
        String givenWord = getRandomWord();
        
        
        // code for printing off the hangman
        if (wrongGuesses > 0) {
            System.out.println(

                    "   +---+\n" +
                            "   O  |\n" +
                            "       |\n" +
                            "       |\n" +
                            " ========\n");
        }
        if (wrongGuesses > 1) {
            System.out.println(

                    "   +---+\n" +
                            "   O    |\n" +
                            "  /|\\  |\n" +
                            "      |\n" +
                            " ========\n");

        }
        if (wrongGuesses > 2) {
            System.out.println(
                    "   +---+\n" +
                            "   O    |\n" +
                            "  /|\\  |\n" +
                            "   |    |\n" +
                            " ========\n");
        }
        if (wrongGuesses > 3) {
            System.out.println(
                    "   +---+\n" +
                            "   O    |\n" +
                            "  /|\\  |\n" +
                            "   |    |\n" +
                            " ========\n");
        }
        if (wrongGuesses > 4) {
            System.out.println(
                    "   +---+\n" +
                            "   O    |\n" +
                            "  /|\\  |\n" +
                            "   |    |\n" +
                            "   |    |\n" +
                            " ========\n");
        }
        if (wrongGuesses > 5) {
            System.out.println(
                    "   +---+\n" +
                            "   O    |\n" +
                            "  /|\\  |\n" +
                            "   |    |\n" +
                            "   |    |\n" +
                            "  / \\    |\n" +
                            " ========\n");
        }

    }

    public static ArrayList<String> missingLetters(String guess, int wrongGuesses) {
        // Declare a list to store the missing letters
        ArrayList<String> missingLetter = new

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

    public static String getRandomWord() {
        return randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    public static void main(String[] args) {
        System.out.println(startingDialog());
        //System.out.println(getPlayerTwo());
        System.out.println(getPlayerOne());

    }
}