package app;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    assertEquals("J_________", game.getWordToGuess());
  }

  @Test
  public void testHas10Attempts() {
    WordChooser mockChooser = mock(WordChooser.class);
    Game game = new Game(mockChooser);
    assertEquals(10, game.getRemainingAttempts());
  }

  @Test
  public void testDecrementsAttemptAtIncorrectGuess() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    game.getWordToGuess();
    Boolean result = game.guessLetter('Q');
    assertFalse(result);
    assertEquals(9, game.getRemainingAttempts());
  }

  @Test
  public void testAddsToGuessedAtCorrectGuess() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    game.getWordToGuess();
    Boolean result = game.guessLetter('P');
    assertTrue(result);
    assertTrue(game.guessed.contains('P'));
    assertEquals(10, game.getRemainingAttempts());
  }

}
