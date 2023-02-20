package com.example.project_8_human_vs_goblins_gui;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);

        Human humanPlayer = new Human("\uD83E\uDDCD", 16, 14, 600, 8);
        Goblin goblinOpponent = new Goblin("\uD83D\uDC79", 13, 12, 800, 8);
        while (playAgain) {
            Land outerLand = new Land(6, 6);

            System.out.println(goblinOpponent);
            System.out.println(humanPlayer);

            int gob_x_pos = 5;
            int gob_y_pos = (int) (Math.random() * 5);
            int hum_x_pos = 0;
            int hum_y_pos = (int) (Math.random() * 5);

            System.out.println(goblinOpponent.getCreatureType() + " Starting Position\n x: " + (gob_x_pos + 1) + "\n y: " + (gob_y_pos + 1) + "\n");
            System.out.println(humanPlayer.getCreatureType() + " Starting Position\n x: " + (hum_x_pos + 1) + "\n y: " + (hum_y_pos + 1) + "\n");

            outerLand.setPostion(hum_x_pos, hum_y_pos);
            outerLand.setDeath(gob_x_pos, gob_y_pos);
            outerLand.createGameBoard();

            while ((!Objects.equals(gob_x_pos, hum_x_pos)) || (!Objects.equals(gob_y_pos, hum_y_pos))) {
                Land land = new Land(5, 5);
                Land combat = new Land(5, 5);

                System.out.println("Which direction will you take: North \"n\", East \"e\", South \"s\", or West \"w\"?");
                System.out.println("or will you press 'c' to start a fight if a goblin is nearby?");
                String movementInput = input.nextLine();

                // com.example.project_8_human_vs_goblins_gui.Goblin movement
                if (!Objects.equals(gob_x_pos, hum_x_pos)) {
                    if (gob_x_pos > hum_x_pos) {
                        gob_x_pos = gob_x_pos - 1;
                    } else {
                        gob_x_pos = gob_x_pos + 1;
                    }
                } else {
                    if (gob_y_pos > hum_y_pos) {
                        gob_y_pos = gob_y_pos - 1;
                    } else {
                        gob_y_pos = gob_y_pos + 1;
                    }
                }

                // Player Input movement
                if (Objects.equals(movementInput, "e") || Objects.equals(movementInput, "w")) {
                    if (movementInput.equalsIgnoreCase("e")) {
                        hum_x_pos = hum_x_pos + 1;
                    }
                    if (movementInput.equalsIgnoreCase("w")) {
                        hum_x_pos = hum_x_pos - 1;
                    }
                } else if (Objects.equals(movementInput, "n") || Objects.equals(movementInput, "s")) {
                    if (movementInput.equalsIgnoreCase("n")) {
                        hum_y_pos = hum_y_pos - 1;
                    }
                    if (movementInput.equalsIgnoreCase("s")) {
                        hum_y_pos = hum_y_pos + 1;
                    }
                } else if (movementInput.equalsIgnoreCase("c")) {
                    System.out.println("You initiating combat mode.");
                } else {
                    System.out.println("Invalid choice. You lost a turn");
                }

                System.out.println(goblinOpponent.getCreatureType() + " Position 'x': " + (gob_x_pos + 1) + " 'y': " + (gob_y_pos + 1) + ".");
                System.out.println(humanPlayer.getCreatureType() + " Position 'x': " + (hum_x_pos + 1) + " 'y': " + (hum_y_pos + 1) + ".");

                // re-creates board of new position
                if (!Objects.equals(hum_x_pos, gob_x_pos) || !Objects.equals(hum_y_pos, gob_y_pos)) {
                    land.setPostion(hum_x_pos, hum_y_pos);
                    land.setDeath(gob_x_pos, gob_y_pos);
                    land.createGameBoard();
                } else if (Objects.equals(hum_x_pos, gob_x_pos) && Objects.equals(hum_y_pos, gob_y_pos)) {
                    combat.combatInitiated(hum_x_pos, hum_y_pos);
                    combat.createGameBoard();
                }
            }
            humanPlayer.combat(goblinOpponent);

            // goblin death
            if (goblinOpponent.getHealth() <= 0) {
                System.out.println();
                System.out.println("You are Victorious!");
                break;
            }

            // human death
            if (humanPlayer.getHealth() <= 0) {
                System.out.println();
                System.out.println("Rest In Peace Warrior, you have lost.");
                break;
            }

        }
    }
}


/*
implement a re-playable method

    public static boolean replayGame() {
        // code for replaying the game
        boolean playAgain = false;
        do {
            try {
                String replayChoice;
                Scanner userInput = new Scanner(System.in);
                // Asks the user for their input if they want to continue playing or not
                System.out.println("Do you want to play again? (yes or no)");
                replayChoice = userInput.nextLine();

                if (replayChoice.equalsIgnoreCase("yes")) {
                    playAgain = true;
                } else if (replayChoice.equalsIgnoreCase("no")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Caught Exception: Invalid Choice.");
            }
            // stop when playAgain is true or returned out of the loop
        } while (!playAgain);

        // return T or F if player wants to replay the game
        return playAgain;
    }
 */