import java.util.Scanner;

public class dragon_cave {
    public static void main(String[] args) {
        // Prints dialog into console
        System.out.println(introDialog());

        try {
            System.out.println(getCaveChoice());
        } catch (NumberFormatException e) {
            System.out.println("Invalid cave choice");
        }
    }

    public static String introDialog() {
        return "You are in a land full of dragons. In front of you," + '\n' +
                "you see two caves. In one cave, the dragon is friendly" + '\n' +
                "and will share his treasure with you. The other dragon" + '\n' +
                "is greedy and hungry and will eat you on sight." + '\n' +
                "which cave will you go into? (1 or 2)";
    }

    public static String getCaveChoice() {
        Scanner userInput = new Scanner(System.in);
        // reads user's input
        int caveChoice = userInput.nextInt();

        // user input's choice code.
        if (caveChoice == 1) {
            return "You approach the cave..." + '\n' +
                    "It is dark and spooky..." + '\n' +
                    "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                    "Gobbles you down in one bite!";
        } else if (caveChoice == 2) {
            return "You approach the cave..." + '\n' +
                    "It is dark and spooky..." + '\n' +
                    "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                    "Asks you to take his treasure!";
        } else {
            throw new NumberFormatException();
        }
    }
}