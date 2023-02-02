import static java.lang.Math.*;

public class Human extends Creature {
    String creatureType;
    int strength;
    int defence;
    int health;
    int luck;
    int x;
    int y;

    public Human(String creatureType, int strength, int defence, int health, int luck ,int x, int y) {
        super(creatureType, strength, defence, health, luck ,x, y);
    }

    public void equipment(String equipment){
        switch(equipment.toLowerCase()){
            case "sword":
                strength += 5;
                break;
            case "shield":
                defence += 3;
                break;
            case "amulet":
                health += 4;
                luck += 4;
                break;
            case "ring":
                health += 2;
                luck += 2;
                break;
            case "armored chest":
                defence += 4;
                break;
            case "armored leg":
                defence += 4;
                break;
            case "armored shoe":
                defence += 1;
                break;
            case "armored helmet":
                defence += 3;
                break;
            case "armored gauntlet":
                defence += 1;
                strength += 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + equipment.toLowerCase());
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
