package game;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList("SAILING"));
    WordChooser wChooser = new WordChooser(dict);
    Game game = new Game(wChooser);
    game.getWordToGuess();
  }
}
