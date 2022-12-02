package game;

import java.util.ArrayList;

public class Masker {
  public String maskWord(String word, ArrayList<Character> guessedLetters) {
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      if (!guessedLetters.contains(sBuilder.charAt(i))) {
        sBuilder.replace(i, i+1, "_");
      }
    }
    return sBuilder.toString();
  }
}
