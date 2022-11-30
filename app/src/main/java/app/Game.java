package app;

import java.util.ArrayList;

public class Game {
  WordChooser wChooser;
  int attempts = 10;
  String word;
  ArrayList<Character> guessed = new ArrayList<Character>();

  Game(WordChooser wChsr) {
    wChooser = wChsr;
  }

  public static void main(String[] args) {
    System.out.println(Math.random());
  }

  public String getWordToGuess() {
    word = wChooser.getRandomWordFromDictionary();
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      sBuilder.replace(i, i+1, "_");
    }
    return sBuilder.toString();
  }

  public int getRemainingAttempts() {
    return attempts;
  }

  public Boolean guessLetter(Character letter) {
    if (word.indexOf(letter) > -1) {
      guessed.add(letter);
      return true;
    } else {
      attempts--;
      return false;
    }
  }
}
