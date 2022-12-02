package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    print("Today your word to guess is:");
    Game game = setup();
    run(game);
    end(game.isGameWon());
  }

  public static Game setup() {
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList("SAILING"));
    WordChooser wChooser = new WordChooser(dict);
    return new Game(wChooser);
  }

  public static void run(Game game){
    Scanner sc = new Scanner(System.in);
    while(game.getRemainingAttempts() > 1) {
      print(game.getWordToGuess());
      if (game.isGameWon()) {
        break;
      } else {
        Character letter = sc.nextLine().charAt(0);
        game.guessLetter(letter);
        System.out.println(game.getRemainingAttempts());
      }
    }
    sc.close();
  }

  public static void end(Boolean win) {
    String message = win ? "CONGRATULATIONS!" : "BETTER LUCK NEXT TIME...";
    print(message);
  }

  public static void print(String message) {
    System.out.println(message);
  }
}
