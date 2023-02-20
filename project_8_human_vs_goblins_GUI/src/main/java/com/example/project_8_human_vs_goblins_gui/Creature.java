package com.example.project_8_human_vs_goblins_gui;

public class Creature {
    String creatureType;
    int strength;
    int defence;
    int health;
    int luck;
    int x;
    int y;

    public Creature(String creatureType, int strength, int defence, int health, int luck) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.defence = defence;
        this.health = health;
        this.luck = luck;
    }

    public void combat(Creature player) {
        System.out.println("Combat Initiated: " + getCreatureType() + " VS " + player.getCreatureType());

        while (player.getHealth() > 0 && getHealth() > 0) {
            int creatureAttack = calculateAttack(this, player);
            int playerAttack = calculateAttack(player, this);

            // Player
            player.setHealth(player.getHealth() - creatureAttack);
            System.out.println(getCreatureType() + " attacked " + player.getCreatureType() + " for " + creatureAttack + " dmg");

            if (player.getHealth() <= 0) {
                System.out.println(player.getCreatureType() + " has died, " + getCreatureType() + " has won");
                return;
            }

            // com.example.project_8_human_vs_goblins_gui.Creature
            setHealth(getHealth() - playerAttack);
            System.out.println(player.getCreatureType() + " attacked " + getCreatureType() + " for " + playerAttack + " dmg");

        }
    }

    // calculates the attack for the player
    private int calculateAttack(Creature attacker, Creature defender) {
        int baseAttack = 10 * (int) ((Math.random() * 6) + 1);
        int attackModifier = (attacker.getStrength() / defender.getDefence()) * attacker.getLuck();
        int totalAttack = baseAttack * attackModifier;

        // this is for handicap reason
        if (totalAttack <= 0) {
            totalAttack = (int) ((Math.random() * 12) + 2) * (10 * attacker.getLuck());
        }
        return totalAttack;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
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


    @Override
    public String toString() {
        return "com.example.project_8_human_vs_goblins_gui.Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nDefence: " + getDefence();
    }
}
