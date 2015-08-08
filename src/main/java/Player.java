import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by pdale on 8/7/15.
 */
public class Player {
    private PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Board board;
    private String piece;

    public Player(PrintStream printStream, BufferedReader bufferedReader, Board board, String piece) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.piece = piece;
    }

    private Integer inputLocationToMark() {
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.valueOf(input);
    }

    public void makeAMove() {
        printStream.print("Enter a number between 1 and 9: ");
        Integer locationToMark = inputLocationToMark();
        board.markLocation(locationToMark, piece);
    }
}
