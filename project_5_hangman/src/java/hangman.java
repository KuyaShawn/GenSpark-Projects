import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hangman {
    // create an array of letters that have been guessed
    private static ArrayList<Character> guessedLetters;

    // Starting Dialog for the Hangman Game
    public static String startingDialog() {
        try {
            return "Welcome to the Hangman game, you will be given a word by a computer and all you " +
                    "have to do is guess the word, good luck!\n" + "H A N G M A N\n";
        }catch (Exception e){
            return "Failed to display Starting Message.";
        }
    }

    // Player one is the computer who guesses the word for player two
    public static String generateWord() {
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
            System.out.println("Caught Exception: File not found! Please check the path and try again.");
        }

        // Generate a random index between 0 and the number of words in the word list
        int randomIndex = random.nextInt(words.size());
        String randomWord = words.get(randomIndex);

        // returns the random word given
        return randomWord;
    }

    // creates a player for guessing the word given by the computer
    public static String getPlayerTwo() {
        try {
            // code for getting player name
            Scanner userInput = new Scanner(System.in);

            System.out.println("Please Input your name!");
            String playerTwoName = userInput.nextLine();

            if (playerTwoName.isEmpty()) {
                throw new IllegalArgumentException("Caught Exception: Invalid Name.");
            }
            if (!playerTwoName.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Caught Exception: Invalid Name.");
            }

            // return Name
            return playerTwoName;
        }catch (Exception e){
            return "Failed to retrieve user input";
        }
    }

    public static void printHangingMan(int hangmanStage) {
        // code for printing off the hangman
        switch (hangmanStage) {
            case 0:
                System.out.println(
                        "   +----+\n" +
                                "        |\n" +
                                "        |\n" +
                                "        |\n" +
                                " =========\n");
                break;
            case 1:
                System.out.println(
                                "   +----+\n" +
                                "   O    |\n" +
                                "        |\n" +
                                "        |\n" +
                                " =========\n");
                break;
            case 2:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "   |    |\n" +
                                "        |\n" +
                                " =========\n");
                break;
            case 3:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|    |\n" +
                                "        |\n" +
                                " =========\n");
                break;
            case 4:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|\\  |\n" +
                                "        |\n" +
                                " =========\n");
                break;
            case 5:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|\\  |\n" +
                                "   |    |\n" +
                                " =========\n");
                break;
            case 6:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|\\  |\n" +
                                "   |    |\n" +
                                "   |    |\n" +
                                " =========\n");
                break;
            case 7:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|\\  |\n" +
                                "   |    |\n" +
                                "   |    |\n" +
                                "  /     |\n" +
                                " =========\n");
                break;
            case 8:
                System.out.println(
                        "   +----+\n" +
                                "   O    |\n" +
                                "  /|\\  |\n" +
                                "   |    |\n" +
                                "   |    |\n" +
                                "  / \\  |\n" +
                                " =========\n");
                break;
            default:
                System.out.println("How did you end up with more than 8 chances?");
        }
    }

    public static ArrayList<Character> guessedList(char letter) {
        ArrayList<Character> guessedList = new ArrayList<>();
        guessedList.add(letter);
        setGuessedLetters(guessedList);
        return guessedList;
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

    public static boolean startGame() {
        int countWins = 0;
        boolean replayGame = false;
        Scanner input = new Scanner(System.in);
        // Randomly chooses a word from the word list.
        String wordToGuess = generateWord();

        // create an array of underscores the same length as the word to guess
        char[] underscores = new char[wordToGuess.length()];
        Arrays.fill(underscores, '_');

        // Create an array of letters that have been guessed
        char[] guessedLetters = new char[26];
        int guessedLettersCount = 0;

        // Set a variable to keep track of the stage of the hangman
        int hangmanStage = 0;

        //Loop until the hangman is fully printed
        while (hangmanStage < 8) {
            // print the hangman
            printHangingMan(hangmanStage);

            // prints the Missed letters
            System.out.print("Missed letters: ");
            for (int i = 0; i < guessedLettersCount; i++) {
                System.out.print(guessedLetters[i] + " ");
            }
            System.out.println();

            // Print the current state of the word to guess
            for (int i = 0; i < underscores.length; i++) {
                System.out.print(underscores[i] + " ");
            }
            System.out.println();

            // Ask the user to guess the letter
            System.out.print("Guess a letter: ");
            // scanner makes sure that it only accepts the first letter
            char guessInput = input.next().charAt(0);

            // Check if the letter has been guessed
            boolean alreadyGuessed = false;
            for (int i = 0; i < guessedLettersCount; i++) {
                if (guessedLetters[i] == guessInput) {
                    alreadyGuessed = true;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println("You have already guessed that letter. Choose again.");
                continue;
            }

            // Add the letter to the guessed letter array
            guessedLetters[guessedLettersCount] = guessInput;
            guessedLettersCount++;

            //check if the letter is in the word to guess
            boolean isCorrect = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessInput) {
                    underscores[i] = guessInput;
                    isCorrect = true;
                }
            }

            // if the letter is not in the word, increase the stage of the hangman drawing
            if (!isCorrect) {
                hangmanStage++;
                System.out.println("Incorrect.");
            } else {
                System.out.println("Correct!");
            }
            if (isWordGuessed(underscores)) {
                break;
            }
        }
        if (isWordGuessed(underscores)) {
            System.out.println("Yes! The secret word is \"" + wordToGuess + "\" You have won!");
        } else {
            // Print the final state of the word to guess
            System.out.print("Word to guess: ");
            for (int i = 0; i < underscores.length; i++) {
                System.out.print(underscores[i] + " ");
            }
            System.out.println();

        }
        // Print a message indicating that the user lost
        System.out.println("Sorry, The secret word was \"" + wordToGuess + "\".");

        replayGame = replayGame();
        return replayGame;
    }

    // check if list still has underscores
    public static boolean isWordGuessed(char[] underscores) {
        for (int i = 0; i < underscores.length; i++) {
            if (underscores[i] == '_') {
                return false;
            }
        }
        return true;
    }


    public static ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public static void setGuessedLetters(ArrayList<Character> guessedLetters) {
        hangman.guessedLetters = guessedLetters;
    }

    public static void main(String[] args) {
        boolean playAgain = true;
        System.out.println(generateWord());
        System.out.println(startingDialog());
        //System.out.println("To start the game Enter your name.");
        while (playAgain) {
            playAgain = startGame();
        }


    }
}

