import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/9/15.
 */
public class ThreeInARowTest {

    private List<String> locations;
    private ThreeInARow threeInARow;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        locations = asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        printStream = mock(PrintStream.class);
        threeInARow = new ThreeInARow(locations, printStream);
    }

    @Test
    public void shouldReturnFalseWhenThereIsNotAHorizontalThreeInARow() throws Exception {
        assertFalse(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldReturnTrueWhenThereIsAHorizontalThreeInARow() throws Exception {
        locations.set(0, "X");
        locations.set(1, "X");
        locations.set(2, "X");

        assertTrue(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldReturnFalseWhenThereIsNotAVerticalThreeInARow() throws Exception {
        assertFalse(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldReturnTrueWhenThereIsAVerticalThreeInARow() throws Exception {
        locations.set(1, "O");
        locations.set(4, "O");
        locations.set(7, "O");

        assertTrue(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldReturnFalseWhenThereIsNotADiagonalThreeInARow() throws Exception {
        assertFalse(threeInARow.anyThreeInARow());

    }

    @Test
    public void shouldReturnTrueWhenThereIsAIncreasingDiagonalThreeInARow() throws Exception {
        locations.set(0, "O");
        locations.set(4, "O");
        locations.set(8, "O");

        assertTrue(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldReturnTrueWhenThereIsADecreasingDiagonalThreeInARow() throws Exception {
        locations.set(2, "X");
        locations.set(4, "X");
        locations.set(6, "X");

        assertTrue(threeInARow.anyThreeInARow());
    }

    @Test
    public void shouldDisplayPlayerXWinsWhenPlayerXWinsWithHorizontalThreeInARow() throws Exception {
        locations.set(0, "X");
        locations.set(1, "X");
        locations.set(2, "X");

        threeInARow.anyThreeInARow();

        verify(printStream).println("Player X Wins!");
    }

    @Test
    public void shouldDisplayPlayerTWinsWhenPlayerTWinsWithHorizontalThreeInARow() throws Exception {
        locations.set(0, "T");
        locations.set(1, "T");
        locations.set(2, "T");

        threeInARow.anyThreeInARow();

        verify(printStream).println("Player T Wins!");
    }

    @Test
    public void shouldDisplayPlayerOWinsWhenPlayerOWinsWithVerticalThreeInARow() throws Exception {
        locations.set(0, "O");
        locations.set(3, "O");
        locations.set(6, "O");

        threeInARow.anyThreeInARow();

        verify(printStream).println("Player O Wins!");
    }

    @Test
    public void shouldDisplayPlayerJWinsWhenPlayerJWinsWithDiagonalThreeInARow() throws Exception {
        locations.set(0, "J");
        locations.set(4, "J");
        locations.set(8, "J");

        threeInARow.anyThreeInARow();

        verify(printStream).println("Player J Wins!");

    }
}