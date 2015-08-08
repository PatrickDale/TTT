/**
 * Created by pdale on 8/7/15.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.drawBoard();
    }
}