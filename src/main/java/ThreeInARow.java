import java.io.PrintStream;
import java.util.List;

/**
 * Created by pdale on 8/9/15.
 */
public class ThreeInARow {
    private List<String> locations;
    private PrintStream printStream;

    public ThreeInARow(List<String> locations, PrintStream printStream) {
        this.locations = locations;
        this.printStream = printStream;
    }

    public boolean anyThreeInARow() {
        int row;
        for (int col = 0; col < 3; col++) {
            row = col * 3;
            if (isThreeHorizontalPiecesInARow(row) || isThreeVerticalPiecesInARow(col)) {
                return true;
            }
        }
        return diagonalThreeInARow();
    }

    private boolean isThreeHorizontalPiecesInARow(int row) {
        if (!locations.get(row).equals(" ") && locations.get(row).equals(locations.get(row + 1)) && locations.get(row).equals(locations.get(row + 2))) {
            displayPlayerWins(locations.get(row));
            return true;
        }
        return false;
    }

    private boolean isThreeVerticalPiecesInARow(int col) {
        if (!locations.get(col).equals(" ") && locations.get(col).equals(locations.get(col + 3)) && locations.get(col).equals(locations.get(col + 6))) {
            displayPlayerWins(locations.get(col));
            return true;
        }
        return false;
    }

    private void displayPlayerWins(String player) {
        printStream.println("Player " + player + " Wins!");
    }

    private boolean diagonalThreeInARow() {
        boolean increasingDiagonal = !locations.get(0).equals(" ") && locations.get(0).equals(locations.get(4)) && locations.get(0).equals(locations.get(8));
        boolean decreasingDiagonal = !locations.get(2).equals(" ") && locations.get(2).equals(locations.get(4)) && locations.get(2).equals(locations.get(6));
        if (increasingDiagonal || decreasingDiagonal) {
            displayPlayerWins(locations.get(4));
            return true;
        }
        return  false;
    }
}
