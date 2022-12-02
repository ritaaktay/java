package game;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class MaskerTest {
  @Test 
  public void masksWord() {
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('R');
    assertEquals("R___", masker.maskWord("RUBY", guessedLetters));
  }  
}
