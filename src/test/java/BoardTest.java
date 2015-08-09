import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by pdale on 8/7/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> locations;
    private ThreeInARow threeInARow;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        locations = asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        threeInARow = mock(ThreeInARow.class);
        board = new Board(printStream, locations, threeInARow);
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
    public void shouldDisplayOInLocationOneWhenLocationOneIsMarked() throws Exception {
        locations.set(0, "O");

        board.drawBoard();

        verify(printStream).println(
                        "O| | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | ");

    }

    @Test
    public void shouldDisplayASymbolInAllLocationsInCorrectPositionOnBoard() throws Exception {
        for (int i = 1; i <= 9; i++) {
            locations.set(i - 1, String.valueOf(i));
        }

        board.drawBoard();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    @Test
    public void shouldDisplayBoardWithBothPlayersPiecesAfterBothPlayersPlay() throws Exception {
        board.markLocation(1, "X");
        board.markLocation(2, "O");

        board.drawBoard();

        verify(printStream).println(
                        "X|O| \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | ");
    }

    @Test
    public void shouldNotAllowPlayerMoveToCellWhenCellIsAlreadyTaken() throws Exception {
        locations.set(0, "X");

        assertFalse(board.markLocation(1, "X"));
    }

    @Test
    public void shouldAllowPlayerToMoveToCellWhenCellIsNotTaken() throws Exception {
        assertTrue(board.markLocation(1, "X"));
    }

    @Test
    public void shouldDisplayThatLocationIsAlreadyTakenWhenCellLocationToMoveIsTaken() throws Exception {
        locations.set(0, "X");

        board.markLocation(1, "X");

        verify(printStream).println("Location already taken.");
    }

    @Test
    public void shouldHaveOpenLocationsToMoveWhenTheBoardIsNotFull() throws Exception {
        assertTrue(board.hasOpenLocations());
    }

    @Test
    public void shouldNotHaveOpenLocationsToMoveWhenTheBoardIsFull() throws Exception {
        for (int i = 1; i <= 9; i++) {
            locations.set(i - 1, String.valueOf(i));
        }

        assertFalse(board.hasOpenLocations());
    }

    @Test
    public void shouldDisplayThatGameIsADrawWhenTheBoardIsFull() throws Exception {
        for (int i = 1; i <= 9; i++) {
            locations.set(i - 1, String.valueOf(i));
        }

        board.hasOpenLocations();

        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldCheckAnyThreeInARowWhenCheckingForThreeInARow() throws Exception {
        board.checkThreeInARow();

        verify(threeInARow).anyThreeInARow();
    }
}