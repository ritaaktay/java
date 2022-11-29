package app;

import java.util.*;

public class Game {
  int attempts = 10;
  static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  Game() {
  }

  public static void main(String[] args) {
    System.out.println(Math.random());
  }

  public String[] getDictionary() {
    return DICTIONARY;
  }

  public String getWordToGuess() {
    String word = getRandomWordFromDictionary();
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      sBuilder.replace(i, i+1, "_");
    }
    return sBuilder.toString();
  }

  public int getRemainingAttempts() {
    return attempts;
  }

  public String getRandomWordFromDictionary() {
    Random rand = new Random();
    int randI = rand.nextInt(DICTIONARY.length -1);
    return DICTIONARY[randI];
  }
}
