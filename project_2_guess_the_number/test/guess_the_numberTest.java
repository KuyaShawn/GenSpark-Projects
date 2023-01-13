import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class guess_the_numberTest {

    guess_the_number guessTheNumber;
    @BeforeEach
    void setUp() {
        guessTheNumber = new guess_the_number();
        guessTheNumber.setName("Test Name");
    }

    @Test
    void introDialogue() {
        String expectedIntroDialogue = "Well, " + guessTheNumber.getName() + ", I am thinking of a number between 1 and 20." + '\n' +
                "take a guess.";
        assertEquals(expectedIntroDialogue, guessTheNumber.introDialogue(), "Intro message error");
    }

    @Test
    void replayGameTrue() {
        String trueInput = "y";
        InputStream testCase1 = new ByteArrayInputStream(trueInput.getBytes());
        System.setIn(testCase1);
        assertTrue(guessTheNumber.replayGame());
    }

    @Test
    void replayGameFalse() {
        String trueInput = "n";
        InputStream testCase1 = new ByteArrayInputStream(trueInput.getBytes());
        System.setIn(testCase1);
        assertFalse(guessTheNumber.replayGame());
    }

    @Test
    void checkResponseTooHigh() {
        String expected = "Your Guess is too high." + '\n'
                + "Take a guess.";
        assertEquals(expected,guessTheNumber.checkResponse(15,7), "High guess response error");
    }

    @Test
    void checkResponseTooLow() {
        String expected = "Your Guess is too low." + '\n'
                + "Take a guess.";
        assertEquals(expected,guessTheNumber.checkResponse(4,7),"low guess response error");
    }

    @AfterEach
    void tearDown() {
    }
}