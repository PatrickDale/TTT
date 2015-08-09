/**
 * Created by pdale on 8/7/15.
 */
public class Game {
    private Board board;
    private Player player;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player, Player player2) {
        this.board = board;
        this.player = player;
        this.player2 = player2;
    }

    public void start() {
        board.drawBoard();
        currentPlayer = player;

        while (board.hasOpenLocations()) {
            takeTurn();
            alternateCurrentPlayer();
        }
    }

    private void alternateCurrentPlayer() {
        if (currentPlayer == player) {
            currentPlayer = player2;
        } else {
            currentPlayer = player;
        }
    }

    private void takeTurn() {
        currentPlayer.makeAMove();
        board.drawBoard();
    }
}