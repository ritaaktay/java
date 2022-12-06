package game;

import java.util.ArrayList;

public class Game {
  WordChooser wChooser;
  Masker masker;
  String name;
  Integer attempts = 10;
  String word;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();

  Game(WordChooser w, Masker m, String n) {
    wChooser = w;
    masker = m;
    name = n;
    word = wChooser.getRandomWordFromDictionary();
    guessedLetters.add(word.charAt(0));
  }

  public Boolean isGameWon() {
    for (Character c : word.toCharArray()) {
      if (!guessedLetters.contains(c)) return false;
    }
    return true;
  }

  public Boolean isGameLost() {
    return attempts < 1;
  }

  public String getWordToGuess() {
    return masker.maskWord(word, guessedLetters);
  }

  public int getRemainingAttempts() {
    return attempts;
  }

  public Boolean guessLetter(Character letter) {
    letter = Character.toUpperCase(letter);
    if (word.indexOf(letter) > -1) {
      guessedLetters.add(letter);
      return true;
    } else {
      attempts--;
      return false;
    }
  }
}
