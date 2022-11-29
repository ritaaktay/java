package app;

public class Game {
  String word;

  Game(String w) {
    word = w;
  }

  public String getWordToGuess() {
    StringBuilder sBuilder = new StringBuilder(word);
    for (int i = 1; i < word.length(); i++) {
      sBuilder.replace(i, i+1, "_");
    }
    return sBuilder.toString();
  }
}
