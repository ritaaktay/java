package game;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.mockito.Mockito.*;


public class GameTest {
  WordChooser mockChooser;
  Masker mockMasker;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();

  @Before
  public void init() {
    mockChooser = mock(WordChooser.class);
    when(mockChooser.getRandomWordFromDictionary()).thenReturn("JAVASCRIPT");
    mockMasker = mock(Masker.class);
    guessedLetters.add('J');
  }

  @After 
  public void clear(){
    reset(mockMasker);
    guessedLetters.clear();
  }

  @Test
  public void testGetsWordToGuess() {
    when(mockMasker.maskWord("JAVASCRIPT", guessedLetters)).thenReturn("J_________");
    Game game = new Game(mockChooser, mockMasker);
    assertEquals("J_________", game.getWordToGuess());
  }

  @Test
  public void testHas10Attempts() {
    Game game = new Game(mockChooser, mockMasker);
    assertEquals(10, game.getRemainingAttempts());
  }

  @Test
  public void testDecrementsAttemptAtIncorrectGuess() {
    Game game = new Game(mockChooser, mockMasker);
    assertEquals(false, game.guessLetter('Q'));
    assertEquals(9, game.getRemainingAttempts());
  }

  @Test
  public void testAddsToGuessedAtCorrectGuess() {
    Game game = new Game(mockChooser, mockMasker);
    game.getWordToGuess();
    assertEquals(true, game.guessLetter('P'));
    assertTrue(game.guessedLetters.contains('P'));
    assertEquals(10, game.getRemainingAttempts());
  }

  @Test
  public void testGetsWordToGuessAfterOneGuess() {
    guessedLetters.add('A');
    when(mockMasker.maskWord("JAVASCRIPT", guessedLetters)).thenReturn("JA_A______");
    Game game = new Game(mockChooser, mockMasker);
    assertEquals(true,game.guessLetter('A'));
    assertEquals("JA_A______", game.getWordToGuess());
  }

  @Test
  public void testGuessesLetterCaseInsensitively() {
    guessedLetters.add('A');
    when(mockMasker.maskWord("JAVASCRIPT", guessedLetters)).thenReturn("JA_A______");
    Game game = new Game(mockChooser, mockMasker);
    assertEquals(true,game.guessLetter('a'));
    assertEquals("JA_A______", game.getWordToGuess());
  }

  @Test
  public void testIsGameLostReturnsTrueAfter10Attempts() {
  Game game = new Game(mockChooser, mockMasker);
  for (int i = 0; i < 10; i++) {
    game.guessLetter('K');
  }
  assertEquals(true, game.isGameLost());
  }

  @Test
  public void testIsWonReturnsTrueAfterWordGuessed() {
  Game game = new Game(mockChooser, mockMasker);
  game.guessLetter('A');
  game.guessLetter('V');
  game.guessLetter('S');
  game.guessLetter('C');
  game.guessLetter('R');
  game.guessLetter('I');
  game.guessLetter('P');
  game.guessLetter('T');
  assertEquals(true, game.isGameWon());
  }
}
