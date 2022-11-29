package app;

public class Game {
  String word;

  Game(String w) {
    word = w;
  }

  public String getWordToGuess() {
    StringBuilder hidden = new StringBuilder();
    hidden.append(word.charAt(0));
    for (int i = 1; i < word.length(); i++) {
      hidden.append("_");
    }
    return hidden.toString();
  }
}
