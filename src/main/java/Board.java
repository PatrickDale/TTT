import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by pdale on 8/7/15.
 */
public class Board {
    private PrintStream printStream;
    private List<String> locations;
    private ThreeInARow threeInARow;

    public Board(PrintStream printStream, List<String> locations, ThreeInARow threeInARow) {
        this.printStream = printStream;
        this.locations = locations;
        this.threeInARow = threeInARow;
    }

    public void drawBoard() {
        printStream.println(locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) +
                "\n-----\n" +
                locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) +
                "\n-----\n" +
                locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8));
    }

    public Boolean markLocation(Integer location, String piece) {
        if (locations.get(location - 1).equals(" ")) {
            locations.set(location - 1, piece);
            return true;
        }
        printStream.println("Location already taken.");
        return false;
    }

    public Boolean hasOpenLocations() {
        for (String location : locations) {
            if (location.equals(" ")) {
                return true;
            }
        }
        printStream.println("Game is a draw");
        return false;
    }

    public Boolean checkThreeInARow() {
        if (threeInARow.anyThreeInARow()) {
            return true;
        }
        return false;
    }
}