import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

class HvGTest {
    Creature creature;
    Human human;
    Goblin goblin;

    @BeforeEach
    void setUp() {
        creature = new Creature("test", 0, 0, 0, 0);
        human = new Human("human", 0, 0, 0, 0);
        goblin = new Goblin("goblin", 0, 0, 0, 0);
    }

    @Test
    void getLuck() {
        int expected = 10;
        creature.setLuck(10);
        assertEquals(expected, creature.getLuck());
    }

    @Test
    void getCreatureType() {
        String expected = "test";
        creature.setCreatureType("test");
        assertEquals(expected, creature.getCreatureType());
    }

    @Test
    void getStrength() {
        int expected = 3;
        creature.setStrength(3);
        assertEquals(expected, creature.getStrength());
    }

    @Test
    void getDefence() {
        int expected = 1;
        creature.setDefence(1);
        assertEquals(expected, creature.getDefence());
    }

    @Test
    void getHealth() {
        int expected = 530;
        creature.setHealth(530);
        assertEquals(expected, creature.getHealth());
    }

    @Test
    void humanLuck() {
        int expected = 54673;
        human.setLuck(54673);
        assertEquals(expected, human.getLuck());
    }

    @Test
    void humanCreatureType() {
        String expected = "human";
        human.setCreatureType("human");
        assertEquals(expected, human.getCreatureType());
    }

    @Test
    void humanStrength() {
        int expected = 62465;
        human.setStrength(62465);
        assertEquals(expected, human.getStrength());
    }


    @Test
    void humanDefence() {
        int expected = 23423409;
        human.setDefence(23423409);
        assertEquals(expected, human.getDefence());
    }

    @Test
    void humanHealth() {
        int expected = 90312857;
        human.setHealth(90312857);
        assertEquals(expected, human.getHealth());
    }

    @Test
    void goblinLuck() {
        int expected = 6712376;
        goblin.setLuck(6712376);
        assertEquals(expected, goblin.getLuck());
    }

    @Test
    void goblinCreatureType() {
        String expected = "goblin";
        goblin.setCreatureType("goblin");
        assertEquals(expected, goblin.getCreatureType());
    }

    @Test
    void goblinStrength() {
        int expected = 111119821;
        goblin.setStrength(111119821);
        assertEquals(expected, goblin.getStrength());
    }


    @Test
    void goblinDefence() {
        int expected = 77754745;
        goblin.setDefence(77754745);
        assertEquals(expected, goblin.getDefence());
    }

    @Test
    void goblinHealth() {
        int expected = 3248237;
        goblin.setHealth(3248237);
        assertEquals(expected, goblin.getHealth());
    }

    @AfterEach
    void tearDown() {
    }
}