package app;

public class Game {
  int attempts = 10;
  WordChooser wChooser;

  Game(WordChooser wChsr) {
    wChooser = wChsr;
  }

  public static void main(String[] args) {
    System.out.println(Math.random());
  }

  public String getWordToGuess() {
    String word = wChooser.getRandomWordFromDictionary();
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      sBuilder.replace(i, i+1, "_");
    }
    return sBuilder.toString();
  }

  public int getRemainingAttempts() {
    return attempts;
  }
}
