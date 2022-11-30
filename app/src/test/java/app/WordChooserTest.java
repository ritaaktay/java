package app;

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
    WordChooser wChsr = new WordChooser(dict);
    ArrayList<String> testDict =  wChsr.DICTIONARY;
    assertEquals(dict, testDict);
  }

  @Test
  public void testGetsRandomWord() {
    WordChooser wChsr = new WordChooser(dict);
    String word = wChsr.getRandomWordFromDictionary();
    assertTrue(dict.contains(word));
  }
}
