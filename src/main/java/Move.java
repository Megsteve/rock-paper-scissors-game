// Enum to represent the possible moves in the rock paper scissors game
enum Move {
    ROCK, PAPER, SCISSORS;

    // Method to compare the moves to each other
    // Returns 0 for a draw, 1 if this move wins, and -1 if this move loses
    public int compareMoves(Move nextMove) {
        // Checks if the moves are the same (it's a tie)
        if (this == nextMove) return 0;

        // Chooses winner based on the rules of the game
        return switch (this) {
            case ROCK ->
                // Rock beats Scissors, but loses to Paper
                    (nextMove == SCISSORS ? 1 : -1);
            case PAPER ->
                // Paper beats Rock, but loses to Scissors
                    (nextMove == ROCK ? 1 : -1);
            case SCISSORS ->
                // Scissors beat Paper, but loses to Rock
                    (nextMove == PAPER ? 1 : -1);
        };
    }
}
