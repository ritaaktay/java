package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class UserInterface {
  Boolean multiplayer;
  String[] words;
  Scanner console;

  UserInterface(String[] wrds, Boolean mltplyr) {
    multiplayer = mltplyr;
    words = wrds;
    console = new Scanner(System.in);
  }

  public void run() {
    if (multiplayer) multiplayer(); 
    else solo();
    console.close();
  }

  public void multiplayer() {
    print("\nPlayer 1");
    Game gameOne = setup();
    print("\nPlayer 2");
    Game gameTwo = setup();
    Game[] games = {gameOne, gameTwo};
    print("\nWelcome! Today your words to guess are:");
    for (Game g: games) {
      print(String.format("Player %s: %s", g.name, g.getWordToGuess()));
    }
    endForTwo(runTwoGames(games));
  }

  public void solo() {
    print("\n");
    Game game = setup();
    print(String.format("\nWelcome, %s! Today your word to guess is:", game.name));
    print(String.format("%s\n", game.getWordToGuess()));
    runOneGame(game);
    endForOne(game); 
  }

  public Game setup() {
    ArrayList<String> dict = new ArrayList<String>(Arrays.asList(words));
    WordChooser wChooser = new WordChooser(dict);
    Masker masker = new Masker();
    String name = getName();
    return new Game(wChooser, masker, name);
  }

  public String getName() {
    print("Enter your name:");
    String name = console.nextLine();
    return name;
  }

  public Game[] runTwoGames(Game[] games){
    Random rand = new Random();
    int indexOne = rand.nextInt(games.length-1);
    int indexTwo = indexOne == 0 ? 1 : 0;
    Boolean playing;
    do{
      print(String.format("\n%s, your turn!", games[indexOne].name));
      playing = runOneTurn(games[indexOne]);
      if (playing == false) break;
      print(String.format("\n%s, your turn!", games[indexTwo].name));
      playing = runOneTurn(games[indexTwo]);
    } while(playing);
    return games;
  }

  public void runOneGame(Game game){
    Boolean playing;
    do {
      playing = runOneTurn(game);
    } while (playing);
  }

  public Boolean runOneTurn(Game game) {
    print(game.getWordToGuess());
    Character letter = console.nextLine().charAt(0);
    Boolean result = game.guessLetter(letter);
    print(game.getWordToGuess());
    if (game.isGameWon() || game.isGameLost()) return false;
    print(getResult(result));
    print(String.format("Attemps remaining: %s\n", game.getRemainingAttempts()));
    return true;
  }

  public String getResult(Boolean result) {
    if (result == true) return "Correct!";
    else return "Oops!";
  }

  public void endForOne(Game game) {
    if (game.isGameWon()) {
      print("\nCongratulations!");
    } else {
      print("\nBetter luck next time...");
    }
  }

  public void endForTwo(Game[] games) {
      if (games[0].isGameWon() || games[1].isGameLost()) print(String.format("\n%s wins!", games[0].name));
      else print(String.format("\n%s wins!", games[1].name));
  }

  public void print(String message) {
    System.out.println(message);
  }
}