/*
Methods to use for Project 7

1.
    public static ArrayList<Character> missedLetter(char guess) {
        String wordToGuess = getRandomWord();

        // Declare a list to store the missed letters
        ArrayList<Character> missedLetter = new ArrayList<>();

        ArrayList<Character> guessList = new ArrayList<>();

        // Iterate Through each letter in the word to guess
        for (char letter : wordToGuess.toCharArray()) {
            // Check if the letter is not present in the user's input
            guessList.add(letter);
        }

        if (!guessList.contains(guess)) {
            // if the guessed letter is not present, add it to the list of missing letters
            missedLetter.add(guess);
        }

        // returns a Character of arrays that the player is missing
        return missedLetter;
    }

2.
    public static String inputGuess(char guessLetter) {
        String wordToGuess = getRandomWord();
        char[] word = wordToGuess.toCharArray();
        boolean checkGuessed = alreadyGuessed(guessLetter);

        if (!checkGuessed) {
            for (int i = 0; i <= word.length - 1; i++) {
                if (word[i] == guessLetter) {
                    letterList(guessLetter);
                }
            }
        } else {
            System.out.println("You have Already guessed that letter. Choose Again.");
        }

        // returns a string if player guesses right or not
        return null;
    }

3.
    public static boolean alreadyGuessed(char guessLetter) {
        boolean alreadyGuessed = false;
        ArrayList<Character> guessedList = getGuessedLetters();
        for (int i = 0; i < guessedList.size(); i++) {
            if (guessedList.get(i) == guessLetter) {
                guessedList.add(guessLetter);
                alreadyGuessed = true;
            }
        }

        // returns a character if player guesses that letter already
        return alreadyGuessed;
    }

4.
    private static String randomWord;

    public static String getRandomWord() {
        return randomWord;
    }

    public static void setRandomWord(String randomWord) {
        hangman.randomWord = randomWord;
    }

5.

 */