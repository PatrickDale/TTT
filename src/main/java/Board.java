import java.io.PrintStream;

/**
 * Created by pdale on 8/7/15.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawBoard() {
        printStream.print(" | | \n-----\n | | \n-----\n | | \n");
    }
}
