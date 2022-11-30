package app;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

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

  @Test
  public void testGetsRandomWord() {
    Game game = new Game();
    String word = game.getRandomWordFromDictionary();
    ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(game.getDictionary()));
    assertTrue(dictionary.contains(word));
  }
}
