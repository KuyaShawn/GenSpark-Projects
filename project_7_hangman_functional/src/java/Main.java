public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        hangman_functional game = new hangman_functional();

        System.out.println(game.startingDialog());
        System.out.println("To start the game Enter your name.");
        game.getPlayerTwo();
        while (playAgain) {
            playAgain = game.startGame();
        }
    }
}