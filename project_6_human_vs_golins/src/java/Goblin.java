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

    public String attack(Human human) {
        int damage = (int) (Math.random() * strength);

        // if the Goblin doesn't have enough strength to attack the Human's large defence.
        // A critical chance is the only way for it to defeat it
        if (Math.random() < 0.3) {
            damage = damage * 10;
            System.out.println("Critical Hit!");
        }

        if (damage < human.defence) {
            return "Your attack did no damage";
        } else {
            human.isHit(damage);
            return "You attacked the " + human.getCreatureType() + " and damaged it for " + damage + "!";
        }
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
