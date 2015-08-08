import java.io.PrintStream;
import java.util.List;

/**
 * Created by pdale on 8/7/15.
 */
public class Board {
    private PrintStream printStream;
    private List<String> locations;

    public Board(PrintStream printStream, List<String> locations) {
        this.printStream = printStream;
        this.locations = locations;
    }

    public void drawBoard() {
        printStream.println(locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) +
                            "\n-----\n" +
                            locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) +
                            "\n-----\n" +
                            locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8));
    }

    public void markLocation(Integer location, String piece) {
        locations.set(location - 1, piece);
    }
}
