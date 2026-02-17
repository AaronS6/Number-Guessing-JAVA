import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("words.txt"));
        Scanner chat = new Scanner(System.in);

        int score = 0;
        boolean playagain = true;
        System.out.println("Welcome to the Guess The Number Game!");
        System.out.println("What is your name: ");
        String name = chat.nextLine();

        while (playagain) {

            int tries = 0; // reset tries each round

            // pick a new random line every round
            double random = Math.random();
            String answer = "";

            if (random < 0.2) {
                answer = input.nextLine();

            } else if (random < 0.4) {
                for (int i = 0; i < 2; i++) {
                    answer = input.nextLine();
                }

            } else if (random < 0.6) {
                for (int i = 0; i < 3; i++) {
                    answer = input.nextLine();
                }

            } else if (random < 0.8) {
                for (int i = 0; i < 4; i++) {
                    answer = input.nextLine();
                }

            } else {
                for (int i = 0; i < 5; i++) {
                    answer = input.nextLine();
                }
            }



            int answerinint = Integer.parseInt(answer);
            int guess = 0;

            System.out.println("Welcome back " + name + "!");

            while (guess != answerinint) {
                System.out.print("Give me your guess: ");
                guess = chat.nextInt();
                tries++;

                if (guess > answerinint) {
                    System.out.println("The digit is smaller than " + guess + ".");
                } else if (guess < answerinint) {
                    System.out.println("The digit is bigger than " + guess + ".");
                }

                if (answerinint % 2 == 0) {
                    System.out.println("This number is even.");
                } else {
                    System.out.println("This number is odd.");
                }
            }

            System.out.println("Nice job " + name + "! You got the right answer! It was: " + answer);
            score++;
            System.out.println("You currently have: " + score + " points.");
            System.out.println("That took you: " + tries + " tries.");

            // clear leftover newline from nextInt()
            chat.nextLine();

            System.out.print("Would you like to play again? Yes or No: ");
            String playing = chat.nextLine();

            if (playing.equalsIgnoreCase("yes")) {
                playagain = true;
            } else {
                playagain = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}
