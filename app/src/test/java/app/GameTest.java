package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    Game game = new Game("TENACIOUS");
    assertEquals("T________", game.getWordToGuess());
  }
}
