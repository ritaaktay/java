package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList("SAILING"));
    WordChooser wChooser = new WordChooser(dict);
    Game game = new Game(wChooser);
    System.out.println("Today your word to guess is:");
    Scanner sc = new Scanner(System.in);
    while(game.getRemainingAttempts() > 0 && !game.win()) {
      System.out.println(game.getWordToGuess());
      if (!game.win()) {
        System.out.printf("Guesses: %d\n", game.getRemainingAttempts());
        Character letter = sc.nextLine().charAt(0);
        game.guessLetter(letter);
      }
    }
    sc.close();
  }
}
