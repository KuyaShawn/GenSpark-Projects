import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class hangman_functionalTest {

    hangman_functional hangmanGame;

    @BeforeEach
    public void setUp() throws Exception {
        hangmanGame = new hangman_functional();
    }


    @Test
    public void startingDialog() {
        String expected = "Welcome to the Hangman game, you will be given a word by a computer and all you " +
                "have to do is guess the word, good luck!\n" + "H A N G M A N\n";
        assertEquals(expected, hangmanGame.startingDialog());
    }

    @Test
    public void generateWord() {
        assertTrue(!hangmanGame.generateWord().isEmpty());
    }

    @Test
    void getPlayerTwo() {
    }

    @Test
    public void printHangingManStageOne() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        hangman_functional.printHangingMan(1);
        String expected = "   +----+\n" +
                "   0    |\n" +
                "        |\n" +
                "        |\n" +
                " =========\n";
        assertEquals(expected.replaceAll("[\\r\\n]", ""), outContent.toString().replaceAll("[\\r\\n]", ""));
    }

    @Test
    public void printHangingManStageEight() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        hangman_functional.printHangingMan(8);
        String expected = "   +----+\n" +
                "   0    |\n" +
                "  /|\\   |\n" +
                "   |    |\n" +
                "   |    |\n" +
                "  / \\   |\n" +
                " =========\n";
        assertEquals(expected.replaceAll("[\\r\\n]", ""), outContent.toString().replaceAll("[\\r\\n]", ""));
    }

    @Test
    public void replayGameYes() {
        String input = "yes";
        InputStream testcase = new ByteArrayInputStream(input.getBytes());
        System.setIn(testcase);
        assertTrue(hangmanGame.replayGame());
    }

    @Test
    public void replayGameNo() {
        String input = "no";
        InputStream testcase = new ByteArrayInputStream(input.getBytes());
        System.setIn(testcase);
        assertFalse(hangmanGame.replayGame());
    }
    @Test
    void startGame() {
    }

    @Test
    void printMissedLetters() {
    }

    @Test
    void printCurrentState() {
    }

    @Test
    void hasLetterBeenGuessed() {
    }

    @Test
    void isLetterInWord() {
    }

    @Test
    void isWordGuessed() {
    }

    @Test
    void addScore() {
    }

    @Test
    void subtractScore() {
    }

    @Test
    void resetScore() {
    }

    @AfterEach
    void tearDown() {
    }
}