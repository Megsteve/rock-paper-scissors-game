import java.util.Random;

// Class for a player in the game (both computer and human)
class Player {
    private Move move;

    // Method to generate a random move for the computer player
    public void randomMove() {
        //Gets all possible moves
        Move[] moves = Move.values();
        //Creates random number generator
        Random random = new Random();
        // Chooses random move
        move = moves[random.nextInt(moves.length)];
    }

    // Method to set the human players move
    public void setMove(Move move) {
        this.move = move;
    }

    // Method to get the players current move
    public Move getMove() {
        return move;
    }
}
