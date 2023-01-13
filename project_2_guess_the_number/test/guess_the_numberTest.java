import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class guess_the_numberTest {

    @BeforeEach
    void setUp() {
        guess_the_number.setName("Test Name");
    }

    @Test
    void introDialogue() {
        String expectedIntroDialogue = "Well, " + guess_the_number.getName() + ", I am thinking of a number between 1 and 20." + '\n' +
                "take a guess.";
        assertEquals(expectedIntroDialogue, guess_the_number.introDialogue(), "Intro message error");
    }

    @Test
    void replayGameTrue() {
        String trueInput = "y";
        InputStream testCase1 = new ByteArrayInputStream(trueInput.getBytes());
        System.setIn(testCase1);
        assertTrue(guess_the_number.replayGame());
    }

    @Test
    void replayGameFalse() {
        String trueInput = "n";
        InputStream testCase1 = new ByteArrayInputStream(trueInput.getBytes());
        System.setIn(testCase1);
        assertFalse(guess_the_number.replayGame());
    }

    @AfterEach
    void tearDown() {
    }
}