import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RockPaperScissors {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final String TIE_MESSAGE = "It's a tie!";
    private static final String WINNING_MESSAGES[][] = {
        {"rock", "scissors", "Rock crushes scissors, you win!"},
        {"rock", "paper", "Paper covers rock, you lose!"},
        {"paper", "rock", "Paper covers rock, you win!"},
        {"paper", "scissors", "Scissors cuts paper, you lose!"},
        {"scissors", "paper", "Scissors cuts paper, you win!"},
        {"scissors", "rock", "Rock crushes scissors, you lose!"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to Rock-Paper-Scissors!");
            System.out.println("Enter your choice (rock, paper, or scissors):");

            String userChoice = getUserChoice(scanner);
            String computerChoice = getComputerChoice(random);

            System.out.println("\nYou chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println("\nResult: " + result);

            playAgain = askToPlayAgain(scanner);
        }

        scanner.close();
    }

    private static String getUserChoice(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim().toLowerCase();
                if (isValidChoice(input)) {
                    return input;
                } else {
                    System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static boolean isValidChoice(String input) {
        for (String choice : CHOICES) {
            if (input.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    private static String getComputerChoice(Random random) {
        return CHOICES[random.nextInt(CHOICES.length)];
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return TIE_MESSAGE;
        }

        for (String[] winningMessage : WINNING_MESSAGES) {
            if (winningMessage[0].equals(userChoice) && winningMessage[1].equals(computerChoice)) {
                return winningMessage[2];
            }
        }

        return "Invalid user choice";
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to play again? (yes/no)");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter yes or no.");
            }
        }
    }
}