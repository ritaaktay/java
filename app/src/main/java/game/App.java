package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    print("Today your word to guess is:");
    Game[] games = {setup(), setup()};
    for (int i=0; i<2; i++) {
      print(String.format("Player %s: %s", i+1, games[i].getWordToGuess()));
    }
    endForTwo(runTwoGames(games));
    // end(game.isGameWon()); //for one player
  }

  public static Game setup() {
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList("SAILING", "SWIMMING", "RUNNING", "CLIMBING"));
    WordChooser wChooser = new WordChooser(dict);
    Masker masker = new Masker();
    return new Game(wChooser, masker);
  }

  public static Game[] runTwoGames(Game[] games){
    Random rand = new Random();
    int indexOne = rand.nextInt(games.length-1);
    int indexTwo = indexOne == 0 ? 1 : 0;
    Scanner sc = new Scanner(System.in);
    Boolean playing;
    do{
      playing = runOneTurn(indexOne, games, sc);
      if (playing == false) break;
      playing = runOneTurn(indexTwo, games, sc);
    } while(playing);
    sc.close();
    return games;
  }

  public static Boolean runOneTurn( int index, Game[] games, Scanner sc) {
    print(String.format("\nPlayer %s, your turn!", index+1));
    Game game = games[index];
    print(game.getWordToGuess());
    Character letter = sc.nextLine().charAt(0);
    Boolean result = game.guessLetter(letter);
    if (game.isGameWon() || game.isGameLost()) return false;
    print(game.getWordToGuess());
    print(getResult(result));
    print(String.format("Attemps remaining: %s", game.getRemainingAttempts()));
    return true;
  }

  public static String getResult(Boolean result) {
    if (result == true) return "Correct!";
    else return "Oops!";
  }

  public static void runOneGame(Game game){
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

  public static void endForTwo(Game[] games) {
      if (games[0].isGameWon() || games[1].isGameLost()) print(String.format("\nPlayer 1 wins!"));
      else print(String.format("\nPlayer 2 wins!"));
  }

  public static void print(String message) {
    System.out.println(message);
  }
}
