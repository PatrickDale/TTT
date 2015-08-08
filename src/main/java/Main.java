import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by pdale on 8/7/15.
 */
public class Main {
    public static void main(String[] args) {
        List<String> locations = asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        Board board = new Board(System.out, locations);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game(board, new Player(System.out, bufferedReader, board, "X"), new Player(System.out, bufferedReader, board, "O"));
        game.start();
    }
}
