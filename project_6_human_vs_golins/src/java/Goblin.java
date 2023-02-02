public class Goblin extends Creature {
    String creatureType;
    int strength;
    int defence;
    int health;
    int x;
    int y;

    public Goblin(String creatureType, int strength, int defence, int health, int luck, int x, int y) {
        super(creatureType, strength, defence, health, luck ,x, y);
    }

    @Override
    public String toString() {
        return "Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nX-Position: " + getX() +
                "\nY-Position: " + getY() + "\n";
    }
}
