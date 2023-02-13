import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class hangman_functional {
    // keeps track of player score.
    private static int score = 0;
    private static String name = "";

    // Starting Dialog for the Hangman Game
    public static String startingDialog() {
        try {
            return "Welcome to the Hangman game, you will be given a word by a computer and all you " +
                    "have to do is guess the word, good luck!\n" + "H A N G M A N\n";
        } catch (IllegalArgumentException e) {
            return "Failed to display Starting Message.";
        }
    }

    // Player one is the computer who guesses the word for player two
    public static String generateWord() {
        // Create a Random object to generate a random index
        Random random = new Random();
        String fileName = "C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_7_hangman_functional/src/resources/wordlist.txt";
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

        // returns the random word given
        return words.get(randomIndex);
    }

    // creates a player for guessing the word given by the computer
    public void getPlayerTwo() {
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
            this.name = playerTwoName;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to retrieve user input");
        }
    }

    public static void printHangingMan(int hangmanStage) throws RuntimeException {
        try {
            File file = new File("C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_7_hangman_functional/src/java/stage" + hangmanStage);
            FileReader fr = new FileReader(file);
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                    resetScore();
                } else if (replayChoice.equalsIgnoreCase("no")) {
                    //printTopRankings(); THIS IS BROKEN FOR NOW
                    resetScore();
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
            printMissedLetters(guessedLetters, guessedLettersCount);

            // Print the current state of the word to guess
            printCurrentState(underscores);

            // Ask the user to guess the letter
            System.out.print("Guess a letter: ");
            // scanner makes sure that it only accepts the first letter
            char guessInput = input.next().charAt(0);

            // Check if the letter has been guessed
            if (hasLetterBeenGuessed(guessInput, guessedLetters, guessedLettersCount)) {
                System.out.println("You have already guessed that letter. Choose again.");
                continue;
            }

            // Add the letter to the guessed letter array
            guessedLetters[guessedLettersCount] = guessInput;
            guessedLettersCount++;

            //checks if the letter is present in the word, if not then increase the stage of the hangman drawing
            if (!isLetterInWord(guessInput, wordToGuess, underscores)) {
                hangmanStage++;
                subtractScore();
                System.out.println("Incorrect.\n");
            } else {
                addScore();
                System.out.println("Correct!\n");
            }
            if (isWordGuessed(underscores)) {
                break;
            }
        }

        if (isWordGuessed(underscores)) {
            System.out.println("Yes! The secret word is \"" + wordToGuess + "\" You have won!\n");
            saveScore();
        } else {
            // Print a message indicating that the user lost
            System.out.println("Sorry, The secret word was \"" + wordToGuess + "\".\n");
            saveScore();
        }
        replayGame = replayGame();
        return replayGame;
    }

    public static void printMissedLetters(char[] guessedLetters, int guessedLettersCount) {
        try {
            System.out.print("Missed letters: ");
            for (int i = 0; i < guessedLettersCount; i++) {
                System.out.print(guessedLetters[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Caught Exception: Cannot get retrieve guessed letter.");
        }
    }

    public static void printCurrentState(char[] underscores) {
        try {
            for (char underscore : underscores) {
                System.out.print(underscore + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to print current state");
        }

    }

    public static boolean hasLetterBeenGuessed(char guessInput, char[] guessedLetters, int guessedLettersCount) {
        try {
            boolean alreadyGuessed = false;
            for (int i = 0; i < guessedLettersCount; i++) {
                if (guessedLetters[i] == guessInput) {
                    alreadyGuessed = true;
                    break;
                }
            }
            return alreadyGuessed;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to check each letter");
        }
    }

    public static boolean isLetterInWord(char guessInput, String wordToGuess, char[] underscores) {
        try {
            boolean isCorrect = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessInput) {
                    underscores[i] = guessInput;
                    isCorrect = true;
                }
            }
            return isCorrect;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to retrieve information");
        }

    }

    // check if list still has underscores
    public static boolean isWordGuessed(char[] underscores) {
        try {
            for (char underscore : underscores) {
                if (underscore == '_') {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to check if word is guessed by user");
        }
    }

    public static void saveScore() {
        String line = String.format("%s:%s\n", name, score);
        List<String> scores;

        try {
            scores = Files.readAllLines(Paths.get("C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_7_hangman_functional/src/java/scores"));
        } catch (IOException err) {
            System.out.println("Caught Exception: Scores file not found");
            return;
        }

        boolean hasHigherScore = false;
        for (String scoreLine : scores) {
            String[] parts = scoreLine.split(":");
            if (parts[0].equals(name)) {
                int oldScore = Integer.parseInt(parts[1]);
                if (score > oldScore) {
                    hasHigherScore = true;
                    break;
                } else {
                    return;
                }
            }
        }

        try {
            if (hasHigherScore) {
                scores.removeIf(scoreLine -> scoreLine.startsWith(name + ":"));
            }
            scores.add(line);
            Files.write(Paths.get("C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_7_hangman_functional/src/java/scores"), scores, StandardCharsets.UTF_8);
        } catch (IOException err) {
            System.out.println("Error: Scores file not found");
        }
    }

    // METHOD IS BROKEN :(
    public static void printTopRankings() {
        List<String> scores;
        try {
            scores = Files.readAllLines(Paths.get("C:/Users/Big Daddy/Documents/GitHub/GenSpark-Projects/project_7_hangman_functional/src/java/scores"));
        } catch (IOException e) {
            System.out.println("Error: Scores file not found");
            return;
        }
        if (scores.size() < 3) {
            return;
        }
        HashMap<String, Integer> scoresMap = new HashMap<>();
        scores.sort((x, y) -> {
            int score1 = Integer.parseInt(y.split(":")[1]);
            int score2 = Integer.parseInt(x.split(":")[1]);
            return score1 - score2;
        });
        System.out.println("Rankings:");
        for (int i = 0; i < 3; i++) {
            String[] parts = scores.get(i).split(":");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            scoresMap.put(name, score);
            System.out.println((i + 1) + ". " + name + " - " + score);
        }
        if (scoresMap.containsKey(name)) {
            System.out.println("Your rank # is" + (scoresMap.get(name) + 1)
                    + ", with a score of " + scoresMap.get(name) + ".");
        }
    }

    public static void addScore() {
        score += 1;
    }

    public static void subtractScore() {
        score -= 1;
    }

    public static void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
