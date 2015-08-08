import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/7/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> locations;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        locations = asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        board = new Board(printStream, locations);
    }

    @Test
    public void shouldDisplayFormattedBoard() throws Exception {
        board.drawBoard();

        verify(printStream).println(
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | ");
    }

    @Test
    public void shouldUpdateLocationOneWhenLocationOneIsMarked() throws Exception {
        board.markLocation(1, "X");
        
        assertThat(locations.get(0), is("X"));
    }

    @Test
    public void shouldDisplayXInLocationOneWhenLocationOneIsMarked() throws Exception {
        locations.set(0, "X");

        board.drawBoard();

        verify(printStream).println(
                "X| | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | ");
    }

    @Test
    public void shouldDisplayASymbolInAllLocationsInCorrectPositionOnBoard() throws Exception {
        for (int i = 1; i <= 9; i++) {
            locations.set(i-1, String.valueOf(i));
        }

        board.drawBoard();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }
}