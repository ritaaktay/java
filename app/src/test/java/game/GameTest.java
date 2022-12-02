package game;

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
    assertEquals(false, game.guessLetter('Q'));
    assertEquals(9, game.getRemainingAttempts());
  }

  @Test
  public void testAddsToGuessedAtCorrectGuess() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    game.getWordToGuess();
    assertEquals(true, game.guessLetter('P'));
    assertTrue(game.guessedLetters.contains('P'));
    assertEquals(10, game.getRemainingAttempts());
  }

  @Test
  public void testGetsWordToGuessAfterOneGuess() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    assertEquals(true,game.guessLetter('A'));
    assertEquals("JA_A______", game.getWordToGuess());
  }

  @Test
  public void testGuessesLetterCaseInsensitively() {
    WordChooser mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    Game game = new Game(mockChooser);
    assertEquals(true,game.guessLetter('a'));
    assertEquals("JA_A______", game.getWordToGuess());
  }

  @Test
  public void testIsGameLostReturnsTrueAfter10Attempts() {
  WordChooser mockChooser = mock(WordChooser.class);
  when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
  Game game = new Game(mockChooser);
  for (int i = 0; i < 10; i++) {
    game.guessLetter('K');
  }
  assertEquals(true, game.isGameLost());
  }

  @Test
  public void testIsWonReturnsTrueAfterWordGuessed() {
  WordChooser mockChooser = mock(WordChooser.class);
  when(mockChooser.getRandomWordFromDictionary()).thenReturn("RUBY");
  Game game = new Game(mockChooser);
  game.guessLetter('U');
  game.guessLetter('B');
  game.guessLetter('Y');
  assertEquals(true, game.isGameWon());
  }
}
