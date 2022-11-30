package app;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class WordChooserTest {
  @Test
  public void itHasADictionary() {
    ArrayList<String> dict  = new ArrayList<String>(Arrays.asList("RUBY", "PYTHON", "GOLANG", "JAVA"));
    WordChooser wCh = new WordChooser(dict);
    ArrayList<String> testDict =  wCh.DICTIONARY;
    assertEquals(dict, testDict);
  }
}
