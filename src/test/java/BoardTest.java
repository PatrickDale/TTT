import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/7/15.
 */
public class BoardTest {
    @Test
    public void shouldDisplayFormattedBoard() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.drawBoard();

        verify(printStream).print(  " | | \n" +
                                    "-----\n" +
                                    " | | \n" +
                                    "-----\n" +
                                    " | | \n");
    }
}