import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;

class dragon_caveTest {

    dragon_cave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new dragon_cave();
    }

    @Test
    void introDialog() {
        String expectedIntroDialog = "You are in a land full of dragons. In front of you," + '\n' +
                "you see two caves. In one cave, the dragon is friendly" + '\n' +
                "and will share his treasure with you. The other dragon" + '\n' +
                "is greedy and hungry and will eat you on sight." + '\n' +
                "which cave will you go into? (1 or 2)";
        assertEquals(expectedIntroDialog, dragonCave.introDialog(),"Error on introDialog method in the return msg");
    }

    @Test
    void getCaveChoice1() {
        String expectedChoice1 = "You approach the cave..." + '\n' +
                "It is dark and spooky..." + '\n' +
                "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                "Gobbles you down in one bite!";
        assertEquals(expectedChoice1, dragonCave.getCaveChoice(1), "Error on getCaveChoice for cave choice 1");
    }

    @Test
    void getCaveChoice2() {
        String expectedChoice2 = "You approach the cave..." + '\n' +
                "It is dark and spooky..." + '\n' +
                "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                "Asks you to take his treasure!";
        assertEquals(expectedChoice2, dragonCave.getCaveChoice(2), "Error on getCaveChoice for cave choice 2");
    }

    @Test
    void getCaveChoice3() throws NumberFormatException {
        assertThrows(NumberFormatException.class, () -> dragonCave.getCaveChoice(10), "Check getCaveChoice method or Try catch for error" );
    }

    @AfterEach
    void tearDown() {
    }


}