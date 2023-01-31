import java.util.Scanner;

public class land {
    static int rows = 20;
    static int columns = 20;
    static Object[][] gameBoard = new Object[rows][columns];

    public void createGameBoard(Human human, Goblin goblin) {
        gameBoard[human.x][human.y] = human;
        gameBoard[goblin.x][goblin.y] = goblin;

        // Implementing the turn-based movement using the keyboard keys "n", "s", "e", and "w".
        while (true) {
            displayGrid();
            String input = String.valueOf(getInput());
            int dx = 0, dy = 0;
            switch (input) {
                case "n":
                    dy = -1;
                    break;
                case "w":
                    dx = -1;
                    break;
                case "s":
                    dy = 1;
                    break;
                case "e":
                    dx = 1;
                    break;
            }
            human.move(dx, dy);
            gameBoard[human.x][human.y] = human;
            goblin.move(dx, dy);
            gameBoard[goblin.x][goblin.y] = goblin;
            if (human.x == goblin.x && human.y == goblin.y) {
                goblin.attack(human);
                if (human.health <= 0) {
                    System.out.println("You lost the game");
                    break;
                }
            }
        }
    }


    static void displayGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Object object = gameBoard[i][j];
                if (object == null) {
                    System.out.print(".");
                } else {
                    System.out.print(object.toString());
                }
            }
            System.out.println();
        }
    }

    public static char getInput() {
        // Read the keyboard input for movement
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your move (n, s, e, w): ");
        String input = scan.nextLine();
        char move = input.charAt(0);
        return move;
    }

    @Override
    public String toString() {
        return "The Starting Board";
    }
}
