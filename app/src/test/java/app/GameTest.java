package app;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import static org.mockito.Mockito.*;


public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    Game game = new Game();
    assertEquals("T________", game.getWordToGuess());
  }

  @Test
  public void testHas10Attempts() {
    Game game = new Game();
    assertEquals(10, game.getRemainingAttempts());
  }

}
