package com.example.project_8_human_vs_goblins_gui;

public class Goblin extends Creature {
    String creatureType;
    int strength;
    int defence;
    int health;
    int luck;


    public Goblin(String creatureType, int strength, int defence, int health, int luck) {
        super(creatureType, strength, defence, health, luck);
    }

    @Override
    public String toString() {
        return "com.example.project_8_human_vs_goblins_gui.Creature: " + getCreatureType() +
                "\nHealth: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nDefence: " + getDefence() +
                "\nLuck: " + getLuck() + "\n";
    }
}
