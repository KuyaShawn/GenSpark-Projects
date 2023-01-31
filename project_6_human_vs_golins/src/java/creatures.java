public class creatures {
    String creatureType;
    int strength;
    int defence;
    int health;
    int x;
    int y;

    public creatures(String creatureType, int strength, int defence, int health, int x, int y) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.defence = defence;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void isHit(int damage) {
        health = health - damage;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nDefence: " + getDefence() +
                "\nX-Position: " + getX() +
                "\nY-Position: " + getY();
    }
}
