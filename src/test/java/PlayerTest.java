import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pdale on 8/7/15.
 */
public class PlayerTest {

    public static final String DEFAULT_PIECE = "X";
    private Player player;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1");
        board = mock(Board.class);
        player = new Player(printStream, bufferedReader, board, DEFAULT_PIECE);
    }

    @Test
    public void shouldPromptPlayerToEnterAMoveLocationWhenItIsTheirTurn() throws Exception {
        player.makeAMove();

        verify(printStream).print("Enter a number between 1 and 9: ");
    }

    @Test
    public void shouldMarkLocationOneOnBoardWhenPlayerEntersLocationOneToMark() throws Exception {
        player.makeAMove();

        verify(board).markLocation(1, DEFAULT_PIECE);
    }

    @Test
    public void shouldMarkLocationTwoOnBoardWhenPlayerEntersLocationTwoToMark() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2");
        Player player = new Player(printStream, bufferedReader, board, DEFAULT_PIECE);
        player.makeAMove();

        verify(board).markLocation(2, DEFAULT_PIECE);
    }
}