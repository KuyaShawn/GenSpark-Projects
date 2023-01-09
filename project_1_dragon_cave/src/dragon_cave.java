import java.util.Scanner;

public class dragon_cave {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Prints dialog into console
        System.out.println("You are in a land full of dragons. In front of you," + '\n' +
                            "you see two caves. In one cave, the dragon is friendly" + '\n' +
                            "and will share his treasure with you. The other dragon" + '\n' +
                            "is greedy and hungry and will eat you on sight." + '\n' +
                            "which cave will you go into? (1 or 2)");

        // reads user's input
        int caveChoice = userInput.nextInt();
        System.out.println();

        // user input's choice code.
        if(caveChoice == 1){
            System.out.println("You approach the cave..." + '\n' +
                                "It is dark and spooky..." + '\n' +
                                "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                                "Gobbles you down in one bite!");
        }else if(caveChoice == 2) {
            System.out.println("You approach the cave..." + '\n' +
                                "It is dark and spooky..." + '\n' +
                                "A large dragon jumps out in front of you! He opens his jaws and..." + '\n' +
                                "Asks you to take his treasure!");
        }else {
            System.out.println("Invalid cave choice");
        }
    }
}