package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    print("Today your word to guess is:");
    multiplayer(); 
    // solo();
  }

  public static void multiplayer() {
    Game[] games = {setup(), setup()};
    for (int i=0; i<2; i++) {
      print(String.format("Player %s: %s", i+1, games[i].getWordToGuess()));
    }
    endForTwo(runTwoGames(games));
  }

  public static void solo() {
    Game game = setup();
    print(String.format("%s\n", game.getWordToGuess()));
    runOneGame(game);
    endForOne(game); 
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
      print(String.format("\nPlayer %s, your turn!", indexOne + 1));
      playing = runOneTurn(games[indexOne], sc);
      if (playing == false) break;
      print(String.format("\nPlayer %s, your turn!", indexTwo + 1));
      playing = runOneTurn(games[indexTwo], sc);
    } while(playing);
    sc.close();
    return games;
  }

  public static void runOneGame(Game game){
    Scanner sc = new Scanner(System.in);
    Boolean playing;
    do {
      playing = runOneTurn(game, sc);
    } while (playing);
    sc.close();
  }

  public static Boolean runOneTurn(Game game, Scanner sc) {
    print(game.getWordToGuess());
    Character letter = sc.nextLine().charAt(0);
    Boolean result = game.guessLetter(letter);
    print(game.getWordToGuess());
    if (game.isGameWon() || game.isGameLost()) return false;
    print(getResult(result));
    print(String.format("Attemps remaining: %s\n", game.getRemainingAttempts()));
    return true;
  }

  public static String getResult(Boolean result) {
    if (result == true) return "Correct!";
    else return "Oops!";
  }

  public static void endForOne(Game game) {
    if (game.isGameWon()) {
      print("\nCONGRATULATIONS!");
    } else {
      print("\nBETTER LUCK NEXT TIME...");
    }
  }

  public static void endForTwo(Game[] games) {
      if (games[0].isGameWon() || games[1].isGameLost()) print(String.format("\nPlayer 1 wins!"));
      else print(String.format("\nPlayer 2 wins!"));
  }

  public static void print(String message) {
    System.out.println(message);
  }
}
