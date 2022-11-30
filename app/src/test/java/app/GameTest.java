package app;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import static org.mockito.Mockito.*;


public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    WordChooser wChooser = mock(WordChooser.class);
    when(wChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(wChooser);
    assertEquals("J_________", game.getWordToGuess());
  }

  @Test
  public void testHas10Attempts() {
    WordChooser wChooser = mock(WordChooser.class);
    Game game = new Game(wChooser);
    assertEquals(10, game.getRemainingAttempts());
  }

}
