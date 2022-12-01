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
    System.out.println(game.getWordToGuess());
    // while word contains unguessed letters and attempts are greater than 10
    // ask for letter to guess
    // print remaining attempts
    // print word to guess
    Scanner sc = new Scanner(System.in);
    Character letter = sc.nextLine().charAt(0);
    game.guessLetter(letter);
    System.out.println(game.getWordToGuess());
  }
}
