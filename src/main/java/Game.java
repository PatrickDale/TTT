/**
 * Created by pdale on 8/7/15.
 */
public class Game {
    private Board board;
    private Player player;
    private Player player2;

    public Game(Board board, Player player, Player player2) {
        this.board = board;
        this.player = player;
        this.player2 = player2;
    }

    public void start() {
        board.drawBoard();

        player.makeAMove();
        board.drawBoard();

        player2.makeAMove();
        board.drawBoard();
    }
}