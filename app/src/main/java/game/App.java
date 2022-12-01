package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Game game = setup();
    run(game);
    end(game.win());
  }

  public static Game setup() {
    print("Today your word to guess is:");
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList("SAILING"));
    WordChooser wChooser = new WordChooser(dict);
    return new Game(wChooser);
  }

  public static void run(Game game){
    Scanner sc = new Scanner(System.in);
    while(game.getRemainingAttempts() > 0 && !game.win()) {
      print(game.getWordToGuess());
      if (!game.win()) {
        Character letter = sc.nextLine().charAt(0);
        game.guessLetter(letter);
      }
    }
    sc.close();
  }

  public static void end(Boolean win) {
    if (win) {
      print("CONGRATULATIONS!");
    } else {
      print("BETTER LUCK NEXT TIME...");
    }
  }

  public static void print(String message) {
    System.out.println(message);
  }
}
