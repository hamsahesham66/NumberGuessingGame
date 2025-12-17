import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random = new Random();
        String round=" ";
        while (!round.equals("n")) {
            System.out.print("""
                    Welcome to the Number Guessing Game!
                    I'm thinking of a number between 1 and 100.
                    You have chances to guess the correct number.
                    
                    Please select the difficulty level:
                    1. Easy (10 chances)
                    2. Medium (5 chances)
                    3. Hard (3 chances)
                    Enter your choice: """);
            int choice = scanner.nextInt();
            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("You have enter wrong number please choose again the right number from list");
                System.out.print("Enter your choice:");
                choice = scanner.nextInt();
            }
            int maxAttempts;
            if (choice == 1) {
                System.out.println("Great! You have selected the Easy difficulty level.");
                maxAttempts = 10;
            } else if (choice == 2) {
                System.out.println("Great! You have selected the Medium difficulty level.");
                maxAttempts = 5;
            } else {
                System.out.println("Great! You have selected the Hard difficulty level.");
                maxAttempts = 3;
            }


            System.out.println("Let's start the game!");
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            int num = random.nextInt(1, 100);
            System.out.println(num);
            int cnt = 1;
            long startTime = System.nanoTime();

            while (guess != num) {
                if (guess > num) {
                    System.out.println("Incorrect! The number is less than " + guess);
                } else {
                    System.out.println("Incorrect! The number is greater than " + guess);
                }
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();

                cnt++;
                if (cnt > maxAttempts) {
                    System.out.println("you ran out of choices");
                    break;
                }
            }
            long endTime = System.nanoTime();

            if (guess == num) {
                System.out.println("Congratulations! You guessed the correct number in " + cnt + " attempts.");
            }
            printTimeTaken(startTime, endTime);
            System.out.println("Want to play again ? Y for yes N for no : ");

            round = scanner.next().toLowerCase();
        }
    }
    public static void printTimeTaken(long startTime, long endTime) {
        long elapsedNano = endTime - startTime;

        long totalSeconds = elapsedNano / 1_000_000_000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        System.out.println("Time taken: " + minutes + " min " + seconds + " sec");
    }
}
