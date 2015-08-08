import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by pdale on 8/7/15.
 */
public class PlayerTest {

    public static final String DEFAULT_PIECE = "X";
    public static final int DEFAULT_LOCATION = 1;
    private Player player;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);

        when(bufferedReader.readLine()).thenReturn("1");
        when(board.markLocation(DEFAULT_LOCATION, DEFAULT_PIECE)).thenReturn(true);

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
        when(board.markLocation(2, DEFAULT_PIECE)).thenReturn(true);
        player.makeAMove();

        verify(board).markLocation(2, DEFAULT_PIECE);
    }

    @Test
    public void shouldNotMarkLocationWhenLocationToMarkIsTaken() throws Exception {
        when(board.markLocation(DEFAULT_LOCATION, DEFAULT_PIECE)).thenReturn(false).thenReturn(true);

        player.makeAMove();

        verify(board, times(2)).markLocation(DEFAULT_LOCATION, DEFAULT_PIECE);
    }

    @Test
    public void shouldMarkLocationWhenLocationToMarkIsNotTaken() throws Exception {
        player.makeAMove();

        verify(board, times(1)).markLocation(DEFAULT_LOCATION, DEFAULT_PIECE);
    }

    //    @Test
//    public void shouldNotBeAbleToMarkLocationOnBoardWhenLocationIsAlreadyTakenOnBoard() throws Exception {
//        player.makeAMove();
//
//        assertFalse(board.markLocation(2, DEFAULT_PIECE));
//    }

    //
//    @Test
//    public void shouldCheckIfLocationToMarkOnBoardIsTakenWhenMarkingLocationOnBoard() throws Exception {
//        player.makeAMove();
//
//        verify(board).isLocationMarked(1);
//    }
//
//    @Test
//    public void shouldFindANewLocationToMarkWhenLocationToMarkIsTaken() throws Exception {
//        when(board.isLocationMarked(1)).thenReturn(true);
//    }
}