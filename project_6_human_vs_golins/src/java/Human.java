public class Human extends creatures {
    String creatureType;
    int strength;
    int defence;
    int health;
    int x;
    int y;

    public Human(String creatureType, int strength, int defence, int health, int x, int y) {
        super(creatureType, strength, defence, health, x, y);
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
