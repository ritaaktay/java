package game;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;


public class WordChooserTest { 
  ArrayList<String> dict; 
  @Before 
  public void initialize() {
    dict = new ArrayList<String>(Arrays.asList("RUBY", "PYTHON", "GOLANG", "JAVA"));
  }

  @Test
  public void itHasADictionary() {
    WordChooser wChooser = new WordChooser(dict);
    ArrayList<String> testDict =  wChooser.DICTIONARY;
    assertEquals(dict, testDict);
  }

  @Test
  public void testGetsRandomWord() {
    WordChooser wChooser = new WordChooser(dict);
    String word = wChooser.getRandomWordFromDictionary();
    assertTrue(dict.contains(word));
  }
}
