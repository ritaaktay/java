package game;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class MaskerTest {
  @Test 
  public void testMasksWord() {
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('R');
    assertEquals("R___", masker.maskWord("RUBY", guessedLetters));
  }  

  @Test 
  public void testMasksWordWithMultipleGuesses() {
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('R');
    guessedLetters.add('Y');
    assertEquals("R__Y", masker.maskWord("RUBY", guessedLetters));
  } 
}
