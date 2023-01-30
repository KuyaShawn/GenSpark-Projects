public class Goblin extends creatures {
    String creatureType;
    int strength;
    int defence;
    int health;
    int x;
    int y;

    public Goblin(String creatureType, int strength, int defence, int health, int x, int y) {
        super(creatureType, strength, defence, health, x, y);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void attack(Human human){

    }

    @Override
    public String toString() {
        return "Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nX-Position: " + getX() +
                "\nY-Position: " + getY();
    }
}
