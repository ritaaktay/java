package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
  String word = "";
  GameTest() {
    word = "BABYLON";
  }

  @Test
  public void testGetsWordToGuess() {
    Game game = new Game();
    assertEquals(game.getWordToGuess(), "B_______");
  }
}
