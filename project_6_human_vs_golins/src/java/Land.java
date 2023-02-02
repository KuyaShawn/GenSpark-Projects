
import java.util.Scanner;

public class Land {
    public static Scanner sc = new Scanner(System.in);
    public static int rows = 20;
    public static int columns = 20;
    private static int[][] gameBoard;

    // UTF character for human & Goblin
    private String humanUTF = "\\uD83E\\uDDCD";
    private String goblinUTF = "\\uD83D\\uDC79";

    // Generates a board for the game
    public void createGameBoard() {
        StringBuilder line = new StringBuilder();
        // try-catch block for handling any excpetions
        try {
            // iterate through a nested loop by going through each element of the gameBoard Array
            // then fills each element with the appropriate value (UTF or symbol)
            for (int y = 0; y < columns; y++) {
                line.append("|");
                for (int x = 0; x < rows; x++) {
                    if (gameBoard[x][y] == 0) {
                        line.append("|   |");
                    } else if (gameBoard[x][y] == 2) {
                        line.append("| ").append(goblinUTF).append(" |");
                    } else if (gameBoard[x][y] == 3) {
                        line.append("| X |");
                    } else {
                        line.append("| ").append(humanUTF).append(" |");
                    }
                }
                line.append("|");
                System.out.println(line);
            }
            // creates a space between each of the game boards.
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Cannot create game Board.");
        }
    }

    // set position for the player
    public void setPostion(int x, int y){
        try {
            gameBoard[x][y] = 1;
        }catch (Exception e){
            System.out.println("Cannot set player position.");
        }
    }

    // set death position for the creature
    public void setDeath(int x,int y){
        try {
            gameBoard[x][y] = 2;
        }catch (Exception e){
            System.out.println("Cannot set death to creature.");
        }
    }

    // set position for where the combat initiated
    public void combatInitiated(int x, int y){
        try {
            gameBoard[x][y] = 3;
        }catch (Exception e){
            System.out.println("Cannot initiate combat.");
        }
    }

    public Land(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.gameBoard = new int[rows][columns];
    }

    @Override
    public String toString() {
        return "The Starting Board";
    }
}
