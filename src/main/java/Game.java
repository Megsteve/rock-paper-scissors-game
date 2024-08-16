import java.util.Scanner;

// Class to manage the game logic and play rounds
class Game {
    // Human player
    private final Player humanPlayer;
    // Computer player
    private final Player computerPlayer;
    // Scanner for reading user input
    private final Scanner scanner;
    // Count of how many rounds the human has won
    private int humanWins;
    // Count of how many rounds the computer has won
    private int computerWins;

    // Constructor to initialize the game
    public Game() {
        humanPlayer = new Player();
        computerPlayer = new Player();
        scanner = new Scanner(System.in);
        humanWins = 0;
        computerWins = 0;
    }

    // Method to play best out of 5 against the computer
    public void bestOfThree() {
        System.out.println("Let's Play Best out of Five in Rock, Paper Scissors!");

        // Play rounds until one player wins three rounds
        while (humanWins < 3 && computerWins < 3) {
            // Play a single round
            playRound();
            // Displays the current score
            displayScore();
        }

        // Announce the overall winner of the series
        if (humanWins > computerWins) {
            System.out.println("Congratulations! You won best out of 5 in Rock Paper Scissors!");
        } else {
            System.out.println("The computer won best out of 5 in Rock, Paper, Scissors :(. Better luck next time!");
        }
    }

    // Method to play a single round of the game
    private void playRound() {
        // Get the human player's move
        Move humanMove = getHumanMove();
        humanPlayer.setMove(humanMove);

        // Generate a random move for the computer
        computerPlayer.randomMove();
        Move computerMove = computerPlayer.getMove();

        // Display both moves
        System.out.println("You played: " + humanMove);
        System.out.println("The Computer played: " + computerMove);

        // Compare the moves and determine the result of the round
        int result = humanMove.compareMoves(computerMove);
        switch (result) {
            case 0:
                // when players choose same item it equals a draw
                System.out.println("It's a draw!");
                break;
            case 1:
                // Human wins the round
                System.out.println(humanMove + " beats " + computerMove + ". You won this round!");
                humanWins++;
                break;
            case -1:
                // Computer wins the round
                System.out.println(computerMove + " beats " + humanMove + ". Computer wins this round!");
                computerWins++;
                break;
        }
    }

    // Method to display the current score after each round
    private void displayScore() {
        System.out.println("Score:");
        System.out.println("You: " + humanWins + " | Computer: " + computerWins);
    }

    // Method to get the human player's move
    private Move getHumanMove() {
        System.out.println("Rock, Paper or Scissors?: ");
        // Read input and converts humans response to uppercase
        String input = scanner.nextLine().toUpperCase();
        try {
            // Try's to match the input to one of the enum values
            return Move.valueOf(input);
        } catch (IllegalArgumentException e) {
            // If the input isn't valid, it will ask human to try again ensuring they input correct response to play the game
            System.out.println("Invalid move! It has to be Rock, Paper or Scissors. Please try again.");
            return getHumanMove();
        }
    }
}
