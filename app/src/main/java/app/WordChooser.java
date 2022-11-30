package app;

import java.util.ArrayList;

import java.util.Random;

public class WordChooser {
  ArrayList<String> DICTIONARY;
  
  WordChooser(ArrayList<String> dictionary) {
    DICTIONARY = dictionary;
  }

  public String getRandomWordFromDictionary() {
    Random rand = new Random();
    int randI = rand.nextInt(DICTIONARY.size()-1);
    return DICTIONARY.get(randI);
  }
}
