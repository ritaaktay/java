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
     do{
      print(game.getWordToGuess());
      if (game.isGameWon()) break;
      Character letter = sc.nextLine().charAt(0);
      game.guessLetter(letter);
      System.out.println(game.getRemainingAttempts());
    } while(!game.isGameLost());
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
