package game;

import java.util.ArrayList;

public class Game {
  WordChooser wChooser;
  Integer attempts = 10;
  String word;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  Boolean win = false;

  Game(WordChooser wChsr) {
    wChooser = wChsr;
    word = wChooser.getRandomWordFromDictionary();
  }

  public Boolean win() {
    return win;
  }

  public void checkWin(String guess) {
    win = !guess.contains("_");
  }

  public String getWordToGuess() {
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      if (!guessedLetters.contains(sBuilder.charAt(i))) {
        sBuilder.replace(i, i+1, "_");
      }
    }
    checkWin(sBuilder.toString());
    return sBuilder.toString();
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
