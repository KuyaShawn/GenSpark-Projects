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



    public String attack(Goblin goblin){
        int damage = (int) (Math.random() * strength);

        // if the Human doesn't have enough strength to attack the Goblin's large defence.
        // A critical chance is the only way for it to defeat it
        if (Math.random() < 0.3) {
            damage = damage * 10;
            System.out.println("Critical Hit!");
        }

        if (damage < goblin.defence) {
            return "Your attack did no damage";
        } else {
            goblin.isHit(damage);
            return "You attacked the " + goblin.getCreatureType() + " and damaged it for " + damage + "!";
        }
    }

    @Override
    public String toString() {
        return "Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nX-Position: " + getX() +
                "\nY-Position: " + getY()  + "\n";
    }
}
