/**
 * Created by pdale on 8/7/15.
 */
public class Game {
    private Board board;
    private Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void start() {
        board.drawBoard();

        player.makeAMove();
        board.drawBoard();
    }
}