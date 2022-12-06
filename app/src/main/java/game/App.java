package game;

public class App {
  public static void main(String[] args) {
    String[] words = {"SAILING", "SWIMMING", "RUNNING", "CLIMBING"};
    UserInterface userInterface = new UserInterface(words, true);
    userInterface.run();
  }
}
