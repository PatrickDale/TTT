import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/7/15.
 */
public class GameTest {

    private Board board;
    private Game game;
    private Player player;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player, player2);
    }

    @Test
    public void shouldDrawBoardThreeTimesWhenGameStartsAndBothPlayersMove() throws Exception {
        game.start();

        verify(board, times(3)).drawBoard();
    }

    @Test
    public void shouldHavePlayerMoveWhenGameStarts() throws Exception {
        game.start();

        verify(player).makeAMove();
    }

    @Test
    public void shouldHavePlayer2MoveWhenGameStarts() throws Exception {
        game.start();

        verify(player2).makeAMove();

    }
}