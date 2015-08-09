import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

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
        when(board.hasOpenLocations()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(board, times(3)).drawBoard();
    }

    @Test
    public void shouldHavePlayerMoveWhenGameStarts() throws Exception {
        when(board.hasOpenLocations()).thenReturn(true).thenReturn(false);

        game.start();

        verify(player).makeAMove();
    }

    @Test
    public void shouldHavePlayer2MoveWhenGameStarts() throws Exception {
        when(board.hasOpenLocations()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(player2).makeAMove();
    }

    @Test
    public void shouldNotHavePlayerMoveWhenGameBoardIsFull() throws Exception {
        when(board.hasOpenLocations()).thenReturn(false);

        game.start();

        verifyZeroInteractions(player);
        verifyZeroInteractions(player2);
    }

    @Test
    public void shouldHavePlayersAlternateMovesWhenGameBoardIsNotFull() throws Exception {
        when(board.hasOpenLocations()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(player, times(2)).makeAMove();
        verify(player2, times(1)).makeAMove();
    }

    @Test
    public void shouldCheckThreeInARowWhenLocationIsMarked() throws Exception {
        when(board.hasOpenLocations()).thenReturn(true).thenReturn(false);

        game.start();

        verify(board).checkThreeInARow();
    }

    @Test
    public void shouldEndGameWhenLocationMarkedCreatesThreeInARow() throws Exception {
        when(board.hasOpenLocations()).thenReturn(true);
        when(board.checkThreeInARow()).thenReturn(true);

        game.start();

        verify(board, times(1)).checkThreeInARow();
    }
}